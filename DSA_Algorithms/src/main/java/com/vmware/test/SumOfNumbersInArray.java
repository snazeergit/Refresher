package com.vmware.test;

public class SumOfNumbersInArray {

	public static void main(String[] args) {
		int[] ar = { 9, 5, 2, 8, 3, 5, 1, 6, 2 };
		int n = ar.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (i != j && ar[i] + ar[j] == ar[k]) {
						System.out.println("Match Found.. " + ar[i] + " + " + ar[j] + "=" + (ar[k]));
					}
				}

			}
		}
		System.out.println("No match found..!");
	}
}
