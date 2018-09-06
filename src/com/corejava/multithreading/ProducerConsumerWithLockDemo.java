package com.corejava.multithreading;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerWithLockDemo {
	public static void main(String[] args) {

		ReentrantLock lock = new ReentrantLock();
		Buffer buffer = new Buffer();
		
		Thread producer = new Thread(new Producer(lock, buffer), "Producer");
		Thread consumer = new Thread(new Consumer(lock, buffer), "Consumer");

		producer.start();
		consumer.start();
	}
}

class Buffer {
	private boolean isBufferReady = false;
	private int buffer = 0;

	public boolean isBufferReady() {
		return isBufferReady;
	}

	public int getBuffer() {
		return buffer;
	}

	public void setBuffer(int buffer) {
		this.buffer = buffer;
	}

	public void setBufferReady(boolean isBufferReady) {
		this.isBufferReady = isBufferReady;
	}
	
}

class Producer implements Runnable {
	private ReentrantLock lock;
	private Buffer buffer;
	private int count = 0;
	private Random rand = new Random();

	public Producer(ReentrantLock lock, Buffer buffer) {
		this.lock = lock;
		this.buffer = buffer;
	}

	@Override
	public void run() {
		System.out.println("Starting the producer...");
		for (;;) {
			if (buffer.isBufferReady()) {
				Thread.yield();
			} else {
				lock.lock();
				if (!buffer.isBufferReady()) {
					buffer.setBuffer(rand.nextInt(100));
					System.out.println(Thread.currentThread().getName() + " produced " + buffer.getBuffer());
					buffer.setBufferReady(true);
					count++;
				}
				lock.unlock();
				if (count == 10)
					break;
			}
		}
		System.out.println("Producer done producing.");
	}
}

class Consumer implements Runnable {
	private ReentrantLock lock;
	private Buffer buffer;
	private int count = 0;

	public Consumer(ReentrantLock lock, Buffer buffer) {
		this.lock = lock;
		this.buffer = buffer;
	}

	@Override
	public void run() {
		System.out.println("Starting the consumer...");
		for (;;) {
			if (!buffer.isBufferReady()) {
				Thread.yield();
			} else {
				lock.lock();
				if (buffer.isBufferReady()) {
					System.out.println(Thread.currentThread().getName() + " consumed " + buffer.getBuffer());
					buffer.setBufferReady(false);
					count++;
				}
				lock.unlock();
				if (count == 10)
					break;
			}
		}
		System.out.println("Consumer done consuming.");
	}
}
