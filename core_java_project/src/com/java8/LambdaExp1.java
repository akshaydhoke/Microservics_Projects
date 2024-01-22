package com.java8;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;

/*
 Functional Interface ::

 The Lambda expression is used to provide the implementation of an interface which has functional interface.

 https://www.javatpoint.com/java-lambda-expressions
*/

//@FunctionalInterface
interface Single{
	public int add(int a);
}

//@FunctionalInterface
interface multiple{
	public int mul(int a,int b);
}

public class LambdaExp1 {
	public static void main(String[] args) {
		
		Single s1=(a)->a*2;
		System.out.println("Single Parameter :: "+ s1.add(2));
		
//		With return keyword ::

		multiple m1=(int a,int b)->{
			return a*b;
		};
		System.out.println( " Multiple Values :: "+ m1.mul(20, 30));
		
//		without return keyword ::
		
		multiple m2=(a,b)->(a+b);
		System.out.println( " Multiple Values :: "+ m2.mul(20, 30));
		
//		forEach() loop ::
		
		List<String> stringList=Arrays.asList("akshay","prashant","gaurav","girish");
		stringList.forEach(i->System.out.println(i));
		
//		In Thread ::
		
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread1 is created....");
			}
		};
		
		Thread t1=new Thread(r1);
		t1.start();
		
		Runnable r2=()->{
			System.out.println("Thread2 is created....");
		};
		
		Thread t2=new Thread(r2);
		t2.start();
				
//		Filter Collection Data
	
		List<Product> productList=new ArrayList<>();
		productList.add(new Product(10, "Akshay", 100));
		productList.add(new Product(20, "Prashant",300));
		productList.add(new Product(30, "Ajay", 700));
		productList.add(new Product(40, "Kunal", 500));
		productList.add(new Product(50, "Vikas", 400));
		
		Stream<Product> list=productList.stream().filter(p->p.price>300);
		
		list.forEach(
		 Product-> System.out.println("PRODUCT PRICE AND NAME :: "+ Product.name +":"+ Product.price)
	    );
		
	}
}

class Product {
	int id;
	String name;
	float price;

	public Product(int id, String name, float price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
}  


