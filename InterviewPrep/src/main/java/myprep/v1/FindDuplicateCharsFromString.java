package myprep.v1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateCharsFromString {

	static String s = "NAZEER";

	public static void main(String[] args) {
		approach1();

		approach2();

		approach3();

		approach4();

	}

	private static void approach4() {
		char[] charArray = s.toCharArray();
		List<Character> list2 = new ArrayList<Character>();
		for (char c : charArray) {
			list2.add(c);
		}
		List<Character> list = list2.stream().filter(c -> Collections.frequency(list2, c) > 1).distinct()
				.collect(Collectors.toList());
		System.out.println("Duplicate elements : " + list);
	}

	private static void approach3() {
		char[] chars = s.toCharArray();
		Map<Character, Integer> map1 = new HashMap<Character, Integer>();
		for (char c : chars) {
			map1.put(c, map1.getOrDefault(c, 0) + 1);
		}
		List<Character> list = map1.entrySet().stream().filter(entry -> entry.getValue() > 1)
				.map(entry -> entry.getKey()).collect(Collectors.toList());
		System.out.println("Duplicate elements : " + list);
	}

	private static void approach2() {
		char[] charArray = s.toCharArray();
		List<Character> list2 = new ArrayList<Character>();
		for (char c : charArray) {
			list2.add(c);
		}
		HashSet<Character> set = new HashSet<Character>();
		List<Character> list = list2.stream().filter(n -> !set.add(n)).collect(Collectors.toList());
		System.out.println("Duplicate elements : " + list);
	}

	private static void approach1() {

		char[] charArray = s.toCharArray();
		List<Character> list = new ArrayList<Character>();
		for (int i = 0; i < charArray.length; i++) {
			list.add(charArray[i]);
		}

		Map<Character, Long> map = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		List<Character> uniqueList = map.entrySet().stream().filter(m -> m.getValue() == 1).map(m -> m.getKey())
				.collect(Collectors.toList());
		List<Character> duplicateList = map.entrySet().stream().filter(m -> m.getValue() > 1).map(m -> m.getKey())
				.collect(Collectors.toList());
		System.out.println("Duplicate elements : " + uniqueList);
		System.out.println("Duplicate elements : " + duplicateList);
	}
}
