package com.array.level1;
// https://career.guru99.com/top-50-array-interview-questions-answers/

public class intersectionExp {

	public static void main(String[] args) {

/*
		Common elements of both Arrays
		Ans: Logic: print the element if the element is present or available in both the arrays.
		Use two index variables i and j, after that initial the values i = 0, j = 0
		If arr01 [i] is smaller than arr02 [j] then increment i.
		If arr01 [i] is greater than arr02 [j] then increment j.
		If both are same then print any of them and increment both i and j.
*/

		int arr01[] = { 1, 2, 4, 5, 6 };
		int arr02[] = { 2, 3, 5, 7 };
		
		int m = arr01.length;
		int n = arr02.length;
		int i = 0, j = 0;

		while (i < m && j < n) {
			if (arr01[i] < arr02[j])
				i++;
			else if (arr01[i] > arr02[j])
				j++;
			else {
				System.out.print(arr02[j++] + " ");
				i++;
			}
		}
		
	}
}
