package com.innerclasses;

// https://java.scjp.jobs4times.com/inner.htm

public class AnonymousThreadInnnerClasses {

	public static void main(String[] args) {
	
//		Thread :
		
		Thread t=new Thread(){
			@Override
			public void run() {
                for(int i=0;i<5;i++) {
                	System.out.println("In Thread");
                }
			}
		};
		
//		t.start();
		
//		Runnable interface: 
		
		Runnable runnable=new Runnable() {
			@Override
			public void run() {
                for(int i=0;i<5;i++) {
                	System.out.println("In Runnable");
                }
			}
		};
		
		Thread t2=new Thread(runnable);
//		t2.start();
		
//		Optimized method : 
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("Inner optimized method");
				}
			}
		}).start();
		
		for(int i=0;i<5;i++) {
			System.out.println("Main method");
		}

	}

}
