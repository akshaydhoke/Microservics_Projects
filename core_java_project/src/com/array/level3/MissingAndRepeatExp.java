package com.array.level3;

// https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/

public class MissingAndRepeatExp {

	public static void main(String[] args) {

		int[] arr = { 7, 3, 4, 5, 5, 6, 2 ,9};
		int n = arr.length;

		printTwoElements(arr, n);
	}

	private static void printTwoElements(int[] arr, int n) {

		System.out.print("PRINT MISSING NUMBER IS :");
		
		for(int i=1;i<=n;i++) {
			if(i!=arr[i-1]) {
				System.out.print(i);
				break;
			}
		}
	}

}
