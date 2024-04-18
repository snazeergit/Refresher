package com.nt.oops.inheritance;

interface A4 {

	default void printDetails() {
		System.out.println("Interface default method :: A4");
	}

}

interface B4 {

	default void printDetails() {
		System.out.println("Interface default method :: B4");
	}

}

interface C4 extends A4, B4 {

	@Override
	default void printDetails() {
		// TODO Auto-generated method stub
		System.out.println("Interface default method :: C4");
	}

}

public class MultipleInheritanceDemo1 implements C4 {

	public static void main(String[] args) {

		C4 c4 = new MultipleInheritanceDemo1();
		c4.printDetails();
	}

}
