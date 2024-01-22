package com.multi_threading;

class ThreadRunClass implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
}

public class ThreadGroupExp {
	public static void main(String[] args) {

		ThreadGroup threadGroup = new ThreadGroup("Paraent Thread Group");
		Runnable runner = new ThreadRunClass();

		Thread tr1 = new Thread(threadGroup, runner, "First");
		tr1.start();

		Thread tr2 = new Thread(threadGroup, runner, "Second");
		tr2.start();

		Thread tr3 = new Thread(threadGroup, runner, "Third");
		tr3.start();

		System.out.println("Thread Group Name: " + threadGroup.getName());

		threadGroup.list();

		// activeCount() ::

		System.out.println("Thread activeCount() : " + threadGroup.activeCount()); // The number of active threads in the thread group and its subgroups.

		// activeGroupCount() ::

		System.out.println("Thread activeGroupCount() : " + threadGroup.activeGroupCount());
		
//		

	}
}
