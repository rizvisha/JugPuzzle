package ca.utoronto.utm.assignment1.jugpuzzle;

import static org.junit.Assert.*;

import org.junit.Test;

public class JugPuzzleTest {

	JugPuzzle jpuzzle = new JugPuzzle();
	JugPuzzle jpuzzle2 = new JugPuzzle();
	
	@Test
	public void testgetJugPuzzle() {
		//Check each Jug object type is initiated with correct capacity and amount of liquid.
		String s;
		s = jpuzzle.toString();

		assertEquals("jpuzzle incorrect construction", "0  0:(8/8) 1:(0/5) 2:(0/3)", s);
		
		s = jpuzzle2.toString();
		assertEquals("jpuzzle2 incorrect construction", "0  0:(8/8) 1:(0/5) 2:(0/3)", s);
		
		assertEquals("JugPuzzle0 incorrect construction", 8, jpuzzle.getJugPuzzle(0).getContains());
		assertEquals("JugPuzzle0 incorrect construction", 8, jpuzzle.getJugPuzzle(0).getCapacity());
		
		assertEquals("JugPuzzle1 incorrect construction", 0, jpuzzle.getJugPuzzle(1).getContains());
		assertEquals("JugPuzzle1 incorrect construction", 5, jpuzzle.getJugPuzzle(1).getCapacity());
		
		assertEquals("JugPuzzle2 incorrect construction", 0, jpuzzle.getJugPuzzle(2).getContains());
		assertEquals("JugPuzzle2 incorrect construction", 3, jpuzzle.getJugPuzzle(2).getCapacity());

	}

	
	@Test
	public void testtoString() {
		
		String s;
		
		//Note moves increment by 1 each time.
		
		s = jpuzzle.toString();
		assertEquals("jpuzzle bad toString move 0", "0  0:(8/8) 1:(0/5) 2:(0/3)" , s);
		
		jpuzzle.move(0,  2);
		s = jpuzzle.toString();
		assertEquals("jpuzzle bad toString move 1", "1  0:(5/8) 1:(0/5) 2:(3/3)" , s);
		
		jpuzzle.move(2, 1);
		s = jpuzzle.toString();
		assertEquals("jpuzzle bad toString move 2", "2  0:(5/8) 1:(3/5) 2:(0/3)" , s);
		
		jpuzzle.move(0, 2);
		s = jpuzzle.toString();
		assertEquals("jpuzzle bad toString move 3", "3  0:(2/8) 1:(3/5) 2:(3/3)" , s);
		
		jpuzzle.move(2, 1);
		s = jpuzzle.toString();
		assertEquals("jpuzzle bad toString move 4", "4  0:(2/8) 1:(5/5) 2:(1/3)" , s);
		
		jpuzzle.move(1, 0);
		s = jpuzzle.toString();
		assertEquals("jpuzzle bad toString move 5", "5  0:(7/8) 1:(0/5) 2:(1/3)" , s);
		
		jpuzzle.move(2, 1);
		s = jpuzzle.toString();
		assertEquals("jpuzzle bad toString move 6", "6  0:(7/8) 1:(1/5) 2:(0/3)" , s);
		
		jpuzzle.move(0, 2);
		s = jpuzzle.toString();
		assertEquals("jpuzzle bad toString move 7", "7  0:(4/8) 1:(1/5) 2:(3/3)" , s);
		
		jpuzzle.move(2, 1);
		s = jpuzzle.toString();
		assertEquals("jpuzzle bad toString move 8", "8  0:(4/8) 1:(4/5) 2:(0/3)" , s);
		
		jpuzzle.move(0, 0);
		s = jpuzzle.toString();
		assertEquals("jpuzzle bad toString move 9", "9  0:(4/8) 1:(4/5) 2:(0/3)" , s);
		
		jpuzzle.move(1, 1);
		s = jpuzzle.toString();
		assertEquals("jpuzzle bad toString move 10", "10  0:(4/8) 1:(4/5) 2:(0/3)" , s);
		
		jpuzzle.move(2, 2);
		s = jpuzzle.toString();
		assertEquals("jpuzzle bad toString move 11", "11  0:(4/8) 1:(4/5) 2:(0/3)" , s);
		
		jpuzzle.move(2, 0);
		s = jpuzzle.toString();
		assertEquals("jpuzzle bad toString move 12", "12  0:(4/8) 1:(4/5) 2:(0/3)" , s);
		
		jpuzzle.move(2, 1);
		s = jpuzzle.toString();
		assertEquals("jpuzzle bad toString move 13", "13  0:(4/8) 1:(4/5) 2:(0/3)" , s);
		
		jpuzzle.move(0, 1);
		s = jpuzzle.toString();
		assertEquals("jpuzzle bad toString move 14", "14  0:(3/8) 1:(5/5) 2:(0/3)" , s);
		
		jpuzzle.move(0, 2);
		s = jpuzzle.toString();
		assertEquals("jpuzzle bad toString move 15", "15  0:(0/8) 1:(5/5) 2:(3/3)" , s);
		
		jpuzzle.move(1, 0);
		s = jpuzzle.toString();
		assertEquals("jpuzzle bad toString move 16", "16  0:(5/8) 1:(0/5) 2:(3/3)" , s);
	}
	
	
	@Test
	public void getIsPuzzleSolved() {
		//initially 0 contains 8 and 1 contains 0.
		assertEquals("Should not be solved move 0", false, jpuzzle.getIsPuzzleSolved());
		
		jpuzzle.move(0, 2);
		//0 contains 5 and 1 contains 0.
		assertEquals("Should not be solved move 1", false, jpuzzle.getIsPuzzleSolved());
		
		jpuzzle.move(2, 1);
		//0 contains 5 and 1 contains 3.
		assertEquals("Should not be solved move 2", false, jpuzzle.getIsPuzzleSolved());
		
		jpuzzle.move(0, 2);
		//0 contains 2 and 1 contains 3.
		assertEquals("Should not be solved move 3", false, jpuzzle.getIsPuzzleSolved());
		
		jpuzzle.move(2, 1);
		//0 contains 2 and 1 contains 5.
		assertEquals("Should not be solved move 4", false, jpuzzle.getIsPuzzleSolved());
		
		jpuzzle.move(1, 0);
		//0 contains 7 and 1 contains 0.
		assertEquals("Should not be solved move 5", false, jpuzzle.getIsPuzzleSolved());
		
		jpuzzle.move(2, 1);
		//0 contains 7 and 1 contains 1.
		assertEquals("Should not be solved move 6", false, jpuzzle.getIsPuzzleSolved());
		
		jpuzzle.move(0, 2);
		//0 contains 4 and 1 contains 1.
		assertEquals("Should not be solved move 7", false, jpuzzle.getIsPuzzleSolved());
		
		jpuzzle.move(0, 0);
		//no move
		assertEquals("Should not be solved move 8", false, jpuzzle.getIsPuzzleSolved());
		
		jpuzzle.move(2, 1);
		//0 contains 4 and 1 contains 4.
		assertEquals("Should be solved move 9", true, jpuzzle.getIsPuzzleSolved());
		
		jpuzzle.move(0, 0);
		//no move.
		assertEquals("Should be solved move 10", true, jpuzzle.getIsPuzzleSolved());
		
		jpuzzle.move(1, 1);
		//no move.
		assertEquals("Should be solved move 11", true, jpuzzle.getIsPuzzleSolved());
		
		jpuzzle.move(2, 2);
		//no move.
		assertEquals("Should be solved move 12", true, jpuzzle.getIsPuzzleSolved());
		
		jpuzzle.move(2, 0);
		//2 is empty.
		assertEquals("Should be solved move 13", true, jpuzzle.getIsPuzzleSolved());
		
		jpuzzle.move(2, 1);
		//2 is empty.
		assertEquals("Should be solved move 14", true, jpuzzle.getIsPuzzleSolved());
		
		jpuzzle.move(0, 1);
		//0 contains 3 and 1 contains 5.
		assertEquals("Should not be solved move 15", false, jpuzzle.getIsPuzzleSolved());
		
		jpuzzle.move(0, 2);
		//0 contains 0 and 1 contains 5.
		assertEquals("Should not be solved move 16", false, jpuzzle.getIsPuzzleSolved());
		
		jpuzzle.move(1, 0);
		//0 contains 5 and 1 contains 0.
		assertEquals("Should not be solved move 17", false, jpuzzle.getIsPuzzleSolved());
	}
	
