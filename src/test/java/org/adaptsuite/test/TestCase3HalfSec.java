package test.java.org.adaptsuite.test;

import org.junit.Test;

public class TestCase3HalfSec {
	
	@Test
	public void testOne() throws InterruptedException {
		System.out.println("Testing 3.5sec...");
		Thread.sleep(3400);
		System.out.println("Tested 3.5sec!");
	}
}
