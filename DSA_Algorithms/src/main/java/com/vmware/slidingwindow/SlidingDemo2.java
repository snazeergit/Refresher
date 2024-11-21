package com.vmware.slidingwindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/*
 * PriorityQueue Max-Heap Approach
 * Time Comp: O(nlogk) Space Comp:O(k)
*/
public class SlidingDemo2 {

	public static void main(String[] args) {
		int[] ar = { 2, 5, 9, 3, 6, 4, 1, 8, 3 };

		int n = ar.length;//10
		int k = 3;//window size

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
		ArrayList<Integer> res = new ArrayList<Integer>();

		for (int i = 0; i < k; i++) {
			queue.add(ar[i]);
		}
		res.add(queue.peek());
		queue.remove(ar[0]); 

		for (int i = k; i < n; i++) {
			queue.add(ar[i]);
			res.add(queue.peek());
			queue.remove(ar[i - k + 1]);
		}
		System.out.println(res);
	}
}
//[9, 9, 9, 6, 6, 8, 8]