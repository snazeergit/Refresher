package com.vmware.test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class SlidingWindowMax {

	public static void main(String[] args) {
		int[] ar = { 1, 4, 2, 6, 4, 2, 1, 5, 8, 4 };
		int n = ar.length;
		int k = 3;

		Deque<Integer> dq = new ArrayDeque<Integer>();
		ArrayList<Integer> res = new ArrayList<Integer>();

		for (int i = 0; i < k; i++) {
			while (!dq.isEmpty() && ar[i] >= ar[dq.peekLast()]) {
				dq.removeLast();
			}
			dq.addLast(i);
		}
		res.add(ar[dq.peek()]);

		for (int i = k; i < n; i++) {
			while (!dq.isEmpty() && dq.peek() < i - 2) {
				dq.removeFirst();
			}

			while (!dq.isEmpty() && ar[i] >= ar[dq.peekLast()]) {
				dq.removeLast();
			}
			dq.addLast(i);
			res.add(ar[dq.peek()]);
		}
		System.out.println(res);
	}

}
