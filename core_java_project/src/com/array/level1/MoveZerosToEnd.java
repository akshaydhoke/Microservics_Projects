package com.array.level1;

import java.util.Arrays;

public class MoveZerosToEnd {

	public static void main(String[] args) {

		int[] nums = { 12, 0, 7, 0, 8, 0, 3 };

		int counter = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[counter] = nums[i];
				counter++;
			}
		}
		while (counter < nums.length) {
			nums[counter] = 0;
			counter++;
		}

		System.out.println(Arrays.toString(nums));
	}

}
