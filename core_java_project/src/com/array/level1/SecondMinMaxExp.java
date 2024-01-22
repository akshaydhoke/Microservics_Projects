package com.array.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// https://www.geeksforgeeks.org/to-find-smallest-and-second-smallest-element-in-an-array/
// https://www.tutorialride.com/java-array-programs/find-second-min-and-max-number-from-array.htm
// Using Stream :
// https://www.baeldung.com/java-array-min-max
// Actual >>
// https://www.benchresources.net/java-8-find-second-largest-number-in-an-arrays-or-list-or-stream/
public class SecondMinMaxExp {

	public static void main(String[] args) {
		
		System.out.println("************************ way1 **********************************");

//		int arr[] = { 12, 13, -1, 10, 34, 34,-22,0 ,1 };
        int arr[] = {23, 43,12, 19, 10, 52, 78, 25, 99, 2 }; // 2 10 12 19 23 25 43 52 78 99 
//		int arr[] = { 2, 10, 12, 19, 23, 25, 43, 52, 78, 99}; 

        int n = arr.length;

        // way1:
		int smallest = Integer.MAX_VALUE;
		int largest = Integer.MIN_VALUE;
		
		for (int i = 0; i < n; i++) {
			if (arr[i] < smallest) {
				smallest = arr[i];
			}
			if (arr[i] > largest) {
				largest = arr[i];
			}
		}
		
		System.out.println("Smallest Element : " + smallest);
		System.out.println("Largest Element : " + largest);
		
		int secondSmallest = Integer.MAX_VALUE;
		int secondLargest = Integer.MIN_VALUE;
		
		for (int i = 0; i < n; i++) {
			if (arr[i] < secondSmallest && arr[i] > smallest) {
				secondSmallest = arr[i];
			}
			if (arr[i] > secondLargest && arr[i] < largest) {
				secondLargest = arr[i];
			}
		}

		System.out.println("Second Smallest Element : "+ secondSmallest );
		System.out.println("Second Largest Element : "+ secondLargest ); 
		
		System.out.println("************************ way2 **********************************");
		
//		way2:
		
		int arr2[] = { 23, 43, 12, 19, 10, 52, 78, 25, 99, 2 }; // 2 10 12 19 23 25 43 52 78 99
//		int arr2[] = { 2, 10, 12, 19, 23, 25, 43, 52, 78, 99}; 

		int len = arr2.length;
//		System.out.println(Arrays.toString(arr2));

		int min = arr2[0];  // 23 43 12 10 2
		int secondMin = arr2[0];  // 23 43 12 10 2
		
		int max = arr2[0];   // 23
		int secondMax = arr2[0];  // 23

		for (int i = 0; i < len; i++) {   // i=> 4
			if (arr2[i] < min) {
				secondMin = min;
				min = arr2[i];
			} else if (arr2[i] < secondMin) {
				secondMin = arr2[i];
			}

		}

		System.out.println("min :" + min);
		System.out.println("secondMin :" + secondMin);

		for (int i = 0; i < len; i++) {
			if (arr2[i] > max) {
				secondMax = max;
				max = arr2[i];
			} else if (arr2[i] > secondMax) {
				secondMax = arr2[i];
			}

		}

		System.out.println("max :" + max);
		System.out.println("secondMax :" + secondMax);
		
		System.out.println("**************** Using Stream way3 ***************************");

		try {
			Car car = new Car("Maruti", "200", "6Lack");
			Car car2 = new Car("Honda", "300", "12Lack");
			Car car3 = new Car("BMW", "600", "36Lack");
			Car car4 = new Car("Audi", "350", "20Lack");

			Car[] cars = { car, car2, car3, car4 };
			
			Car maxBySpeed = Arrays.stream(cars)
					.max(Comparator.comparing(Car::getCarSpeed))
					.orElseThrow(NoSuchMethodException::new);
			
			System.out.println("MAX CAR SPEED OBJECT IS : " + maxBySpeed.getCarSpeed());

		} catch (Exception e) {
			System.out.println("Exception in way3 : " + e);
		}
		
		System.out.println("**************** Using Stream way4 ***************************");
//      List of number :
		int[] numList= {23, 43, 12, 19, 10, 52, 78, 25, 99, 2};
		
		int maxNum=Arrays.stream(numList).boxed().sorted(Comparator.reverseOrder()).limit(2).skip(1).findFirst().get();
		System.out.println(maxNum);
		
//		List/ArrayList :
		
		List<Integer> arrayList=new ArrayList<>();
		
        		
		
		

	}

}
