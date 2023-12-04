package com.nt.oops.inheritance;

interface A3 {

	int no = 10;

	default void printDetails() {
		System.out.println("Interface default method :: A3");
		System.out.println(no);
	}

}

interface B3 {

	float bill = 154.50f;

	default void printDetails() {
		System.out.println("Interface default method :: B3");
		System.out.println(bill);
	}

}

interface C3 extends A3, B3 {

	static String name = "Nazeer Syed";

	public default void printDetails() {
		System.out.println("Interface default method :: C3");
		System.out.println(no);
		System.out.println(bill);
		System.out.println(name);
		System.out.println("*************************");
		A3.super.printDetails();
		B3.super.printDetails();
	}

}

public class MultipleInheritanceDemo implements C3 {

	public static void main(String[] args) {

		C3 c3_ref = new MultipleInheritanceDemo();
		c3_ref.printDetails();

	}

}
