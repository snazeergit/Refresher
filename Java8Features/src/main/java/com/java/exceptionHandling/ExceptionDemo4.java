package com.java.exceptionHandling;

public class ExceptionDemo4 {

	static int anyMethod() {
		int i = 1;

		try {
			i = i + 1; //2

			return i;
		} catch (Exception e) {
			i = i + 2;
			//return i;
		} finally {
			i = i + 3; //5
			//return i;
		}
		return i; //5
		//System.out.println(i);
	}

	public static void main(String[] args) {
		System.out.println(anyMethod());
	}
}
