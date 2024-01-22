package com.string;

/*
Input:
s = Geeks
Output: skeeG
*/

public class ReverseStringExp {
	public static void main(String[] args) {

		String str="Akshay";
		String revString="";
		
//		way1 : 
		System.out.println("============ way1 ============");
		
//		for(int i=0;i<str.length();i++) {
//			char ch=str.charAt(i);
//			revString=ch+revString;
//		}
//		System.out.println(revString);
		
		System.out.println("============= way2 ===========");
		
		for(int i=str.length()-1;i>=0;i--){
			revString+= str.charAt(i);
		}
		
		System.out.println(revString);
	}
}
