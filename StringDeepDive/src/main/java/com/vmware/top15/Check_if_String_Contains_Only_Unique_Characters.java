package com.vmware.top15;

import java.util.HashSet;
import java.util.Set;

//Problem: Determine if a string has all unique characters.
public class Check_if_String_Contains_Only_Unique_Characters {

	public static void main(String[] args) {
		String str = "NazrSyed";
		boolean isUnique = true;
		Set<Character> set = new HashSet<Character>();
		for (char c : str.toCharArray()) {
			if (!set.add(c)) {
				isUnique = false;
				break;
			}
		}
		if (isUnique)
			System.out.println("String contain only unique characters");
		else
			System.out.println("String NOT contain unique characters");
	}

}
