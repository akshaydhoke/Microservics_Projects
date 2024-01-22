package com.multi_threading.interthreadcommunication;

// Deadlock and Prevention :: 
//https://www.geeksforgeeks.org/how-to-solve-deadlock-using-threads-in-java/

class A {

	synchronized void mA(B b) {
		System.out.println(" ::::: In method mA() :::::: ");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(" Thread calling b.last() method ");
		b.last();
	}

	synchronized void last() {
		System.out.println("Calling last method in Class-A");
	}

}

class B {

	synchronized void mB(A a) {
		System.out.println(" ::::: In method mB() :::::: ");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(" Thread calling a.last() method ");
		a.last();
	}

	synchronized void last() {
		System.out.println("Calling last method in Class-B");
	}

}

public class DeadlockExp implements Runnable {
	A a = new A();
	B b = new B();

	public DeadlockExp() {
		new Thread(this).start();
		a.mA(b);// main thread
	}

	@Override
	public void run() {
		b.mB(a); // child thread
	}

	public static void main(String[] args) {
		new DeadlockExp();
	}

}
