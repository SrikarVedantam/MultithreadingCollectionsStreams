package com.corejava.multithreading;

public class CurrentThreadDemo {
	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		System.out.println("Current thread: " + t);
		t.setName("My main thread");
		System.out.println("Current thread: " + t);
		System.out.println("Sleeping for two seconds...");
		try {
			Thread.sleep(2000); // Sleep for two seconds
		}
		catch(InterruptedException ex) {
			System.err.println("Thread interrupted: " + ex);
		}
		System.out.println("Awake from sleep and fininshing execution.");
	}
}
