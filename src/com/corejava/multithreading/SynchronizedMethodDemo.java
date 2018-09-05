package com.corejava.multithreading;

public class SynchronizedMethodDemo {

	public static void main(String[] args) {
		// Creating the shared resource
		BankAccount02 bankAccount = new BankAccount02();

		Depositor02 depostiorA = new Depositor02(100, bankAccount);
		Depositor02 depostiorB = new Depositor02(200, bankAccount);

		Thread threadA = new Thread(depostiorA, "Thread A");
		Thread threadB = new Thread(depostiorB, "Thread B");

		System.out.println("Initial bank balance: Rs." + bankAccount.getBalance());

		// Start the threads...
		threadA.start();
		threadB.start();

		// Wait for the threads to finish processing
		try {
			threadA.join();
			threadB.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Bank balance after depositing: Rs." + bankAccount.getBalance());
	}

}

// BankAccount is the shared resource
class BankAccount02 {
	private int balance = 0;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	synchronized public void deposit(int amount) {
		try {
			Thread.sleep(100); // Doing some processing...

			// Get the initial Balance
			int initialBalance = getBalance();
			Thread.sleep(100); // Doing some processing...

			// Add the deposit amount to the initial balance
			int finalBalance = initialBalance + amount;
			Thread.sleep(100); // Doing some processing...

			// Set the final balance
			setBalance(finalBalance);
			Thread.sleep(100); // Doing some processing...

		} catch (InterruptedException ex) {
			System.err.println("Thread '" + Thread.currentThread().getName() + "' is interrupted!");
		}
	}
}

class Depositor02 implements Runnable {
	private int amount;
	private BankAccount02 bankAccount;

	public Depositor02(int amount, BankAccount02 bankAccount) {
		this.amount = amount;
		this.bankAccount = bankAccount;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is executing and depositing Rs." + amount + "...");
		bankAccount.deposit(amount);
		System.out.println(Thread.currentThread().getName() + " is done executing and depositing.");
	}

}
