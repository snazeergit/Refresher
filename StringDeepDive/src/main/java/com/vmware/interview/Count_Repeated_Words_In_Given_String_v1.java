package com.vmware.interview;

import java.util.HashMap;
import java.util.Map;

/*
 * 1.Using "\\s+":
 * 	
 * 	The regular expression "\\s+" matches one or more whitespace characters, which includes spaces, tabs, and newlines.
 * 	This is useful if the input has multiple spaces or other types of whitespace.
 * 
 * 2.Using " ":
 * 	
 * This will only split by a single space character and will not handle multiple consecutive spaces or other types of whitespace.
 * 
 * Summary:
 * If you want to handle different types of whitespace or multiple consecutive spaces, "\\s+" is generally the better choice.
 */

public class Count_Repeated_Words_In_Given_String_v1 {

	public static void main(String[] args) {
		String str = "This is 		a test  sentence 	and this test   IS just a TEST";

		String[] words = str.toLowerCase().split("\\s+");
		//String[] words = str.toLowerCase().split(" ");

		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String word : words) {
			/*
			 * getOrDefault(key, defaultValue) method returns value of the given key from map
			 * if key not present it returns the default value specified.
			 * 
			 * getOrDefault(key, defaultValue) simply works like get(key) method just that when key not found it retuns default value 0
			 * 
			 * when we add the key for the first time, getOrDefault(-,-) method returns default value which is 0 in our case
			 * so the (key, value) pair inserted is (key,0) but if key is inserted then key should have no.of times its repeated so add
			 * +1 manually to implement this logic. From now on every time the key found in the map its value will be increased by 1.
			 * If a fresh key is inserted then the key with initial value 1 will be inserted.
			 * If the key is alreaydy available then the key value is incremented by 1 so match the no.of times its repeated.
			 */
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		System.out.println(map);

		System.out.println("Repeated words from the given String is :");
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			Integer repetitions = entry.getValue();
			if (repetitions > 1) {
				System.out.println(entry.getKey() + "	" + repetitions + " times");
			}
		}
	}
}
