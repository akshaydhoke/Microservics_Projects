package com.sample.examples;

import java.util.HashSet;
import java.util.Set;

public class BlockExecutionExp2 {

	public static void main(String[] args) {

		Set<String> sets = new HashSet<String>() {
			{
				add("one");
				add("two");
				add("three");
			}

		};

		System.out.println(sets);

	}

}
