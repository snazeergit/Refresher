package com.vmware.twopointer;

public class ClosestPairInArray {

	public static void main(String[] args) {

		int ar1[] = { 1, 4, 5, 7 };
		int ar2[] = { 10, 20, 30, 40 };
		int target = 38;

		int len1 = ar1.length;
		int len2 = ar2.length;

		int res_l = 0, res_r = 0;
		int dif = Integer.MAX_VALUE;

		//two pointers
		int left = 0, right = len2 - 1;
		while (left < len1 && right >= 0) {
			if (Math.abs(ar1[left] + ar2[right] - target) < dif) {
				res_l = left;
				res_r = right;
				dif = Math.abs(ar1[left] + ar2[right] - target);
			}
			if (ar1[left] + ar2[right] > target) {
				right--;
			} else {
				left++;
			}
		}
		System.out.println("The closest pair to " + target + " is : [" + ar1[res_l] + ", " + ar2[res_r] + "]");
	}

}
