package com.vmware;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Fetch_Distinct_Elements {
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 5, 3, 4, 2, 4, 1, 5 };

		//HashSet
		System.out.println("HashSet :");
		Set<Integer> set1 = new HashSet<Integer>();
		for (int i : arr) {
			set1.add(i);
		}
		System.out.println(set1);

		//LinkedHashSet
		System.out.println("LinkedHashSet :");
		Set<Integer> set2 = new LinkedHashSet<Integer>();
		for (int i : arr) {
			set2.add(i);
		}
		System.out.println(set2);
		//HashMap
		System.out.println("HashMap :");
		Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		for (int i : arr) {
			map1.put(i, map1.getOrDefault(i, 0) + 1);
		}
		Object[] array1 = map1.entrySet().stream().map(Map.Entry::getKey).toArray();
		System.out.println(Arrays.toString(array1));

		//LinkedHashMap
		System.out.println("LinkedHashMap :");
		Map<Integer, Integer> map2 = new LinkedHashMap<Integer, Integer>();
		for (int i : arr) {
			map2.put(i, map2.getOrDefault(i, 0) + 1);
		}
		Object[] array2 = map2.entrySet().stream().map(Map.Entry::getKey).toArray();
		System.out.println(Arrays.toString(array2));

		//Java 8 Streams
		System.out.println("Streams :");
		int[] array3 = Arrays.stream(arr).distinct().toArray();
		System.out.println(Arrays.toString(array3));

		//Nested Loop with out using Collections and Stream API
		System.out.println("Nested Loop with out using Collections and Stream API :");
		int counter = 0, n = arr.length;
		int[] temp = new int[n];
		for (int i = 0; i < n; i++) {
			boolean isDistinct = true;
			for (int j = 0; j < i; j++) {
				if (arr[i] == arr[j]) {
					isDistinct = false;
					break;
				}
			}
			if (isDistinct) {
				temp[counter++] = arr[i];
			}
		}
		int[] res = Arrays.copyOf(temp, counter);
		System.out.println(Arrays.toString(res));
	}
}
