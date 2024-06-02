package com.java.exceptionHandling;

public class ExceptionDemo4 {

	static int anyMethod() {
		int i = 1;

		try {
			i = i + 1;

			return i;
		} catch (Exception e) {
			i = i + 2;
			//return i;
		} finally {
			i = i + 3;
			//return 1;
		}
return i;
		//System.out.println(i);
	}

	public static void main(String[] args) {
		System.out.println(anyMethod());
	}
}
