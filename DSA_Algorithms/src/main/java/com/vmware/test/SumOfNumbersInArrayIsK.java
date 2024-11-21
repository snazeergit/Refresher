package com.vmware.test;

public class SumOfNumbersInArrayIsK {

	public static void main(String[] args) {
		int[] ar = { 1, 2, 3, 4, 7, 6, 5, 9 };
		int n = ar.length;
		int k = 16;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j && ar[i] + ar[j] == k) {
					System.out.println(i + " " + j);
					System.out.println("Match Found..!");
					return;
				}
			}

		}
	}

}
