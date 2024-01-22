package com.array.level2;

//  https://www.geeksforgeeks.org/find-common-elements-three-sorted-arrays/

public class FindCommon3Array {

	public static void main(String args[]) {

//		int ar1[] = { 1, 5, 10, 20, 40, 80 };
//		int ar2[] = { 6, 7, 20, 80, 100 };
//		int ar3[] = { 3, 4, 15, 20, 30, 70, 80, 120 };

		int arr1[] = { 1, 5, 10, 20, 40, 80 };
		int arr2[] = { 6, 7, 20, 80, 100 };
		int arr3[] = { 3, 4, 15, 20, 30, 70, 80, 120 };
		int arr4[] = { 300, 400, 15, 20, 100, 70, 800, 120 };

		System.out.print("Common elements are : ");
		// findCommon(ar1, ar2, ar3);

//		findCommonTwoMethods(arr1, arr2);

		findCommonFromFourArrays(arr1, arr2, arr3, arr4);
	}

	private static void findCommonFromFourArrays(int[] arr1, int[] arr2, int[] arr3, int[] arr4) {

		int i = 0, j = 0, k = 0, l = 0;

		while (i < arr1.length && j < arr2.length && k < arr3.length && l < arr4.length) {

			if (arr1[i] == arr2[j] && arr2[j] == arr3[k] && arr3[k] == arr4[l]) {
				System.out.print(arr1[i] + " ");
				i++;
				j++;
				k++;
				l++;
			} else if (arr1[i] < arr2[j]) {
				i++;
			} else if (arr2[j] < arr3[k]) {
				j++;
			} else if (arr3[k] < arr4[l]) {
				k++;
			} else {
				l++;
			}

		}
	}

	private static void findCommonTwoMethods(int[] arr1, int[] arr2) {
		int i = 0, j = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] == arr2[j]) {
				System.out.print(arr1[i] + " ");
				i++;
				j++;
			} else if (arr1[i] < arr2[j]) {
				i++;
			} else {
				j++;
			}
		}

	}

	static void findCommon(int ar1[], int ar2[], int ar3[]) {
		// Initialize starting indexes for ar1[], ar2[] and ar3[]
		int i = 0, j = 0, k = 0;

		// Iterate through three arrays while all arrays have elements

		while (i < ar1.length && j < ar2.length && k < ar3.length) {
			// If x = y and y = z, print any of them and
			// move ahead in all arrays
			if (ar1[i] == ar2[j] && ar2[j] == ar3[k]) {
				System.out.print(ar1[i] + " ");
				i++;
				j++;
				k++;
			}

			// x < y
			else if (ar1[i] < ar2[j])
				i++;

			// y < z
			else if (ar2[j] < ar3[k])
				j++;

			// We reach here when x > y and z < y, i.e., z
			// is smallest
			else
				k++;
		}
	}
}
