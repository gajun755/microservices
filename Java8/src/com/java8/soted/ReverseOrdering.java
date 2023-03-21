package com.java8.soted;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ReverseOrdering {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);
		list.stream().sorted(Comparator.reverseOrder()).forEach(x -> System.out.println(x));
	}

}
