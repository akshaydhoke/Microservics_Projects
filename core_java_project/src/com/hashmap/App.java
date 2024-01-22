package com.hashmap;

import java.util.HashSet;

public class App {

	public static void main(String[] args) {

//		Possibility1 : doesn't have duplicates 
		HashSet<Integer> intSet=new HashSet<>();
		intSet.add(10);
		intSet.add(20);
		intSet.add(30);
		intSet.add(40);
		System.out.println(intSet);
		System.out.println(intSet.add(40));
		System.out.println(intSet);
		
		System.out.println("-------------------------");

//		Possibility2 : set allows duplicates of identical Objs
//		Note : If we override equals and hashcode method in Person then duplicate entry insertion is avoids.
		
		HashSet<Person> personSet=new HashSet<>();
		personSet.add(new Person(101, "Akshay"));
		personSet.add(new Person(102, "Shubham"));
		personSet.add(new Person(103, "Ajay"));
		System.out.println(personSet);
		System.out.println(personSet.add(new Person(101, "Akshay")));
		System.out.println(personSet);
		
		System.out.println("********************************");
		
//		Possibility3 : having same hashCode values: 
		
		HashSet<String> set1 = new HashSet<>();
		System.out.println(set1.add(new String("Akshay")));
		System.out.println(set1.hashCode());
		
		
		

		
		
		
		
	}

}
