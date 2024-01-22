package com.java8;

import java.util.function.BiFunction;

interface PrintFun {
	public void print();
}

class Arithmatic {

	public static int add(int a, int b) {
		return a + b;
	}

	public static float add(int a, float b) {
		return a + b;
	}

	public static void name() {
		System.out.println("Hi Akshay ...");
	}

	public static void ThreadStatus() {
		System.out.println("Thread is running...");
	}

}

public class MethodReferenceExp1 {
	public static void main(String[] args) {
		
//		Static Method Referance ::

//		Using with static method return something ::
		
		BiFunction<Integer, Integer, Integer> adder1 = Arithmatic::add;
		Integer resultInteger = adder1.apply(10, 20);
		System.out.println("resultInteger :: " + resultInteger);

		BiFunction<Integer, Float, Float> adder2 = Arithmatic::add;
		Float resultFloat = adder2.apply(100, 43.6f);
		System.out.println("resultFloat :: " + resultFloat);

//		Using with static method to using Functional Interface for printing some message ::
		
		PrintFun pp = Arithmatic::name;
		pp.print();
		
//		Using to run thread using method reference :: 
		
		Thread t1= new Thread(Arithmatic::ThreadStatus);
		t1.start();
		
	}
}
