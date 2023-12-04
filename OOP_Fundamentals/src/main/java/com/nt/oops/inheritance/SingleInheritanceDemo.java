package com.nt.oops.inheritance;

class A {
	
	int no;
	static String name;
	final int PINCODE = 524004;

	A() {
		System.out.println("Default Constructor :: A");
		no = 10;
		name = "Nazeer Syed";
		//PINCODE = 500082; final variable can not be overridden, acts like constants
	}

}

class B extends A {

	public void printDetails() {
		System.out.println(no);
		System.out.println(name);
		System.out.println(PINCODE);
	}

	B() {
		System.out.println("Default Constructor :: B");
	}

}

public class SingleInheritanceDemo {

	public static void main(String[] args) {
		B b_ref = new B();
		b_ref.printDetails();

	}

}
