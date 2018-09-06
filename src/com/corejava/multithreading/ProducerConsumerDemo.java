package com.corejava.multithreading;

import java.util.Random;

public class ProducerConsumerDemo {

	public static void main(String[] args) {
		System.out.println("Main thread begins the execution...");

		Buffer01 buffer = new Buffer01();
		Thread producer = new Thread(new Producer01(buffer), "Producer");
		Thread consumer = new Thread(new Consumer01(buffer), "Consumer");

		producer.start();
		consumer.start();

		try {
			producer.join();
			consumer.join();
		} catch (InterruptedException e) {
			System.err.println(Thread.currentThread().getName() + " interrupted!");
		}
		
		System.out.println("Main thread done with the execution.");
	}

}

class Buffer01 {
	private boolean isBufferReady = false;
	private int buffer = 0;

	public synchronized void put(int i) {
		while (isBufferReady) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println(Thread.currentThread().getName() + " interrupted!");
			}
		}
		buffer = i;
		isBufferReady = true;
		notify();
	}

	public synchronized int get() {
		int result = 0;
		while (!isBufferReady) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println(Thread.currentThread().getName() + " interrupted!");
			}
		} 
		result = buffer;
		isBufferReady = false;
		notify();
		return result;
	}

}

class Producer01 implements Runnable {
	private Buffer01 buffer;
	private int count = 0;
	private Random rand = new Random();

	public Producer01(Buffer01 buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		System.out.println("Starting " + Thread.currentThread().getName() + " thread...");
		while (true) {
			int i = rand.nextInt(100);
			System.out.println(Thread.currentThread().getName() + " produced " + i);
			buffer.put(i);
			++count;
			if(count == 10) {
				break;
			}
		}
		System.out.println(Thread.currentThread().getName() + " thread done.");
	}
}

class Consumer01 implements Runnable {
	private Buffer01 buffer;
	private int count = 0;

	public Consumer01(Buffer01 buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		System.out.println("Starting " + Thread.currentThread().getName() + " thread...");
		while (true) {
			int i = buffer.get();
			System.out.println(Thread.currentThread().getName() + " consumed " + i);
			++count;
			if(count == 10) {
				break;
			}
		}
		System.out.println(Thread.currentThread().getName() + " thread done.");
	}
}
