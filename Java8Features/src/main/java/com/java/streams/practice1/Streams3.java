package com.java.streams.practice1;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
	We are using TreeSet to have natural sorting order for the elements
*/
public class Streams3 {

	public static void main(String[] args) {
		List<String> list = List.of("Durian", "Durian", "Banana", "Apple", "Apple", "Carrot");

		//Approach:1 using Hashset
		TreeSet<String> unique = new TreeSet<String>();
		Set<String> duplicate = list.stream().filter(name -> !unique.add(name))
				.collect(Collectors.toCollection(TreeSet::new));
		System.out.println("Duplicates: " + duplicate);
		System.out.println("Unique: " + unique);

		//Approach:2 Using Map
		Map<String, Long> map = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		TreeSet<String> duplicate1 = map.entrySet().stream().filter(m -> m.getValue() > 1).map(m -> m.getKey())
				.collect(Collectors.toCollection(TreeSet::new));
		TreeSet<String> unique1 = map.entrySet().stream().filter(m -> m.getValue() < 2).map(m -> m.getKey())
				.collect(Collectors.toCollection(TreeSet::new));
		TreeSet<String> distinct = map.entrySet().stream().map(m -> m.getKey()).distinct()
				.collect(Collectors.toCollection(TreeSet::new));
		System.out.println("Duplicates: " + duplicate1);
		System.out.println("Unique: " + unique1);
		System.out.println("Distinct: " + distinct);

		//Approach:3 Using Collections.frequency(-,-)
		List<String> duplicate2 = list.stream().filter(name -> Collections.frequency(list, name) > 1)
				.collect(Collectors.toList());
		System.out.println("Duplicates: " + duplicate2);
	}

}
