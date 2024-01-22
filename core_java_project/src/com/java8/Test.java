package com.java8;

import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Student7 implements Comparable<Student7> {

	int id;
	String name;
	double marks;

	public Student7(int id, String name, double marks) {
		this.id = id;
		this.name = name;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", marks=" + marks + "]";
	}

	@Override
	public int compareTo(Student7 o) {
		return this.id - o.id;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getMarks() {
		return marks;
	}
}

public class Test {
	public static void main(String[] args) {

		HashMap<Integer, Student7> map = new HashMap<>();
		map.put(1, new Student7(3, "Akshay", 98));
		map.put(2, new Student7(1, "Soham", 77));
		map.put(3, new Student7(2, "Jay", 67));
		map.put(4, new Student7(4, "Bhushan", 56));
		
		TreeMap<Integer, Student7> treeMap=new TreeMap<>(map);
				
		for(Entry<Integer, Student7> e : map.entrySet()) {
			System.out.println( e.getKey()+ " : "+ e.getValue());
		}
		
		
		

	}
}
