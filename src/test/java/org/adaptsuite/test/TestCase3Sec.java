package org.adaptsuite.test;

import org.junit.Test;

public class TestCase3Sec extends GenericTest {

	@Test
	public void testThree() throws InterruptedException{
		System.out.println("Testing three...");
		Thread.sleep(2900);
		System.out.println("Tested three!");
	}
}