	@Test
	public void getMoves() {
		//no moves have been made on jpuzzle
		assertEquals("should be 0 moves", 0, jpuzzle.getMoves());
		
		//jpuzzle moves 0+4=4
		jpuzzle.move(1, 0);
		jpuzzle.move(1, 1);
		jpuzzle.move(1, 2);
		jpuzzle.move(1, 0);
		assertEquals("should be 4 moves", 4, jpuzzle.getMoves());
		
		//no moves have been made on jpuzzle2
		assertEquals("should be 0 moves", 0, jpuzzle2.getMoves());
		
		//jpuzzle2 moves 0+1=1
		jpuzzle2.move(0, 1);
		assertEquals("should be 1 moves", 1, jpuzzle2.getMoves());
		
		//jpuzzle2 moves 1+1=2
		jpuzzle2.move(0, 1);
		assertEquals("should be 2 moves", 2, jpuzzle2.getMoves());
		
		//jpuzzle2 moves 2+12=14
		jpuzzle2.move(1, 2);
		jpuzzle2.move(0, 2);
		jpuzzle2.move(1, 0);
		jpuzzle2.move(0, 1);
		jpuzzle2.move(0, 2);
		jpuzzle2.move(1, 0);
		jpuzzle2.move(1, 2);
		jpuzzle2.move(2, 1);
		jpuzzle2.move(1, 2);
		jpuzzle2.move(1, 1);
		jpuzzle2.move(1, 0);
		jpuzzle2.move(0, 0);
		assertEquals("should be 14 moves", 14, jpuzzle2.getMoves());
		
		//jpuzzle2 moves 14+6=20
		jpuzzle2.move(1, 2);
		jpuzzle2.move(2, 1);
		jpuzzle2.move(1, 2);
		jpuzzle2.move(1, 1);
		jpuzzle2.move(1, 0);
		jpuzzle2.move(0, 0);
		assertEquals("should be 20 moves", 20, jpuzzle2.getMoves());
		
		//jpuzzle moves 4+3=7
		jpuzzle.move(1, 0);
		jpuzzle.move(1, 1);
		jpuzzle.move(1, 2);
		assertEquals("should be 7 moves", 7, jpuzzle.getMoves());
		
		jpuzzle.move(1, 2);
		assertEquals("should be 8 moves", 8, jpuzzle.getMoves());
		
		jpuzzle2.move(0, 0);
		jpuzzle2.move(2, 1);
		assertEquals("should be 22 moves", 22, jpuzzle2.getMoves());
	}
	

}
