package com.array.level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

// https://www.geeksforgeeks.org/union-and-intersection-of-two-sorted-arrays-2/

public class UnionIntersectionExp {

	public static void main(String[] args) {

		int arr1[] = { 1, 3, 4, 5, 7 };
		int arr2[] = { 2, 3, 5, 6 };

		int arr1Len = arr1.length;
		int arr2Len = arr2.length;

		// Normail way :
		getUnion(arr1, arr2, arr1Len, arr2Len);

		// Using TreeSet :
		List<Integer> list = getUnionByTreeSet(arr1, arr2, arr1Len, arr2Len);
		System.out.println("Union list : " + list.toString());

		// Using HashMap :

		List<Integer> listMap = getUnionByHashMap(arr1, arr2, arr1Len, arr2Len);
		System.out.println("Union Map list : " + listMap.toString());

	}

	private static List<Integer> getUnionByHashMap(int[] arr1, int[] arr2, int arr1Len, int arr2Len) {
		List<Integer> list = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr1Len; i++) {
			if (map.containsKey(arr1[i])) {
				map.put(arr1[i], map.get(arr1[i]) + 1);
			} else {
				map.put(arr1[i], 1);
			}
		}

		for (int i = 0; i < arr2Len; i++) {
			if (map.containsKey(arr2[i])) {
				map.put(arr2[i], map.get(arr1[i]) + 1);
			} else {
				map.put(arr2[i], 1);
			}
		}

		for (int i : map.keySet()) {
			list.add(i);
		}

		return list;
	}

	private static List<Integer> getUnionByTreeSet(int[] arr1, int[] arr2, int arr1Len, int arr2Len) {

		List<Integer> list = new ArrayList<Integer>();

		TreeSet<Integer> set = new TreeSet<>();

		// Remove duplicates arr1 :
		for (int i : arr1) {
			set.add(i);
		}
		// Remove duplicates arr2 :
		for (int j : arr2) {
			set.add(j);
		}
		// Adding in list:
		for (int k : set) {
			list.add(k);
		}

		return list;
	}

	private static void getUnion(int[] arr1, int[] arr2, int arr1Len, int arr2Len) {
		int i = 0, j = 0;

		while (i < arr1Len && j < arr2Len) {

			if (arr1[i] < arr2[j]) {
				System.out.print(arr1[i++] + "");
			} else if (arr2[j] < arr1[i]) {
				System.out.println(arr2[j++] + "");
			} else {
				System.out.print(arr2[j++] + "");
				i++;
			}
		}

			while (i < arr1Len) {
				System.out.print(arr1[i++] + "");
			}

			while (j < arr2Len) {
				System.out.print(arr2[j++] + "");
			}

	}

}
