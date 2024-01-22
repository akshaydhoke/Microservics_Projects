package com.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

// First learn >> 
//https://roytuts.com/java-supplier-consumer/

// Then >>

// https://www.geeksforgeeks.org/supplier-interface-in-java-with-examples/
// https://www.geeksforgeeks.org/java-8-consumer-interface-in-java-with-examples/
public class SuplierConsumerExp {
	public static void main(String[] args) {
		
//  supplier exp : T get()
		System.out.println("------------- supplier---------------");
	
		Supplier<Integer> intValue = ()-> 100;
		System.out.println("int value : "+ intValue.get());
		
		Supplier<Double> randomValue=()->Math.random();
		System.out.println("random value  : "+ randomValue.get());
		
		Supplier<String> strValue= ()-> "Akshay";
		System.out.println("String value : "+ strValue.get());
		
//		Consumer exp : void accept(T t)
		System.out.println("------------- consumer program 1 ---------------");
		
//	    program 1: 
		
		List<Integer> list=new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		System.out.print("Print Integer values : ");
		Consumer<Integer> intValueDisplay = element-> System.out.println(" "+ element);
		intValueDisplay.accept(97);
		
		System.out.print("Print normal list : ");
		Consumer<List<Integer>> listDisplay = list2 -> list2.stream().forEach(element -> System.out.print(" "+ element));                          
		listDisplay.accept(list);
		
//		operations on list:
		
		System.out.println();
		System.out.print("Print modified List : ");
		Consumer<List<Integer>> listIterate=list4-> list4.forEach(e -> System.out.print(" "+ e));
		
		Consumer<List<Integer>> listModified = list3->{
			for(int i=0;i<=list3.size();i++){
				list3.set(i, 2*list3.get(i) );
			}
		};
		
//		accept() method only >>
//		listModified.accept(list);
//		listIterate.accept(list);
		
//	    andThen() method using >> 
//		listModified.andThen(listIterate).accept(list);

		System.out.println();
		System.out.println("------------- consumer program 2 ---------------");
//		Program 2: To demonstrate when NullPointerException is returned.
//		Program 3: To demonstrate how an Exception in the after function is returned and handled.
		
		try {
//		progarm2: 
//			listIterate.andThen(null).accept(list);
			
//	    progarm3:  java.lang.IndexOutOfBoundsException: Index: 3, Size: 3
			listModified.andThen(listIterate).accept(list);

		} catch (Exception e) {
			e.printStackTrace();
		}

		

	}

}
