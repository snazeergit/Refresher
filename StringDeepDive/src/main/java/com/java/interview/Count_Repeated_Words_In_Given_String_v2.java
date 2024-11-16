package com.java.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Count_Repeated_Words_In_Given_String_v2 {

	public static void main(String[] args) {
		String str = "This is 		a test  sentence 	and this test   IS just a TEST";
		String[] words = str.toLowerCase().split("\\s+");
		List<String> list = new ArrayList<String>();
		for (String word : words) {
			list.add(word);
		}
		System.out.println(list);
		Map<String, Long> map = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map);
		System.out.println("Repeated words:");

		//Without method reference
		map.entrySet().stream().filter(entry -> entry.getValue() > 1).collect(Collectors.toList())
				.forEach(System.out::println);

		//With method reference by creating a custom method
		map.entrySet().stream().filter(Count_Repeated_Words_In_Given_String_v2::checkValueGreaterThanOne)
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
