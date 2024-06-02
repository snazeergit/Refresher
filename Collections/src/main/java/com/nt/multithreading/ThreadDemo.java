package com.nt.multithreading;

class Customer1 extends Thread {

	public Customer1() {
		System.out.println("Customer1()");
	}

	@Override
	public void run() {
		System.out.println("Customer1->run()");
		get();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		put();

	}

	synchronized void get() {
		try {
			System.out.println("Before wait(-): " + getState());
			this.wait(1000);
			System.out.println("After wait(-): " + getState());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	synchronized void put() {
		System.out.println("Before notify(): " + getState());
		notify();
		System.out.println("Is Interrupted: " + interrupted());
		interrupt();
		System.out.println("Is Interrupted: " + interrupted());
		
		System.out.println("After notify(): " + getState());
	}
}

public class ThreadDemo {

	public static void main(String[] args) throws InterruptedException {
		Customer1 c = new Customer1();
		System.out.println("Thread Name: " + c.getName());
		System.out.println("Thread Id: " + c.getId());
		System.out.println("Thread Priority: " + c.getPriority());
		System.out.println("Thread State: " + c.getState());

		System.out.println("Thread State: " + c.getState());
		c.start();
		System.out.println("Active threads: " + c.activeCount());
		//c.start();// throws IllegalThreadStateException as we should not start a thread twice.
	}

}
