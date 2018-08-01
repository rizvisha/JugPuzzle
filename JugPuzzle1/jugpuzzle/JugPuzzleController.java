package ca.utoronto.utm.assignment1.jugpuzzle;
import java.io.*;
import java.util.*;
/**
 * @author csc207student
 * This class allows a console user to play an instance of JugPuzzle.
 */
//JugPuzzleController HAS-A JugPuzzle
public class JugPuzzleController {
        private static final String INVALID_INPUT_MESSAGE="Invalid number, please enter 0,1 or 2";

        private Scanner scanner;
        private JugPuzzle jugPuzzle;

        /**
         * Constructs a new JugPuzzleController with a new JugPuzzle, 
         * ready to play with a user at the console.
         */
        public JugPuzzleController(){
                jugPuzzle=new JugPuzzle();
                scanner=new Scanner(System.in);
        }

        /** 
         * http://download.oracle.com/javase/8/docs/api/
         * 
         * Prints a message to user and prompts for input. Returns an integer input by the user if
         * it is in range lower to upper. Prints an error message if the integer is out of  range
         * or if input type is not integer.
         * 
         * @param message The message printed out to the user when the function is called.
         * @param lower   The lower limit to the number input by the user.
         * @param upper   The upper limit to the number input by the user.
         * @return        Returns the input by the user.
         */
        private int getMove(String message, int lower, int upper){
                int move;
                while(true){
                        try {
                                System.out.print(message);
                                String line=scanner.nextLine();
                                move=Integer.parseInt(line);
                                if(lower<=move && move<=upper){
                                        return move;
                                } else {
                                        System.out.println(INVALID_INPUT_MESSAGE);
                                }
                        }
                        catch(NumberFormatException e){
                                System.out.println(INVALID_INPUT_MESSAGE);
                        }
                }
        }
        /**
         * Initiates a new jugPuzzle and prints out the current status of jugPuzzle. Prompts for moves from the user utilizing the
         * getMove method as long as the puzzle is unsolved. When the win condition is met, a notification message is printed out along  
         *  with the number of moves made to solve the puzzle.
         */
        public void play(){
                while(!jugPuzzle.getIsPuzzleSolved()){
                        System.out.println(jugPuzzle); // called the toString() method of jugPuzzle
                        int from, to;
                        from = getMove("spill from jug: ", 0,2);
                        to   = getMove("into jug: ",0,2);
                        jugPuzzle.move(from,to);
                }
                if(jugPuzzle.getMoves()==1) {
                    System.out.println("Congrats you solved it in "+jugPuzzle.getMoves()+" move!!");
                } else {
                	System.out.println("Congrats you solved it in "+jugPuzzle.getMoves()+" moves!!");
                }
        }

        public static void main(String [] args){
                JugPuzzleController jpcc=new JugPuzzleController();
                jpcc.play();
        }
}
