package ca.utoronto.utm.jugpuzzle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * Recognizes the first button pressed (jug to be spilt from) and the second button pressed (jug to be spilt into) and makes the 
 * appropriate move by calling the move method from JugPuzzle. The JLabel jl_prompt on JugPuzzleGUIController is appropriately modified.
 * The first time a button is pressed in a new JugPuzzle game, a timer is started. Checks if game is won after every move. 
 * When game is won disables all 3 Jug buttons and displays a "game won" message and stop timer. Continue to make moves if game is not won.
 * 
 * @author CSC207
 *
 */

public class JugButtonActionListener extends JugPuzzle implements ActionListener {
	
	private JugPuzzle jugpuzzle;
	private JLabel jl;
	private TimerModel timer_model;
	private ArrayList<JButton> list;
	public AtomicBoolean temp;
	
	JugButtonActionListener(JugPuzzle j, JLabel t, TimerModel tmodel, ArrayList<JButton> l, AtomicBoolean b) {
		this.jugpuzzle = j;
		this.jl = t;
		this.timer_model = tmodel;
		this.list = l;
		this.temp = b;
	}
	
	int button1;
	int button2;
	int button;

	public void actionPerformed(ActionEvent e) {
			
		button = Integer.parseInt(e.getActionCommand());

		if (temp.get()) {
			
			button1 = button;
			
			if (!timer_model.getTimer().isRunning()) {
				timer_model.getTimer().start();
			}
			
			temp.set(false);
			jl.setText("Spill from " + e.getActionCommand() + " to ?");
			
		} else {
			
			button2 = button;
			jugpuzzle.move(button1, button2);
			
			// Check if the puzzle is solved after spilling from one jug to another
			if (jugpuzzle.getIsPuzzleSolved()) {
				
				jl.setText("Congrats you solved it in " + jugpuzzle.getMoves() + " moves and " + timer_model.getTime() + " seconds!");
				timer_model.getTimer().stop();
				
				// Disable buttons if solved
				for (JButton item : list) {
					item.setEnabled(false);
				}
				return;
			}
			temp.set(true);
			jl.setText("Spill From?");
			
		
		}
	}
}
