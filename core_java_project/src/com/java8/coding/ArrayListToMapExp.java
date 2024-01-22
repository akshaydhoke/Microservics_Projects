package com.java8.coding;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArrayListToMapExp {

	public static void main(String[] args) {

		ArrayList<String> fruits = new ArrayList<>();
		fruits.add("Banana");
		fruits.add("Guava");
		fruits.add("Pineapple");
		fruits.add("Apple");

		// printing contents of arraylist before conversion
		System.out.println("Elements in ArrayList are : " + fruits);

		Map<String, Integer> mapList = fruits.stream().collect(Collectors.toMap(Function.identity(), String::length));

		System.out.println(mapList);

	}
}