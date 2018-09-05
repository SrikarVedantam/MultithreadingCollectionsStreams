package com.corejava.multithreading;

public class SynchronizedBlockDemo {

	public static void main(String[] args) {
		// Creating the shared resource
		BankAccount01 bankAccount = new BankAccount01();

		Depositor01 depostiorA = new Depositor01(100, bankAccount);
		Depositor01 depostiorB = new Depositor01(200, bankAccount);

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
class BankAccount01 {
	private int balance = 0;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void deposit(int amount) {
		try {
			Thread.sleep(100); // Doing some processing...

			synchronized(this) {
				// Get the initial Balance
				int initialBalance = getBalance();
				Thread.sleep(100); // Doing some processing...

				// Add the deposit amount to the initial balance
				int finalBalance = initialBalance + amount;
				Thread.sleep(100); // Doing some processing...

				// Set the final balance
				setBalance(finalBalance);
			}
			
			Thread.sleep(100); // Doing some processing...

		} catch (InterruptedException ex) {
			System.err.println("Thread '" + Thread.currentThread().getName() + "' is interrupted!");
		}
	}
}

class Depositor01 implements Runnable {
	private int amount;
	private BankAccount01 bankAccount;

	public Depositor01(int amount, BankAccount01 bankAccount) {
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
