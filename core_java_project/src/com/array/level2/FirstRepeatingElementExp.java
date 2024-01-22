package com.array.level2;

import java.util.HashSet;

// https://www.geeksforgeeks.org/find-first-repeating-element-array-integers/

public class FirstRepeatingElementExp {

	public static void main(String[] args) {

		int arr[] = { 10, 5, 3, 4, 3, 5, 6 };
//		int arr[] = { 1, 2, 3, 4, 5};


		// Using Normal way:
		int firstValue = 0;
		firstValue = getFirstRepeatElement(arr);

		if (firstValue == -1) {
			System.out.println("Not repeating values");
		} else {
			System.out.println("First Repeat Element : " + arr[firstValue]);
		}

		// Using HashSet:

		int firstElement = getFirstElementUsingHash(arr);

		if (firstElement != -1) {
			System.out.println("First Repeat Element : " + arr[firstElement]);
		} else {
			System.out.println("No repeat element");
		}
	}

	private static int getFirstElementUsingHash(int[] arr) {

		int min = -1;
		HashSet<Integer> set = new HashSet<>();

		for (int i = arr.length - 1; i > 0; i--) {
			if (set.contains(arr[i])) {
				min = i;
			} else {
				set.add(arr[i]);
			}
		}
		return min;
	}

	private static int getFirstRepeatElement(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					return i;
				}
			}
		}

		return -1;
	}

}
