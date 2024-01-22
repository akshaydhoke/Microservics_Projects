package com.regex;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// https://java.scjp.jobs4times.com/regexp.htm

public class RegularExpressionExp1 {

	public static void main(String[] args) {

		System.out.println("---------- Exp1 -----------");
		// Normal Code :
		int count = 0;
		Pattern p = Pattern.compile("ab");
		Matcher m = p.matcher("abbbbabbbbab");

		while (m.find()) {
			count++;
			System.out.println(m.start() + "--- " + m.end() + "---> " + m.group());
		}

		System.out.println("---------- Exp2 -----------");

		// Multiple Pattern :
		// String str = "[abc]";
		// String str = "[^abc]";
		// String str = "[a-z]";
		// String str = "[0-9]";
		String str = "[a-z0-9]";
		Pattern p2 = Pattern.compile(str);
		Matcher m2 = p2.matcher("a1b7@z#");

		while (m2.find()) {
			System.out.println(m2.start() + "--- " + m2.end() + "---> " + m2.group());
		}

		System.out.println("---------- Exp3 -----------");

		// String str2 = "\\s";
		// String str2 = "\\d";
		// String str2 = "\\w";
		// String str2 = ".";
		// String str2 = "\\D";
		String str2 = "\\W";

		Pattern p3 = Pattern.compile(str2);
		Matcher m3 = p3.matcher("a1b7 @z#");

		while (m3.find()) {
			System.out.println(m3.start() + "--- " + m3.end() + "---> " + m3.group());
		}

		System.out.println("---------- Exp4 -----------");

		// Quantifiers:

		// String str3 = "a";
		// String str3 = "a+";
		// String str3 = "a*";
		String str3 = "a?";

		Pattern p4 = Pattern.compile(str3);
		Matcher m4 = p4.matcher("abaabaaab");

		while (m4.find()) {
			System.out.println(m4.start() + "---> " + m4.group());
		}

		System.out.println("---------- Exp5 -----------");

		// Pattern split() method :

		Pattern p5 = Pattern.compile("[.]"); // [.]
		String[] strs = p5.split("akshay.dhoke");
		for (String s : strs) {
			System.out.println(s);
		}

		System.out.println("---------- Exp6 -----------");
		// String Tokenizer :

		StringTokenizer tokenizer = new StringTokenizer("akshay.dhoke","[.]");
		while (tokenizer.hasMoreElements()) {
			System.out.println(tokenizer.nextElement());
		}

	}

}
