package test.java.org.adaptsuite.test;

import junit.framework.TestSuite;

import main.java.org.adaptsuite.suite.AdaptSuiteBuilder;
import org.junit.runner.RunWith;
import org.junit.runners.AllTests;

@RunWith(AllTests.class)
public class Seconds3Suite {
	public static TestSuite suite(){
		return new AdaptSuiteBuilder().sec(3).build();
	}
}
