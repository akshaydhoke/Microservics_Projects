package com.multi_threading;

class ThreadRunner extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("Exception is occured :: " + e);
			}

			System.out.print("Current Thread name is :: " + Thread.currentThread().getName());
			System.out.print(" >>>> " + i);
			System.out.println();
		}
	}
}

public class ThreadJoinExample {
	public static void main(String[] args) {

		ThreadRunner tr1 = new ThreadRunner();
		ThreadRunner tr2 = new ThreadRunner();
		ThreadRunner tr3 = new ThreadRunner();

//		Thread1 ==>

		tr1.start();

		try {

			System.out.println("Current Thread in main is ::" + Thread.currentThread().getName());

			tr1.join();

		} catch (Exception e) {
			System.out.println(e);
		}

//		Thread2 ==>

		tr2.start();

		try {

			System.out.println("Current Thread in main is ::" + Thread.currentThread().getName());

			tr2.join();

		} catch (Exception e) {
			System.out.println(e);
		}

//		Thread3 ==>

		tr3.start();

		try {

			System.out.println("Current Thread in main is ::" + Thread.currentThread().getName());

			tr3.join();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
