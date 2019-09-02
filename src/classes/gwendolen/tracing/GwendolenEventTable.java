package gwendolen.tracing;

import java.io.File;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.text.JTextComponent;


import ail.tracing.EventStorage;
import ail.tracing.EventTable;
import gwendolen.tracing.explanations.WhyQuestions;

/**
 * A space-time view (see "Omniscient Debugging for Cognitive Agent Programs",
 * Koeman et. al 2017) for a trace (i.e. {@link EventStorage}). The main method
 * of this class requests a trace file to be loaded in, and shows the table
 * along with explanation buttons (see {@link WhyQuestions}).
 */
public class GwendolenEventTable extends EventTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
