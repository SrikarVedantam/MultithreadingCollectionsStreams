package com.corejava.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThredPoolDemo {
	public static void main(String[] args) {
		Hello hellos = new Hello();
		GoodBye goodbyes = new GoodBye();
		
		// Create a cached thread pool
		ExecutorService executor = Executors.newCachedThreadPool();
		
		executor.execute(hellos);
		executor.execute(goodbyes);
		
		// Shutdown the executor
		executor.shutdown();
	}
}

class Hello implements Runnable{
	@Override
	public void run() {
		for(int i=0; i < 10; i++) {
			System.out.println("Hello " + (i + 1));
		}
	}
	
}

class GoodBye implements Runnable{
	@Override
	public void run() {
		for(int i=0; i < 10; i++) {
			System.out.println("Goodbye " + (i + 1));
		}
	}
}