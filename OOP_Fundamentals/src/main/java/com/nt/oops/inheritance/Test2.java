package com.nt.oops.inheritance;

interface Left2 {
	static void m1() {
		System.out.println("Left2 interface m1()");
	}
}

interface Right2 {
	static void m1() {
		System.out.println("Right2 interface m1()");
	}
}

public class Test2 implements Left2, Right2 {
	
	//not an overridden method Left2 or Right2, It's a Test3 class specific normal method
	public void m1() {
		System.out.println("Test class specific m1()");
		//static methods can not participate in inheritance.Compiler will throw error for below red lines.
		/*Left2.super.m1();
		Right2.super.m1();*/
	}

	public static void main(String[] args) {
		Test2 t1 = new Test2();
		//invoke m1() from Test
		t1.m1();
	}
}
