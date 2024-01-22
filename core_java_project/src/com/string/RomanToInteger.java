package com.string;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

	public static void main(String[] args) {

		String s = "XL"; // 1904

//		way1 ::
		
		System.out.println(romanToDecimal(s));

//		way2 ::
		
		Map<Character, Integer> translations = new HashMap<Character, Integer>();

		// Adding elements to map
		translations.put('I', 1);
		translations.put('V', 5);
		translations.put('X', 10);
		translations.put('L', 50);
		translations.put('C', 100);
		translations.put('D', 500);
		translations.put('M', 1000);

		s = s.replace("IV", "IIII");
		s = s.replace("IX", "VIIII");
		s = s.replace("XL", "XXXX");
		s = s.replace("XC", "LXXXX");
		s = s.replace("CD", "CCCC");
		s = s.replace("CM", "DCCCC");

		int number = 0;
		for (int i = 0; i < s.length(); i++) {
			number = number + (translations.get(s.charAt(i)));
		}
		System.out.println(number);
	}

	static int romanToDecimal(String str) {

		int res = 0;

		for (int i = 0; i < str.length(); i++) {

			int s1 = value(str.charAt(i));

			if (i + 1 < str.length()) {

				int s2 = value(str.charAt(i + 1));

				if (s1 >= s2) {
					res = res + s1;

				} else {
					res = res + s2 - s1;
					i++;
				}

			} else {
				res = res + s1;
			}
		}

		return res;
	}

	static int value(char r) {

		if (r == 'I') {
			return 1;
		}
		if (r == 'V') {
			return 5;
		}
		if (r == 'X') {
			return 10;
		}
		if (r == 'L') {
			return 50;
		}
		if (r == 'C') {
			return 100;
		}
		if (r == 'D') {
			return 500;
		}
		if (r == 'M') {
			return 1000;
		}
		return -1;
	}

}
