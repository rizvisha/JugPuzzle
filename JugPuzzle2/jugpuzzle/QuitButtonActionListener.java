package ca.utoronto.utm.jugpuzzle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Exit the system when the QuitGame button is pressed.
 * 
 * @author CSC207
 *
 */

public class QuitButtonActionListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		
		System.exit(0);
	}
}
