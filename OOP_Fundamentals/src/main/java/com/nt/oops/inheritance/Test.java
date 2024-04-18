package com.nt.oops.inheritance;

interface Left {
	abstract void m1();
}

interface Right {
	abstract void m1();
}

interface Center extends Left, Right {

}

public class Test implements Left, Right {

	@Override
	public void m1() {
		System.out.println("Overriden m1()");
		/*cannot use below syntax to call the m1() in Left and Right interface's as it is abstract method 
		and we cannot invoke abstract methods.*/
		/*Left.super.m1();
		Right.super.m1(); */
	}

	public static void main(String[] args) {
		Test t1 = new Test();
		//invoke m1() from Test
		t1.m1();
	}
}
