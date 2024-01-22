package com.string;
//https://www.geeksforgeeks.org/reverse-words-given-string-java/
import java.util.regex.Pattern;

/* Input:
S = i.like.this.program.very.much
Output: much.very.program.this.like.i */

public class ReverseWorldExp {
	public static void main(String[] args) {

		String string = "I like this program very much";
		String reverseString = "";

		String[] worlds = string.split("\\s");

		for (int i = 0; i < worlds.length; i++) {
			if (i == worlds.length - 1) {
				reverseString = worlds[i] + reverseString;
			} else {
				reverseString = " " + worlds[i] + reverseString;
			}
		}

		System.out.println(reverseString);

		// System.out.println(reverseWords(string));

	}
	
    static String reverseWords(String str)
    {
        String[] temp = str.split("\\s");
        String result = "";
 
        // Iterate over the temp array and store
        // the string in reverse order.
        for (int i = 0; i < temp.length; i++) {
            if (i == temp.length - 1)
                result = temp[i] + result;
            else
                result = " " + temp[i] + result;
        }
        return result;
    }
}
