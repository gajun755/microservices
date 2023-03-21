package com.java8.soted;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class CustomSorting {

	public static void main(String[] args) {
		
		Stream<Person> personStream = getPersonStream();
		//personStream.sorted().forEach(x->System.out.println(x));
		
		//reverse order
		//personStream.sorted(Comparator.reverseOrder()).forEach(x->System.out.println(x));
		
		//checking excepion condition and reverse order
		personStream.sorted(new FirstNameSort().reversed()).forEach(x->System.out.println(x));
	}

	private static Stream<Person> getPersonStream() {
		List<Person> list=Arrays.asList(new Person (6, "Lo", "Kolen"),
					new Person (5, "Lokesh", "Gupta"),
					 new Person (4, "Brian", "Clooney"),
					 new Person (3,"Brian", "Clooney"),
						new Person(2, "Lokesh", "Gupta"),
						new Person (1,"Lokesh", "Gupta"));
		
		return list.stream() ;
	}

}
