package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// Predicate:
//https://www.geeksforgeeks.org/java-8-predicate-with-examples/
// Function: 

public class PredicateFunctionExp {
	
	protected int x,y;

	public static void main(String[] args) {

		// Java 8 Predicate with Examples

		// Example 1: Simple Predicate

		Predicate<Integer> lowerThanTwenty = i -> i < 20;
		Predicate<Integer> higherThanTen = i -> i > 10;
		System.out.println(higherThanTen.test(9));

		boolean result = lowerThanTwenty.and(higherThanTen).test(15);
		System.out.println(result);

		// Example 2: Predicate in to Function

		checkNumber(30, i -> i > 13);

		// Example 3: Predicate OR

		predicate_or();

		// Example 4: Predicate AND

		predicate_and();

		// Example 5: Predicate negate()

		Predicate<Integer> isEven = i -> i % 2 == 0;
		Predicate<Integer> isOdd = isEven.negate();

		List<Integer> collectList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9).stream().filter(isOdd)
				.collect(Collectors.toList());
		System.out.println("negate() List : " + collectList);

		// Example 6: Predicate in Collection

		List<User> listOfUsers = new ArrayList<User>();
		listOfUsers.add(new User("Akshay", "Developer"));
		listOfUsers.add(new User("Aman", "QA"));

		List<User> roles = predicate_collection(listOfUsers, (User u) -> u.getRole().equals("QA"));
		System.out.println("collection List : " + roles);

		System.out.println("*****************************************");


		
		
	}

	private static Predicate<String> hasMoreLenThan10 = new Predicate<String>() {
		@Override
		public boolean test(String t) {
			return t.length() > 10;
		}
	};

	private static void checkNumber(int number, Predicate<Integer> predicate) {
		if (predicate.test(number)) {
			System.out.println("NUMBER IS : " + number);
		}
	}

	private static void predicate_and() {

		Predicate<String> notNullStr = Objects::nonNull;
		String str = null;

		boolean res1 = notNullStr.and(hasMoreLenThan10).test(str);
		System.out.println("RESULT OF predicate_and() : " + res1);

		String nameString = "Welcome Akshay";

		boolean res2 = notNullStr.and(hasMoreLenThan10).test(nameString);
		System.out.println("RESULT OF predicate_and() : " + res2);
	}

	private static void predicate_or() {
		Predicate<String> checkChar = c -> c.contains("a");
		String name = "Akshay";
		boolean res = hasMoreLenThan10.or(checkChar).test(name);
		System.out.println("RESULT OF predicate_or() : " + res);

	}

	private static List<User> predicate_collection(List<User> users, Predicate<User> predicate) {
		List<User> roleUsers = new ArrayList<>();

		for (User user : users) {
			if (predicate.test(user)) {
				roleUsers.add(user);
			}
		}
		return roleUsers;
	}

}

class User {
	String name, role;

	User(String a, String b) {
		name = a;
		role = b;
	}

	String getRole() {
		return role;
	}

	String getName() {
		return name;
	}

	public String toString() {
		return "User Name : " + name + ", Role :" + role;
	}
}
