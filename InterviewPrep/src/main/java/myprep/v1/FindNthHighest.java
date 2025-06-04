package myprep.v1;

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
		map.put("Kevin", 1100);
		map.put("James", 1200);
		map.put("Justin", 1300);

		//Way-1
		Integer secondHighestSal = map.entrySet().stream().map(e -> e.getValue()).sorted(Comparator.reverseOrder())
				.distinct().skip(1).findFirst().get();
		List<String> list = map.entrySet().stream().filter(e -> e.getValue().equals(secondHighestSal))
				.map(e -> e.getKey()).collect(Collectors.toList());
		System.out.println(list);
		System.out.println(secondHighestSal);
		
		System.out.println("---------------");

		//Way-2
		//Arrange the map with salary as a key and list of names as value
		Map<Integer, List<String>> map1 = map.entrySet().stream().collect(
				Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
		System.out.println(map1);

		//Sorting the Map in descending order
		LinkedHashMap<Integer, List<String>> map2 = map1.entrySet().stream()
				.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey,
						Map.Entry::getValue, (oldVal, newVal) -> oldVal, LinkedHashMap::new));
		System.out.println(map2);

		//finding the 2nd highest
		Entry<Integer, List<String>> entry = map2.entrySet().stream().skip(1).findFirst().get();
		System.out.println(entry);
	}

}
