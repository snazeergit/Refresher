package com.nt.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class Map_Collection {

	public static void main(String[] args) {
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		map1.put("Sita", 20);
		map1.put("Rama", 40);
		map1.put("Gopi", 10);
		map1.put("Giri", 30);
		Set<Entry<String, Integer>> set = map1.entrySet();
		System.out.println(set);

		
		//MAP sorting is not working
		Map<String, Integer> map = map1.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors
				.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldVal, newVal) -> oldVal, LinkedHashMap::new));
		System.out.println(map);

		Map<Object, Object> map4 = map1.entrySet().stream()
				.collect(Collectors.toMap(k -> (String) k.getKey(), v -> (Integer) v.getValue())).entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, n) -> o, LinkedHashMap::new));
		System.out.println(map4);
	}

}
