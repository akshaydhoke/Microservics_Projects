package com.array.level1;

//https://www.geeksforgeeks.org/top-50-array-coding-problems-for-interviews/

public class SelectionSortExp {
	public static void main(String[] args) {

		int arr[] = { 64, 25, 12, 22, 11 };

		sort(arr);

		System.out.println("After Sorting :");
		for (int i : arr) {
			System.out.print(i + " ");
		}

	}
	
//	Unstable Selection Sort : { 64, 25, 12, 22, 22, 11 }  // O/P =>  11 22 22 12 25 64 
   public static void sort(int arr[])
	{
		int n = arr.length;

		// One by one move boundary of unsorted subarray.
		for (int i = 0; i < n - 1; i++) {

			// Find the minimum element in unsorted array.
			int min_idx = i;
			for (int j = i + 1; j < n; j++)
				if (arr[j] < arr[min_idx]) {
					min_idx = j;

					// Swap the found minimum element with the first element.
					int temp = arr[min_idx];
					arr[min_idx] = arr[i];
					arr[i] = temp;
				}
		}
	}
   
//   Stable Selection Sort :: It can be overcome by using Insertion Sort.

	
}
