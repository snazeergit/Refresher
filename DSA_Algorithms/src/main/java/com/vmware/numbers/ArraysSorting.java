package com.vmware.numbers;

import java.util.Arrays;
import java.util.Collections;

public class ArraysSorting {

	public static void main(String[] args) {

		// Sample array
		Integer[] arr = { 5, 2, 8, 1, 9 };
		System.out.println("Given array: " + Arrays.toString(arr));

		// Sorting in ascending order
		Arrays.sort(arr);
		System.out.println("Sorted in Ascending Order: " + Arrays.toString(arr));

		// Sorting in descending order
		Arrays.sort(arr, Collections.reverseOrder());
		System.out.println("Sorted in Descending Order: " + Arrays.toString(arr));
	}
}