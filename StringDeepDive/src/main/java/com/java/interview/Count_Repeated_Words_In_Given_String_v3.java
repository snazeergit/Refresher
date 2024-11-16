package com.java.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Count_Repeated_Words_In_Given_String_v3 {

	public static void main(String[] args) {
		String str = "This is 		a test  sentence 	and this test   IS just a TEST";
		String[] words = str.toLowerCase().split("\\s+");
		List<String> list = new ArrayList<String>(Arrays.asList(words));

		list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(entry -> entry.getValue() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
				.forEach((k, v) -> {
					System.out.println(k + " -> has repeated " + v + " times");
				});

	

	}

}
