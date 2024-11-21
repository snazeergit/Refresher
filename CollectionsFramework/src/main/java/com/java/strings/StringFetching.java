package com.java.strings;

import java.util.ArrayList;
import java.util.List;

public class StringFetching {

	public static void main(String[] args) {

		String s = "N@z3^$";
		//to store charactors, numbers and Special Charactors
		List<Character> l1 = new ArrayList<Character>();
		List<Character> l2 = new ArrayList<Character>();
		List<Character> l3 = new ArrayList<Character>();

		char[] cs = s.toCharArray();
		for(char c: cs) {
			if (Character.isLetter(c)) {
				l1.add(c);
			} else if (Character.isDigit(c)) {
				l2.add(c);
			} else {
				l3.add(c);
			}
		}
		
		System.out.println("Charactors: " + l1.toString());
		System.out.println("Digits: " + l2.toString());
		System.out.println("Special Chars: " + l3.toString());
	}
}