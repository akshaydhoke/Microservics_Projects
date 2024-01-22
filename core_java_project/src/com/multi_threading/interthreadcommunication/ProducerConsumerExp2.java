package com.multi_threading.interthreadcommunication;

import java.util.LinkedList;

class CP {

	LinkedList<Integer> list = new LinkedList<>();
	int capacity = 7;

	public void producer1() throws InterruptedException {
		int value = 0;
		while (true) {
			synchronized (this) {
				if (list.size() == capacity) {
					wait();
				}

				list.add(value++);
				System.out.println("Produced : " + list.size());
				notify();
				Thread.sleep(500);
			}
		}
	}

	public void consumer1() throws InterruptedException {

		while (true) {
			synchronized (this) {
				if (list.size() == 0) {
					wait();
				}
				list.removeFirst();
				System.out.println("Consumed :" + list.size());
				notify();
				Thread.sleep(500);

			}
		}
	}

}

public class ProducerConsumerExp2 {
	public static void main(String[] args) {

		CP pc = new CP();

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.producer1();
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.consumer1();
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();

	}
}
