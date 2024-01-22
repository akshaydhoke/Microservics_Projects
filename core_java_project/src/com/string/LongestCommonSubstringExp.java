package com.string;

public class LongestCommonSubstringExp {

	public static void main(String[] args) {

		String s1 = "Akshay";
		String s2 = "AssksrrhayDhoke";

		int m = s1.length();
		int n = s2.length();

		int result = 0;

		char[] x = s1.toCharArray();
		char[] y = s2.toCharArray();

		int[][] init = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {

				if (i == 0 || j == 0) {
					init[i][j] = 0;
				} else if (x[i - 1] == y[j - 1]) {
					init[i][j] = init[i - 1][j - 1] + 1;
					result = Integer.max(result, init[i][j]);
				} else {
					init[i][j] = 0;
				}
			}
		}

		System.out.println(" Result :" + result);
	}
	
	public static String findLCS(String str1, String str2) {
	    int longest = 0;
	    String longestSubstring = "";

	    for (int i=0; i < str1.length(); ++i) {
	        for (int j=i+1; j <= str1.length(); ++j) {
	            String substring = str1.substring(i, j);
	            if (str2.contains(substring) && substring.length() > longest) {
	                longest = substring.length();
	                longestSubstring = substring;
	            }
	        }
	    }

	    return longestSubstring;
	}
}
