package ca.utoronto.utm.jugpuzzle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * The JugPuzzl
 * Resets the JugPuzzle and TimerModel variables and the JLabel t (jl_prompt in JugPuzzleGUIController) to initial values/conditions 
 * using reset methods from JugPuzzle and TimerModel, for example Jug0 has 8/8 amount of liquid while Jug1 and Jug2 have 0/5 and 0/3,
 * respectively. All buttons in the ArrayList l (jb_list in JugPuzzleGUIController) if disabled, that is if the game was won, are enabled 
 *  again. The AtomicBoolean bool in JugPuzzleGUIController is set to true.
 *  
 * @author CSC207
 *
 */

public class NewGameActionListener extends JugPuzzle implements ActionListener {
	
	private JugPuzzle jugpuzzle;
	private JLabel jl;
	private TimerModel timer_model;
	private ArrayList<JButton> list;
	public AtomicBoolean temp;
	
	NewGameActionListener(JugPuzzle j, JLabel t, TimerModel tmodel, ArrayList<JButton> l, AtomicBoolean b) {
		this.jugpuzzle = j;
		this.jl = t;
		this.timer_model = tmodel;
		this.list = l;
		this.temp = b;
	}
	
	public void actionPerformed(ActionEvent e) {

		// Reset everything
		if (e.getActionCommand() == "New Game") {
			temp.set(true);
			jugpuzzle.reset();
			timer_model.reset();
			for (JButton item : list) {
				item.setEnabled(true);
			}
			jl.setText("Click on a Jug to begin!");
			return;
		}
	}
}
