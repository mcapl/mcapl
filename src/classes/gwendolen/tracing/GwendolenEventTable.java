package gwendolen.tracing;

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

import org.apache.commons.text.StringEscapeUtils;
import org.jdesktop.swingx.JXTable;

import ail.syntax.Action;
import ail.syntax.GBelief;
import ail.syntax.Goal;
import ail.syntax.Guard;
import ail.syntax.GuardAtom;
import ail.syntax.Predicate;
import ail.tracing.EventStorage;
import ail.tracing.EventTable;
import ail.tracing.events.AbstractEvent;
import ail.tracing.explanations.AbstractReason;
import ail.tracing.explanations.ExplanationLevel;
import gwendolen.tracing.explanations.GoalReason;
import gwendolen.tracing.explanations.GuardReason;
import ail.tracing.explanations.PredicateDescriptions;
import gwendolen.tracing.explanations.WhyQuestions;
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
 */
public class GwendolenEventTable extends EventTable {

	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				File file = getFile(args);
				final EventStorage storage = new EventStorage(file);
				final WhyQuestions questions = new WhyQuestions(storage);
				GwendolenEventTable table = new GwendolenEventTable(storage, header, description);
				setUp(table, questions);
			}
		});
	}

	/**
	 * @param storage     The trace
	 * @param headers     A container at the left side of the table that can be used
	 *                    to show a header for each row.
	 * @param description A container at the bottom of the table that can be used to
	 *                    show details (i.e. of the event) for a selected column.
	 */
	public GwendolenEventTable(final EventStorage storage, final JLabel headers, final JTextComponent description) {
		super(storage, headers,description);
	}



}
