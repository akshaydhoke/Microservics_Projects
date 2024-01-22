package com.java8;

import java.util.function.BiFunction;

// BiFunction:
//https://www.geeksforgeeks.org/java-bifunction-interface-methods-apply-and-addthen/

public class BiFunctionExp {
	public static void main(String[] args) {

		// 1) R apply(T t, U u) :

		BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
		int sum = add.apply(10, 20);
		System.out.println("sum : " + sum);

		// 2) addThen() :
		// BiFunction<T, U, V> addThen(Function<? super R, ? extends V> after)

		BiFunction<Integer, Integer, Integer> product = (a, b) -> a * b;
		product = product.andThen(a -> 2 * a);

		System.out.println("andThan() : " + product.apply(3, 2));

		// BiFunction in Exception case :

		BiFunction<Integer, Integer, Integer> add2 = (a, b) -> a + b;
		add2 = add2.andThen(a -> a / (a - 5));
		
		try {
			System.out.println("In Exception case : " + add2.apply(2, 3));
		} catch (Exception e) {
			System.out.println("Exception in BiFunction : " + e);
		}

	}
}
