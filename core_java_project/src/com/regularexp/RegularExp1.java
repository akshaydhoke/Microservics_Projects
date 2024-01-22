package com.regularexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExp1 {
	public static void main(String[] args) {

		Pattern pattern = Pattern.compile("{", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher("{([])}");

		boolean flag = matcher.find();

		if (flag) {
			System.out.println("Matched");
		} else {
			System.out.println("Not Matched");
		}

	}
}
