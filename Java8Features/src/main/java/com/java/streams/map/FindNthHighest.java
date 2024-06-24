package com.java.streams.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

public class FindNthHighest {

	public static void main(String[] args) {
		Map<String, Integer> map1 = new HashMap<>();
		map1.put("John", 1000);
		map1.put("Mike", 1300);
		map1.put("Peter", 1200);
		map1.put("Kevin", 1300);
		map1.put("James", 1200);
		map1.put("Justin", 1300);

		//nth highest salaried employees

		//1. Preparing Map with Salary as Key and Names as Value
		Map<Integer, List<String>> map = map1.entrySet().stream().collect(
				Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));

		//2. Sorting Map with Key and Fetching 2nd highest salaried employee
		LinkedHashMap<Integer, List<String>> map2 = map.entrySet().stream()
				.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey,
						Map.Entry::getValue, (oldVal, newVal) -> oldVal, LinkedHashMap::new));

		Optional<Entry<Integer, List<String>>> optional = map2.entrySet().stream().skip(1).findFirst();

		System.out.println("2nd highest Salries EMployees: " + optional.get());

	}

}
