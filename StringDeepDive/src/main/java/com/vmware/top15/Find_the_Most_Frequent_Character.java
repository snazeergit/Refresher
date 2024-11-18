package com.vmware.top15;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//Problem: Identify the character that appears most frequently in a string.
public class Find_the_Most_Frequent_Character {

	public static void main(String[] args) {
		String str = "My 			name	 is 		Syed Nazeer";
		List<Character> list = new ArrayList<Character>();
		//remember to replace all white spaces with "" for accurate results
		for (char c : str.toLowerCase().replaceAll("\\s", "").toCharArray()) {
			list.add(c);
		}
		//System.out.println(list);
		Map<Character, Long> map1 = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		//System.out.println(map1);
		Character character = map1.entrySet().stream().max(Map.Entry.comparingByValue()).map(entry -> entry.getKey())
				.get();
		System.out.println(character);
	}

}
