package com.nt.collections;

public class NazeerException extends Exception {

	public NazeerException() {
		super();
		System.out.println("NazeerException: 0-Param Constructor");
	}

	public NazeerException(String msg) {
		super(msg);
		System.out.println("NazeerException: 1-Param Constructor");
	}

}