package com.vmware.twopointer;

//Java program to find closest pair in an array
public class ClosestPair {
	/*
	 * ar1[] and ar2[] are two given sorted arrays and target is given number. 
	 * This function prints the pair from both arrays such that the sum of
	 * the pair is closest to target.
	 */
	void printClosest(int ar1[], int ar2[], int len1, int len2, int target) {

		// Initialize the diff between pair sum and target.
		int diff = Integer.MAX_VALUE;

		// res_l and res_r are result indexes from ar1[] and ar2[] respectively
		int res_l = 0, res_r = 0;

		// Start from left side of ar1[] and right side of ar2[]
		int l = 0, r = len2 - 1;

		while (l < len1 && r >= 0) {
			/*
			 * If this pair is closer to target than the previously found closest, then
			 * update res_l, res_r and diff
			 */
			if (Math.abs(ar1[l] + ar2[r] - target) < diff) {
				res_l = l;
				res_r = r;
				diff = Math.abs(ar1[l] + ar2[r] - target);
			}

			// If sum of this pair is more than target, move to smaller side
			if (ar1[l] + ar2[r] > target)
				r--;
			else // move to the greater side
				l++;
		}

		// Print the result
		System.out.print("The closest pair is [" + ar1[res_l] + ", " + ar2[res_r] + "]");
	}

	public static void main(String args[]) {
		ClosestPair ob = new ClosestPair();
		int ar1[] = { 1, 4, 5, 7 };
		int ar2[] = { 10, 20, 30, 40 };
		int len1 = ar1.length;
		int len2 = ar2.length;
		int target = 38;
		ob.printClosest(ar1, ar2, len1, len2, target);
	}
}