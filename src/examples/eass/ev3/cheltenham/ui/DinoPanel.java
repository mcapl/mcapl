package eass.ev3.cheltenham.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import eass.ev3.cheltenham.DinoUI;

public class DinoPanel extends JPanel {
	public static Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	public GridBagConstraints c = new GridBagConstraints();
	DinoUI dinoUI;
	
	public DinoPanel(DinoUI ui) {
		dinoUI = ui;
		setLayout(new GridBagLayout());		
	}
	
	public DinoPanel(String title, DinoUI ui) {
		this(ui);
		setBorder(BorderFactory.createTitledBorder(loweredetched, title));
	}
	
	public DinoUI getDinoUI() {
		return dinoUI;
	}

}
