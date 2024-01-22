package com.array.level2;

import java.math.BigInteger;

// https://www.geeksforgeeks.org/factorial-large-number/

public class FactorialOfMaxNum {
	public static void main(String[] args) {

		// Simple factorial no :
		int num = 20;
		int result = simpleFactorial(num);
		System.out.println("Factorial is : " + result);

		// Large number :

		BigInteger maxFact = factorialOfLarge(num);
		System.out.println("Factorial of Max number :" + maxFact);

	}

	private static BigInteger factorialOfLarge(int num) {
//		BigInteger bigValue = BigInteger.ONE;
		BigInteger bigValue = new BigInteger("1");

		for (int i = 2; i <= num; i++) {
           bigValue = bigValue.multiply(BigInteger.valueOf(i));
		}
		return bigValue;
	}

	private static int simpleFactorial(int num) {
		if (num == 0) {
			return 1;
		}
		return num * simpleFactorial(num - 1);
	}

}
