package com.vmware.top15;

public class Check_if_a_String_is_a_Palindrome {

	public static void main(String[] args) {
	//	String str="radar";
		String str="Nazeer";
		StringBuilder builder=new StringBuilder(str);
		if(str.equalsIgnoreCase(builder.reverse().toString()))
			System.out.println("Given string '"+str+"' is a Palindrome");
		else
			System.out.println("Given string '"+str+"' is NOT a Palindrome");
	}

}
