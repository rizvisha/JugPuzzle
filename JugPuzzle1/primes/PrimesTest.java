package ca.utoronto.utm.assignment1.primes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class PrimesTest {

	// Add in a testXX for each public method XX in Primes
	
	@Test
	public void testIsPrime() {
		assertEquals("2 is prime", true, Primes.isPrime(2));
		assertEquals("3 is prime", true, Primes.isPrime(3));
		assertEquals("5 is prime", true, Primes.isPrime(5));
		assertEquals("11 is prime", true, Primes.isPrime(11));
		assertEquals("101 is prime", true, Primes.isPrime(101));
		
		assertEquals("-7 is not prime", false, Primes.isPrime(-7));
		assertEquals("-1 is not prime", false, Primes.isPrime(-1));
		assertEquals("0 is not prime", false, Primes.isPrime(-0));
		assertEquals("1 is not prime", false, Primes.isPrime(1));
		assertEquals("4 is not prime", false, Primes.isPrime(4));
		assertEquals("6 is not prime", false, Primes.isPrime(6));
	}
	
	@Test
	public void testprimes() {
		Assert.assertArrayEquals("Problem at primes(5)", new int[] {2,3,5,7,11},  Primes.primes(5));
		Assert.assertArrayEquals("Problem at primes(7)", new int[] {2,3,5,7,11,13,17},  Primes.primes(7));
		Assert.assertArrayEquals("Problem at primes(12)", new int[] {2,3,5,7,11,13,17,19,23,29,31,37},  Primes.primes(12));
		Assert.assertArrayEquals("Problem at primes(15)", new int[] {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47},  Primes.primes(15));
		Assert.assertArrayEquals("Problem at primes(18)", new int[] {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61},  Primes.primes(18));
		Assert.assertArrayEquals("Problem at primes(20)", new int[] {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71},  Primes.primes(20));
		Assert.assertArrayEquals("Problem at primes(1)", new int[] {2},  Primes.primes(1));
		Assert.assertArrayEquals("Problem at primes(0)", new int[] {},  Primes.primes(0));
		Assert.assertArrayEquals("Problem at primes(-7)", new int[] {},  Primes.primes(-7));
		Assert.assertArrayEquals("Problem at primes(-200)", new int[] {},  Primes.primes(-200));
	}
	
	@Test
	public void testprimesLessThan() {
		ArrayList<Integer> mylist = new ArrayList<Integer>() {{ // mylist becomes ArrayList [2 , 3]
			add(2);
			add(3);
			}};
		assertEquals ("Problem at primesLessThan(5)",mylist,  Primes.primesLessThan(5));
		
		mylist.add(5); 											// mylist becomes ArrayList [2 , 3, 5]
		assertEquals (mylist,  Primes.primesLessThan(7));
		
		mylist.add(7);mylist.add(11);mylist.add(13);			// mylist becomes ArrayList [2 , 3, 5, 7, 13]. true for n = 14,..,17.
		assertEquals ("Problem at primesLessThan(14)",mylist,  Primes.primesLessThan(14));		
		assertEquals ("Problem at primesLessThan(15)",mylist,  Primes.primesLessThan(15));
		assertEquals ("Problem at primesLessThan(16)",mylist,  Primes.primesLessThan(16));
		assertEquals ("Problem at primesLessThan(17)",mylist,  Primes.primesLessThan(17));
		
		mylist.add(17);mylist.add(19);mylist.add(23);mylist.add(29); //mylist becomes ArrayList[2 , 3, 5, 7, 13, 17, 19, 23 ,29]
		assertEquals ("Problem at primesLessThan(30)",mylist,  Primes.primesLessThan(30));
		assertEquals ("Problem at primesLessThan(31)",mylist,  Primes.primesLessThan(31));
		
		mylist.clear();											// mylist becomes ArrayList []
		assertEquals ("Problem at primesLessThan(1)",mylist,  Primes.primesLessThan(1));
		assertEquals ("Problem at primesLessThan(0)",mylist,  Primes.primesLessThan(0));
		assertEquals ("Problem at primesLessThan(-8)",mylist,  Primes.primesLessThan(-8));
		assertEquals ("Problem at primesLessThan(-200)",mylist,  Primes.primesLessThan(-200));
	}
	
	@Test
	public void testprimesLessThanSieveRemove() {
		assertEquals ("Problem at LessThanSieveRemove(5)", Primes.primesLessThan(5),  Primes.primesLessThanSieveRemove(5));
		assertEquals ("Problem at LessThanSieveRemove(7)", Primes.primesLessThan(7),  Primes.primesLessThanSieveRemove(7));
		
		assertEquals ("Problem at LessThanSieveRemove(14)", Primes.primesLessThan(14),  Primes.primesLessThanSieveRemove(14));	
		assertEquals ("Problem at LessThanSieveRemove(15)", Primes.primesLessThan(15),  Primes.primesLessThanSieveRemove(15));
		assertEquals ("Problem at LessThanSieveRemove(16)", Primes.primesLessThan(16),  Primes.primesLessThanSieveRemove(16));
		assertEquals ("Problem at LessThanSieveRemove(17)", Primes.primesLessThan(17),  Primes.primesLessThanSieveRemove(17));
		assertEquals ("Problem at LessThanSieveRemove(200)", Primes.primesLessThan(200),  Primes.primesLessThanSieveRemove(200));
		
		assertEquals ("Problem at LessThanSieveRemove(1)", Primes.primesLessThan(1),  Primes.primesLessThanSieveRemove(1));
		assertEquals ("Problem at LessThanSieveRemove(0)", Primes.primesLessThan(0),  Primes.primesLessThanSieveRemove(0));
		assertEquals ("Problem at LessThanSieveRemove(-8)", Primes.primesLessThan(-8),  Primes.primesLessThanSieveRemove(-8));
		assertEquals ("Problem at LessThanSieveRemove(-200)", Primes.primesLessThan(-8),  Primes.primesLessThanSieveRemove(-200));
	}
	@Test
	public void testprimesLessThanSieveAdd() {
		assertEquals ("Problem at LessThanSieveAdd(5)", Primes.primesLessThan(5),  Primes.primesLessThanSieveAdd(5));
		assertEquals ("Problem at LessThanSieveAdd(7)", Primes.primesLessThan(7),  Primes.primesLessThanSieveAdd(7));
		
		assertEquals ("Problem at LessThanSieveAdd(14)", Primes.primesLessThan(14),  Primes.primesLessThanSieveAdd(14));	
		assertEquals ("Problem at LessThanSieveAdd(15)", Primes.primesLessThan(15),  Primes.primesLessThanSieveAdd(15));
		assertEquals ("Problem at LessThanSieveAdd(16)", Primes.primesLessThan(16),  Primes.primesLessThanSieveAdd(16));
		assertEquals ("Problem at LessThanSieveAdd(17)", Primes.primesLessThan(17),  Primes.primesLessThanSieveAdd(17));
		assertEquals ("Problem at LessThanSieveAdd(200)", Primes.primesLessThan(200),  Primes.primesLessThanSieveAdd(200));
		
		assertEquals ("Problem at LessThanSieveAdd(1)", Primes.primesLessThan(1),  Primes.primesLessThanSieveAdd(1));
		assertEquals ("Problem at LessThanSieveAdd(0)", Primes.primesLessThan(0),  Primes.primesLessThanSieveAdd(0));
		assertEquals ("Problem at LessThanSieveAdd(-8)", Primes.primesLessThan(-8),  Primes.primesLessThanSieveAdd(-8));
		assertEquals ("Problem at LessThanSieveAdd(-200)", Primes.primesLessThan(-8),  Primes.primesLessThanSieveAdd(-200));
	}
	
	@Test
	public void testprimesLessThanSieveRemove2() {
		assertEquals ("Problem at LessThanSieveRemove2(5)", Primes.primesLessThan(5),  Primes.primesLessThanSieveRemove2(5));
		assertEquals ("Problem at LessThanSieveRemove2(7)", Primes.primesLessThan(7),  Primes.primesLessThanSieveRemove2(7));
		
		assertEquals ("Problem at LessThanSieveRemove2(14)", Primes.primesLessThan(14),  Primes.primesLessThanSieveRemove2(14));	
		assertEquals ("Problem at LessThanSieveRemove2(15)", Primes.primesLessThan(15),  Primes.primesLessThanSieveRemove2(15));
		assertEquals ("Problem at LessThanSieveRemove2(16)", Primes.primesLessThan(16),  Primes.primesLessThanSieveRemove2(16));
		assertEquals ("Problem at LessThanSieveRemove2(17)", Primes.primesLessThan(17),  Primes.primesLessThanSieveRemove2(17));
		assertEquals ("Problem at LessThanSieveRemove2(200)", Primes.primesLessThan(200),  Primes.primesLessThanSieveRemove2(200));
		
		assertEquals ("Problem at LessThanSieveRemove2(1)", Primes.primesLessThan(1),  Primes.primesLessThanSieveRemove2(1));
		assertEquals ("Problem at LessThanSieveRemove2(0)", Primes.primesLessThan(0),  Primes.primesLessThanSieveRemove2(0));
		assertEquals ("Problem at LessThanSieveRemove2(-8)", Primes.primesLessThan(-8),  Primes.primesLessThanSieveRemove2(-8));
		assertEquals ("Problem at LessThanSieveRemove2(-200)", Primes.primesLessThan(-8),  Primes.primesLessThanSieveRemove2(-200));
	}

}

