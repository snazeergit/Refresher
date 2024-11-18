package com.vmware.interview;

public class Find_SubString_Count_In_Given_String {

	public static void main(String[] args) {
		String[] str = { "a", "abc", "bc", "d", "cd" };
		String word = "abc";

		// Using contains() returns true if the word contains the substring
		int count = 0;
		for (String s : str) {
			if (word.contains(s))
				count++;
		}
		System.out.println("substrings count " + count);
		
		//using indexOf() returns the index of the first occurance of the substring in the given String if substring not found then returns -1
		count = 0;
		for (String s : str) {
			if (word.indexOf(s) != -1)
				count++;
		}
		System.out.println("substrings count " + count);
	}

}