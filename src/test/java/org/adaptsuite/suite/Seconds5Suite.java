package org.adaptsuite.suite;

import junit.framework.TestSuite;
import java.util.HashMap;
import java.util.Map;

import org.adaptsuite.suite.AdaptSuiteBuilder;
import org.junit.runner.RunWith;
import org.junit.runners.AllTests;

@RunWith(AllTests.class)
public class Seconds5Suite {
	public static TestSuite suite() {
		return new AdaptSuiteBuilder().sec(5).build();
	}
}