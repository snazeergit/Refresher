package com.nt.multithreading.job_ready_programmer;

public class Application {

	public static void main(String[] args) {
		Sequence sq = new Sequence();

		Worker w1 = new Worker(sq);
		w1.start();

		Worker w2 = new Worker(sq);
		w2.start();

	}

}

class Worker extends Thread {

	private Sequence sq = null;

	public Worker(Sequence sq) {
		this.sq = sq;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "->" + sq.getValue());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}