package com.vmware.numbers;

public class ReverseNumber {

	public static void main(String[] args) {
		int n = 12345678, result = 0, reminder = 0;
		while (n > 0) {
			reminder = n % 10;
			result = result * 10 + reminder;
			n = n / 10;
		}
		System.out.println(result);
	}
}
