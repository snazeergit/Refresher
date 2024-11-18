package com.vmware.top15;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

//•	Problem: Identify the first character in a string that does not repeat.
public class Find_the_First_Non_Repeating_Character {

	public static void main(String[] args) {
		String str = "Hello";

		/*
		Doesn't work because asList(-) method expects arrays of objects(Ex: Character[], String[],..) 
		but not arrays of primitive types(Ex: char[], int[], double[],..). 
		
		List<String> list = new ArrayList<String>(Arrays.asList(str.toLowerCase().toCharArray()));
		*/

		/*
		chars() method returns IntStream having ASCII/Unicode values of each charecter
		str.toLowerCase().chars(); -> [104, 101, 108, 108, 111] // ASCII/Unicode values for 'h', 'e', 'l', 'l', 'o'
		*/

		/*
		(char) c casts each integer in the stream back into its corresponding char.
		[104, 101, 108, 108, 111].mapToObj(c -> (char) c) -> ['h', 'e', 'l', 'l', 'o']
		*/
		List<Character> chars = str.toLowerCase().chars().mapToObj(c -> (char) c).toList();
		LinkedHashMap<Character, Long> map = chars.stream()
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		Character character = map.entrySet().stream().filter(entry -> entry.getValue() < 2).map(entry -> entry.getKey())
				.findFirst().get();
		System.out.println(character);

		//approach-2
		List<Character> list = new ArrayList<Character>();
		for (char c : str.toLowerCase().toCharArray()) {
			list.add(c);
		}
		HashSet<Character> distinct = new HashSet<Character>();
		Character character2 = list.stream().filter(c -> distinct.add(c)).findFirst().get();
		System.out.println(character2);

		//approach-3
		Map<Character, Integer> map1 = new LinkedHashMap<Character, Integer>();
		for (char c : str.toLowerCase().toCharArray()) {
			map1.put(c, map1.getOrDefault(c, 0) + 1);
		}
		Entry<Character, Integer> entry2 = map1.entrySet().stream().filter(entry -> entry.getValue() < 2).findFirst()
				.get();
		System.out.println(entry2.getKey());
	}

}
