package ca.utoronto.utm.assignment1.jugpuzzle;

import static org.junit.Assert.*;

import org.junit.Test;

public class JugTest {
	
	Jug jug0 = new Jug(0);
	Jug jug1 = new Jug(1);
	Jug jug2 = new Jug(2);
	
	
	//Constructor test.
	@Test
	public void testJug() {
		
		assertEquals("jug0 bad capacity", 8,jug0.getCapacity());
		assertEquals("jug1 bad capacity", 5,jug1.getCapacity());
		assertEquals("jug2 bad capacity", 3,jug2.getCapacity());
		
		assertEquals("jug0 bad contains", 8,jug0.getContains());
		assertEquals("jug1 bad contains", 0,jug1.getContains());
		assertEquals("jug2 bad contains", 0,jug2.getContains());
	}

	@Test
	public void testtoString() {
		
		assertEquals("jug0 bad string", "0:(8/8)", jug0.toString());
			
		assertEquals("jug1 bad string", "1:(0/5)", jug1.toString());
		
		assertEquals("jug2 bad string", "2:(0/3)", jug2.toString());
	}
	
	@Test
	public void testaddLiquid() {
		
		//jug0 has no available room.
		jug0.addLiquid(1); 
		assertEquals(8, jug0.getContains());
		
		jug0.addLiquid(-1); 
		assertEquals(8, jug0.getContains());
		
		jug0.addLiquid(100); 
		assertEquals(8, jug0.getContains());
		
		jug0.addLiquid(-200); 
		assertEquals(8, jug0.getContains());
		
		//jug1 had no liquid. 5 available spaces.
		jug1.addLiquid(1);
		assertEquals(1, jug1.getContains());
		
		jug1.addLiquid(1);
		assertEquals(2, jug1.getContains());
		
		jug1.addLiquid(-2);
		assertEquals(2, jug1.getContains());
		
		jug1.addLiquid(-10000);
		assertEquals(2, jug1.getContains());
		
		jug1.addLiquid(10000);
		assertEquals(2, jug1.getContains());
		
		jug1.addLiquid(1);
		assertEquals(3, jug1.getContains());
		
		jug1.addLiquid(3);
		assertEquals(3, jug1.getContains());
		
		jug1.addLiquid(2);
		assertEquals(5, jug1.getContains());
		
		//jug1 has no more room.
		jug1.addLiquid(1);
		assertEquals(5, jug1.getContains());
		
		jug1.addLiquid(-1);
		assertEquals(5, jug1.getContains());
		
		jug1.addLiquid(1000000);
		assertEquals(5, jug1.getContains());
		
		//jug2 has no liquid
		assertEquals(0, jug2.getContains());
		
		jug2.addLiquid(1);
		assertEquals(1, jug2.getContains());
		
		jug2.addLiquid(1);
		assertEquals(2, jug2.getContains());
		
		jug2.addLiquid(1);
		assertEquals(3, jug2.getContains());
		
		//jug2 has no more room.
		jug2.addLiquid(1);
		assertEquals(3, jug2.getContains());
		
		jug2.addLiquid(2500);
		assertEquals(3, jug2.getContains());
		
		jug2.addLiquid(-2);
		assertEquals(3, jug2.getContains());
		
		jug2.addLiquid(-2500);
		assertEquals(3, jug2.getContains());
	}
	
	public void testspillLiquid() {
		//jug0 was full (8/8)
		jug0.spillLiquid(1);
		assertEquals(7, jug0.getContains());
		
		jug0.spillLiquid(2);
		assertEquals(5, jug0.getContains());
		
		//can't spill 1000
		jug0.spillLiquid(1000);
		assertEquals(5, jug0.getContains());
		
		jug0.spillLiquid(1);
		assertEquals(4, jug0.getContains());
		
		jug0.spillLiquid(3);
		assertEquals(4, jug0.getContains());
		
		jug0.spillLiquid(-3);
		assertEquals(4, jug0.getContains());
		
		jug0.spillLiquid(-2000);
		assertEquals(4, jug0.getContains());
		
		jug0.spillLiquid(4);
		assertEquals(0, jug0.getContains());
		
		//jug0 is empty.
		jug0.spillLiquid(1);
		assertEquals(0, jug0.getContains());
		
		jug0.spillLiquid(-1);
		assertEquals(0, jug0.getContains());
		
		jug0.spillLiquid(10);
		assertEquals(0, jug0.getContains());
		
		jug0.spillLiquid(-10);
		assertEquals(0, jug0.getContains());
		
		//jug1 is empty.
		jug1.spillLiquid(1);
		assertEquals(0, jug1.getContains());
		
		jug1.spillLiquid(10);
		assertEquals(0, jug1.getContains());
		
		jug1.spillLiquid(-1);
		assertEquals(0, jug1.getContains());
		
		jug1.spillLiquid(-100);
		assertEquals(0, jug1.getContains());
		
		//jug2 is empty.
		jug2.spillLiquid(1);
		assertEquals(0, jug2.getContains());
		
		jug2.spillLiquid(20);
		assertEquals(0, jug2.getContains());
		
		jug2.spillLiquid(3000);
		assertEquals(0, jug2.getContains());
		
		jug2.spillLiquid(-3);
		assertEquals(0, jug2.getContains());
		
		jug2.spillLiquid(-40000);
		assertEquals(0, jug2.getContains());
	}
}






































