package com.sample.examples;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://www.geeksforgeeks.org/double-brace-initialization-java/?ref=rp

public class TraceOutExp1 {

	static {
		initialize();
	}
	
	
	private static boolean initialized=false;
	static int sum;

	
	private static int getSum() {
		initialize();
		return sum;
	}
	
	
	static void initialize() {

		System.out.println("value :"+ initialized);
		if (!initialized) {
			for (int i = 0; i < 100; i++) {
                  sum=sum+i;
			}
			initialized=true;
		}
	}

	public static void main(String[] args) {

		System.out.println("Sum is : " + TraceOutExp1.getSum());

	}

}
