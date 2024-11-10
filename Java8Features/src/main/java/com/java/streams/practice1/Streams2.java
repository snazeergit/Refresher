package com.java.streams.practice1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Streams2 {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("John", 1000);
		map.put("Mike", 1300);
		map.put("Peter", 1200);
		map.put("Kevin", 1300);
		map.put("James", 1200);
		map.put("Justin", 1300);

		//nth highest salaried employees

		//1. Create salary wise emps
		Map<Integer, List<String>> map1 = map.entrySet().stream().collect(
				Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
		System.out.println(map1);

		//2. Sort them based on the salary
		LinkedHashMap<Integer, List<String>> map2 = map1.entrySet().stream()
				.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey,
						Map.Entry::getValue, (oldK, oldV) -> oldK, LinkedHashMap::new));
		System.out.println(map2);

		//3. Find 2nd highest salaried Emp
		Entry<Integer, List<String>> entry = map2.entrySet().stream().skip(1).findFirst().get();
		System.out.println(entry.getKey() + " : " + entry.getValue());
	}

}
