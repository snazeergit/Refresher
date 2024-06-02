package com.java.strings;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyNonRepeatingElement {

	public static void main(String[] args) {
		String s = "GEEKS FOR GEEKS";
		//Non-Reating Kth element
		int k = 2;
		//remove all white spaces from a given string
		String s1 = s.replaceAll("\\s", "").toUpperCase();

		//Converting String to Char array and store the chars in List.
		char[] charArray = s1.toCharArray();
		List<Character> list = new ArrayList<Character>();
		for (char c : charArray) {
			list.add(c);
		}

		System.out.println(list);
		//Creating a Map with Charactor as keys and thier repition as value
		Map<Character, Long> map = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map);

		//Sorting the Map in Ascending order  by comparing the value 
		LinkedHashMap<Character, Long> map2 = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldVal, newVal) -> oldVal,
						LinkedHashMap::new));
		System.out.println(map2);

		int counter = 0;
		
		//Looping through Map's (K,V) pair 
		for (int i = 0; i < map2.size(); i++) {
			for (Character character : list) {
				
				//fetching each char from the list and checking if its repeated only once or not
				if (map2.get(character) == 1) {
					//to maintain the count of non repeated Kth element
					//like non ripitative 1st, 2nd 3rd will checked here
					counter++;
					if (counter == k) {
						System.out.println("-->" + character);
						break;
					}
				}
			}
		}
	}
}
