package org.adaptsuite.sorter;

import java.util.List;

public class AdaptSuiteSorter {

	private boolean[] chosenTests;
	private Long[][] knaspackTabble;
	
	public boolean[]  findTests (List<TestData> testData, int queueSize, Long maxTime) {		
		
		chosenTests = new boolean[queueSize];
		knaspackTabble = new Long [queueSize + 1][maxTime.intValue() + 1];
		
		boolean shouldRunTrivialCase = testData.get(0).getLastExecutionTime() == 0 || maxTime == Long.MAX_VALUE;
		if(shouldRunTrivialCase)
			return trivialCase();
					
		testsValue(testData, queueSize, maxTime);
		chooseTests(testData, queueSize, maxTime);
		return chosenTests;
		
	}
	
	private void testsValue (List<TestData> testData, int queueSize, Long maxTime) {
		
		Long a, b;
		
		for (int time = 0; time <= maxTime; time++) {
			knaspackTabble[0][time] = (Long)0L;	
			for (int i = 1; i <= queueSize; i++) {
				a = knaspackTabble[i-1][time];
				Long lastExecutionTime = testData.get(i-1).getLastExecutionTime();
				Long testFailures = testData.get(i-1).getFailures();
				if (lastExecutionTime.intValue() > time)
					b = (Long)0L;
				else
					b = knaspackTabble[i-1][time - lastExecutionTime.intValue()] + testFailures;
				
				knaspackTabble[i][time] = Max(a, b);
			}
		}
	}
	
	
	private void chooseTests (List<TestData> testData, int queueSize, Long maxTime) {
		
		Long time = maxTime;
		
		for (int i = queueSize; i >= 1; i--)
			if(knaspackTabble[i][time.intValue()] == knaspackTabble[i-1][time.intValue()])
				chosenTests[i-1] = false;
			else {
				Long executionTime = testData.get(i-1).getLastExecutionTime();
				chosenTests[i-1] = true;
				time -= executionTime;
			}
	}
	
	
	private Long Max (Long a, Long b) {
		
		return a.longValue() >= b.longValue() ? a : b;
	}
	
	
	private boolean[] trivialCase() {
		
		for (int i = 0; i < chosenTests.length; i++)
			chosenTests[i] = true;
		
		return chosenTests;
	}
}
