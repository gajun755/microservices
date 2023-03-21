package com.java8.soted;

import java.util.Arrays;
import java.util.List;

public class UsingLambda {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);
		list.stream().sorted((x1,x2)->x2.compareTo(x1)).forEach(x->System.out.print(x));
		System.out.println();
		list.stream().sorted((x1,x2)->x1.compareTo(x2)).forEach(x->System.out.print(x));
	}

}
