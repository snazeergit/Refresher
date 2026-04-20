package com.vmware.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Return the list pairs whose sum equals to target
 */
public class SumOfNumbersInArrayIsK {

	public static void main(String[] args) {
		int[] ar = { 1, 2, 3, 4, 7, 6, 5, 9 };

		int n = ar.length;
		int k = 10;

		bruteForce(ar, n, k);
		twoPointer(ar, n, k);
		hashing(ar, n, k);
	}

	private static void hashing(int[] ar, int n, int k) {
		Set<Integer> seen = new HashSet<>();
		List<String> list = new ArrayList<>();
		for (int first : ar) {
			int second = k - first;
			if (seen.contains(second)) {
				list.add("(" + first + "," + second + ")");
			}
			seen.add(first);
		}
		System.out.println("Hashing:	" + list);
	}

	private static void twoPointer(int[] ar, int n, int k) {
		int left = 0, right = n - 1;
		Arrays.sort(ar);
		List<String> list = new ArrayList<>();

		while (left < right) {
			int sum = ar[left] + ar[right];
			if (sum == k) {
				list.add("(" + ar[left] + "," + ar[right] + ")");
				left++;
				right--;
			} else if (sum > k) {
				right--;
			} else {
				left++;
			}
		}
		System.out.println("Two Pointers:	" + list);
	}

	private static void bruteForce(int[] ar, int n, int k) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (i != j && ar[i] + ar[j] == k) {
					list.add("(" + ar[i] + "," + ar[j] + ")");
					break;
				}
			}

		}
		System.out.println("Brute Force:	" + list);
	}

}
