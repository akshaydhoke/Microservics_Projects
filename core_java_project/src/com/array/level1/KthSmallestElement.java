package com.array.level1;

// https://www.geeksforgeeks.org/top-50-array-coding-problems-for-interviews/
// https://www.geeksforgeeks.org/kth-smallest-largest-element-in-unsorted-array/
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class KthSmallestElement {
	public static void main(String[] args) {
		Integer arr[] = new Integer[] { 12, 3, 5, 7, 19 };

		int kth = 4;

		kth = kth - 1;

		// way1 :
		// Arrays.sort(arr);

		// way2 :
		Set<Integer> sortList = new TreeSet<>();

		for (int j = 0; j < arr.length; j++) {
			sortList.add(arr[j]);
		}

		Iterator<Integer> itr = sortList.iterator();

		while (kth > 0) {
			itr.next();
			kth--;
		}

		System.err.println(itr.next());
		
//		way3 :
//		first Sort -> find kth element.

		for (int i : arr) {
			System.out.print(i + " ");
		}

		System.err.println(arr[kth]);

	}

}
