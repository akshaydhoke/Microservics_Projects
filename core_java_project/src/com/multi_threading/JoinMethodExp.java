package com.multi_threading;

class MyThread extends Thread {

	static Thread tt;

	@Override
	public void run() {

		try {
			 tt.join();

			for (int i = 0; i < 5; i++) {
				Thread.sleep(500);
				System.out.println("In MyThread1 ");
			}
		} catch (Exception e) {
			System.out.println("Exception in MyThread" + e);
		}
	}

}

class MyThread2 extends Thread {

	@Override
	public void run() {

		for (int i = 0; i < 5; i++) {
			System.out.println("In MyThread2 ");
		}
	}

}

public class JoinMethodExp {

	public static void main(String[] args) {
		try {
			MyThread t1 = new MyThread();
			MyThread2 t2 = new MyThread2();

			t1.start();
//			t1.join();
			// t2.sStart();

			for (int i = 0; i < 5; i++) {
				Thread.sleep(500);
				System.out.println("In main");
			}

		} catch (Exception e) {
			System.out.println("Exeption in JoinMethodExp : " + e);
		}

	}

}
