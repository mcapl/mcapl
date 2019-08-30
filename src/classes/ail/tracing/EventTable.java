// ----------------------------------------------------------------------------
// Copyright (C) 2018 Louise A. Dennis, Michael Fisher, and Vincent Koeman
//
// This file is part of the Agent Infrastructure Layer (AIL)
// 
// The AIL is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The AIL is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------
package ail.tracing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.JTextComponent;

import org.jdesktop.swingx.JXTable;

import ail.syntax.Action;
import ail.syntax.Predicate;
import ail.tracing.events.AbstractEvent;
import ail.tracing.explanations.AbstractReason;
import ail.tracing.explanations.ExplanationLevel;
import ail.tracing.explanations.PredicateDescriptions;
import ail.tracing.explanations.WhyQuestionsBase;
import ail.util.Tuple;
import ajpf.MCAPLcontroller;
import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.SortedList;
import ca.odell.glazedlists.gui.TableFormat;
import ca.odell.glazedlists.swing.JXTableSupport;
import ca.odell.glazedlists.swing.TableComparatorChooser;

/**
 * A space-time view (see "Omniscient Debugging for Cognitive Agent Programs",
 * Koeman et. al 2017) for a trace (i.e. {@link EventStorage}). The main method
 * of this class requests a trace file to be loaded in, and shows the table
 * along with explanation buttons (see {@link WhyQuestions}).
 * 
 * Generic version for languages with no implementation of explanations.
 */
