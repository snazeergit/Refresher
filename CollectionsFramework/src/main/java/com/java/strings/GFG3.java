package com.java.strings;

public class GFG3 {

	public static void main(String[] args) {
		String s1 = new String("abc").intern();
		String s2 = new String("abc").intern();

		if (s1 == s2)
			System.out.println("s1 == s2 : True");
		else
			System.out.println("s1 == s2 : Flase");
		
		System.out.println("s1.equals(s2): "+s1.equals(s2));
	}
}
