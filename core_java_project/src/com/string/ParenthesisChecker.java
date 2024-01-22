package com.string;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ParenthesisChecker {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			
			System.out.println("Enter String ::");
			String st = sc.next();

//			if (CheckerClass.ispar(st) == true)
//				System.out.println("balanced");
//			else
//				System.out.println("not balanced");
			
			if (Checker.check(st) == true)
				System.out.println("balanced");
			else
				System.out.println("not balanced");
			
		}
	}
}


class Checker {

	public static boolean check(String str) {

		Stack<Character> stack = new Stack<>();

		if (str.length() % 2 != 0) {
			System.out.println(" :::::: False inside % 2 ::::: ");
			return false;
		}

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '(') {
				stack.push(str.charAt(i));
			} else {
				
				if(stack.isEmpty()==true) {
					System.out.println(" :::::: False insides {tack.isEmpty()==true} ::::: ");
					return false;
				}

				char ch = stack.peek();
				System.out.println(ch);
				stack.pop();
				if ((str.charAt(i) == '}' && ch != '{') || (str.charAt(i) == ']' && ch != '[')|| (str.charAt(i) == ')' && ch != '(')) {
					System.out.println(" :::::: False insides else--> if ::::: ");
					return false;
				}
			}
		}

		if (stack.isEmpty()) {
			return true;
		}

		return false;
	}
}



class CheckerClass {

	static boolean ispar(String x) {
		
	       Stack<Character> s = new Stack<Character>();
	       if(x.length()%2 != 0){
	           return false;
	       }
	       for(int i=0;i<x.length();i++){
	           if((x.charAt(i) == '(')||(x.charAt(i) == '{')||(x.charAt(i) == '[')){
	               s.push(x.charAt(i));
	           }
	           else{
	               if(s.empty()==true){
	                   return false;
	               }
	               char ch = s.peek();
	               s.pop();
	               if((x.charAt(i) == ')' && ch != '(')||(x.charAt(i) == '}' && ch!='{')||(x.charAt(i) == ']' && ch!='[')){
	                   return false;
	               }
	           }
	       }

			if (!s.isEmpty()) {
				return true;
			}
		return false;
	}
}
