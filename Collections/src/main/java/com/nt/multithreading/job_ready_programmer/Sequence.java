package com.nt.multithreading.job_ready_programmer;

public class Sequence {

	private int value = 0;

	public synchronized int getValue() {
		value++;
		return value;
	}

}
