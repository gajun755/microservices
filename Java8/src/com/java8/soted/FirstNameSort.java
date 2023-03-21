package com.java8.soted;

import java.util.Comparator;

public class FirstNameSort implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		
		if(o1.getfName()==null || o2.getlName()==null) {
			throw new IllegalArgumentException("First or last name is missing");
		}
		
		return 0;
	}

}
