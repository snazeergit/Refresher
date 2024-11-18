package com.vmware.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Count_Repeated_Words_In_Given_String_v4 {

	public static void main(String[] args) {
		String str = "This is 		a test  sentence 	and this test   IS just a TEST";
		String[] words = str.toLowerCase().split("\\s+");

		approch1(words);

		approch2(words);

		approch3(words);
	}

	//approch1
	private static void approch1(String[] words) {
		System.out.println("-------approch1------");
		List<String> list = new ArrayList<String>(Arrays.asList(words));
		list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(entry -> entry.getValue() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
				.forEach((k, v) -> {
					System.out.println(k + " -> has repeated " + v + " times");
				});
	}

	//approch2
	private static void approch2(String[] words) {
		System.out.println("-------approch2------");
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		//using streams
		map.entrySet().stream().filter(entry -> entry.getValue() > 1)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)).forEach((k, v) -> {
					System.out.println(k + " -> has repeated " + v + " times");
				});
		System.out.println("          ------          ");
		//using core
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			Integer repetitions = entry.getValue();
			if (repetitions > 1) {
				System.out.println(entry.getKey() + " -> has repeated" + repetitions + " times");
			}
		}
	}

	//approch3
	private static void approch3(String[] words) {
		System.out.println("-------approch3------");
		List<String> list = new ArrayList<String>(Arrays.asList(words));
		Map<String, Long> map = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		//Without method reference
		map.entrySet().stream().filter(entry -> entry.getValue() > 1).collect(Collectors.toList())
				.forEach(System.out::println);
		System.out.println("          ------          ");

		//With method reference by creating a custom method
		map.entrySet().stream().filter(Count_Repeated_Words_In_Given_String_v4::checkValueGreaterThanOne)
				.collect(Collectors.toList()).forEach(System.out::println);
	}

	/*
	 * If you find yourself frequently using this condition, you could create a
	 * utility method Then, you could replace the lambda with a method reference as
	 * shown above.
	 */
	private static boolean checkValueGreaterThanOne(Map.Entry<String, Long> entry) {
		return entry.getValue() > 1;
	}

}
