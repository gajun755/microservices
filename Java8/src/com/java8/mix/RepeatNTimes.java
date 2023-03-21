package com.java8.mix;

public class RepeatNTimes {

	public static void main(String[] args) {
		String s="A";
		System.out.println( s.repeat(3));
		
		//before java 11
		System.err.println(new String(new char[3]).replace("\0",s));
	}
}
