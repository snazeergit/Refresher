package com.vmware.top15;

public class Reverse_a_String {

	public static void main(String[] args) {
		String str = "Syed Nazeer";
		StringBuilder builder = new StringBuilder(str);
		StringBuilder reverse = builder.reverse();
		System.out.println("Original: " + str);
		System.out.println("Reversed: " + reverse);
	}

}
