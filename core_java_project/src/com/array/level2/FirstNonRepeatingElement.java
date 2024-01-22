package com.array.level2;

import java.util.HashMap;
import java.util.Set;

// https://www.geeksforgeeks.org/non-repeating-element/

public class FirstNonRepeatingElement {

	public static void main(String[] args) {

		int arr[] = { 9, 4, 9, 6, 7, 4 };

		// Using Normal way:
		int firstElement = 0;
		firstElement = getNonRepeatingElement(arr);
		System.out.println("Non-repeating element : " + firstElement);

		// Using HashMap :

		int FirstValue = 0;
		FirstValue = getNonRepeatingElementUsingHash(arr);
		System.out.println("Non-repeating element : " + FirstValue);

	}

	private static int getNonRepeatingElementUsingHash(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
						
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}

		for (int i = 0; i < arr.length; i++) {
             if(map.get(arr[i])==1) {
            	 return arr[i];
             }
		}

		System.out.println(map);

		return -1;
	}

//	int arr[] = { 9, 4, 9, 6, 7, 4 };
	private static int getNonRepeatingElement(int[] arr) {

		for (int i = 0; i < arr.length; i++) {   
			int j = 0;
			for (j = 0; j < arr.length; j++) {   

				if (i != j && arr[i] == arr[j]) {  
					break;
				}
			}
			if (j == arr.length) {
				return arr[i];
			}

		}
		return -1;
	}

}