public class EventTable extends JXTable {
	private static final long serialVersionUID = 1L;
	private final List<String> columns;
	private final EventList<Map<String, String>> rows;
	private final Map<String, Integer> index;
	// initialize the description of the selected column (shown at the bottom)
	// it is actually linked in the EventTable constructor
	public final static JTextComponent description = new JTextField();
	public final static JLabel header = new JLabel();

	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// initialize the trace and the question-asking
				File file = getFile(args);
				final EventStorage storage = new EventStorage(file);
				final WhyQuestionsBase questions = new WhyQuestionsBase(storage);
				EventTable table = new EventTable(storage, header, description);
				setUp(table, questions);
			}
		});
	}
	
	
	public static void setUp(EventTable table, WhyQuestionsBase questions) {

		// initialize the why-buttons at the right
		final JPanel buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
		buttons.add(new JLabel("FINEST"));
		buttons.add(new WhyActionButton(questions, ExplanationLevel.FINEST));
		buttons.add(new WhyBeliefButton(questions, ExplanationLevel.FINEST));
		buttons.add(new WhyGoalButton(questions, ExplanationLevel.FINEST));
		buttons.add(new JLabel("FINE"));
		buttons.add(new WhyActionButton(questions, ExplanationLevel.FINE));
		buttons.add(new WhyBeliefButton(questions, ExplanationLevel.FINE));
		buttons.add(new WhyGoalButton(questions, ExplanationLevel.FINE));

		// initialize the frame itself
		final JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		final JScrollPane scroll1 = new JScrollPane(header, ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		final JScrollPane scroll2 = new JScrollPane(table);
		scroll1.getVerticalScrollBar().setModel(scroll2.getVerticalScrollBar().getModel());
		frame.add(scroll1, BorderLayout.WEST);
		frame.add(scroll2, BorderLayout.CENTER);
		frame.add(description, BorderLayout.SOUTH);
		frame.add(buttons, BorderLayout.EAST);

		// show the frame (full-screen)
		final Dimension fullscreen = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getMaximumWindowBounds().getSize();
		frame.setPreferredSize(fullscreen);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public static File getFile(String[] args) {
		File file = null;
		if (args.length == 0) {
		// request a .db file, i.e. a trace
			final JFileChooser picker = new JFileChooser(System.getProperty("user.dir"));
			picker.setFileFilter(new FileNameExtensionFilter("AIL Trace File", "db"));
			if (picker.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				file = picker.getSelectedFile();
			}
		} else {
			try {
				file = new File(MCAPLcontroller.getFilename(args[0]));
			} catch (Exception e) {
				System.err.println(e);
				System.exit(0);
			}
		}
		return file;
		
	}

	/**
	 * @param storage     The trace
	 * @param headers     A container at the left side of the table that can be used
	 *                    to show a header for each row.
	 * @param description A container at the bottom of the table that can be used to
	 *                    show details (i.e. of the event) for a selected column.
	 */
	public EventTable(final EventStorage storage, final JLabel headers, final JTextComponent description) {
		// initialize the headers before each table row (filled by the EventTable)
		headers.setVerticalAlignment(SwingConstants.TOP);
		headers.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));

		this.columns = new LinkedList<>();
		this.rows = GlazedLists.eventList(new LinkedList<Map<String, String>>());
		this.index = new LinkedHashMap<>();
		final List<AbstractEvent> data = storage.getAll();
		process(data); // here we fill the columns/rows/index fields

		// actually create the row-headers
		String headersTxt = "<html><br>";
		for (final String header : this.index.keySet()) {
			headersTxt += header + "<br>";
		}
		headers.setText(headersTxt + "</html>");

		// initialize the table using some libraries
		JXTableSupport.<Map<String, String>>install(EventTable.this, this.rows, new TableFormat<Map<String, String>>() {
			@Override
			public int getColumnCount() {
				return EventTable.this.columns.size();
			}

			@Override
			public String getColumnName(final int columnIndex) {
				return EventTable.this.columns.get(columnIndex);
			}

			@Override
			public Object getColumnValue(final Map<String, String> rowObject, final int columnIndex) {
				final Object value = rowObject.get(getColumnName(columnIndex));
				return (value == null) ? "" : value;
			}
		}, new SortedList<Map<String, String>>(this.rows, null), TableComparatorChooser.SINGLE_COLUMN);

		// visual stuff
		setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		setGridColor(Color.GRAY);

		// show a description at the bottom based on the currently selected cell
		final int mouseIndex = getMouseListeners().length;
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(final MouseEvent evt) {
				final int col = EventTable.this.getSelectedColumn();
				final AbstractEvent event = data.get(col);
				description.setText(col + ": " + event.toString(storage.getDescriptions()));
			}
		});
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(final KeyEvent e) {
				int keyCode = e.getKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_UP:
				case KeyEvent.VK_DOWN:
				case KeyEvent.VK_LEFT:
				case KeyEvent.VK_RIGHT:
					getMouseListeners()[mouseIndex].mouseReleased(null);
					break;
				}
			}
		});
	}

	private void process(final List<AbstractEvent> data) {
		for (int i = 0; i < data.size(); ++i) {
			final String index = Integer.toString(i);
			final AbstractEvent event = data.get(i);
			final List<String> lookup = (event == null) ? new ArrayList<>(0) : event.getLookupData();
			for (final String signature : lookup) {
				final Integer existing = this.index.get(signature);
				if (existing == null) {
					this.index.put(signature, this.rows.size());
					final Map<String, String> row = new LinkedHashMap<>();
					row.put(index, getDescription(event));
					this.rows.add(row); // TODO: grouping on type?!
				} else {
					final Map<String, String> row = this.rows.get(existing);
					row.put(index, getDescription(event));
				}
			}
			if (!this.columns.contains(index)) {
				this.columns.add(index);
			}
		}
	}

	public static String getDescription(final AbstractEvent event) {
		return event.getClass().getSimpleName().replace("Event", "");
	}

	/**
	 * This class entails a button that, once pressed, requests the user to select
	 * one of the actions present in a given trace (through
	 * {@link WhyQuestions#getAllActions()}). Once selected, the answer(s) to why
	 * that action was executed are shown (see {@link AnswerArea}), respecting the
	 * given {@link ExplanationLevel}.
	 */
	private static final class WhyActionButton extends JButton {
		private static final long serialVersionUID = 1L;

		WhyActionButton(final WhyQuestionsBase questions, final ExplanationLevel level) {
			setText("WHY ACTION?");
			addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					// list all actions that there were in the trace,
					// and request which one we should explain.
					final Set<Tuple<Action, Integer>> actions = questions.getAllActions();
					final JComboBox<ActionPlusInt> select = new JComboBox<>(EventTable.toActionArray(actions));
					final int result = JOptionPane.showConfirmDialog(null, select, "Why did you execute this action?",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (result == JOptionPane.OK_OPTION) {
						// for the selected action, fetch and show its explanation(s)
						final ActionPlusInt action = (ActionPlusInt) select.getSelectedItem();
						final AbstractReason reason = questions.whyAction(action.getAction(), action.getIndex());
						final AnswerArea msg = new AnswerArea(reason, level, questions);
						JOptionPane.showMessageDialog(null, new JScrollPane(msg), "", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
		}
	}
	
	private static class ActionPlusInt {
		Action action;
		int index;
		
		public ActionPlusInt(Action a, int i) {
			this.action = a;
			this.index = i;
		}
		
		public String toString() {
			return action.toString();
		}
		
		public Action getAction() {
			return action;
		}
		
		public int getIndex() {
			return index;
		}
	}

	/**
	 * This class entails a button that, once pressed, requests the user to select
	 * one of the beliefs present in a given trace (through
	 * {@link WhyQuestions#getAllBeliefs()}). Once selected, the answer(s) to why
	 * that belief was inserted are shown (see {@link AnswerArea}), respecting the
	 * given {@link ExplanationLevel}.
	 */
	private static final class WhyBeliefButton extends JButton {
		private static final long serialVersionUID = 1L;

		WhyBeliefButton(final WhyQuestionsBase questions, final ExplanationLevel level) {
			setText("WHY BELIEF?");
			addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					// list all beliefs that there were in the trace,
					// and request which one we should explain.
					final Set<Tuple<Predicate, Integer>> beliefs = questions.getAllBeliefs();
					final JComboBox<PredicatePlusInt> select = new JComboBox<>(EventTable.toPredicateArray(beliefs));
					final int result = JOptionPane.showConfirmDialog(null, select, "Why did you insert this belief?",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (result == JOptionPane.OK_OPTION) {
						// for the selected belief, fetch and show its explanation(s)
						final PredicatePlusInt belief = (PredicatePlusInt) select.getSelectedItem();
						final AbstractReason reason = questions.whyBelief(belief.getPredicate(), belief.getIndex());
						final AnswerArea msg = new AnswerArea(reason, level, questions);
						JOptionPane.showMessageDialog(null, new JScrollPane(msg), "", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
		}
	}
	
	private static class PredicatePlusInt {
		Predicate pred;
		int index;
		
		public PredicatePlusInt(Predicate a, int i) {
			this.pred = a;
			this.index = i;
		}
		
		public String toString() {
			return pred.toString();
		}
		
		public Predicate getPredicate() {
			return pred;
		}
		
		public int getIndex() {
			return index;
		}
	}


	/**
	 * This class entails a button that, once pressed, requests the user to select
	 * one of the goals present in a given trace (through
	 * {@link WhyQuestions#getAllBeliefs()}). Once selected, the answer(s) to why
	 * that goal was adopted are shown (see {@link AnswerArea}), respecting the
	 * given {@link ExplanationLevel}.
	 */
	private static final class WhyGoalButton extends JButton {
		private static final long serialVersionUID = 1L;

		WhyGoalButton(final WhyQuestionsBase questions, final ExplanationLevel level) {
			setText("WHY GOAL?");
			addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					// list all goals that there were in the trace,
					// and request which one we should explain.
					final List<Tuple<Predicate, Integer>> goals = questions.getAllGoals();
					nonGenericTuple[] array = new nonGenericTuple[goals.size()];
					int index = 0;
					for (Tuple<Predicate, Integer> goal: goals) {
						array[index] = new EventTable.nonGenericTuple(goal);
						index++;
					}
					final JComboBox<nonGenericTuple> select = new JComboBox<nonGenericTuple>(array);
					final int result = JOptionPane.showConfirmDialog(null, select, "Why did you adopt this goal?",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (result == JOptionPane.OK_OPTION) {
						// for the selected goal, fetch and show its explanation(s)
						final nonGenericTuple goal = (nonGenericTuple) select.getSelectedItem();
						final AbstractReason reasons = questions.whyGoal(goal.getLeft(), goal.getRight());
						final AnswerArea msg = new AnswerArea(reasons, level, questions);
						JOptionPane.showMessageDialog(null, new JScrollPane(msg), "", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
		}
	}
	
	private static class nonGenericTuple {
		Predicate pred = null;
		Integer step;
		
		nonGenericTuple(Tuple<Predicate, Integer> tuple) {
			pred = tuple.getLeft();
			step = tuple.getRight();
		}
		
		public String toString() {
			return pred.toString();
		}
		
		public Predicate getLeft() {
			return pred;
		}
		
		public Integer getRight() {
			return step;
		}
	}

	/**
	 * This class does some post-processing on the result of a {@link WhyQuestions}
	 * query, i.e., one or more {@link AbstractReason}s, and then shows it.
	 * Extending JEditorPane allows for styled and interactive (i.e. through
	 * hyperlinks) HTML output.
	 */
	private static final class AnswerArea extends JEditorPane implements HyperlinkListener {
		private static final long serialVersionUID = 1L;
		private final WhyQuestionsBase questions;
		private final ExplanationLevel level;
		private final Map<String, Predicate> beliefs = new LinkedHashMap<>();
		private final Map<String, Predicate> goals = new LinkedHashMap<>();

		AnswerArea(final AbstractReason reason, final ExplanationLevel level, final WhyQuestionsBase questions) {
			this.questions = questions;
			this.level = level;
			setContentType("text/html");
			setText(answerString(reason, level));
			setEditable(false);
			setPreferredSize(new Dimension(600, 300));
			addHyperlinkListener(this);
		}

		@Override
		public void hyperlinkUpdate(final HyperlinkEvent e) {
			if (e.getInputEvent() instanceof MouseEvent
					&& ((MouseEvent) e.getInputEvent()).getButton() == MouseEvent.BUTTON1) {
				final String url = e.getDescription(); // automatically decoded
				if (url.startsWith("belief://")) {
					final Predicate belief = beliefs.get(url.substring(9));
					final AbstractReason reasons = questions.whyBelief(belief, 0);
					setText(answerString(reasons, level));
				} else if (url.startsWith("goal://")) {
					final Predicate goal = goals.get(url.substring(7));
					final AbstractReason reasons = questions.whyGoal(goal, 0);
					setText(answerString(reasons, level));
				}
			}
		}

		private String answerString(final AbstractReason main, final ExplanationLevel level) {
			final PredicateDescriptions descriptions = questions.getDescriptions();
			//for (final AbstractReason main : reason2) {
				AbstractReason current = main;
			/*	while (current != null) {
					if (current instanceof GuardReason) {
						final Guard guard = ((GuardReason) current).getEvent().getGuard();
						for (final GuardAtom<?> atom : guard.getAllAtoms()) {
							if (atom.isVar()) {
								continue;
							} else if (atom instanceof GBelief) {
								beliefs.put(atom.toString(descriptions), (GBelief) atom);
							} else if (atom instanceof Goal) {
								goals.put(atom.toString(descriptions), (Goal) atom);
							}
						}
					}
					current = current.getParent();
				} */
			//}
			final StringBuilder answer = new StringBuilder();
			/* for (int i = 1; i <= reason2.size(); ++i) {
				final String reason = reason2.get(i - 1).getExplanation(level, descriptions);
				answer.append("<p><b>").append(i).append(":</b> ").append(reason).append("</p>");
			} */
			final String reason = current.getExplanation(level, descriptions);
			answer.append(reason);
			String result = answer.toString();
			/* for (final String rawbelief : beliefs.keySet()) {
				final String belief = StringEscapeUtils.escapeHtml4(rawbelief);
				result = result.replace(belief, "<a href=\"belief://" + belief + "\">" + belief + "</a>");
			} */
			return "<html>" + result.replace("because", "<i>because</i>") + "</html>";
		}
		
	}
	
	private static PredicatePlusInt[] toPredicateArray(Set<Tuple<Predicate, Integer>> set) {
		PredicatePlusInt[] array = new PredicatePlusInt[set.size()];
		int index = 0;
		for (Tuple<Predicate, Integer> tuple: set) {
			array[index] = new PredicatePlusInt(tuple.getLeft(), tuple.getRight());
			index++;
		}
		return array;
	}
	
	private static ActionPlusInt[] toActionArray(Set<Tuple<Action, Integer>> set) {
		ActionPlusInt[] array = new ActionPlusInt[set.size()];
		int index = 0;
		for (Tuple<Action, Integer> tuple: set) {
			array[index] = new ActionPlusInt(tuple.getLeft(), tuple.getRight());
			index++;
		}
		return array;
	}


}
