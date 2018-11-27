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

import org.apache.commons.text.StringEscapeUtils;
import org.jdesktop.swingx.JXTable;

import ail.syntax.Action;
import ail.syntax.GBelief;
import ail.syntax.Goal;
import ail.syntax.Guard;
import ail.syntax.GuardAtom;
import ail.syntax.Predicate;
import ail.tracing.events.AbstractEvent;
import ail.tracing.explanations.AbstractReason;
import ail.tracing.explanations.ExplanationLevel;
import ail.tracing.explanations.GuardReason;
import ail.tracing.explanations.PredicateDescriptions;
import ail.tracing.explanations.WhyQuestions;
import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.SortedList;
import ca.odell.glazedlists.gui.TableFormat;
import ca.odell.glazedlists.swing.JXTableSupport;
import ca.odell.glazedlists.swing.TableComparatorChooser;

public class EventTable extends JXTable {
	private static final long serialVersionUID = 1L;
	private final List<String> columns;
	private final EventList<Map<String, String>> rows;
	private final Map<String, Integer> index;

	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// request a .db file, i.e. a trace
				final JFileChooser picker = new JFileChooser(System.getProperty("user.dir"));
				picker.setFileFilter(new FileNameExtensionFilter("AIL Trace File", "db"));
				if (picker.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					// initialize the trace and the question-asking
					final EventStorage storage = new EventStorage(picker.getSelectedFile());
					final WhyQuestions questions = new WhyQuestions(storage);
					questions.process();

					// initialize the headers before each table row (filled by the EventTable)
					final JLabel header = new JLabel();
					header.setVerticalAlignment(SwingConstants.TOP);
					header.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));

					// initialize the description of the selected column (shown at the bottom)
					// it is actually linked in the EventTable constructor
					final JTextComponent description = new JTextField();

					// initialize the table itself
					final EventTable table = new EventTable(storage, header, description);

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
			}
		});
	}

	public EventTable(final EventStorage storage, final JLabel headers, final JTextComponent description) {
		this.columns = new LinkedList<>();
		this.rows = GlazedLists.eventList(new LinkedList<Map<String, String>>());
		this.index = new LinkedHashMap<>();
		final List<AbstractEvent> data = storage.getAll();
		process(data); // here we fill the columns/rows/index fields

		// actually create the row-headers
		String headersTxt = "<html><br>";
		for (String header : this.index.keySet()) {
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

	private static String getDescription(final AbstractEvent event) {
		return event.getClass().getSimpleName().replace("Event", "");
	}

	private static final class WhyActionButton extends JButton {
		private static final long serialVersionUID = 1L;

		WhyActionButton(final WhyQuestions questions, final ExplanationLevel level) {
			setText("WHY ACTION?");
			addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					// list all actions that there were in the trace,
					// and request which one we should explain.
					final Set<Action> actions = questions.getAllActions();
					final JComboBox<Action> select = new JComboBox<>(actions.toArray(new Action[actions.size()]));
					final int result = JOptionPane.showConfirmDialog(null, select, "Why did you execute this action?",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (result == JOptionPane.OK_OPTION) {
						// for the selected action, fetch and show its explanation(s)
						final Action action = (Action) select.getSelectedItem();
						final List<AbstractReason> reasons = questions.whyAction(action);
						final AnswerArea msg = new AnswerArea(reasons, level, questions);
						JOptionPane.showMessageDialog(null, new JScrollPane(msg), "", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
		}
	}

	private static final class WhyBeliefButton extends JButton {
		private static final long serialVersionUID = 1L;

		WhyBeliefButton(final WhyQuestions questions, final ExplanationLevel level) {
			setText("WHY BELIEF?");
			addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					// list all beliefs that there were in the trace,
					// and request which one we should explain.
					final Set<Predicate> beliefs = questions.getAllBeliefs();
					final JComboBox<Predicate> select = new JComboBox<>(beliefs.toArray(new Predicate[beliefs.size()]));
					final int result = JOptionPane.showConfirmDialog(null, select, "Why did you insert this belief?",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (result == JOptionPane.OK_OPTION) {
						// for the selected belief, fetch and show its explanation(s)
						final Predicate belief = (Predicate) select.getSelectedItem();
						final List<AbstractReason> reasons = questions.whyBelief(belief);
						final AnswerArea msg = new AnswerArea(reasons, level, questions);
						JOptionPane.showMessageDialog(null, new JScrollPane(msg), "", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
		}
	}

	private static final class WhyGoalButton extends JButton {
		private static final long serialVersionUID = 1L;

		WhyGoalButton(final WhyQuestions questions, final ExplanationLevel level) {
			setText("WHY GOAL?");
			addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					// list all goals that there were in the trace,
					// and request which one we should explain.
					final Set<Predicate> goals = questions.getAllGoals();
					final JComboBox<Predicate> select = new JComboBox<>(goals.toArray(new Predicate[goals.size()]));
					final int result = JOptionPane.showConfirmDialog(null, select, "Why did you adopt this goal?",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (result == JOptionPane.OK_OPTION) {
						// for the selected goal, fetch and show its explanation(s)
						final Predicate goal = (Predicate) select.getSelectedItem();
						final List<AbstractReason> reasons = questions.whyGoal(goal);
						final AnswerArea msg = new AnswerArea(reasons, level, questions);
						JOptionPane.showMessageDialog(null, new JScrollPane(msg), "", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
		}
	}

	private static final class AnswerArea extends JEditorPane implements HyperlinkListener {
		private static final long serialVersionUID = 1L;
		private final WhyQuestions questions;
		private final ExplanationLevel level;
		private final Map<String, Predicate> beliefs = new LinkedHashMap<>();
		private final Map<String, Predicate> goals = new LinkedHashMap<>();

		AnswerArea(final List<AbstractReason> reasons, final ExplanationLevel level, final WhyQuestions questions) {
			this.questions = questions;
			this.level = level;
			setContentType("text/html");
			setText(answerString(reasons, level));
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
					final List<AbstractReason> reasons = questions.whyBelief(belief);
					setText(answerString(reasons, level));
				} else if (url.startsWith("goal://")) {
					final Predicate goal = goals.get(url.substring(7));
					final List<AbstractReason> reasons = questions.whyGoal(goal);
					setText(answerString(reasons, level));
				}
			}
		}

		private String answerString(final List<AbstractReason> reasons, final ExplanationLevel level) {
			final PredicateDescriptions descriptions = questions.getDescriptions();
			for (final AbstractReason main : reasons) {
				AbstractReason current = main;
				while (current != null) {
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
				}
			}
			final StringBuilder answer = new StringBuilder();
			for (int i = 1; i <= reasons.size(); ++i) {
				final String reason = reasons.get(i - 1).getExplanation(level, descriptions);
				answer.append("<p><b>").append(i).append(":</b> ").append(reason).append("</p>");
			}
			String result = answer.toString();
			for (final String rawbelief : beliefs.keySet()) {
				final String belief = StringEscapeUtils.escapeHtml4(rawbelief);
				result = result.replace(belief, "<a href=\"belief://" + belief + "\">" + belief + "</a>");
			}
			return "<html>" + result.replace("because", "<i>because</i>") + "</html>";
		}
	}
}
