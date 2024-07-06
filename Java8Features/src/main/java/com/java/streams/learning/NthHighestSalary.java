package com.java.streams.learning;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class NthHighestSalary {

	public static void main(String[] args) {

		Map<String, Integer> map1 = new HashMap<>();
		map1.put("John", 1000);
		map1.put("Mike", 1300);
		map1.put("Peter", 1200);
		map1.put("Kevin", 1300);
		map1.put("James", 1200);
		map1.put("Justin", 1300);

		System.out.println(map1);

		//Creating a Map with Salary as key and list of employee names as values
		Map<Integer, List<String>> map2 = map1.entrySet().stream().collect(
				Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
		System.out.println(map2);

		//Sorting the Map using values in Descending order
		LinkedHashMap<Integer, List<String>> map3 = map2.entrySet().stream()
				.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey,
						Map.Entry::getValue, (oldVal, newVal) -> oldVal, LinkedHashMap::new));
		System.out.println(map3);
		//Skipping the first element to fetch secoind highest element
		Entry<Integer, List<String>> entry = map3.entrySet().stream().skip(1).findFirst().get();
		System.out.println(entry);

	}

}
