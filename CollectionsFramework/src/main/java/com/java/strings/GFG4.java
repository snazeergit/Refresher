package com.java.strings;

public class GFG4 {

	public static void main(String[] args) {
		String s1 = new String("abc");
		String s2 = new String("abc");

		String s3=s1; //s3==s1
		String s4=s2; //s4==s2
		
		if (s3 == s2)
			System.out.println("s3 == s2 : True");
		else
			System.out.println("s3 == s2 : Flase");
		
		System.out.println("s3.equals(s2): "+s3.equals(s2));
		
		if (s1 == s4)
			System.out.println("s1 == s4 : True");
		else
			System.out.println("s1 == s4 : Flase");
		
		System.out.println("s1.equals(s4): "+s1.equals(s4));
	}
}

/*
 * 
 * F
 * T
 * F
 * T
 *
 */

