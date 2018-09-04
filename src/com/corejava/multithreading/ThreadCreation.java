package com.corejava.multithreading;

public class ThreadCreation {
	public static void main(String[] args) {
		System.out.println("Main thread begins...");
		ThreadA threadA = new ThreadA();
		// Create ThreadA that implements "Runnable" interface
		Thread t1 = new Thread(threadA, "threadA");
		t1.start();
		
		// Create ThreadB that extends "Thread" class
		ThreadB t2 = new ThreadB();
		t2.start();
		
		try {
			// Wait for the child threads to join the "main" thread
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Check if the child threads are alive
		System.out.println("Is Thread A alive? " + t1.isAlive());
		System.out.println("Is Thread B alive? " + t2.isAlive());

		System.out.println("Main thread ends...");
	}

}

class ThreadA implements Runnable {
	@Override
	public void run() {
		System.out.println("Thread A running...");
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException ex) {
			System.err.println("Thread A interrupted!");
		}
		System.out.println("ThreadA done");
	}
}

class ThreadB extends Thread {
	/*ThreadB() {
		super("This is ThreadB");
		start(); // call the start method
	}*/

	public void run() {
		System.out.println("Thread B running...");
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException ex) {
			System.err.println("ThreadB interrupted!");
		}
		System.out.println("ThreadB done");
	}
}
