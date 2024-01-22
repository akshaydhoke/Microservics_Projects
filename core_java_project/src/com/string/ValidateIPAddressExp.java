package com.string;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateIPAddressExp {
	public static void main(String[] args) {

		String ipString = "222.111.111.00";
		
//		String ipString= "0000.0000.0000.0000";


		int flag = isIPValid(ipString);

		if (flag == 1) {
			System.out.println(" :::: Valid Criteria :::: ");
		} else {
			System.out.println(" :::: Invalid Criteria :::: ");
		}

		String str1 = "172.16.254.1";
		System.out.println("Input: " + str1);
		System.out.println("Output: " + isValidIPAddress(str1));

	}

	private static boolean isValidIPAddress(String ip) {

		/*
		 * // regular expression to validate numbers from 0 to 255
		 * 
		 * zeroTo255 -> (\\d{1, 2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])
		 * 
		 * //regular expression to validate complete IP address
		 * 
		 * IPAddress -> zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." +
		 * zeroTo255;
		 * 
		 *
		   \d denotes the regular expression to represent number from o to 9.
		   \\d{1, 2} represents any 1 or 2 digits number.
		   (0|1)\\d{2} represents a three digit number which is starting from 0 or 1.
		   2[0-4]\\d represents numbers between 200 and 249.
		   25[0-5] represents number between 250 and 255.
		 
		 */

		// regex for digit from 0 to 255.
		
		String zeroTo255 = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";

		String regex = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;

		Pattern p = Pattern.compile(regex);

		if (ip == null) {
			return false;
		}

		Matcher m = p.matcher(ip);
		return m.matches();
	}  
		
	private static int isIPValid(String ipString) {

		int counter = 0;
		int flag = 0;
		String[] ips = ipString.replace(".", " ").split(" ");

		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 256; i++) {
				if (i == Integer.parseInt(ips[j])  && ips[j].length()==3) {
					System.out.println( ">>>>" + ips[j].length());
					if(Arrays.asList("0","1").contains(ips[j])) {
						
					}
					System.err.println(ips[j]);
					counter++;
				}
			}
		}
		

		if (counter == 4) {
			flag = 1;
		}

		return flag;
	}
}
