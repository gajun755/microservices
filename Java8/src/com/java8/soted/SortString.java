package com.java8.soted;

import java.util.Comparator;
import java.util.stream.Stream;

public class SortString {

	
		public static void main(String[] args) {
			
		Stream<String> 	wordStream= Stream.of("A","C","E","B","D");
				//wordStream.sorted().forEach(x->System.out.print(x));
		
		//reverse order
		//wordStream.sorted(Comparator.reverseOrder()).forEach(x->System.out.print(x));
			
		}
	
}
