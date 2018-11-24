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
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.JTextComponent;

import org.jdesktop.swingx.JXTable;

import ail.syntax.Action;
import ail.syntax.Predicate;
import ail.tracing.events.AbstractEvent;
import ail.tracing.explanations.ActionReason;
import ail.tracing.explanations.ExplanationLevel;
import ail.tracing.explanations.ModificationReason;
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
					final int col = EventTable.this.getSelectedColumn();
					final AbstractEvent event = data.get(col);
					description.setText(col + ": " + event.toString(storage.getDescriptions()));
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
		private final WhyQuestions questions;

		WhyActionButton(final WhyQuestions questions, final ExplanationLevel level) {
			this.questions = questions;
			setText("WHY ACTION?");
			addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					// list all actions that there were in the trace,
					// and request which one we should explain.
					final Set<Action> actions = WhyActionButton.this.questions.getAllActions();
					final JComboBox<Action> select = new JComboBox<>(actions.toArray(new Action[actions.size()]));
					final int result = JOptionPane.showConfirmDialog(null, select, "Why did you execute this action?",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (result == JOptionPane.OK_OPTION) {
						// for the selected action, fetch its explanation...
						final Action action = (Action) select.getSelectedItem();
						final List<ActionReason> reasons = questions.whyAction(action);
						final StringBuilder answer = new StringBuilder();
						for (int i = 1; i <= reasons.size(); ++i) {
							final String reason = reasons.get(i - 1).getExplanation(level,
									WhyActionButton.this.questions.getDescriptions());
							answer.append(i).append(": ").append(reason).append("\n");
						}
						// ... and show it in a new dialog
						final AnswerArea msg = new AnswerArea(answer.toString());
						JOptionPane.showMessageDialog(null, new JScrollPane(msg), "Why did you execute " + action + "?",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
		}
	}

	private static final class WhyBeliefButton extends JButton {
		private static final long serialVersionUID = 1L;
		private final WhyQuestions questions;

		WhyBeliefButton(final WhyQuestions questions, final ExplanationLevel level) {
			this.questions = questions;
			setText("WHY BELIEF?");
			addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					// list all beliefs that there were in the trace,
					// and request which one we should explain.
					final Set<Predicate> beliefs = WhyBeliefButton.this.questions.getAllBeliefs();
					final JComboBox<Predicate> select = new JComboBox<>(beliefs.toArray(new Predicate[beliefs.size()]));
					final int result = JOptionPane.showConfirmDialog(null, select, "Why did you insert this belief?",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (result == JOptionPane.OK_OPTION) {
						// for the selected belief, fetch its explanation...
						final Predicate belief = (Predicate) select.getSelectedItem();
						final List<ModificationReason> reasons = questions.whyBelief(belief);
						final StringBuilder answer = new StringBuilder();
						for (int i = 1; i <= reasons.size(); ++i) {
							final String reason = reasons.get(i - 1).getExplanation(level,
									WhyBeliefButton.this.questions.getDescriptions());
							answer.append(i).append(": ").append(reason).append("\n");
						}
						// ... and show it in a new dialog
						final AnswerArea msg = new AnswerArea(answer.toString());
						JOptionPane.showMessageDialog(null, new JScrollPane(msg), "Why did you insert " + belief + "?",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
		}
	}

	private static final class WhyGoalButton extends JButton {
		private static final long serialVersionUID = 1L;
		private final WhyQuestions questions;

		WhyGoalButton(final WhyQuestions questions, final ExplanationLevel level) {
			this.questions = questions;
			setText("WHY GOAL?");
			addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent e) {
					// list all beliefs that there were in the trace,
					// and request which one we should explain.
					final Set<Predicate> goals = WhyGoalButton.this.questions.getAllGoals();
					final JComboBox<Predicate> select = new JComboBox<>(goals.toArray(new Predicate[goals.size()]));
					final int result = JOptionPane.showConfirmDialog(null, select, "Why did you adopt this goal?",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (result == JOptionPane.OK_OPTION) {
						// for the selected belief, fetch its explanation...
						final Predicate goal = (Predicate) select.getSelectedItem();
						final List<ModificationReason> reasons = questions.whyGoal(goal);
						final StringBuilder answer = new StringBuilder();
						for (int i = 1; i <= reasons.size(); ++i) {
							final String reason = reasons.get(i - 1).getExplanation(level,
									WhyGoalButton.this.questions.getDescriptions());
							answer.append(i).append(": ").append(reason).append("\n");
						}
						// ... and show it in a new dialog
						final AnswerArea msg = new AnswerArea(answer.toString());
						JOptionPane.showMessageDialog(null, new JScrollPane(msg), "Why did you adopt " + goal + "?",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
		}
	}

	private static final class AnswerArea extends JTextArea {
		private static final long serialVersionUID = 1L;

		AnswerArea(final String answer) {
			super(answer, 10, 50);
			setEditable(false);
			setLineWrap(true);
			setWrapStyleWord(true);
		}
	}
}
