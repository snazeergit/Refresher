package com.vmware.strings;

public class RemoveWhiteSpace {

	public static void main(String[] args) {
		String input = "Naz ee r_Sy ed";
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != ' ') {
				out = out.append(input.charAt(i));
			}
		}
		System.out.println(out);
	}

}