//**********ROUGH CODE***********
//@Test
//public void testgetContains() {
//	
//	//Check if constructed correctly.
//	assertEquals("jug0 does not contain 8", 8, jugpuzzle.getJugPuzzle(0).getContains());
//	assertEquals("jug1 does not contain 0", 0, jugpuzzle.getJugPuzzle(1).getContains());
//	assertEquals("jug2 does not contain 0", 0, jugpuzzle.getJugPuzzle(2).getContains());
//	
//	//move liquid between jugs and come up with the expected values of the liquid contained by working at the puzzle manually.
//	//if getContains() returns the correct value
//	jugpuzzle.move(0,1);
//	assertEquals("jug0 does not contain 3", 3, jugpuzzle.getJugPuzzle(0).getContains());
//	assertEquals("jug0 does not contain 5", 5, jugpuzzle.getJugPuzzle(1).getContains());
//	assertEquals("jug0 does not contain 0", 0, jugpuzzle.getJugPuzzle(2).getContains());
//	
//	jugpuzzle.move(1, 2);
//	assertEquals("jug0 does not contain 3", 3, jugpuzzle.getJugPuzzle(0).getContains());
//	assertEquals("jug0 does not contain 2", 2, jugpuzzle.getJugPuzzle(1).getContains());
//	assertEquals("jug0 does not contain 3", 3, jugpuzzle.getJugPuzzle(2).getContains());
//	
//	jugpuzzle.move(2, 1);
//	assertEquals("jug0 does not contain 3", 3, jugpuzzle.getJugPuzzle(0).getContains());
//	assertEquals("jug0 does not contain 5", 5, jugpuzzle.getJugPuzzle(1).getContains());
//	assertEquals("jug0 does not contain 0", 0, jugpuzzle.getJugPuzzle(2).getContains());
//	
//	jugpuzzle.move(1, 0);
//	assertEquals("jug0 does not contain 8", 8, jugpuzzle.getJugPuzzle(0).getContains());
//	assertEquals("jug0 does not contain 0", 0, jugpuzzle.getJugPuzzle(1).getContains());
//	assertEquals("jug0 does not contain 0", 0, jugpuzzle.getJugPuzzle(2).getContains());
//	
//	jugpuzzle.move(1, 0); //no change because 1 is empty
//	assertEquals("jug0 does not contain 8", 8, jugpuzzle.getJugPuzzle(0).getContains());
//	assertEquals("jug0 does not contain 0", 0, jugpuzzle.getJugPuzzle(1).getContains());
//	assertEquals("jug0 does not contain 0", 0, jugpuzzle.getJugPuzzle(2).getContains());
//	
//	jugpuzzle.move(2, 0); //no change because 2 is empty
//	assertEquals("jug0 does not contain 8", 8, jugpuzzle.getJugPuzzle(0).getContains());
//	assertEquals("jug0 does not contain 0", 0, jugpuzzle.getJugPuzzle(1).getContains());
//	assertEquals("jug0 does not contain 0", 0, jugpuzzle.getJugPuzzle(2).getContains());
//	
//	jugpuzzle.move(2, 1); //no change because 2 and 1, both are empty
//	assertEquals("jug0 does not contain 8", 8, jugpuzzle.getJugPuzzle(0).getContains());
//	assertEquals("jug0 does not contain 0", 0, jugpuzzle.getJugPuzzle(1).getContains());
//	assertEquals("jug0 does not contain 0", 0, jugpuzzle.getJugPuzzle(2).getContains());
//	
//	jugpuzzle.move(1, 2); //no change because 2 and 1, both are empty
//	assertEquals("jug0 does not contain 8", 8, jugpuzzle.getJugPuzzle(0).getContains());
//	assertEquals("jug0 does not contain 0", 0, jugpuzzle.getJugPuzzle(1).getContains());
//	assertEquals("jug0 does not contain 0", 0, jugpuzzle.getJugPuzzle(2).getContains());
//	
//	jugpuzzle.move(0, 2); 
//	assertEquals("jug0 does not contain 5", 5, jugpuzzle.getJugPuzzle(0).getContains());
//	assertEquals("jug0 does not contain 0", 0, jugpuzzle.getJugPuzzle(1).getContains());
//	assertEquals("jug0 does not contain 3", 3, jugpuzzle.getJugPuzzle(2).getContains());
//	
//	jugpuzzle.move(0, 1); 
//	assertEquals("jug0 does not contain 0", 0, jugpuzzle.getJugPuzzle(0).getContains());
//	assertEquals("jug0 does not contain 5", 5, jugpuzzle.getJugPuzzle(1).getContains());
//	assertEquals("jug0 does not contain 3", 3, jugpuzzle.getJugPuzzle(2).getContains());
//	
//	jugpuzzle.move(2, 1); //no change as 1 is  full.
//	assertEquals("jug0 does not contain 0", 0, jugpuzzle.getJugPuzzle(0).getContains());
//	assertEquals("jug0 does not contain 5", 5, jugpuzzle.getJugPuzzle(1).getContains());
//	assertEquals("jug0 does not contain 3", 3, jugpuzzle.getJugPuzzle(2).getContains());
//	
//	jugpuzzle.move(1, 2); //no change as 2 is  full.
//	assertEquals("jug0 does not contain 0", 0, jugpuzzle.getJugPuzzle(0).getContains());
//	assertEquals("jug0 does not contain 5", 5, jugpuzzle.getJugPuzzle(1).getContains());
//	assertEquals("jug0 does not contain 3", 3, jugpuzzle.getJugPuzzle(2).getContains());
//	
//	jugpuzzle.move(0, 1); //no change as 0 is  empty.
//	assertEquals("jug0 does not contain 0", 0, jugpuzzle.getJugPuzzle(0).getContains());
//	assertEquals("jug0 does not contain 5", 5, jugpuzzle.getJugPuzzle(1).getContains());
//	assertEquals("jug0 does not contain 3", 3, jugpuzzle.getJugPuzzle(2).getContains());
//	
//	jugpuzzle.move(0, 2); //no change as 0 is  empty.
//	assertEquals("jug0 does not contain 0", 0, jugpuzzle.getJugPuzzle(0).getContains());
//	assertEquals("jug0 does not contain 5", 5, jugpuzzle.getJugPuzzle(1).getContains());
//	assertEquals("jug0 does not contain 3", 3, jugpuzzle.getJugPuzzle(2).getContains());
//	
//	jugpuzzle.move(0, 0); //no change as from 0 to 0 is no move.
//	assertEquals("jug0 does not contain 0", 0, jugpuzzle.getJugPuzzle(0).getContains());
//	assertEquals("jug0 does not contain 5", 5, jugpuzzle.getJugPuzzle(1).getContains());
//	assertEquals("jug0 does not contain 3", 3, jugpuzzle.getJugPuzzle(2).getContains());
//	
//	jugpuzzle.move(1, 1); //no change as from 1 to 1 is no move.
//	assertEquals("jug0 does not contain 0", 0, jugpuzzle.getJugPuzzle(0).getContains());
//	assertEquals("jug0 does not contain 5", 5, jugpuzzle.getJugPuzzle(1).getContains());
//	assertEquals("jug0 does not contain 3", 3, jugpuzzle.getJugPuzzle(2).getContains());
//	
//	jugpuzzle.move(2, 2); //no change as from 2 to 2 is no move.
//	assertEquals("jug0 does not contain 0", 0, jugpuzzle.getJugPuzzle(0).getContains());
//	assertEquals("jug0 does not contain 5", 5, jugpuzzle.getJugPuzzle(1).getContains());
//	assertEquals("jug0 does not contain 3", 3, jugpuzzle.getJugPuzzle(2).getContains());
//}
//
//@Test
//public void testgetCapacity() {
//	
//	//Check if constructed correctly.
//	assertEquals("jug0 wrong capacity", 8, jugpuzzle.getJugPuzzle(0).getCapacity());
//	assertEquals("jug1 wrong capacity", 5, jugpuzzle.getJugPuzzle(1).getCapacity());
//	assertEquals("jug2 wrong capacity", 3, jugpuzzle.getJugPuzzle(2).getCapacity());
//	
//	//No matter what move, capacity remains constant.
//	jugpuzzle.move(0,1);
//	assertEquals("jug0 wrong capacity", 8, jugpuzzle.getJugPuzzle(0).getCapacity());
//	assertEquals("jug1 wrong capacity", 5, jugpuzzle.getJugPuzzle(1).getCapacity());
//	assertEquals("jug2 wrong capacity", 3, jugpuzzle.getJugPuzzle(2).getCapacity());
//	
//	jugpuzzle.move(0,2);
//	assertEquals("jug0 wrong capacity", 8, jugpuzzle.getJugPuzzle(0).getCapacity());
//	assertEquals("jug1 wrong capacity", 5, jugpuzzle.getJugPuzzle(1).getCapacity());
//	assertEquals("jug2 wrong capacity", 3, jugpuzzle.getJugPuzzle(2).getCapacity());
//	
//	jugpuzzle.move(1,2);
//	assertEquals("jug0 wrong capacity", 8, jugpuzzle.getJugPuzzle(0).getCapacity());
//	assertEquals("jug1 wrong capacity", 5, jugpuzzle.getJugPuzzle(1).getCapacity());
//	assertEquals("jug2 wrong capacity", 3, jugpuzzle.getJugPuzzle(2).getCapacity());
//	
//	jugpuzzle.move(1,0);
//	assertEquals("jug0 wrong capacity", 8, jugpuzzle.getJugPuzzle(0).getCapacity());
//	assertEquals("jug1 wrong capacity", 5, jugpuzzle.getJugPuzzle(1).getCapacity());
//	assertEquals("jug2 wrong capacity", 3, jugpuzzle.getJugPuzzle(2).getCapacity());
//	
//	jugpuzzle.move(2,1);
//	assertEquals("jug0 wrong capacity", 8, jugpuzzle.getJugPuzzle(0).getCapacity());
//	assertEquals("jug1 wrong capacity", 5, jugpuzzle.getJugPuzzle(1).getCapacity());
//	assertEquals("jug2 wrong capacity", 3, jugpuzzle.getJugPuzzle(2).getCapacity());
//	
//	jugpuzzle.move(2,0);
//	assertEquals("jug0 wrong capacity", 8, jugpuzzle.getJugPuzzle(0).getCapacity());
//	assertEquals("jug1 wrong capacity", 5, jugpuzzle.getJugPuzzle(1).getCapacity());
//	assertEquals("jug2 wrong capacity", 3, jugpuzzle.getJugPuzzle(2).getCapacity());
//	
//	jugpuzzle.move(1,2);
//	assertEquals("jug0 wrong capacity", 8, jugpuzzle.getJugPuzzle(0).getCapacity());
//	assertEquals("jug1 wrong capacity", 5, jugpuzzle.getJugPuzzle(1).getCapacity());
//	assertEquals("jug2 wrong capacity", 3, jugpuzzle.getJugPuzzle(2).getCapacity());
//	
//	jugpuzzle.move(0,2);
//	assertEquals("jug0 wrong capacity", 8, jugpuzzle.getJugPuzzle(0).getCapacity());
//	assertEquals("jug1 wrong capacity", 5, jugpuzzle.getJugPuzzle(1).getCapacity());
//	assertEquals("jug2 wrong capacity", 3, jugpuzzle.getJugPuzzle(2).getCapacity());
//	
//	jugpuzzle.move(2,1);
//	assertEquals("jug0 wrong capacity", 8, jugpuzzle.getJugPuzzle(0).getCapacity());
//	assertEquals("jug1 wrong capacity", 5, jugpuzzle.getJugPuzzle(1).getCapacity());
//	assertEquals("jug2 wrong capacity", 3, jugpuzzle.getJugPuzzle(2).getCapacity());
//	
//	jugpuzzle.move(1,2);
//	assertEquals("jug0 wrong capacity", 8, jugpuzzle.getJugPuzzle(0).getCapacity());
//	assertEquals("jug1 wrong capacity", 5, jugpuzzle.getJugPuzzle(1).getCapacity());
//	assertEquals("jug2 wrong capacity", 3, jugpuzzle.getJugPuzzle(2).getCapacity());
//	
//	jugpuzzle.move(0,1);
//	assertEquals("jug0 wrong capacity", 8, jugpuzzle.getJugPuzzle(0).getCapacity());
//	assertEquals("jug1 wrong capacity", 5, jugpuzzle.getJugPuzzle(1).getCapacity());
//	assertEquals("jug2 wrong capacity", 3, jugpuzzle.getJugPuzzle(2).getCapacity());
//	
//	jugpuzzle.move(1,0);
//	assertEquals("jug0 wrong capacity", 8, jugpuzzle.getJugPuzzle(0).getCapacity());
//	assertEquals("jug1 wrong capacity", 5, jugpuzzle.getJugPuzzle(1).getCapacity());
//	assertEquals("jug2 wrong capacity", 3, jugpuzzle.getJugPuzzle(2).getCapacity());
//	
//	jugpuzzle.move(0,2);
//	assertEquals("jug0 wrong capacity", 8, jugpuzzle.getJugPuzzle(0).getCapacity());
//	assertEquals("jug1 wrong capacity", 5, jugpuzzle.getJugPuzzle(1).getCapacity());
//	assertEquals("jug2 wrong capacity", 3, jugpuzzle.getJugPuzzle(2).getCapacity());
//}
//
//@Test
//public void testgetAvailable() {
//	
//	//Check if constructed correctly.
//	assertEquals("jug0 bad available", 0, jugpuzzle.getJugPuzzle(0).getAvailable());
//	assertEquals("jug1 bad available", 5, jugpuzzle.getJugPuzzle(1).getAvailable());
//	assertEquals("jug2 bad available", 3, jugpuzzle.getJugPuzzle(2).getAvailable());
//	
//	jugpuzzle.move(0,1);
//	assertEquals("jug0 bad available", 5, jugpuzzle.getJugPuzzle(0).getAvailable());
//	assertEquals("jug1 bad available", 0, jugpuzzle.getJugPuzzle(1).getAvailable());
//	assertEquals("jug2 bad available", 3, jugpuzzle.getJugPuzzle(2).getAvailable());
//	
//	jugpuzzle.move(1,2);
//	assertEquals("jug0 bad available", 5, jugpuzzle.getJugPuzzle(0).getAvailable());
//	assertEquals("jug1 bad available", 3, jugpuzzle.getJugPuzzle(1).getAvailable());
//	assertEquals("jug2 bad available", 0, jugpuzzle.getJugPuzzle(2).getAvailable());
//	
//	jugpuzzle.move(2,0);
//	assertEquals("jug0 bad available", 2, jugpuzzle.getJugPuzzle(0).getAvailable());
//	assertEquals("jug1 bad available", 3, jugpuzzle.getJugPuzzle(1).getAvailable());
//	assertEquals("jug2 bad available", 3, jugpuzzle.getJugPuzzle(2).getAvailable());
//	
//	jugpuzzle.move(1,0);
//	assertEquals("jug0 bad available", 0, jugpuzzle.getJugPuzzle(0).getAvailable());
//	assertEquals("jug1 bad available", 5, jugpuzzle.getJugPuzzle(1).getAvailable());
//	assertEquals("jug2 bad available", 3, jugpuzzle.getJugPuzzle(2).getAvailable());
//	
//	jugpuzzle.move(0,2);
//	assertEquals("jug0 bad available", 3, jugpuzzle.getJugPuzzle(0).getAvailable());
//	assertEquals("jug1 bad available", 5, jugpuzzle.getJugPuzzle(1).getAvailable());
//	assertEquals("jug2 bad available", 0, jugpuzzle.getJugPuzzle(2).getAvailable());
//	
//	jugpuzzle.move(2,1);
//	assertEquals("jug0 bad available", 3, jugpuzzle.getJugPuzzle(0).getAvailable());
//	assertEquals("jug1 bad available", 2, jugpuzzle.getJugPuzzle(1).getAvailable());
//	assertEquals("jug2 bad available", 3, jugpuzzle.getJugPuzzle(2).getAvailable());
//	
//	jugpuzzle.move(1,0);
//	assertEquals("jug0 bad available", 0, jugpuzzle.getJugPuzzle(0).getAvailable());
//	assertEquals("jug1 bad available", 5, jugpuzzle.getJugPuzzle(1).getAvailable());
//	assertEquals("jug2 bad available", 3, jugpuzzle.getJugPuzzle(2).getAvailable());
//
//	jugpuzzle.move(1,2);//no change as 1 is  empty.
//	assertEquals("jug0 bad available", 0, jugpuzzle.getJugPuzzle(0).getAvailable());
//	assertEquals("jug1 bad available", 5, jugpuzzle.getJugPuzzle(1).getAvailable());
//	assertEquals("jug2 bad available", 3, jugpuzzle.getJugPuzzle(2).getAvailable());
//	
//	jugpuzzle.move(2,1);//no change as 2 is  empty.
//	assertEquals("jug0 bad available", 0, jugpuzzle.getJugPuzzle(0).getAvailable());
//	assertEquals("jug1 bad available", 5, jugpuzzle.getJugPuzzle(1).getAvailable());
//	assertEquals("jug2 bad available", 3, jugpuzzle.getJugPuzzle(2).getAvailable());
//	
//	jugpuzzle.move(1,0);//no change as 1 is  empty.
//	assertEquals("jug0 bad available", 0, jugpuzzle.getJugPuzzle(0).getAvailable());
//	assertEquals("jug1 bad available", 5, jugpuzzle.getJugPuzzle(1).getAvailable());
//	assertEquals("jug2 bad available", 3, jugpuzzle.getJugPuzzle(2).getAvailable());
//	
//	jugpuzzle.move(2,0);//no change as 2 is  empty.
//	assertEquals("jug0 bad available", 0, jugpuzzle.getJugPuzzle(0).getAvailable());
//	assertEquals("jug1 bad available", 5, jugpuzzle.getJugPuzzle(1).getAvailable());
//	assertEquals("jug2 bad available", 3, jugpuzzle.getJugPuzzle(2).getAvailable());
//	
//	jugpuzzle.move(0,0);//no change as from 0 to 0 is no move.
//	assertEquals("jug0 bad available", 0, jugpuzzle.getJugPuzzle(0).getAvailable());
//	assertEquals("jug1 bad available", 5, jugpuzzle.getJugPuzzle(1).getAvailable());
//	assertEquals("jug2 bad available", 3, jugpuzzle.getJugPuzzle(2).getAvailable());
//	
//	jugpuzzle.move(1,1);//no change as from 1 to 1 is no move.
//	assertEquals("jug0 bad available", 0, jugpuzzle.getJugPuzzle(0).getAvailable());
//	assertEquals("jug1 bad available", 5, jugpuzzle.getJugPuzzle(1).getAvailable());
//	assertEquals("jug2 bad available", 3, jugpuzzle.getJugPuzzle(2).getAvailable());
//	
//	jugpuzzle.move(2,2);//no change as from 2 to 2 is no move.
//	assertEquals("jug0 bad available", 0, jugpuzzle.getJugPuzzle(0).getAvailable());
//	assertEquals("jug1 bad available", 5, jugpuzzle.getJugPuzzle(1).getAvailable());
//	assertEquals("jug2 bad available", 3, jugpuzzle.getJugPuzzle(2).getAvailable());
//	
//	jugpuzzle.move(0,1);
//	assertEquals("jug0 bad available", 5, jugpuzzle.getJugPuzzle(0).getAvailable());
//	assertEquals("jug1 bad available", 0, jugpuzzle.getJugPuzzle(1).getAvailable());
//	assertEquals("jug2 bad available", 3, jugpuzzle.getJugPuzzle(2).getAvailable());
//	
//	jugpuzzle.move(1,0);
//	assertEquals("jug0 bad available", 0, 0, jugpuzzle.getJugPuzzle(0).getAvailable());
//	assertEquals("jug1 bad available", 5, jugpuzzle.getJugPuzzle(1).getAvailable());
//	assertEquals("jug2 bad available", 3, jugpuzzle.getJugPuzzle(2).getAvailable());
//	
//	jugpuzzle.move(0,2);
//	assertEquals("jug0 bad available", 3, 0, jugpuzzle.getJugPuzzle(0).getAvailable());
//	assertEquals("jug1 bad available", 5, jugpuzzle.getJugPuzzle(1).getAvailable());
//	assertEquals("jug2 bad available", 0, jugpuzzle.getJugPuzzle(2).getAvailable());
//	
//	jugpuzzle.move(2,0);
//	assertEquals("jug0 bad available", 0, jugpuzzle.getJugPuzzle(0).getAvailable());
//	assertEquals("jug1 bad available", 5, jugpuzzle.getJugPuzzle(1).getAvailable());
//	assertEquals("jug2 bad available", 3, jugpuzzle.getJugPuzzle(2).getAvailable());
//}