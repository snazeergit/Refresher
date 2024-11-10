package com.java.streams.learning;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateElements {

	static String s = "NAZEER";

	public static void main(String[] args) {
		approach1();

		//approach2();

	}

	private static void approach2() {
		char[] charArray = s.toCharArray();
		List<Character> list2 = new ArrayList();
		for (char c : charArray) {
			list2.add(c);
		}
		System.out.println(list2);
		HashSet<Character> set = new HashSet<Character>();
		List<Character> list = list2.stream().filter(n -> !set.add(n)).collect(Collectors.toList());
		System.out.println(list);
	}

	private static void approach1() {

		char[] charArray = s.toCharArray();
		List<Character> list = new ArrayList<Character>();
		for (int i = 0; i < charArray.length; i++) {
			list.add(charArray[i]);
		}
		System.out.println(list);

		Map<Character, Long> map = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map);
		List<Character> list2 = map.entrySet().stream().filter(m -> m.getValue() == 1).map(m -> m.getKey())
				.collect(Collectors.toList());
		System.out.println(list2);
	}
}
