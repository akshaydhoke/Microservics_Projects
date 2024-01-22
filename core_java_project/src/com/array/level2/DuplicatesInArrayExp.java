package com.array.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//import scala.annotation.implicitAmbiguous;

// https://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
//https://www.geeksforgeeks.org/duplicates-array-using-o1-extra-space-set-2/?ref=rp

public class DuplicatesInArrayExp {

	public static void main(String[] args) {

		int numRay[] = { 0, 4, 3, 2, 7, 8, 2, 3, 1 };
		int numRayLen = numRay.length;

		for (int i = 0; i < numRayLen; i++) {
			numRay[numRay[i] % numRayLen] = numRay[numRay[i] % numRayLen] + numRayLen;
		}
		
//		If the duplicates items are present then value is greater than Array length*2

		System.out.print("Duplicates items are : ");
		for (int i = 0; i < numRayLen; i++) {
//			if (numRay[i] >= numRayLen * 2) {
//				System.out.print(i + " ");
//			}
			
			if (numRay[i]/numRayLen>=2) {
				System.out.print(i + " ");
			}
		}
		
		System.out.println();
		System.out.println("*********************** Way2 **********************************");
		
		int numRay1[] = { 0, 4, 3, 2, 7, 8, 2, 3, 1 };
		
		printRepeating(numRay1,numRayLen);
		
		System.out.println();
		System.out.println("*************************** Way3 ******************************");
		
		System.out.print("Duplicates items are : ");

		int numRay2[] = { 0, 4, 3, 2, 7, 8, 2, 3, 1 };
		List<Integer> numRay2List=new ArrayList<>();
		for(int i: numRay2){
			numRay2List.add(i);
		}

        numRay2List.stream().filter(i -> Collections.frequency(numRay2List, i)>1).collect(Collectors.toSet()).forEach(System.out::println);;		
		
		
	}
	
	static void printRepeating(int arr[], int n) {
        // First check all the values that are present in an array then go to that
        // values as indexes and increment by the size of array
		
        for (int i = 0; i < n; i++)
        {
            int index = arr[i] % n;
            arr[index]=arr[index]+ n;
        }
 
        // Now check which value exists more
        // than once by dividing with the size
        // of array
		System.out.print("Duplicates items are : ");
        for (int i = 0; i < n; i++)
        {
            if ((arr[i] / n) >= 2)
                System.out.print(i + " ");
        }
    }

}
