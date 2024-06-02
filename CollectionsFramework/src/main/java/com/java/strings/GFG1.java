package com.java.strings;

import java.util.concurrent.ConcurrentHashMap;

public class GFG1 {

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "abc";

		if (s1 == s2)
			System.out.println("s1 == s2 : True");
		else
			System.out.println("s1 == s2 : Flase");

		System.out.println("s1.equals(s2): " + s1.equals(s2));
		ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();
	}
}
