package com.vmware.test;

import java.util.ArrayList;

public class Slide1 {

	public static void main(String[] args) {
		int[] ar = { 9, 4, 7, 3, 7, 2, 8, 0, 1 };
		int n = ar.length;
		int k = 3;
		int max;
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < n - k + 1; i++) {
			max = ar[i];
			for (int j = 1; j < k; j++) {
				if (ar[i + j] > max) {
					max = ar[i + j];
				}
			}
			res.add(max);
		}
		System.out.println(res);
	}

}
//9777888