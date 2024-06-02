package com.nt.multithreading;


class Account {
	private int balance = 0;

	synchronized void deposite(int amount) {
		balance = balance + amount;
		System.out.println("Current balance: " + balance);
	}

	int getBalance() {
		return balance;
	}
}

class Customer extends Thread {
	Account account;

	public Customer(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		account.deposite(10);
	}
}

public class SynchonizationDemo {

	public static void main(String[] args) {
		Account account = new Account();

		//creating an array of Customer threads
		Customer customer[] = new Customer[5];

		//give single reference of Account class to Customer threads
		for (int i = 0; i < 5; i++) {
			customer[i] = new Customer(account);
		}

		//start the Customer threads to deposit Rs 10/-
		for (int i = 0; i < 5; i++) {
			customer[i].start();
		}
		//join the Customer threads
		try {
			for (int i = 0; i < 5; i++) {
				customer[i].join();
			}
		} catch (InterruptedException e) {
			System.err.println("Problem in thread execution");
		}
		System.out.println("Total Balance : " + account.getBalance());
	}
}
