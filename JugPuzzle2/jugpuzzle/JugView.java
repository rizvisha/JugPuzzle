package ca.utoronto.utm.jugpuzzle;

import java.awt.Color;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;

/**
 * Present a text view of the amounts of liquid in a Jug of JugPuzzle.
 * 
 * @author CSC207
 *
 */

public class JugView extends JLabel implements Observer {
	
	@Override
	public void update(Observable o, Object arg) {
		
		Jug jug = (Jug)o;
		this.setText("" + jug.getAmount() + "");
		
		// Centers the text within the JLabel
		this.setHorizontalAlignment(CENTER);
		
		this.setFont(new Font("Monotype Corsiva", Font.HANGING_BASELINE, 20));
		this.setForeground(Color.DARK_GRAY);
	}
	
}
