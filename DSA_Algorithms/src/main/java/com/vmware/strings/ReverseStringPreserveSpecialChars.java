package com.vmware.strings;

public class ReverseStringPreserveSpecialChars {
	public static String reversePreservingSpecialChars(String str) {
		// Convert string to char array for in-place operations
		char[] arr = str.toCharArray();
		int left = 0;
		int right = arr.length - 1;

		// Loop until the two pointers meet
		while (left < right) {
			// Ignore special characters and digits on the left
			if (!Character.isLetter(arr[left])) {
				left++;
			}
			// Ignore special characters and digits on the right
			else if (!Character.isLetter(arr[right])) {
				right--;
			}
			// Swap the letters at left and right pointers
			else {
				char temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}

		// Return the reversed string with special characters and digits in place
		return new String(arr);
		//return String.valueOf(arr);
	}

	public static void main(String[] args) {
		String input = "a,b$c123d!";
		String result = reversePreservingSpecialChars(input);
		System.out.println("Original: " + input);
		System.out.println("Reversed: " + result);
	}

}
