package com.vmware.interfaces;

public interface Right {

	default void add() {
		System.out.println("Right.add()");
	}

}
