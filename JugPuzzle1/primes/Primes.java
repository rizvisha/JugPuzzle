package ca.utoronto.utm.assignment1.primes;
import java.util.ArrayList;

public class Primes {
    public static void main(String [] args){

            System.out.println(primes(10000)[9999]);
            System.out.println(primesLessThan(10000));

            int n = 100000;
            ArrayList<Integer> a;
            long start, end;
            
//            /**
            start = System.currentTimeMillis();
            a = primesLessThan(n);
            end = System.currentTimeMillis();
            System.out.println(a.size()+ " " + (end-start));
            
            start = System.currentTimeMillis();
            a = primesLessThanSieveRemove(n);
            end = System.currentTimeMillis();
            System.out.println(a.size()+ " " + (end-start));
            
            start = System.currentTimeMillis();
            a = primesLessThanSieveAdd(n);
            end = System.currentTimeMillis();
            System.out.println(a.size()+ " " + (end-start));
            
            start = System.currentTimeMillis();
            a = primesLessThanSieveRemove2(n);
            end = System.currentTimeMillis();
            System.out.println(a.size()+ " " + (end-start));
//            **/
    }
    
    //ANSWER: primesLessThanSieveAdd turned out to be the FASTEST because unlike other methods it does not iterate over a long ArrayList, 
    //but adds to it and returns it.
    
    /**
     * Determines whether a number is a prime number or not.
     * 
     * @param n The number given to the method to be classified as prime  or not.
     * @return Returns true if n was prime, false if it was not.
     */
    
