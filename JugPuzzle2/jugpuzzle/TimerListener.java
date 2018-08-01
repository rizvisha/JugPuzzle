package ca.utoronto.utm.jugpuzzle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The action listener is called every time the Timer variable t of this is fired off. The listener calls on the go method which
 * increments the vale of sec of this. The value of sec represents the number of seconds passed as the Timer t of this is set to 
 * fire off every 1000 milliseconds (or every second).
 * 
 * @author CSC207
 *
 */

public class TimerListener extends TimerModel implements ActionListener {
	
	private TimerModel tmodel;
	
	TimerListener(TimerModel t){
		this.tmodel = t;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		tmodel.go();
	}
}
