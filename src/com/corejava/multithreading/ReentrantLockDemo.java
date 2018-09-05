package com.corejava.multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

	public static void main(String[] args) {
		// Creating the shared resource
		BankAccount03 bankAccount = new BankAccount03();

		Depositor03 depostiorA = new Depositor03(100, bankAccount);
		Depositor03 depostiorB = new Depositor03(200, bankAccount);

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
class BankAccount03 {
	private int balance = 0;
	ReentrantLock depositLock = new ReentrantLock();

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void deposit(int amount) {
		depositLock.lock();
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
		finally {
			depositLock.unlock();
		}
	}
}

class Depositor03 implements Runnable {
	private int amount;
	private BankAccount03 bankAccount;

	public Depositor03(int amount, BankAccount03 bankAccount) {
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

