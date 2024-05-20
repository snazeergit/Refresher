package com.java.streams.learning;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LinearStringStreamDemo {

	static List<String> list = Arrays.asList("Nazeer", "Abhi", "Chandan", "Dilshad", "Badri", "Abhi", "Tanu", "Ramu",
			"Ramu", "Tanu", "Chandan", "Eswar", "Eswar");

	public static void main(String[] args) {

		System.out.println("Input:			" + list);

		//1. Sorting Ascending
		List<String> list2 = list.stream().sorted().collect(Collectors.toList());
		System.out.println("Natural order:		" + list2);

		//1.1 Sorting Ascending -No duplicates
		Collection<String> set = list.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
		System.out.println("natural order- distinct:" + set);

		//2. Soring Descending
		List<String> list3 = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println("Reverse Order:		" + list3);

		//2.1 Soring Descending- No Duplicates
		Collection<String> set2 = list.stream().sorted(Comparator.reverseOrder())
				.collect(Collectors.toCollection(LinkedHashSet::new));
		System.out.println("Reverse order-distinct:	" + set2);

		//3. Thrird highest
		String integer = list.stream().sorted(Comparator.reverseOrder()).distinct().skip(2).findFirst().get();
		System.out.println("Third highest:	" + integer);

		//4. Second lowest
		String integer2 = list.stream().sorted().distinct().skip(1).findFirst().get();
		System.out.println("Second lowest:	" + integer2);

		//5 Deplicate elements as KEYs and no .of time repeated as VLaues
		Map<String, Long> map2 = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("Map<Keys, Ripitation>:	" + map2);

		//5.1 Duplicate elements in the list
		Map<String, Long> map = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		List<String> list5 = map.entrySet().stream().filter(s -> s.getValue() > 1).map(s -> s.getKey())
				.collect(Collectors.toList());
		System.out.println("Duplicate elements:	" + list5);

		//5.2 Duplicate elements in the list - sorting order
		List<String> list6 = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().filter(s -> s.getValue() > 1).map(s -> s.getKey())
				.sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println("Duplicate in sorted:	" + list6);

		//6. Unique Elemets but not distinct elements
		List<String> list7 = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().filter(s -> s.getValue() == 1).map(s -> s.getKey()).collect(Collectors.toList());
		System.out.println("Unique elemnts: 	" + list7);

		//7. Distinct Elements
		List<String> list4 = list.stream().distinct().collect(Collectors.toList());
		System.out.println("Distinct Elemets:	" + list4);
		//7. Distinct Elements- sorted
		List<String> list8 = list.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println("Distinct -Sorted:	" + list8);
	}

}
