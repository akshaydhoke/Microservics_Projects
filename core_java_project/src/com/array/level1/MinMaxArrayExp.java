package com.array.level1;

// https://www.geeksforgeeks.org/top-50-array-coding-problems-for-interviews/
// https://practice.geeksforgeeks.org/problems/find-minimum-and-maximum-element-in-an-array4428/1
class MinMax {
	int max;
	int min;
}

public class MinMaxArrayExp {
	public static void main(String[] args) {

		int arr[] = { 1000, 11, 445, 1, 3300, 3000 };

		int size = arr.length;

		MinMax minMax = minAndMax(arr, size);

		System.out.println("Min Number :"+ minMax.min);
		System.out.println("Max Number :"+ minMax.max);

	}

	private static MinMax minAndMax(int[] arr, int n) {

		MinMax minMax = new MinMax();

		if (n == 1) {
			minMax.max = arr[0];
			minMax.min = arr[1];
			return minMax;
		}

		if (arr[0] > arr[1]) {
			minMax.max = arr[0];
			minMax.min = arr[1];
		} else {
			minMax.max = arr[1];
			minMax.min = arr[0];
		}

		for (int i = 2; i < n; i++) {
			if (arr[i] > minMax.max) {
				minMax.max = arr[i];
			} else if (arr[i] < minMax.min) {
				minMax.min = arr[i];
			}
		}

		return minMax;
	}

}
