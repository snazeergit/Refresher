package com.stream.list;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Interview1 {

	public static void main(String[] args) {

		List<Integer> list = List.of(2, 3, 7, 4, 1);
		HashMap<Integer, Object> map = new LinkedHashMap<Integer, Object>();
		list.stream().sorted().forEach(k -> map.put(k, null));
		System.out.println(map);
	}

}
