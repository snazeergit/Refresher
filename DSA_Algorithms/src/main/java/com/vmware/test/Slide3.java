package com.vmware.test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Slide3 {

	public static void main(String[] args) {
		int[] ar = { 9, 4, 7, 3, 7, 2, 8, 0, 1 };
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
		System.out.print(res);
	}

}
//9777888