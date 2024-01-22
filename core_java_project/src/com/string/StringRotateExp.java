package com.string;

public class StringRotateExp {
	
	public static void main(String[] args) {
		
		String original="IndiaVsEngland";
		String rotate="EnglandIndiaVs";
	}
	
	public static boolean checkRotatation(String original, String rotation) {
		if (original.length() != rotation.length()) {
			return false;
		}
		String concatenated = original + original;
		if (concatenated.indexOf(rotation) != -1) {
			return true;
		}
		return false;
	}

}
