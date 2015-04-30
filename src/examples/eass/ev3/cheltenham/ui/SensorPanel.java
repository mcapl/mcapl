package eass.ev3.cheltenham.ui;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import eass.ev3.cheltenham.DinoEnvironment;
import eass.ev3.cheltenham.DinoUI;

public class SensorPanel extends DinoPanel {
	JLabel vtext = new JLabel("Ultrasonic Sensor Values:");
	JTextArea textArea = new JTextArea(15, 30);
    JPanel output = new JPanel();
    protected TextAreaOutputStream uvalues;
    
    @Override
    public void setEnabled(boolean enabled) {
    	super.setEnabled(enabled);
    	vtext.setEnabled(enabled);
    	textArea.setEnabled(enabled);
    	output.setEnabled(enabled);
    	
    }
		        
	public SensorPanel(String title, DinoUI ui) {
		super(title, ui);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        add(vtext, c);
        uvalues = new TextAreaOutputStream(textArea, "Ultrasound Sensor Value");
        output.add(new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        add(output, c);
		
	}

	public void componentShown() {
		// TODO Auto-generated method stub
        ((DinoEnvironment) getDinoUI().env).setUltraPrintStream(getDinoUI().rName, new PrintStream(uvalues));
	}
	
    /**
     * A text area to display the contents of an output stream.
     * @author lad
     *
     */
    public class TextAreaOutputStream extends OutputStream {

    	   private final JTextArea textArea;
    	   private final StringBuilder sb = new StringBuilder();
    	   private String title;

    	   public TextAreaOutputStream(final JTextArea textArea, String title) {
    	      this.textArea = textArea;
    	      this.title = title;
    	      sb.append(title + "> ");
    	   }

    	   /*
    	    * (non-Javadoc)
    	    * @see java.io.OutputStream#flush()
    	    */
    	   public void flush() {
    	   }

    	   /*
    	    * (non-Javadoc)
    	    * @see java.io.OutputStream#close()
    	    */
    	   public void close() {
    	   }

    	   /*
    	    * (non-Javadoc)
    	    * @see java.io.OutputStream#write(int)
    	    */
    	   public void write(int b) throws IOException {

    	      if (b == '\r')
    	         return;

    	      if (b == '\n') {
    	         final String text = sb.toString() + "\n";
    	         SwingUtilities.invokeLater(new Runnable() {
    	            public void run() {
    	               textArea.append(text);
    	            }
    	         });
    	         sb.setLength(0);
    	         sb.append(title + "> ");
    	         return;
    	      }

    	      sb.append((char) b);
    	   }
    }


}
