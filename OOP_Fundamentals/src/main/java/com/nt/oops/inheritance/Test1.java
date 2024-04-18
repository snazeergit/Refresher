package com.nt.oops.inheritance;

interface Left1 {
	default void m1() {
		System.out.println("Left1 interface m1()");
	}
}

interface Right1 {
	default void m1() {
		System.out.println("Right1 interface m1()");
	}
}

public class Test1 implements Left1, Right1 {

	@Override
	public void m1() {
		System.out.println("Test class overridden m1()");
		//invoke m1() from Left1
		Left1.super.m1();
		//invoke m1() from Right1
		Right1.super.m1();
	}

	public static void main(String[] args) {
		Test1 t1 = new Test1();
		//invoke m1() from Test
		t1.m1();
	}
}
