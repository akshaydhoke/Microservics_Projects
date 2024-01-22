package com.java8;

import java.util.function.BiFunction;

class InstanceMethodReference {
	public void printnMsg() {
		System.out.println("Hello, this is instance method");
	}

	public void ThreadStatus() {
		System.out.println("Thread is running using non-static...");
	}

	public int mul(int a, int b) {
		return a * b;
	}
}

public class MethodReferenceExp2 {
	public static void main(String[] args) {

//  Reference to an Instance Method using Threads  ::
		Thread t1=new Thread(new InstanceMethodReference()::ThreadStatus);
		t1.start();
		
//		Using with static method return something ::
		
		BiFunction<Integer, Integer, Integer> res =new InstanceMethodReference()::mul;
		System.out.println(res.apply(10, 4));
		
		
		
	}
}
