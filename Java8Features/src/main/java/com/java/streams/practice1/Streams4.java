package com.java.streams.practice1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Streams4 {

	public static void main(String[] args) {
		String str = "nazeer";
		char[] charArray = str.toCharArray();
		ArrayList<Character> list = new ArrayList<Character>();
		for (char c : charArray) {
			list.add(c);
		}
		System.out.println("Given String : " + list);

		//Approach-1
		Map<Character, Long> map = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("After converting to Map : " + map);
		List<Character> uniqueList = map.entrySet().stream().filter(m -> m.getValue() < 2).map(m -> m.getKey())
				.collect(Collectors.toList());
		System.out.println("Unique elements : " + uniqueList);
		List<Character> distinctList = map.entrySet().stream().distinct().map(m -> m.getKey())
				.collect(Collectors.toList());
		System.out.println("Distinct elements : " + distinctList);
		List<Character> duplicateList = map.entrySet().stream().filter(m -> m.getValue() > 1).map(m -> m.getKey())
				.collect(Collectors.toList());
		System.out.println("Duplicate elements : " + duplicateList);

		//Approach-2
		HashSet<Character> unique = new HashSet<Character>();
		Set<Character> duplicateElements = list.stream().filter(e -> !unique.add(e)).collect(Collectors.toSet());
		List<Character> distinctElements = list.stream().distinct().collect(Collectors.toList());
		System.out.println("Unique: " + unique);
		System.out.println("Duplicate: " + duplicateElements);
		System.out.println("Distinct: " + distinctElements);

		//Approach-3
		StringBuilder sb = new StringBuilder();
		str.chars().distinct().forEach(c -> sb.append((char) c));
		System.out.println("Result :" + sb);
	}
}