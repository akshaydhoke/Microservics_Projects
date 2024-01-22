package com.multi_threading;

// Using synchronized block :

//Class level lock =>
//https://www.geeksforgeeks.org/object-level-class-level-lock-java/

class ThreadClass5 implements Runnable {

	@Override
	public void run() {

		System.out.println(Thread.currentThread().getName());

		lock();
	}

	private void lock() {

		System.out.println("Inside : "+ Thread.currentThread().getName());

	}

}

public class SyncBlockForObjClassExp {

	public static void main(String[] args) {

		ThreadClass5 obj1 = new ThreadClass5();
		ThreadClass5 obj2 = new ThreadClass5();

		Thread t1 = new Thread(obj1);
		Thread t2 = new Thread(obj1);
		Thread t3 = new Thread(obj2);

		t1.setName("t1");
		t2.setName("t2");
		t3.setName("t3");

		t1.start();
		t2.start();
		t3.start();

	}

}
