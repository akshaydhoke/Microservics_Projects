package com.array.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// https://www.geeksforgeeks.org/top-50-array-coding-problems-for-interviews/
// https://www.geeksforgeeks.org/count-number-of-occurrences-or-frequency-in-a-sorted-array/

public class FindOccurencesInArray {
	public static void main(String[] args) {

		int arr[] = { 1, 2, 2, 2, 2, 3, 4, 7, 8, 8 };
		int arrLen = arr.length;
		int x = 2;
		
        // way 1 :         
		int count = 0;
		for (int i=0;i<arrLen;i++) {
			if (x == arr[i]) {
				count++;
			}
		}
		System.out.println(x + " occurance is : " + count);
		
       // way2 : 
		List<Integer> cList=new ArrayList<>();
        
		for(int j:arr) {
			cList.add(j);
		}
		
		int occurance=Collections.frequency(cList, x);
		System.out.println( x +" Repeated elements : " + occurance);
		
        
	}
}
