package com.java8.coding;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student implements Comparable<Student> {

	Integer Id;
	String name;

	public Student(Integer id) {
		super();
		Id = id;
	}

	public Student(Integer id, String name) {
		super();
		Id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [Id=" + Id + ", name=" + name + "]";
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Student o) {
		return this.Id.compareTo(o.Id);
	}
}

public class HashSetSortedKeyValuesExp {

	public static void main(String[] args) {

		LinkedHashMap<Student, Integer> mapList = new LinkedHashMap<>();
		mapList.put(new Student(3, "Dinesh"), 300);
		mapList.put(new Student(1, "Akshay"), 100);
		mapList.put(new Student(4, "Bhushan"), 400);
		mapList.put(new Student(2, "Rakesh"), 200);

		TreeMap<Student, Integer> setList = new TreeMap<>(mapList);

//		System.out.println(setList);
		
		
	}
}
