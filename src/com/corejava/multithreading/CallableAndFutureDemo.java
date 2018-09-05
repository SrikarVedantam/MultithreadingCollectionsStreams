package com.corejava.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableAndFutureDemo {
	public static void main(String[] args) {
		
		// Create a fixed thread pool with 3 threads
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		Future<Integer> twoMultiplerResult = executor.submit(new TwoMultiplier(2));
		Future<Integer> threeMultiplerResult = executor.submit(new ThreeMultiplier(3));
		Future<Integer> fourMultiplerResult = executor.submit(new FourMultiplier(4));
		
		// Get the multiplication result from the Future object returned earlier
		try {
			System.out.println("Two multiplier result: " + twoMultiplerResult.get());
			System.out.println("Three multiplier result: " + threeMultiplerResult.get());
			System.out.println("Four multiplier result: " + fourMultiplerResult.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}

class TwoMultiplier implements Callable<Integer>{
	
	private int factor;
	
	public TwoMultiplier(int factor) {
		this.factor = factor;
	}

	@Override
	public Integer call() throws Exception {
		Thread.sleep(500); // Doing some processing
		return 2 * factor;
	}
	
}

class ThreeMultiplier implements Callable<Integer>{
	
	private int factor;
	
	public ThreeMultiplier(int factor) {
		this.factor = factor;
	}

	@Override
	public Integer call() throws Exception {
		Thread.sleep(500); // Doing some processing
		return 3 * factor;
	}
	
}

class FourMultiplier implements Callable<Integer>{
	
	private int factor;
	
	public FourMultiplier(int factor) {
		this.factor = factor;
	}

	@Override
	public Integer call() throws Exception {
		Thread.sleep(500); // Doing some processing
		return 4 * factor;
	}
	
}