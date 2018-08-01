package ca.utoronto.utm.assignment1.jugpuzzle;

/**
 * @author csc207student
 * This class is creates Jug objects that are to be used in JugPuzzle.
 */
//Jug RESPONDS-TO JugPuzzle.
public class Jug {
		
		public int number;
		public int capacity;
		public int contains;
		
		/**
		 * Creates Jug objects with different capacities and initial amounts of liquid they contain based on the Jug number.
		 * {@link JugPuzzle#JugPuzzle()}
		 * 
		 * @param number An integer that specifies the type of Jug object, in terms of capacity and initial amount of liquid contained.
		 */
		public Jug(int number) {
			this.number = number;
			
			if (number == 0) {
				this.capacity = 8;
				this.contains = 8;
				
			} else if (this.number == 1) {
				this.capacity = 5;
				this.contains = 0;
				
			} else {
				this.capacity = 3;
				this.contains = 0;
			}
			
		}
		
		/**
		 * Adds an positive amount of liquid to the jug given that the amount is not greater than the room available for the liquid in the 
		 * jug. If the amount is greater, then it cannot be added.
		 * 
		 * @param n The amount of liquid to be added to the jug.
		 */
		public void addLiquid(int n) {
			if ((0 <= n) && (n <= this.getAvailable())){
				int temp = this.contains;
				this.contains = temp + n;
			}
		}
		
		/**
		 * Spills an positive amount of liquid from the jug given that the amount is not greater than the liquid contained in the 
		 * jug. If the amount is greater, then it cannot be spilled.
		 * 
		 * @param n The amount of liquid to be spilled from the jug.
		 */

		public void spillLiquid(int n) {
			if ((0 <= n) && (n <= this.contains)) {
				int temp = this.contains;
				this.contains = temp - n;
			}
		}

		public int getContains() {
			return this.contains;
		}
		
		public int getCapacity() {
			return this.capacity;
		}
		
		public int getAvailable() {
			return this.capacity - this.contains;
		}
		
		/**
		 * Creates a string representation of the Jug object, specifying its type (0, 1 or 2) and the amount of liquid it contains out of
		 * its total capacity, and then returns it.
		 * {@link JugPuzzleController#play()}
		 * 
		 * @return String representation of the Jug object's type, contained liquid and capacity, for e.g. "1:(0/5)" for a Jug of type 1.
		 */
		public String toString() {
			String s = this.number+":("+this.contains+"/"+this.capacity+")";
			return s;
		}
}

