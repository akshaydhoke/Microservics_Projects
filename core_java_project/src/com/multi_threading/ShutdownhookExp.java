package com.multi_threading;

public class ShutdownhookExp {
	public static void main(String[] args) {

		// creating Shutdownhook ::

		Runtime runtime = Runtime.getRuntime();
		runtime.addShutdownHook(new Thread() {

			@Override
			public void run() {
				System.out.println("Thread is ran succeessfully...");
			}
		});

		System.out.println("::::: Main method is running...Please enter ctrl + C :::::");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// removing the hook  
//		Runtime.getRuntime().removeShutdownHook(new Thread("Hi Akshay"));  
		
		
		
	}
}
