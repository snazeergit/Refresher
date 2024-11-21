package com.vmware.slidingwindow;

/*
 * Basic Approach
 * Time Comp: O(n*k) Space Comp:O(1)
*/
public class SlidingDemo1 {

	public static void main(String[] args) {
		int[] ar = { 2, 5, 9, 3, 6, 4, 1, 8, 3 };
		int n = ar.length;//10
		int k = 3;//window size
		int max;

		for (int i = 0; i < n - k + 1; i++) {
			max = ar[i];
			for (int j = 1; j < k; j++) {
				if (ar[i + j] > max) {
					max = ar[i + j];
				}
			}
			System.out.print(max + " ");
		}
	}
}
// 9 9 9 6 6 8 8 