package com.vmware.patterns;

public class StartPatterns8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 5;
		for (int i = 0; i < N; i++) {

			for (int j = 0; j < i; j++) {
				System.out.print("   ");
			}

			for (int j = 0; j < 2 * N - (2 * i + 1); j++) {
				System.out.print(" * ");
			}

			for (int j = 0; j < i; j++) {
				System.out.print("   ");
			}

			System.out.println();
		}

	}

}
