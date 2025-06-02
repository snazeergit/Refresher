package myprep.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * Arrange the characters in Ascending order based on repitition 
 * If the two characters are repetitions are same then first come first fit based. 
 * Below BB and EE are repeated twice since EE occurrs first in string it should occupie first place.
 */
public class StringCharSorting {

	public static void main(String[] args) {
		String str = "AAAAAEECCCCDBB";
		//Output: DEEBBCCCCAAAAA 

		char[] chars = str.toCharArray();
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for (char c : chars) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		System.out.println(map);
		LinkedHashMap<Character, Integer> map2 = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(
				Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldV, newV) -> oldV, LinkedHashMap::new));
		
		System.out.println(map2);
		
		String string = map2.entrySet().stream().map(e -> String.valueOf(e.getKey()).repeat(e.getValue()))
				.collect(Collectors.joining());
		System.out.println(string);

	}
}
