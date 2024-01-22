package com.multi_threading.interthreadcommunication;

// https://www.scaler.com/topics/producer-consumer-problem-in-java/

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueCPExp {
	public static void main(String[] args) {

		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

		Producer p = new Producer(queue);
		Consumer c = new Consumer(queue);

		Thread t1 = new Thread(p);
		Thread t2 = new Thread(c);

		t1.start();
		t2.start();

	}
}

class Producer implements Runnable {
	BlockingQueue<Integer> queue;

	public Producer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		// for (int i = 0; i <= 5; i++) {
		for (int i = 0; true; i++) {
			try {
				queue.put(i);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Produced :" + i);
		}
	}

}

class Consumer implements Runnable {
	BlockingQueue<Integer> queue;
	int taken = -1;

	public Consumer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		// while (taken != 5) {
		while (true) {
			try {
				taken = queue.take();
				Thread.sleep(500);
				System.out.println("Consumed :" + taken);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
