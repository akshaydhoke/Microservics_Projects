package com.multi_threading.interthreadcommunication;

class ThreadB extends Thread {

	int total = 0;

	@Override
	public void run() {

		synchronized (this) {
			System.out.println("child thread starts calcuation");// step-2
			for (int i = 0; i <= 100; i++) {
				total = total + i;
			}
			System.out.println("child thread giving notification call");// step-3
			this.notify();
		}
	}

}

public class ThreadA {
	public static void main(String[] args) throws InterruptedException {
		ThreadB threadB = new ThreadB();
		threadB.start();

		synchronized (threadB) {
			System.out.println("main Thread calling wait() method");// step-1
			threadB.wait();
			System.out.println("main Thread got notification call");// step-4
			System.out.println("Total sum is : " + threadB.total);

		}

	}
}
