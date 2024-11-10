package com.java.streams.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class FindNthHighest {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("John", 1000);
		map.put("Mike", 1300);
		map.put("Peter", 1200);
		map.put("Kevin", 1300);
		map.put("James", 1200);
		map.put("Justin", 1300);

		//nth highest salaried employees

		//arrange salary as key and emp_names as values in a Map
		Map<Integer, List<String>> map1 = map.entrySet().stream().collect(
				Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));

		//sort(Descending) the map using salary(Key)
		LinkedHashMap<Integer, List<String>> map2 = map1.entrySet().stream()
				.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey,
						Map.Entry::getValue, (oldVal, newVal) -> oldVal, LinkedHashMap::new));

		//skip N elements and findFirst will return the Nth highest salaried emp
		Entry<Integer, List<String>> entry = map2.entrySet().stream().skip(1).findFirst().get();
		System.out.println(entry);
	}

}
