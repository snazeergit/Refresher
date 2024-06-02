package com.java.multiThreading;

public class ThreadDemo1 {
	
	public static void main(String[] args) {
		Thread myThread = new Thread();

		myThread.start();

		try {
			myThread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
/* Q>In the following example, which thread is going to sleep – myThread or main thread?
 * 
 * It is the main thread which is going to sleep not myThread. Because, when you call sleep() method, 
 * it is currently executing thread which is going to sleep, not on which you have called it.
 * 
 */