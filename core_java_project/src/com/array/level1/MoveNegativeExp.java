package com.array.level1;

import java.util.Arrays;

// https://www.geeksforgeeks.org/top-50-array-coding-problems-for-interviews/
// https://www.geeksforgeeks.org/move-negative-numbers-beginning-positive-end-constant-extra-space/
	
public class MoveNegativeExp {
	public static void main(String[] args) {

		int[] arr = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
		int arrLen=arr.length;
		
		// way 1:
//		arrangeArr1(arr,arrLen);
		
		//way 2:
		arrangeArr2(arr,arrLen);

		
		for(int i:arr) {
			System.out.print(" "+ i);
		}

	}

	private static void arrangeArr1(int[] arr, int arrLen) {
		Arrays.sort(arr);
	}
	
	private static void arrangeArr2(int[] arr, int arrLen) {

		int temp, j = 0;

		for (int i = 0; i < arrLen; i++) {
			if (arr[i] < 0) {
				if (i != j) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				j++;
			}
		}
	}

}
