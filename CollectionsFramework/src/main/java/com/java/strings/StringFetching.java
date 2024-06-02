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
		for (int i = 0; i < cs.length; i++) {
			System.out.println(cs[i]);
			if (Character.isLetter(cs[i])) {
				l1.add(cs[i]);
			} else if (Character.isDigit(cs[i])) {
				l2.add(cs[i]);
			} else {
				l3.add(cs[i]);
			}
		}
		System.out.println("Charactors: " + l1.toString());
		System.out.println("Digits: " + l2.toString());
		System.out.println("Special Chars: " + l3.toString());
	}
}