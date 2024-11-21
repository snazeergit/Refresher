package com.vmware.numbers;

import java.util.Arrays;

public class KthSmallestNumber {

	public static void main(String[] args) {
		int a[] = { 13, 18, 17, 12, 14, 15, 19, 11 };
		int k = 5;
		System.out.println("Given Array: " + Arrays.toString(a));
		Arrays.sort(a);
		System.out.println("Sorted Array: " + Arrays.toString(a));
		System.out.println(k + "th smallest element : " + a[k - 1]);

		//Using stream API
		int integer = Arrays.stream(a).sorted().skip(k - 1).findFirst().getAsInt();
		//Integer integer = Arrays.stream(a).boxed().sorted().skip(k - 1).findFirst().get();
		System.out.println(k + "th smallest element : " + integer);
	}

}
