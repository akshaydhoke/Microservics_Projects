package com.array.level2;

import java.util.Arrays;

// https://www.geeksforgeeks.org/find-the-missing-number/
public class MissingNumExp {

	public static void main(String[] args) {
		
//	int total= (n+1)*(n+2)/2;

//		int arr[] = { 1, 3, 7, 5, 5, 6, 2 };
		int arr [] = new int[]{1,2,3,5,6,7};

		int n = arr.length;

// way1 :
//		getMissingNo(arr, n);

// way2 :
//		getMissingNo2(arr, n);
		
// way3 : Using Java8
		getMissingNo3(arr, n);

	}


	//	Approach 2.1V (Using summation of first N natural numbers):
//	{ 1, 3, 7, 5, 6, 2 }
	public static int getMissingNo(int[] nums, int n) {
		int sum = ((n + 1) * (n + 2)) / 2;
		for (int i = 0; i < n; i++) {
			sum = sum - nums[i];
		}
		System.out.println("Missing No :" + sum);

		return sum;
	}

//	Approach 2.2V (Using summation of first N natural numbers):
//	{ 1, 3, 7, 5, 6, 2 }
	public static int getMissingNo2(int[] nums, int n) {
		int N = n + 1;
		int res = 0;
		int sum = 0;
		int ideaSum = (N * (N + 1)) / 2;

		sum = Arrays.stream(nums).sum();
		res = ideaSum - sum;

		System.out.println("Missing No :" + res);

		return res;
	}
	
	private static void getMissingNo3(int[] arr, int n) {
		int maxVal = Arrays.stream(arr).max().getAsInt();
		int expectedSum = maxVal * (maxVal + 1) / 2;
		int actualSum = Arrays.stream(arr).sum();
		System.out.println("Missing no : "+ (expectedSum-actualSum));
	}

}
