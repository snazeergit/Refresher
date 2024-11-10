package com.vmware.patterns;

public class StartPatterns7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=5;
		for (int i = 0; i < N; i++) {
			
			for (int j = 1; j <= N-i-1; j++) {
				System.out.print("   ");
			}
			
			for (int j = 1; j <= i*2+1; j++) {
				System.out.print(" * ");
			}
			
			for (int j = 1; j <= N-i-1; j++) {
				System.out.print("   ");
			}
			
			System.out.println();
		}

	}

}
