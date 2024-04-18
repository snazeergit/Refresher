package com.nt.oops.inheritance;

interface A3 {

	default void printDetails() {
		System.out.println("Interface default method :: A3");
	}

}

interface B3 {

	default void printDetails() {
		System.out.println("Interface default method :: B3");
	}

}

interface C3 extends A3, B3 {

	public default void printDetails() {
		System.out.println("Interface default method :: C3");
		A3.super.printDetails();
		B3.super.printDetails();
	}

}

public class MultipleInheritanceDemo implements A3{

	public static void main(String[] args) {

		MultipleInheritanceDemo c3_ref = new MultipleInheritanceDemo();
		c3_ref.printDetails();
		MultipleInheritanceDemo m = new MultipleInheritanceDemo();
		m.m1();
	}

	void m1() {
		A3.super.printDetails();
	}

}
