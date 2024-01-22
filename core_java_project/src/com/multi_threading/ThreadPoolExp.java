package com.multi_threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MessageProcessor implements Runnable {

	int messageProcessor;

	public MessageProcessor(int msg) {
		this.messageProcessor = msg;
	}

	public void processMsg() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		System.out.println("CURRENT THREAD IS :: " + Thread.currentThread().getName() + " [START] " + messageProcessor);
		processMsg();
		System.out.println("CURRENT THREAD IS :: " + Thread.currentThread().getName() + " [END] " + messageProcessor);
	}

}

public class ThreadPoolExp {
	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		Runnable thread = new MessageProcessor(2);
		executor.execute(thread);
		
		Runnable thread2 = new MessageProcessor(3);
		executor.execute(thread2);
		
		Runnable thread3 = new MessageProcessor(5);
		executor.execute(thread3);

		executor.shutdown();
		
//		while (!executor.isTerminated()) {}   // Firstly completed execution of ExecutorService then start Main thread.
			
		System.out.println("Finished threadsexecution...");
	}
}
