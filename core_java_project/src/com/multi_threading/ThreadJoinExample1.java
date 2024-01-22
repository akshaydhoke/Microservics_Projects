package com.multi_threading;

class ThreadClass extends Thread {

	@Override
	public void run() {
		for (int i = 1; i < 6; i++) {

			try {
				System.out.print(Thread.currentThread().getName() + " : ");
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("Exception is occured :: " + e);
			}

			System.out.println(">>>> " + i);
		}
	}
}

public class ThreadJoinExample1 {
	public static void main(String[] args) {

		ThreadClass th1 = new ThreadClass();
		ThreadClass th2 = new ThreadClass();
		ThreadClass th3 = new ThreadClass();

		th1.start();

		try {
			th1.join();
		} catch (Exception e) {
			System.out.println(e);
		}

		th2.start();
		th3.start();

	}
}
