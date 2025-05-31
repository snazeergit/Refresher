package com.vmware.itc;

/*
 * Created a lambda expression for Runnable Functional interface and passed is as an argument
 * to the ananymous Thread object and invoked the start() method.
*/

class Operation {
	int num;
	boolean isAvailable = false;

	public synchronized void put(int num) {
		if (isAvailable) {
			try {
				Thread.sleep(100);
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isAvailable = true;
		this.num = num;
		System.out.println("Put->" + num);
		notify();
	}

	public synchronized int get() {
		if (!isAvailable) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isAvailable = false;
		System.out.println("Get->" + num);
		notify();
		return num;
	}
}

public class ITCDemo {
	static Operation op = new Operation();

	public static void main(String[] args) {

		Runnable r1 = () -> {
			for (int i = 0; i < 10; i++) {
				op.put(i);
			}
		};
		new Thread(r1).start();

		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				op.get();
			}
		}).start();
	}

}
