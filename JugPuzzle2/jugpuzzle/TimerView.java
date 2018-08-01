package ca.utoronto.utm.jugpuzzle;

import java.awt.Color;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;

/**
 * Present a text view of the seconds passed in the TimerModel object.
 * 
 * @author CSC207
 *
 */

public class TimerView extends JLabel implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		
		TimerModel timer = (TimerModel)o;
		this.setText(" Time elapsed: " + timer.getTime() + " seconds ");

		// Aligns the text within the JLabel
		this.setHorizontalAlignment(RIGHT);
		
		this.setFont(new Font("Monotype Corsiva", Font.HANGING_BASELINE, 20));
		this.setForeground(Color.DARK_GRAY);
	}
	
}
