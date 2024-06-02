package com.nt;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo {

	public static void main(String[] args) {
		String s1 = "Nazeer";
		char[] charArray = s1.toCharArray();
		ArrayList<Character> list = new ArrayList<Character>();
		for (char c : charArray) {
			list.add(c);
		}
		System.out.println(list);
		Map<Character, Long> map = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map);
		List<Entry<Character, Long>> list2 = map.entrySet().stream().filter(m -> m.getValue() == 2)
				.collect(Collectors.toList());
		System.out.println(list2);
	}

}
