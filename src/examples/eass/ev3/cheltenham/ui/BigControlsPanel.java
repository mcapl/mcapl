package eass.ev3.cheltenham.ui;

import java.awt.Font;
import java.awt.Insets;

import eass.ev3.cheltenham.DinoUI;

public class BigControlsPanel extends ControlsPanel {

	public BigControlsPanel(String title, DinoUI ui) {
		super(title, ui);
		fbutton.setFont(new Font("Sans Serif", Font.PLAIN, 20));
		rbutton.setFont(new Font("Sans Serif", Font.PLAIN, 20));
		bbutton.setFont(new Font("Sans Serif", Font.PLAIN, 20));
		lbutton.setFont(new Font("Sans Serif", Font.PLAIN, 20));
		sbutton.setFont(new Font("Sans Serif", Font.PLAIN, 20));
		lfbutton.setFont(new Font("Sans Serif", Font.PLAIN, 20));
		Insets buttonpadding = new Insets(20, 10, 20, 10);
		fbutton.setMargin(buttonpadding);
		rbutton.setMargin(buttonpadding);
		bbutton.setMargin(buttonpadding);
		lbutton.setMargin(buttonpadding);
		sbutton.setMargin(buttonpadding);
		lfbutton.setMargin(buttonpadding);
		
	}

}
