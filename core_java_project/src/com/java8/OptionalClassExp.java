package com.java8;

import java.util.Optional;

public class OptionalClassExp {
	public static void main(String[] args) {

//	Optional class used for handle NullPointerException in runtime ::

//	Throwing NullPonter Exception ::

		String[] str = new String[10];

//	String lowerCaseString=str[5].toLowerCase();
//	System.out.println(lowerCaseString);

//	Handle NullPointerException ::

		Optional<String> lowerString = Optional.ofNullable(str[5]);
		if (lowerString.isPresent()) {
			String lowerCaseString = str[5].toLowerCase();
			System.out.println(lowerCaseString);
		} else {
            System.out.println("String value is Null");
		}
		
		System.out.println("----------------------------------------------------------");
		
//		If the value is present ::
		
		str[5]="Akshay Dhoke :- Software Developer";
		Optional<String> lwrString = Optional.ofNullable(str[5]);
		if (lwrString.isPresent()) {
			String lowerCaseString = str[5].toLowerCase();
			System.out.println(lowerCaseString);
		} else {
            System.out.println("String value is Null");
		}
		
		System.out.println("----------------------------------------------------------");
		
//		Printing values in various ways ::
		
		lwrString.ifPresent(System.out::println);
		System.out.println(lwrString.get());
		System.out.println(str[5].toLowerCase());
		
		System.out.println("----------------------------------------------------------");

//	    Java Optional Methods Example ::
		
		String[] str1=new String[12];
		str1[6]="Hello Akshay";
		
//		filter() method :-
		
		Optional<String> strValue=Optional.ofNullable(str1[6]);
		
		System.out.println(strValue.filter(s->s.equals("Hello Akshay")));
		
//		orElse() method:-
		
		Optional<String> strValue1=Optional.ofNullable(str1[2]);
        System.out.println(strValue1.orElse("------- String is Null ------"));		
        
        

	}
}
