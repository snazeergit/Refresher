package com.nt.interview;

import java.util.ArrayList;

public class Demo1 {

	@SuppressWarnings("removal")
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(1);
		list.add(7);
		list.add(2);
		list.add(5);
		list.add(4);
		//Sum of odd numbers in a given list
		int sum = list.stream().filter(n -> n % 2 != 0).mapToInt(Integer::new).sum();
		System.out.println(sum);

	}

}
