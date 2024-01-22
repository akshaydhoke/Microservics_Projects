package com.string;

public class StringRotation2places {

	public static void main(String[] args) {

		String str1 = "geeks";
		String str2 = "eksge";

		System.out.println(isRotated(str1, str2) ? "Yes" : "No");

	}

	static boolean isRotated1(String str_1, String str_2) {

		String str1 = str_1.replaceAll("\\s", "");
		String str2 = str_2.replaceAll("\\s", "");

		if (str1.length() != str2.length()) {
			return false;
		}

		int str2Len = str2.length();

		String clockwiseStr = "";
		String antiClockwiseStr = "";

		clockwiseStr = str2.substring(2) + str2.substring(0, 2);

		antiClockwiseStr = str2.substring(str2Len - 2, str2Len) + str2.substring(0, str2Len - 2);

		if (clockwiseStr.equals(str1) || antiClockwiseStr.equals(str1)) {
			return true;
		}

		System.out.println(clockwiseStr);
		System.out.println(antiClockwiseStr);

		return false;
	}
	
//	For clockwise – str1[i] == str2[(i + 2) % n]
//    For anticlockwise – str1[(i + 2) % n] == str2[i]
	
	static boolean isRotated(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();
		if (n != m) // check both the string length equal or not
			return false;
		boolean clockwise = true;
		boolean anticlockwise = true;
		// check clockwise rotation is possible or not
		for (int i = 0; i < n; i++) {
			System.out.println(str1.charAt(i) + " : "+ str2.charAt(i+2)%str1.length());
			if (str1.charAt(i) != str2.charAt((i + 2) % n)) {
				clockwise = false;
				break;
			}
		}
		// check anticlockwise rotation is possible or not
		for (int i = 0; i < m; i++) {
			if (str1.charAt((i + 2) % n) != str2.charAt(i)) {
				anticlockwise = false;
				break;
			}
		}
		return (clockwise || anticlockwise);
	}
	
    		
    		
}
