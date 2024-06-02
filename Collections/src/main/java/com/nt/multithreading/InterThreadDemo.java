package com.nt.multithreading;

class Slave {

	int num = 0;
	boolean set = false;

	public synchronized void put(int i) {

		if (set) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		num = i;
		set = true;
		System.out.println("Put->" + num);
		notify();

	}

	public synchronized int get() {
		if (!set) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Get->" + num);
		set = false;
		notify();
		return num;
	}
}

class Parent extends Thread {

	Slave s;

	public Parent(Slave s) {
		this.s = s;
		this.start();
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			s.put(++i);
		}
	}
}

class Child extends Thread {

	Slave s;

	public Child(Slave s) {
		this.s = s;
		this.start();
	}

	@Override
	public void run() {
		while (true) {
			s.get();
		}

	}
}

public class InterThreadDemo {

	public static void main(String[] args) {
		Slave s = new Slave();
		Parent p = new Parent(s);
		Child c = new Child(s);
	}
}
