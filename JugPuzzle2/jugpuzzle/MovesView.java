package ca.utoronto.utm.jugpuzzle;

import java.awt.Color;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;

/**
 * Present a text view of the number of moves made in JugPuzzle.
 * 
 * @author CSC207
 *
 */

public class MovesView extends JLabel implements Observer {
	
	@Override
	public void update(Observable o, Object arg) {
		
		JugPuzzle jugpuzzle = (JugPuzzle)o;
		this.setText("Moves made : " + jugpuzzle.getMoves());
		
		// Aligns the text within the JLabel
		this.setHorizontalAlignment(LEFT);
		
		this.setFont(new Font("Monotype Corsiva", Font.HANGING_BASELINE, 20));
		this.setForeground(Color.DARK_GRAY);
	}
	
}
