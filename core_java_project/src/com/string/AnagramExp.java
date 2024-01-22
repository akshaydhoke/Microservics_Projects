package com.string;

import java.time.temporal.ValueRange;
import java.util.Arrays;

/*  Input:a = geeksforgeeks, b = forgeeksgeeks
    Output: YES
    Explanation: Both the string have same characters with same frequency. So, both are anagrams.   */

public class AnagramExp {
	public static void main(String[] args) {

		String str1 = "akshay";
		String str2 = "shayak";
		if (str1.length() == str2.length()) {

			char[] arr = str1.toCharArray();
			char[] arr2 = str2.toCharArray();

			Arrays.sort(arr);
			Arrays.sort(arr2);

			boolean result = Arrays.equals(arr, arr2);

			if (result) {
				System.out.println("Both Strings are Anagram");
			} else {
				System.out.println("Both Strings are not Anagram");
			}

		} else {
			System.out.println("Both Strings are not equal...");
		}
		
		ValueRange range= ValueRange.of(0, 255);
		
		System.out.println(range.isValidIntValue(22));
		
		System.out.println("-------------------------------");
		
		

	}
}
