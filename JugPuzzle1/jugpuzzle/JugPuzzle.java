package ca.utoronto.utm.assignment1.jugpuzzle;
/**
 * 
 * @author csc207student 
 *This class creates sets up a JugPuzzle game and modifies the puzzle according to the input provided by the use.
 */
//JugPuzzle RESPONDS-TO JugPuzzleController.
// JugPuzzle HAS-A Jug.
public class JugPuzzle {

	
	//Declare variables
	public Jug[] jug_array;
	public int moves;
	
	/**
	 * Creates an array of Jug type objects. Three Jug objects are created, one of each type 0, 1 and 2 and placed into an array so that 
	 * Jug of type 0 is at index 0, type 1 is at index 1 and type 2 is at index 2. This sets up the starting point of JugPuzzle.
	 */
	public JugPuzzle() {
		this.jug_array = new Jug[] {new Jug(0), new Jug(1), new  Jug(2)};
	}
	
	/**
	 * Returns the Jug object at the index n of the JugPuzzle type object (which is constructed as an array).
	 * This method is used to call ("extract") the Jug objects from the JugPuzzle object. Particularly useful in unit testing, however,
	 * for other parts of this game it was not needed.
	 * 
	 * @param n The Jug object's type, 0, 1 or 2, in the JugPuzzle
	 * @return A Jug object 0, 1 or 2 from the JugPuzzle array.
	 */
	public Jug getJugPuzzle(int n) {
		return this.jug_array[n];
	}
	
	/**
	 * Checks if the JugPuzzle has been solved or not. If the Jugs of types 0 and 2 each contain 4 units of liquid, then the puzzle is solved.
	 * Jug 1 must contain 0 units of liquid as there were 8 units of liquid to begin with.
	 * {@link JugPuzzleController#play()}
	 * 
	 * @return True if the puzzle solved. False otherwise.
	 */
	public boolean getIsPuzzleSolved() {
		
		if ((this.jug_array[0].getContains() == 4) && (this.jug_array[1].getContains() == 4)) {
			return true;
			
		} else {
			return false;
		}
	}
	
	/**
	 * Transfer liquids between Jug objects as specifies by the user. Either the Jug being spilt from is emptied or the Jug being spilt into
	 * is filled to capacity depending on whichever is achieved first. The values for the the amounts of liquid in both Jugs after spilling
	 * is set accordingly. The variable moves is incremented by 1 to keep track of the number of moves made by the user.+
	 * {@link JugPuzzleController#play()}
	 * 
	 * @param from The Jug object liquid is being spilt or transferred from.
	 * @param to The Jug object liquid is being spilt or transferred to.
	 */
	public void move(int from, int to) {
		
		if (from == to) {
			moves += 1;
			return;
		}
		
		//declare variables of type Jug
		Jug from_jug;
		Jug to_jug;
		
		from_jug = this.jug_array[from]; //jug_array[0] points to Jug(0) for instance, by construction
		to_jug = this.jug_array[to];
		
		//jug spilling has more liquid than the other jug's available space
		if (from_jug.getContains() > to_jug.getAvailable()) {
			
			int temp = to_jug.getAvailable();
			
			//the jug spills and loses amount of liquid equal to the available space in the receiving jug.
			from_jug.spillLiquid(temp);
			
			// the jug being spilt into is now full
			to_jug.addLiquid(temp);
		
		//jug spilling has less liquid than the other jugs available space	
		} else {
		
			int temp = from_jug.getContains();
			

			//the jug spills all of its liquid and is now empty
			from_jug.spillLiquid(temp);
			
			// the jug being spilt into takes all of liquid from the other jug
			to_jug.addLiquid(temp);
		}

		moves += 1;
	}
	
	public int getMoves() {
		return moves;
	}
	
	/**
	 * Creates a string representation of the number of moves made and the Jug objects in the current game, specifying their type (0, 1 or 2)
	 *  and the amount of liquid they contain out of their total capacities, and then returns it.
	 * {@link JugPuzzleController#play()}
	 * 
	 * @return String representation of the moves, Jug objects' types, contained liquid and capacities. 
	 * 
	 * For e.g. 
	 * "11 0:(3/8) 1:(0/5) 2:(5/5)" represents 11 moves made, with Jug object type 0 containing 3 units of liquid while having a total
	 * capacity to hold 8 units of liquid. Similarly for Jug objects of type 1 and 2.
	 */
	public String toString() {

		String s = getMoves()+"  "+this.jug_array[0].toString()+" "+this.jug_array[1].toString()+" "+this.jug_array[2].toString();
		return s;
	}	

}





















//*********ROUGH CODE**********
//Line 11
//private Jug jug0;
//private Jug jug1;
//private Jug jug2;

//Line 20
//this.jug_array = new Jug[3];
//this.jug_array[0]= new Jug(0);
//this.jug_array[1]= new Jug(1);
//this.jug_array[2]= new Jug(2);

//LINE 43
//figure out which jug is transferring liquid to which jug.
//if (from == 0) {
//	from_jug = jug0;
//} else if ( from == 1) {
//	from_jug = jug1;
//} else {
//	from_jug = jug2;
//}
//if (to == 0) {
//	to_jug = jug0;
//} else if ( to == 1) {
//	to_jug = jug1;
//} else {
//	to_jug = jug2;
//}

//Line 72
////declare variables of type Jug
//Jug from_jug;
//Jug to_jug;
//
//from_jug = this.jug_array[from]; //jug_array[0] points to Jug(0) for instance, by construction
//to_jug = this.jug_array[to];
//
//
////jug spilling has more liquid than the other jugs available space
//if (from_jug.getContains() > to_jug.getAvailable()) {
//	
//	from_jug.contains = from_jug.getContains() - to_jug.getAvailable(); //the jug spills and loses amount of liquid equal to the 
//																		// available space in the receiving jug.
//	to_jug.contains = to_jug.capacity; //the jug being spilt into is now full
//	
////jug spilling has less liquid than the other jugs available space	
//} else {
//	to_jug.contains = from_jug.getContains() + to_jug.getContains(); // the jug being spilt into takes all of liquid from the 
//																	 // other jug
//	from_jug.contains = 0; //the jug spills all of its liquid and is now empty
//}

//String s = getMoves()+"  "+jug0.toString()+" "+jug1.toString()+" "+jug2.toString();
//String s = getMoves()+" 0: (" + jug0.getContains()+ "/"+jug0.getCapacity()+")"+
//" 1: (" + jug1.getContains()+ "/"+jug1.getCapacity()+")"+" 2: (" + jug2.getContains()+ "/"+jug2.getCapacity()+")";