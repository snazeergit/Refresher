package com.nt.oops.inheritance;

class A1 {

	int no;
	static String name;
	final int PINCODE = 524004;

	A1() {
		System.out.println("Default Constructor :: A1");
		no = 10;
		name = "Nazeer Syed";
		//PINCODE = 500082; final variable can not be overridden, acts like constants
	}

	void print() {
		System.out.println("Print A");
	}

}

class B1 extends A1 {

	float bill;

	B1() {
		System.out.println("Default Constructor :: B1");
		bill = 154.50f;
	}

	void print() {
		System.out.println("Print B");
	}
}

class C1 extends B1 {

	C1() {
		System.out.println("Default Constructor :: C1");
	}

	void print() {
		System.out.println("Print C");
	}

	public void printDetails() {
		System.out.println(no);
		System.out.println(name);
		System.out.println(PINCODE);
		System.out.println(bill);
	}
}

public class MultiLevelInheritanceDemo {

	public static void main(String[] args) {
		C1 c_ref = new C1();
		c_ref.printDetails();
		c_ref.print();
		
	}

}