	public static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		} else {
			for (int i = 2; i < n; i = i + 1) {
				if (n % i == 0) {
					return false;
				}
			}
			return true;
		}
	}
	
	/**
	 * Returns a set number of primes in ascending order, starting with 2, as an array. Non positive numbers return an empty array.
	 * 
	 * @param n The number of primes to be determined. 
	 * @return Array of primes
	 */
	public static int[] primes(int n) {
		int current = 2;
		int num_primes = 0;
		
		if (n < 1) {	// return empty array for non positive n
			int[] bogus = new int[0];
			return bogus;
		}

		int[] list_of_primes = new int[n];
		
		while (num_primes < n) {
			if (isPrime(current)) {
				list_of_primes[num_primes] = current;
				num_primes = num_primes + 1;
			}
			current = current + 1;
		}
		return list_of_primes;
	}
	
	/**
	 * Returns an ArrayList of all of the primes smaller in magnitude than a given integer by calling on the isPrime method on 
	 * every number from 2 to that fixed integer. Non positive argument returns empty ArrayList.
	 * 
	 * @param n All primes less than this number would be determined.  
	 * @return An ArrayList of primes.
	 */
	public static ArrayList<Integer> primesLessThan(int n) {
		
		ArrayList<Integer> primes = new ArrayList<Integer>(); //initiated primes as an Integer ArrayList.
		int current = 2; //current will be iterated over as 2,3,...,n-1. 
		
		while (current < n) {
			if (isPrime(current)) { //check if it is prime.
				primes.add(current); //add to the ArrayList.
			}
			current += 1;
			
		}
		return primes;
	}
	
	/**
	 * Returns an ArrayList of all of the primes smaller in magnitude than a given integer by first constructing an ArrayList
	 * of numbers from 2 to n. Then filtering out all numbers that are multiples of a smaller number in that ArrayList.
	 * 
	 * @param n All primes less than this number would be determined.  
	 * @return An ArrayList of primes.
	 */
	public static ArrayList<Integer> primesLessThanSieveRemove(int n) {

		ArrayList<Integer> primes = new ArrayList<Integer>(); //initiated primes as an Integer ArrayList.

		for (int i = 2; i < n; i += 1) { //iterates over i and appends 2,3,4,...,n-1 to primes.
			primes.add(i);
		}

		int primes_size = primes.size(); //variable for storing updated list size
		
		for (int j = 2; j < primes_size; j += 1) { //iterates over numbers from 2 to n.
			
			//iterate over elements in primes and filter out multiples of j.
			for (int i = 0; i < primes_size; i += 1) {
				
				if ((primes.get(i) % j == 0) && (primes.get(i) != j)) { 
					
					primes.remove(i); //remove the number if it is a multiple of j.
					primes_size = primes.size(); //update list size
				}
			}
		}
		
		return primes;
	}
	
	/**
	 * Returns an ArrayList of all of the primes smaller in magnitude than a given integer by creating an empty ArrayList and then 
	 * adding numbers to the ArrayList one by one given that given that the number is indivisible by any number already in the array
	 * 
	 * @param n All primes less than this number would be determined.  
	 * @return An ArrayList of primes.
	 */
	public static ArrayList<Integer> primesLessThanSieveAdd(int n) {
		
		ArrayList<Integer> primes = new ArrayList<Integer>(); //initiated primes as an Integer ArrayList.
		int primes_size= primes.size(); //variable for storing updated list size

		for(int i=2; i < n; i +=1 ) { //iterate over all numbers 2,3,...,n-1.
			
			if (primes.isEmpty()) { //put 2 in primes.
				primes.add(i);
				primes_size = primes.size();
			}
			
			boolean is_prime= true;
			
			//iterate over items in the ArrayList primes.
			mainloop:
			for(int j = 0; j < primes_size; j += 1) { 
			
				if (i % primes.get(j) == 0) { //number i is not prime. move on to the next number.
					is_prime = false;
					break mainloop; //stop checking i if it is divisible by a "primes" element.
				}
			}
			if (is_prime) { //if no element in primes divides i, execute.
				primes.add(i);
				primes_size = primes.size(); //update the size of primes.
			}

		}
		return primes;
	}
	
	/**
	 * Returns an ArrayList of all of the primes smaller in magnitude than a given integer by creating an ArrayList of booleans 
	 * of set capacity with all elements set to true. The value is set to false for indices that are multiples of some other integer
	 * in the indices of the array. The integer values of indices that remain true are then copied to the ArrayList which is then returned.
	 * 
	 * @param n All primes less than this number would be determined.  
	 * @return An ArrayList of primes.
	 */
	public static ArrayList<Integer> primesLessThanSieveRemove2(int n) {
		
		if (n < 1) {
			ArrayList<Integer> bogus = new ArrayList<Integer>();
			return bogus;
		}

		boolean[] primes = new boolean[n]; //initiate a boolean array, primes.
		ArrayList<Integer> mylist = new ArrayList<Integer>(); //initiate ArrayList to call helper function, get_multiples.
		
		for (int i = 2; i < n; i += 1) { //make all values 2 to n-1 true. 0 and 1 are not primes.
			primes[i] = true;
		}
		
		//make an ArrayList of all multiples of i
		for (int i = 2; i < n; i += 1) {
			mylist = get_multiples(i, n); //call to the helper function which returns an ArrayList of multiples of i, less than n.
			
			//change the instances at multiples of i, but not i, to false
			for(int item : mylist) {
				primes[item] =  false;
			}
			
			//clear list to repeat for next i
			mylist.clear();
		}
		
		ArrayList<Integer> filtered_primes = new ArrayList<Integer>();
		
		// add all indices of primes with element true to filtered_primes.
		int index =  0;
		for(boolean item : primes) {
			if(item == true) {
				filtered_primes.add(index);
			}
			index += 1;
		}
		return filtered_primes;
	}
	
	/**
	 * Returns an ArrayList of all multiples of a given number that are less than another given number.
	 * 
	 * @param m The number whose multiples are to be determined.  
	 * @param n The number who sets the upper bound to the multiples.
	 * @return An ArrayList of integers.
	 */
	//HELPER  FUNCTION FOR primesLessThanSieveRemove2
	public static ArrayList<Integer> get_multiples(int m, int n) {
		
		ArrayList<Integer> list_of_multiples = new ArrayList<Integer>();
		
		//returns a list with all multiples of m, except m itself, that are less than n; no multiples repeat in the list.
		for (int i = m; i < n; i += 1) {
			if ((i % m == 0) && (!list_of_multiples.contains(i) && (i != m))) {
				list_of_multiples.add(i);
			}
		}
		return list_of_multiples;
	}
	
}


























//*********ROUGH CODE***********
//LINE 165
//for(int item : mylist) {
//primes[item] =  false;
//}
//
////find indices that are multiple of numbers 2,...,n-1 other than themselves and set values at them to false.
//for (int i = 2; i < n; i += 1) { //iterates over 2,...,n-1.
//for (int j = 2; j < n; j += 1) { //iterates over elements in primes.
//	if(((j % i == 0) && (j != i)) && (primes[j] == true)) {
//		primes[j] = false;
//	}
//}
//}
//9592 1124
//9592 668
//9592 182
//9592 15507
//
//9592 152024
//9592 3252
//9592 154
//9592 24261

