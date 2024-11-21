package com.vmware.twopointer;

public class SumOfNumbersTwoPointer {

	public static void main(String[] args) {
		int[] ar = { 1, 3, 5, 6, 7, 8, 9, 12 };
		int n = ar.length;
		int k = 20;

		int left = 0, right = n - 1;
		while (left < right) {
			if (ar[left] + ar[right] == k) {
				System.out.println("Match Found..!");
				System.out.println(ar[left] + " " + ar[right]);
				return;
			} else if (ar[left] + ar[right] < k) {
				left++;
			} else {
				right--;
			}
		}
	}
}
