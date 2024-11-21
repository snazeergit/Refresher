package com.vmware.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Deque Best Approach
 * Time Comp: O(n) Space Comp:O(k)
*/
public class SlidingDemo3 {

	public static void main(String[] args) {

		int[] ar = { 2, 5, 9, 3, 6, 4, 1, 8, 3 };
		int n = ar.length;
		int k = 3;

		Deque<Integer> dq = new ArrayDeque<Integer>();

		//Process first k elements of array
		for (int i = 0; i < k; ++i) {

			// Remove elements smaller than the current one from the deque
			while (!dq.isEmpty() && ar[i] >= ar[dq.peekLast()]) {
				dq.removeLast();
			}

			dq.addLast(i);
		}

		for (int i = k; i < n; ++i) {
			System.out.print(ar[dq.peek()] + "  ");

			// Remove elements that are out of this window
			while (!dq.isEmpty() && dq.peek() < i - k + 1) {
				dq.removeFirst();
			}
			// Remove elements smaller than the current one from the deque
			while (!dq.isEmpty() && ar[i] >= ar[dq.peekLast()]) {
				dq.removeLast();
			}

			dq.addLast(i);
		}
		System.out.print(ar[dq.peek()]);
	}
}
//9  9  9  6  6  8  8