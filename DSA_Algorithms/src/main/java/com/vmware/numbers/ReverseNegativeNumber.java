package com.vmware.numbers;

public class ReverseNegativeNumber {

	public static void main(String[] args) {
		int num = -1234;
		int res = 0, rem = 0;
		int sign = num < 0 ? -1 : 1;

		//run the loop till the num becomes 0
		while (num != 0) {
			//get the last digit by modulo ops
			rem = num % 10;
			//forming the number
			res = res * 10 + rem;
			//removing the last digit by deviding ops
			num = num / 10;
		}
		//sign restoration
		res = res * sign;
		System.out.println(res);
	}

}
