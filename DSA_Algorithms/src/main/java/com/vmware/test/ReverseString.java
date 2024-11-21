package com.vmware.test;

public class ReverseString {

	public static void main(String[] args) {
		String input = "ABC123@#$XYZ";
		char[] ar = input.toCharArray();
		int n = ar.length;
		int left = 0, right = n - 1;

		while (left < right) {
			if (!Character.isAlphabetic(ar[left])) {
				left++;
			} else if (!Character.isAlphabetic(ar[right])) {
				right--;
			} else {
				char temp = ar[left];
				ar[left] = ar[right];
				ar[right] = temp;
				left++;
				right--;
			}
		}
		System.out.print(new String(ar));
	}
}