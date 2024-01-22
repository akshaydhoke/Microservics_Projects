package com.array.level1;

// https://www.geeksforgeeks.org/top-50-array-coding-problems-for-interviews/
// https://www.geeksforgeeks.org/write-a-program-to-reverse-an-array-or-string/

public class ReverseArrayExp {
	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5, 6 };
		int start = 0;
		int end = arr.length - 1;
		System.out.println("Original Array :");
		for (int i : arr) {
			System.out.print(i + " ");
		}

		// Reverse Array
		reverseArr(arr, start, end);

		System.out.println();
		System.out.println("Reverse Array :");
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	private static void reverseArr(int[] arr, int start, int end) {

		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}

	}

}
