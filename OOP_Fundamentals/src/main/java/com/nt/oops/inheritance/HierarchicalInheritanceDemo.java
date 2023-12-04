package com.nt.oops.inheritance;

class A2 {

	int no;
	static String name;
	final int PINCODE = 524004;

	A2() {
		System.out.println("Default Constructor :: A2");
		no = 10;
		name = "Nazeer Syed";
		//PINCODE = 500082; final variable can not be overridden, acts like constants
	}

}

class B2 extends A2 {

	float bill;

	B2() {
		System.out.println("Default Constructor :: B2");
		bill = 154.50f;
	}

	public void printDetails() {
		System.out.println(no);
		System.out.println(name);
		System.out.println(PINCODE);
		System.out.println(bill);
	}

}

class C2 extends A2 {

	double chill;

	C2() {
		System.out.println("Default Constructor :: C2");
		chill = 782992078;
	}

	public void printDetails() {
		System.out.println(no);
		System.out.println(name);
		System.out.println(PINCODE);
		System.out.println(chill);
	}

}

public class HierarchicalInheritanceDemo {

	public static void main(String[] args) {
		B2 b_ref = new B2();
		b_ref.printDetails();
		System.out.println("*************************");
		C2 c_ref = new C2();
		c_ref.printDetails();

	}

}
