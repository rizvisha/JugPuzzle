package ca.utoronto.utm.jugpuzzle;

import java.util.Observable;
import java.util.Observer;
import javax.swing.Timer;

/**
 * Model a custom timer that counts the number of seconds passed. Initially sec (number of seconds  is set to 0 and 
 * t is not assigned to any actionListener. Both variables of this can be accessed. The sec variable can be incremented and a TimerModel
 * can be reset to initial conditions when needed.
 * 
 * @author CSC207
 *
 */

public class TimerModel extends Observable {
	
	// Declare Variables
	Timer t;
	int sec;
	
	/**
	 * Construct a TimerModel object with the timer variable set to fire every 1000 milliseconds or every second with the initial delay being
	 * one second as well. No action listener is assigned here.
	 */
	public TimerModel() {
		this.t = new Timer(1000, null);
		this.sec = 0;
	}
	
	/**
	 * 
	 * @return The number of seconds passed since the timer started.
	 */
	public int getTime() {
		return this.sec;
	}
	/**
	 * 
	 * @return The timer variable of this.
	 */
	public Timer getTimer() {
		return this.t;
	}
	
	/**
	 * Increments the integer variable sec, of this. This method is to be called by the actionListener every time the Timer
	 * object t fires, which is set to be every second.
	 */
	public void go() {
		this.sec++;
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Resets this by reverting sec to 0 and stopping the timer t so that the actionListener is not set off anymore. 
	 */
	public void reset() {
		this.t.stop();
		this.sec = 0;
		this.setChanged();
		this.notifyObservers();
	}
	
	@Override
	public synchronized void addObserver(Observer o) {
		super.addObserver(o);
		this.setChanged();
		this.notifyObservers();
	}
	
}
