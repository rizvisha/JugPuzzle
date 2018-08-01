package ca.utoronto.utm.jugpuzzle;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;


public class JugPuzzleGUIController {
	public static void main(String[] args) {
		//Change the "theme" (the look and feel) to Nimbus
		try { 
		    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
		} catch (Exception ex) { 
		    ex.printStackTrace(); 
		}
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	public static void createAndShowGUI() {
		
		// Fonts and color used in GUI to make it look good
		Font font = new Font("Monotype Corsiva", Font.HANGING_BASELINE, 20);
		Color color =  Color.BLUE;
		
		//Create and hook up the Model, View and the controller
		
		// Create View instances
		JugView jug0view = new JugView();
		JugView jug1view = new JugView();
		JugView jug2view = new JugView();
		MovesView movesView = new MovesView();
		TimerView timerView = new TimerView();

		// Create Model
		JugPuzzle model_j1 = new JugPuzzle();
		Jug jug0 = model_j1.getJug(0);
		Jug jug1 = model_j1.getJug(1);
		Jug jug2 = model_j1.getJug(2);
		TimerModel timer = new TimerModel();

		// Hook the model to the view.
		model_j1.addObserver(movesView);
		jug0.addObserver(jug0view);
		jug1.addObserver(jug1view);
		jug2.addObserver(jug2view);
		timer.addObserver(timerView);

		// Create the GUI controller to control the Model
		JFrame frame = new JFrame("Jug Puzzle"); // Frame with title
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		Container mainContentPane = frame.getContentPane();

		// Layout components in a Box Layout, with one column
		mainContentPane.setLayout(new BoxLayout(mainContentPane, BoxLayout.Y_AXIS));
		
		// References to JButtons
		JButton jug0button, jug1button, jug2button, jb_new, jb_quit; 

		// Create the buttons with desired font and color
		ArrayList<JButton> jb_list = new ArrayList<JButton>();
		jb_list.add(jug0button = new JButton("0"));
		jb_list.add(jug1button = new JButton("1"));
		jb_list.add(jug2button = new JButton("2"));
		jb_list.add(jb_new = new JButton("New Game"));
		jb_new.setAlignmentX(Component.CENTER_ALIGNMENT); //Centers the object within the content pane
		jb_list.add(jb_quit = new JButton("Quit Game"));
		jb_quit.setAlignmentX(Component.CENTER_ALIGNMENT); //Centers the object within the content pane
		
		for (JButton item : jb_list) {
			item.setFont(font);
			if (item == jb_quit) {
				item.setForeground(Color.RED);
			} else {
			item.setForeground(color);
			}
		}

		 // References to JLabels
		JLabel jl_prompt, jl_amounts, jl_capacities, jl_jugs, jug0label, jug1label, jug2label;
		
		// Create centered JLabels
		ArrayList<JLabel> jl_list = new ArrayList<JLabel>();
		
		jl_list.add(jl_prompt = new JLabel("Click on a Jug to begin!"));
		jl_prompt.setAlignmentX(Component.CENTER_ALIGNMENT); //Centers the object within the content pane
		jl_list.add(jl_jugs = new JLabel("Jugs:"));
		jl_list.add(jug0label = new JLabel("8"));
		jl_list.add(jug1label = new JLabel("5"));
		jl_list.add(jug2label = new JLabel("3"));
		jl_list.add(jl_amounts = new JLabel("Amount of liquid in Jug:"));
		jl_list.add(jl_capacities = new JLabel("Capacity of Jug:"));

		for (JLabel item : jl_list) {
			item.setHorizontalAlignment(JLabel.CENTER); //Centers the text within the JLabel
			item.setFont(font);
			item.setForeground(color);
		}
		
		// Create a sub-panel to add to the main content pane
		JPanel sub_panel = new JPanel();
		sub_panel.setLayout(new GridLayout(3,4));
		
		// Add contents to the sub-panel in PROPER ORDER!
		// Row 1
		sub_panel.add(jl_amounts);
		sub_panel.add(jug0view);
		sub_panel.add(jug1view);
		sub_panel.add(jug2view);
		
		
		// Row 2
		sub_panel.add(jl_capacities);
		sub_panel.add(jug0label);
		sub_panel.add(jug1label);
		sub_panel.add(jug2label);
		
		// Row 3
		sub_panel.add(jl_jugs);
		sub_panel.add(jug0button);
		sub_panel.add(jug1button);
		sub_panel.add(jug2button);
		
		// Create ANOTHER sub-panel to add to the main content pane
		JPanel sub_panel2 = new JPanel();
		sub_panel2.setLayout(new GridLayout(1,2));
		
		// Add contents to sub-panel2 in PROPER ORDER!
		sub_panel2.add(movesView);
		sub_panel2.add(timerView);

		// Add everything to the Main Content Pane in PROPER ORDER!
		mainContentPane.add(jl_prompt);
		mainContentPane.add(sub_panel);
		mainContentPane.add(jb_new);
		mainContentPane.add(jb_quit);
		mainContentPane.add(sub_panel2);
		
		// Configure jb_list created earlier so it contains only the jug buttons
		jb_list.remove(jb_new);
		jb_list.remove(jb_quit);

		// Create button press event handlers
		AtomicBoolean bool = new AtomicBoolean(true); // boolean is pass by value so it can't be changed in NewGameActionListener
		
		JugButtonActionListener mainListener = new JugButtonActionListener(model_j1, jl_prompt, timer, jb_list, bool);
		
		NewGameActionListener newListen = new NewGameActionListener(model_j1, jl_prompt, timer, jb_list, bool);
		
		QuitButtonActionListener quitListen = new QuitButtonActionListener();
		
		TimerListener timerlistener = new TimerListener(timer);

		
		// Tell all five buttons who they should call when they are pressed
		// That is, hook up the controller to the Model
		jb_new.addActionListener(newListen);
		jb_quit.addActionListener(quitListen);
		for (JButton item : jb_list) {
			item.addActionListener(mainListener);
		}
		timer.getTimer().addActionListener(timerlistener);

		// tell the frame to pack in all the components
		// this is done according to the layout manager
		frame.pack();
		
		// Open frame in the center of the screen
		// Works by setting location of frame (x,y) to x = centerPoint.x - windowSize.width/2; y = centerPoint.y - windowSize.height/2;
		// where centerPoint is the center of the screen and windowSize is the dimension of  the JFrame
		frame.setLocationRelativeTo(null);

		// lets see the frame
		frame.setVisible(true);
	}
}
