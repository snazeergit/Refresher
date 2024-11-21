package com.stream.list;

public class Interview2 {

	public static void main(String[] args) {
		String str = "MADAM";
		checkPalindrome(str);
	}

	private static void checkPalindrome(String str) {
		StringBuilder sb = new StringBuilder(str);
		StringBuilder reverse = sb.reverse();
		System.out.println(reverse);
		if (reverse.toString().equals(str))
			System.out.println(str + " is a Palindrome");
		else
			System.out.println(str + " is NOT a Palindrome");
	}

}
