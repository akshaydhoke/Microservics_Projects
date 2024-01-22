package com.array.level2;

public class SubsetOfAnotherArray {

	public static void main(String[] args) {
		boolean check;
		int arr1[] = { 11, 1, 13, 21, 3, 7 };
		int arr2[] = { 11, 3, 7, 1 };

		int arr1Len = arr1.length;
		int arr2Len = arr2.length;

		check = checkSubsetOfArray(arr1, arr2, arr1Len, arr2Len);
		
		System.out.println(check);
	}

	private static boolean checkSubsetOfArray(int[] arr1, int[] arr2, int arr1Len, int arr2Len) {

		for (int i = 0; i < arr1Len; i++) {
			for (int j = 0; j < arr2Len; j++) {
				if (arr1[i] == arr2[j]) {
					break;
				}
			}
		}

		return true;
	}

}
