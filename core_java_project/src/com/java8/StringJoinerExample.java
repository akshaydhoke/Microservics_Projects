package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringJoinerExample {
	public static void main(String[] args) {
		
//		StringJoiner String1
		
		StringJoiner strJoiner= new StringJoiner(",","[","]");
		strJoiner.add("Akshay");
		strJoiner.add("Dhoke");
		
		System.out.println(strJoiner);
		
//		StringJoiner String2
		
		StringJoiner stringJoiner2=new StringJoiner(":");
		stringJoiner2.add("Software");
		stringJoiner2.add("Developer");
		System.out.println(stringJoiner2);
		
//		StringJoiner merge() method uses::
		
		StringJoiner strMergeString= strJoiner.merge(stringJoiner2);
		System.out.println("Merge String  ::"+"\n"+ strMergeString);
		
//		Set default String as specific String value ::
		
		StringJoiner strJoiner3=new StringJoiner(",");
		strJoiner3.setEmptyValue("This String is Empty by default");
		System.out.println(strJoiner3);
		
//		Using Stream API ::
		
		List<String> listOfStrings=Arrays.asList("Akshay","Dhoke","JavaDeveloper");
		String strList= listOfStrings.stream().collect(Collectors.joining("::","{","}"));
		System.out.println(strList);
		
		System.out.println("****************************************************");

		Stream<Integer> stream=Stream.iterate(40, n -> n+2).limit(1);
//		stream.forEach(System.out::println);
		
	}
}
