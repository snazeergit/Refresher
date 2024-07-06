package com.vmware.immutable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class Demo1 {
	private final Integer number;
	private final String name;
	private final Map<Integer, String> favCricketer;

	public Demo1(Integer number, String name, Map<Integer, String> favCricketer) {
		this.number = number;
		this.name = name;
		Map<Integer, String> tempMap = new HashMap<Integer, String>();
		for (Map.Entry<Integer, String> entry : favCricketer.entrySet()) {
			tempMap.put(entry.getKey(), entry.getValue());
		}
		this.favCricketer = tempMap;
	}

	public Integer getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public Map<Integer, String> getFavCricketer() {
		Map<Integer, String> tempMap = new HashMap<Integer, String>();
		for (Map.Entry<Integer, String> entry : favCricketer.entrySet()) {
			tempMap.put(entry.getKey(), entry.getValue());
		}
		return tempMap;
	}

	@Override
	public String toString() {
		return "Demo -> number=" + number + ", name=" + name + ", favCricketer=" + favCricketer;
	}

}

public class MyImmutable_Map {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Sachime");
		map.put(2, "Dhoni");
		map.put(3, "Virat");
		Demo1 d1 = new Demo1(1, "Nazeer", map);

		System.out.println(d1.getName());
		System.out.println(d1.getNumber());
		System.out.println(d1.getFavCricketer());
		map.put(2, "Ponting");
		map.put(3, "Warner");
		System.out.println(d1.getFavCricketer());

	}

}
