package com.vmware.interfaces;

public interface Left {

	/*
	 * default void add() { System.out.println("Left.add()"); }
	 */
	
	default void sub() {
		System.out.println("Left.sub()");
	}

}
