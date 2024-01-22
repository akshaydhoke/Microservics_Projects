package com.multi_threading;

// https://java.scjp.jobs4times.com/multiThread.htm

class Display {

	public static synchronized void wish(String name) {
		for (int i = 0; i < 5; i++) {
			System.out.print("good morning:");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			System.out.println(name);
		}
	}
	
	public static synchronized void wish2(String name) {
		for (int i = 0; i < 5; i++) {
			System.out.print("good night:");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			System.out.println(name);
		}
	}
}

class MyThread1 extends Thread {
	Display d;
	String name;

	MyThread1(Display d, String name) {
		this.d = d;
		this.name = name;
	}

	public void run() {
		d.wish(name);
		d.wish2(name);
	}
}

public class synchronizedMehodExp {

	public static void main(String[] args) {

		Display d1 = new Display();
		Display d2 = new Display();

		MyThread1 t1 = new MyThread1(d1, "dhoni");
		MyThread1 t2 = new MyThread1(d1, "yuvaraj");

		t1.start();
		t2.start();
	}

}
