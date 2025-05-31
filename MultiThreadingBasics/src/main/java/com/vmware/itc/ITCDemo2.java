package com.vmware.itc;

/*
 * Traditional Approach:
 * In this approach we consider implement two implementation classes for Runnable interface
 * Create Thread object by passing the implementation class object to it and 
 * invoke the start() method.
*/
class Operations2 {
	int num;
	boolean isReady = false;

	public synchronized void put(int num) {
		if (isReady) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isReady = true;
		this.num = num;
		System.out.println("Put->" + num);
		notify();
	}

	public synchronized int get() {
		if (!isReady) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isReady = false;
		System.out.println("Get->" + num);
		notify();
		return num;
	}
}

class Producer implements Runnable {
	Operations2 op;

	public Producer(Operations2 op) {
		this.op = op;
		Thread t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			op.put(i);
		}
	}
}

class Consumer implements Runnable {
	Operations2 op;

	public Consumer(Operations2 op) {
		this.op = op;
		Thread t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			op.get();
		}
	}
}

public class ITCDemo2 {

	static Operations2 op = new Operations2();

	public static void main(String[] args) {
		Producer p = new Producer(op);
		Consumer c = new Consumer(op);
	}

}
