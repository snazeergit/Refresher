package com.java.collections.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapDemo1 {

	public static void main(String[] args) {
		hashMap();
		linkedHashMap();
		treeMap();
	}

	public static void hashMap() {
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		map1.put(null, null);
		map1.put(null, null);
		map1.put("cJ", 3);
		map1.put("am", 2);
		map1.put("am", 1);
		map1.put("balu", 0);

		System.err.println("HashMap:	[Unique Keys | Do not Maintains any order | Allows null Keys and Values]");
		System.out.println(map1);
	}

	public static void linkedHashMap() {
		Map<String, Integer> map1 = new LinkedHashMap<String, Integer>();
		map1.put(null, null);
		map1.put(null, null);
		map1.put("cJ", 3);
		map1.put("am", 2);
		map1.put("am", 1);
		map1.put("balu", 0);

		System.err.println("LinkedHashMap:	[Unique Keys | Maintains Insertion order | Allows null Keys and Values]");
		System.out.println(map1);
	}

	public static void treeMap() {
		Map<String, Integer> map1 = new TreeMap<String, Integer>();
		/*map1.put(null, null);
		map1.put(null, null);*/
		map1.put("cJ", 3);
		map1.put("am", 2);
		map1.put("am", 1);
		map1.put("balu", 0);

		System.err.println("TreeMap: 	[Unique Keys | Maintains Natural sorting order | Allows null Keys and Values]");
		System.out.println(map1);
	}

}
