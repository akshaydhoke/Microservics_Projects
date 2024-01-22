package com.string;

import java.util.Stack;

public class ReverseStringInStackExp {
	public static void main(String[] args) {

		Stack<Character> stack = new Stack<>();

		String string = "Akshay";
		StringBuilder reverseString = new StringBuilder();

		for (int i = 0; i < string.length(); i++) {
			stack.push(string.charAt(i));
		}
		
		System.out.println(stack.size());


		System.out.println(stack);

		for (int i = 0; i < string.length(); i++) {
			char ch = stack.pop();
			reverseString.append(ch);
		}
		
		System.out.println(stack.size());

		System.out.println(reverseString);

	}
}
