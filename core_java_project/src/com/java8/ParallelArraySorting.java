package com.java8;

import java.util.Arrays;

public class ParallelArraySorting {
	public static void main(String[] args) {

//		Sorting Arrays items in ascending order ::

		int[] arr = { 2, 4, 3, 1, 5, 8, 6, 7, -3 };

//		Default Sorting ::

		for (int i : arr)
			System.out.print(" " + i);

		System.out.println();
		Arrays.parallelSort(arr);

//		Sorting in ascending Order ::

		for (int i : arr)
			System.out.print(" " + i);

//		Sorting from particular range ::
		System.out.println();
		
		int[] arr1 = { 2, 4, -3, 1, 5, 8, 6, 7, -9};

		Arrays.parallelSort(arr1,0,5);

		for (int i : arr1)
			System.out.print(" " + i);

	}
}
