package com.vmware.itc;

/*
 * We have created an annonymous inner class that implements Runnable interface
 * and passed to the ananymous Thread object and invoked the start() method.
*/
class Operations1 {
	int price;
	boolean isAvailable = false;

	public synchronized void sell(int price) {
		if (isAvailable) {
			try {
				Thread.sleep(100);
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isAvailable = true;
		this.price = price;
		System.out.println("Sell->" + price);
		notify();
	}

	public synchronized int buy() {
		if (!isAvailable) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isAvailable = false;
		System.out.println("Buy->" + price);
		notify();
		return price;
	}
}

public class ITCDemo1 {

	static Operations1 op = new Operations1();

	public static void main(String[] args) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					op.sell(i);
				}
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					op.buy();
				}
			}
		}).start();
	}

}
