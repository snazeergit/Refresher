package com.vmware.test;

public class Test {

	public static void main(String[] args) {
		int[] ar1 = { 1, 2, 3, 4, 5 };
		int[] ar2 = { 5, 6, 7, 8, 9, 10 };
		int target = 16;

		int l1 = ar1.length;
		int l2 = ar2.length;
		int actualDif = Integer.MAX_VALUE;
		int left = 0, right = l2 - 1;
		int res_l = 0, res_r = 0;

		while (left < l1 && right >= 0) {
			int currentSum = ar1[left] + ar2[right];
			int currentDif = Math.abs(currentSum - target);
			if (currentDif < actualDif) {
				actualDif = currentDif;
				res_l = left;
				res_r = right;
			} else if (currentSum > target) {
				right--;
			} else if (currentSum < target) {
				left++;
			}
		}
		System.out.println("Indexes: " + res_l + "," + res_r);
		System.out.println("Elements: " + ar1[res_l] + "," + ar2[res_r]);
		System.out.println("Target: " + target);

	}

}
