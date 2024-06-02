package com.java.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.IntStream;

public class TestString2 {

	public static void main(String[] args) {
		int[] a = { 2, 5, 1, 3, 2 };
		int[] b = { 7, 5, 9, 3, 3 };
		int[] c = { 0, 5, 6, 3, 1 };

		int[] d = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).distinct().sorted().toArray();
		int[] e = IntStream.concat(Arrays.stream(c), Arrays.stream(d)).distinct().sorted().toArray();

		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < e.length; i++) {
			list.add(e[i]);
		}

		System.out.println(list);

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("nazeer", 23);
		map.put("Riyaz", 44);
		map.put("Karma", 99);

		Set<Entry<String, Integer>> entrySet = map.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + "	->" + value);
		}

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + "	->" + value);
		}

	}

}
