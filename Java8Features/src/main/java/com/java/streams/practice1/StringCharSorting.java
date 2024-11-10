package com.java.streams.practice1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * Arrange the characters in Ascending order based on repitition 
 * If the two characters are repetitions are same then first come first fit based. 
 * Below BB and EE are repeated twice since EE occurrs first in string it should occupie first place.
 */
public class StringCharSorting {

	public static void main(String[] args) {
		String str = "AAAAAEECCCCDBB";
		//Output: DEEBBCCCCAAAAA 

		List<Character> list = new ArrayList<Character>();
		for (char ch : str.toCharArray()) {
			list.add(ch);
		}
		System.out.println("New char [] :" + list);

		// Step 1: Count occurrences and preserve the order of first appearance
		Map<Character, Long> map1 = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		System.out.println(map1);

		// Step 2: Sort by frequency and first occurrence in input string
		List<Entry<Character, Long>> list2 = map1.entrySet().stream()
				.sorted(Comparator.comparing((Map.Entry<Character, Long> entry) -> entry.getValue())  // Sort by frequency
						.thenComparing(entry -> str.indexOf(entry.getKey())))  // If frequency is the same, by first appearance
				.collect(Collectors.toList());
		System.out.println(list2);

		// Step 3: Build the result string based on sorted entries
		StringBuilder result = new StringBuilder();
		for (Entry<Character, Long> entry : list2) {
			result.append(String.valueOf(entry.getKey()).repeat(entry.getValue().intValue()));
		}
		System.out.println(result);

	}
}
