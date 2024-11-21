package com.vmware;

import java.util.Arrays;
import java.util.List;

public class App {
	public static void main(String[] args) {

		//way-1
		int[] num;
		num = new int[5];
		num[0] = 10;
		num[1] = 20;
		num[3] = 40;

		for (int i : num) {
			System.out.println(i);
		}

		//way-2
		int num1[] = { 10, 20, 30 };
		for (int i = 0; i < num1.length; i++) {
			System.out.println(num1[i]);
		}

		//Array to List conversions

		//1. If we already have an array
		Integer[] num2 = new Integer[] { 10, 20, 30 };
		List<Integer> list = Arrays.asList(num2);

		//2. Creating by passing elements
		List<Integer> list2 = Arrays.asList(10, 30, 20, 40);
		Integer[] array = list.toArray(new Integer[0]);

	}
}
