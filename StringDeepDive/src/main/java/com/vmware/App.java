package com.vmware;

public class App {
	public static void main(String[] args) {
		String s1 = new String("Nazeer");
		String s2 = new String("Nazeer");
		String s3 = new String("Syed");
		String s4 = s2;
		
		if (s4 == s2) {
			System.out.println("Reference same");
		}
		if (s4.equals(s2)) {
			System.out.println("Content Same");
		}

	}
}
