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
		Map<String, Integer> map1 = new HashMap<>();
		map1.put("John", 1000);
		map1.put("Mike", 1300);
		map1.put("Peter", 1200);
		map1.put("Kevin", 1300);
		map1.put("James", 1200);
		map1.put("Justin", 1300);

		Entry<Integer, List<String>> entry = map1.entrySet().stream()
				.collect(Collectors.groupingBy(Map.Entry::getValue,
						Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
				.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).collect(Collectors
						.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldVal, newVal) -> oldVal, LinkedHashMap::new))
				.entrySet().stream().skip(1).findFirst().get();

		System.out.println(entry);

	}

}
