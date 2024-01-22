package com.multi_threading;

class MyThread24 extends Thread {
	public void run() {

		for (int i = 0; i < 5; i++) {
			System.out.println("iam lazy thread");
		}

		System.out.println("I'm entered into sleeping stage");

		try {
			Thread.sleep(3000);
			System.out.println("Sleeping done");
		} catch (InterruptedException e) {
			System.out.println("i got interrupted");
		}
	}
}

public class ThreadInterruptDemo1 {

	public static void main(String[] args) {

		MyThread24 t = new MyThread24();
		t.start();
		t.interrupt();
		
		System.out.println("Main tread executed");

	}

}
