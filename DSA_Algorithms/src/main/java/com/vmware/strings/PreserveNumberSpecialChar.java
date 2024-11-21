package com.vmware.strings;

public class PreserveNumberSpecialChar {

	public static void main(String[] args) {

		String in = "ab$c123!e";
		String out = stringReverse(in);
		System.out.println("Input	:" + in);
		System.out.println("Output	:" + out);
	}

	private static String stringReverse(String in) {
		char[] arr = in.toCharArray();
		int len = in.length();
		int left = 0;
		int right = len - 1;
		while (left < right) {
			if (!Character.isAlphabetic(arr[left])) {
				left++;
			} else if (!Character.isAlphabetic(arr[right])) {
				right--;
			} else {
				char temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
		return String.valueOf(arr);
	}

}
