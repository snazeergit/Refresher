package com.nt.multithreading;

class Worker1 {
	int n=0;
	boolean valset = false;

	synchronized void put(int i) {
		try {
			if (valset) {
				wait();
			}
		} catch (InterruptedException e) {
			System.err.println("Problem in thread execution");
		}
		n = i;
		System.out.println("Put : " + n);
		valset = true;
		notify();
	}

	synchronized int get() {
		try {
			if (!valset) {
				wait();
			}
		} catch (InterruptedException e) {
			System.err.println("Problem in thread execution");
		}
		System.out.println("Get : " + n);
		valset = false;
		notify();
		return n;
	}
}

class Producer1 extends Thread {

	Worker1 q;

	public Producer1(Worker1 q) {
		this.q = q;
		this.start();
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			q.put(++i);
		}
	}

}

class Consumer1 extends Thread {
	Worker1 q;

	public Consumer1(Worker1 q) {
		this.q = q;
		this.start();
	}

	@Override
	public void run() {
		while (true) {
			q.get();
		}
	}
}

public class ITC_Demo2 {

	public static void main(String[] args) {
		Worker1 q = new Worker1();
		Producer1 p = new Producer1(q);
		Consumer1 c = new Consumer1(q);

	}

}
