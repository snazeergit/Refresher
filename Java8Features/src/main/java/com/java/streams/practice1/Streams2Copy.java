package com.java.streams.practice1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Streams2Copy {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("John", 1000);
		map.put("Mike", 1300);
		map.put("Peter", 1200);
		map.put("Kevin", 1300);
		map.put("James", 1200);
		map.put("Justin", 1300);

		//nth highest salaried employees
		//	Map<Integer, String> map2 = map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
		//	Exception in thread "main" java.lang.IllegalStateException: Duplicate key 1300 (attempted merging values Kevin and Mike)

		Map<Integer, List<String>> map2 = map.entrySet().stream().collect(
				Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
		System.out.println(map2);

		LinkedHashMap<Integer, List<String>> map3 = map2.entrySet().stream()
				.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey,
						Map.Entry::getValue, (newK, newV) -> newK, LinkedHashMap::new));
		System.out.println(map3);

		Entry<Integer, List<String>> entry = map3.entrySet().stream().skip(1).findFirst().get();

		System.out.println("Second Highest salary: " + entry.getKey());
		entry.getValue().forEach(System.out::println);
	}

}
