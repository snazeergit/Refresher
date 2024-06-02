package com.nt.multithreading;

class MyThread extends Thread {
	@Override
	public void run() {
		synchronized (this) {
			System.out.println("Thread 1 is waiting...");
			try {
				this.wait(); // Thread 1 waits until notified by another thread
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread 1 has been notified.");
		}
	}
}

public class WaitExample {
	public static void main(String[] args) {
		MyThread thread1 = new MyThread();
		thread1.start();

		try {
			Thread.sleep(5000); // Sleep for 1 second
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		synchronized (thread1) {
			thread1.notify(); // Notify thread1 to resume
		}
	}
}
