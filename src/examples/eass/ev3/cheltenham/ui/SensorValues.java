// ----------------------------------------------------------------------------
// Copyright (C) 2015 Strategic Facilities Technology Council 
//
// This file is part of the Engineering Autonomous Space Software (EASS) Library.
// 
// The EASS Library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The EASS Library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the EASS Library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------
package eass.ev3.cheltenham.ui;

import java.awt.Color;
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

/**
 * A Class for displaying the incoming values from some sensor stream in a text area.
 * @author lad
 *
 */
public class SensorValues extends DinoPanel {
	private static final long serialVersionUID = 1L;
	
	JLabel vtext = new JLabel("Ultrasonic Sensor Values:");
	JTextArea textArea = new JTextArea(8, 20);
    JPanel output = new JPanel();
    protected TextAreaOutputStream values;
    public enum SensorType {
    	ULTRASONIC, RED, GREEN
    }
    SensorType type = SensorType.ULTRASONIC;
    
	public SensorValues(String title, DinoUI ui, String textAreaTitle, boolean longpanes) {
		super(title, ui);
		if (longpanes) {
			textArea = new JTextArea(17, 30);
		}
		vtext = new JLabel(textAreaTitle);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        add(vtext, c);
        values = new TextAreaOutputStream(textArea);
        JScrollPane scrollpane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollpane.setBackground(Color.WHITE);
        output.add(scrollpane);
        output.setBackground(Color.WHITE);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        add(output, c);
		if (title.equals("Ultrasonic Sensor")) {
			type = SensorType.ULTRASONIC;
		} else if (title.equals("Red Light")) {
			type = SensorType.RED;
		} else {
			type = SensorType.GREEN;
		}

		
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#setEnabled(boolean)
	 */
	@Override
    public void setEnabled(boolean enabled) {
    	super.setEnabled(enabled);
    	vtext.setEnabled(enabled);
    	textArea.setEnabled(enabled);
    	output.setEnabled(enabled);
    	
    }
		        
	/**
	 * If this component is shown (e.g., the tab containing it is selected) then grab the appropriate streams.
	 */
	public void componentShown() {
		switch (type) {
		case ULTRASONIC:
			((DinoEnvironment) getDinoUI().getEnv()).setUltraPrintStream(getDinoUI().getRName(), new PrintStream(values));
			break;
		case RED:
			((DinoEnvironment) getDinoUI().getEnv()).setRedPrintStream(getDinoUI().getRName(), new PrintStream(values));
			break;
		default:
			((DinoEnvironment) getDinoUI().getEnv()).setGreenPrintStream(getDinoUI().getRName(), new PrintStream(values));
			break;

		}
	}
	
    /**
     * A text area to display the contents of an output stream.
     * @author lad
     *
     */
    public class TextAreaOutputStream extends OutputStream {

    	   private final JTextArea textArea;
    	   private final StringBuilder sb = new StringBuilder();

    	   public TextAreaOutputStream(final JTextArea textArea) {
    	      this.textArea = textArea;
     	      textArea.setBackground(Color.WHITE);
    	      sb.append("> ");
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
    	         sb.append("> ");
    	         return;
    	      }

    	      sb.append((char) b);
    	   }
    }

}
