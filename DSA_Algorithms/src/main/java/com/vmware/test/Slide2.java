package com.vmware.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Slide2 {

	public static void main(String[] args) {
		int[] ar = { 9, 4, 7, 3, 7, 2, 8, 0, 1 };
		int n = ar.length;
		int k = 3;

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Comparator.reverseOrder());
		ArrayList<Integer> res = new ArrayList<Integer>();

		for (int i = 0; i < k; i++) {
			queue.add(ar[i]);
		}
		res.add(queue.peek());
		queue.remove(ar[0]);

		for (int i = k; i < n; i++) {
			queue.add(ar[i]);
			res.add(queue.peek());
			queue.remove(ar[i - 2]);
		}

		System.out.println(res);
	}

}
//9777888