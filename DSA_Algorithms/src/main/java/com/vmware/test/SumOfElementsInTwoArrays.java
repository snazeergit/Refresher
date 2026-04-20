package com.vmware.test;

public class SumOfElementsInTwoArrays {

	public static void main(String[] args) {
		int[] ar1 = { 1, 2, 3, 4, 5 };
		int[] ar2 = { 5, 6, 7, 8, 9, 10 };
		int n1 = ar1.length;
		int n2 = ar2.length;

		int k = 16;
		int dif = Integer.MAX_VALUE;
		int res_l = 0, res_r = 0;

		int left = 0, right = n2 - 1;
		while (left < n1 && right >= 0) {
			if (Math.abs(ar1[left] + ar2[right] - k) < dif) {
				dif = Math.abs(ar1[left] + ar2[right] - k);
				res_l = left;
				res_r = right;
			} else if (ar1[left] + ar2[right] > k) {
				right--;
			} else {
				left++;
			}
		}
		System.out.println(ar1[res_l] + " " + ar2[res_r]);
	}

}
