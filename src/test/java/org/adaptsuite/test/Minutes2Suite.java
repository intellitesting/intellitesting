package org.adaptsuite.test;

import junit.framework.TestSuite;

import org.adaptsuite.suite.AdaptSuiteBuilder;
import org.junit.runner.RunWith;
import org.junit.runners.AllTests;

@RunWith(AllTests.class)
public class Minutes2Suite {
	public static TestSuite suite() {
		return new AdaptSuiteBuilder().min(2).build();
	}
}