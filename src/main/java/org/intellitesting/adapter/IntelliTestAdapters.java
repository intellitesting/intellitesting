package org.intellitesting.adapter;

import java.util.ArrayList;

public class IntelliTestAdapters extends ArrayList<IntelliTestAdapter>{
	
	public IntelliTestAdapters(Class<?>[] tests) {
		for (Class<?> test : tests) {
			add(new IntelliTestAdapter(test));
		}
	}

}