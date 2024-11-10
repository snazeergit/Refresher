package com.java.streams.practice1;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * Print Unique, duplicate elements
 * We are using TreeSet to have natural sorting order for the elements
 */
public class Streams3Copy {

	public static void main(String[] args) {
		List<String> list = List.of("Durian", "Durian", "Banana", "Apple", "Apple", "Carrot");

		approach1(list);

		approach2(list);

		approach3(list);

	}

	private static void approach1(List<String> list) {
		//Approach:1 using Hashset 
		HashSet<String> set = new HashSet<String>();
		//add() method returns true if the element is not available in the Set, if available returns false and will not make any changes to Set
		TreeSet<String> duplicates = list.stream().filter(e -> !set.add(e))
				.collect(Collectors.toCollection(TreeSet::new));
		System.out.println("Unique: " + set);
		System.out.println("Duplicate: " + duplicates);
		TreeSet<String> set3 = list.stream().distinct().collect(Collectors.toCollection(TreeSet::new));
		System.out.println("Distinct : ");
		set3.forEach(System.out::println);
	}

	private static void approach2(List<String> list) {
		//Approach:2 Using Map
		Map<String, Long> map = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		TreeSet<String> set1 = map.entrySet().stream().filter(entry -> entry.getValue() >= 2)
				.map(entry -> entry.getKey()).collect(Collectors.toCollection(TreeSet<String>::new));
		System.out.println("Duplicates : ");
		set1.forEach(System.out::println);
		TreeSet<String> set2 = map.entrySet().stream().filter(entry -> entry.getValue() < 2)
				.map(entry -> entry.getKey()).collect(Collectors.toCollection(TreeSet<String>::new));
		System.out.println("Unique : ");
		set2.forEach(System.out::println);
		TreeSet<String> set3 = list.stream().distinct().collect(Collectors.toCollection(TreeSet::new));
		System.out.println("Distinct : ");
		set3.forEach(System.out::println);
	}

	private static void approach3(List<String> list) {
		//Approach:3 Using Collections.frequency(-,-)
		TreeSet<String> set = list.stream().filter(e -> Collections.frequency(list, e) > 1)
				.collect(Collectors.toCollection(TreeSet::new));
		System.out.println("Duplicates:" + set);

		TreeSet<String> set1 = list.stream().filter(e -> Collections.frequency(list, e) < 2)
				.collect(Collectors.toCollection(TreeSet::new));
		System.out.println("Unique:" + set1);
	}
}
