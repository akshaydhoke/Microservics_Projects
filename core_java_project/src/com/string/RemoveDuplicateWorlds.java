package com.string;

// https://javarevisited.blogspot.com/2015/07/how-to-find-duplicate-words-in-string-java.html#axzz8EfqcqEJf
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicateWorlds {
	public static void main(String[] args) {

		String str = "java developer dev java";
		removeDuplicateWords(str);

		String str2 = "Akshays";
		removeDuplicateCharactors(str2);

	}

	private static void removeDuplicateWords(String string) {

		String[] words = string.split("\\s");

		Set<String> set = new HashSet<>();
		List<String> list = new ArrayList<>();

		for (String word : words) {
			if (!set.add(word)) {
				list.add(word);
			}
		}

		System.out.println(list);
	}

	private static void removeDuplicateCharactors(String string) {
		char[] strArr = string.toCharArray();

		Set<Character> set = new HashSet<>();
		List<Character> list = new ArrayList<>();

		for (char ch : strArr) {
			if (!set.add(ch)) {
				list.add(ch);
			}
		}

		System.out.println(list);
	}

}
