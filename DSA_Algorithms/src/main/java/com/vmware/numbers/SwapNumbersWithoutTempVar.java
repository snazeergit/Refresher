package com.vmware.numbers;

public class SwapNumbersWithoutTempVar {

	public static void main(String[] args) {
		int a = 7;
		int b = 5;

		System.out.println("Before :");
		System.out.println("a : " + a);
		System.out.println("b : " + b);

		a = a + b; //a=15,b=5       
		b = a - b; //b=10, a=15    b=a+b-b=a
		a = a - b; //a=5, b=10     a=a+b-a=b

		System.out.println("After :");
		System.out.println("a : " + a);
		System.out.println("b : " + b);

	}

}
