package com.vmware.twopointer;

public class SumOfTwoElementsInArray {

	public static void main(String[] args) {
		int[] in = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int target = 17;
		boolean result = find(in, target);
		System.out.println(result);
	}

	private static boolean find(int[] in, int target) {
		for (int i = 0; i < in.length; i++) {
			for (int j = 1; j < in.length; j++) {
				if (i != j & in[i] + in[j] == target) {
					//System.out.println(in[i] + " " + in[j]);
					System.out.println(in[i] + " + " + in[j] + " = " + (in[i] + in[j]));
					return true;
				}
			}
		}
		return false;
	}

}
/*
 * Arrays must to sorted array in ascending order Arrays.sort(inputArr) for
 * Ascending; Arrays.sort(inputArr, Collections.reverseOrder()) for descending;
 * here input array must be wrapper type i.e Integer but not int
 */