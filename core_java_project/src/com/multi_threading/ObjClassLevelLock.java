package com.multi_threading;

// Class level lock =>
// https://www.geeksforgeeks.org/object-level-class-level-lock-java/

class ThreadClass4 implements Runnable {

	@Override
	public void run() {
		lock();
	}

	// way1 : static synchronized method.

	// private synchronized static void lock() {
	//
	// System.out.println(Thread.currentThread().getName());
	// System.out.println("Inside : " + Thread.currentThread().getName());
	// System.out.println("End of : " + Thread.currentThread().getName());
	//
	// }

	// way2 : synchronized block.

	private void lock() {

		synchronized (ThreadClass4.class) {
			System.out.println(Thread.currentThread().getName());
			System.out.println("Inside : " + Thread.currentThread().getName());
			System.out.println("End of : " + Thread.currentThread().getName());
		}

	}

}

public class ObjClassLevelLock {

	public static void main(String[] args) {

		ThreadClass4 obj1 = new ThreadClass4();
		ThreadClass4 obj2 = new ThreadClass4();
		ThreadClass4 obj3 = new ThreadClass4();

		Thread t1 = new Thread(obj1);
		Thread t2 = new Thread(obj1);
		Thread t3 = new Thread(obj1);

		t1.setName("t1");
		t2.setName("t2");
		t3.setName("t3");

		t1.start();
		t2.start();
		t3.start();

	}

}
