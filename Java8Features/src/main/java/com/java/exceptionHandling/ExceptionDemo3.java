package com.java.exceptionHandling;

public class ExceptionDemo3 {

	static String anyMethod() {
		String s = "ONE";

		try {
			s = s + "TWO";

			return s; //ONETWO
		} catch (Exception e) {
			s = s + "THREE";

			return s;
		} finally {
			s = s + "FOUR";
			//return s; //ONETWOFOUR
		}
		//return s; //ONETWOFOUR
	}

	public static void main(String[] args) {
		System.out.println(anyMethod());
	}
}
