package com.string;

//https://www.prepbytes.com/blog/java/find-non-repeating-characters-in-a-string-in-java/

public class NonRepratCharExp {
	public static void main(String[] args) {
      
		String string="hello";
		
		char ch=checkNonRepeateChar(string);
		
		FirstNonRepeat2(string);
		
	}

	private static char checkNonRepeateChar(String s) {
        char ch = 0;
	    for (int i = 0; i < s.length(); i++) {
	        if (s.indexOf(s.charAt(i), s.indexOf(s.charAt(i)+1))==-1) {
	          System.out.println("First non-repeating character is "+ s.charAt(i));
	          ch=s.charAt(i);
	          break;
	        }
	      }
		return ch ;
	}
/*
	Brute force approach to find non repeating characters in a string in Java
	Following are steps to follow:

	The idea is to loop through the string for each character.
	Examine the string for the presence of the same character.
	Return that character if the count of its occurrences is one.
	Otherwise, look for the remaining characters.
*/
	public static void FirstNonRepeat2(String s) {
		int index = -1;
		char fnc = ' ';
		for (char i : s.toCharArray()) {
			if (s.indexOf(i) == s.lastIndexOf(i)) {
				fnc = i;
				break;
			} else {
				index += 1;
			}
		}
		if (index == 1) {
			System.out.println("Either all characters are repeating or " + "string is empty");
		} else {
			System.out.println("First non-repeating character is " + fnc);
		}
	}
	
	
	
}
