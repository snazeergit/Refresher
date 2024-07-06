package com.vmware;

import java.util.HashMap;
import java.util.Map;

public final class CustomImmute2 {

	private final String name;
	private final Integer age;
	private final Map<String, Integer> locations;

	public CustomImmute2(String name, Integer age, Map<String, Integer> locations) {
		super();
		this.name = name;
		this.age = age;
		Map<String, Integer> tempMap = new HashMap<String, Integer>();
		for (Map.Entry<String, Integer> entry : locations.entrySet()) {
			tempMap.put(entry.getKey(), entry.getValue());
		}

		this.locations = tempMap;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public Map<String, Integer> getLocations() {
		Map<String, Integer> tempMap = new HashMap<String, Integer>();

		for (Map.Entry<String, Integer> entry : locations.entrySet()) {
			String key = entry.getKey();
			Integer val = entry.getValue();
			tempMap.put(key, val);
		}

		return tempMap;
	}

	public static void main(String[] args) {
		Map<String, Integer> locations = new HashMap<String, Integer>();
		locations.put("Nellore", 100);
		locations.put("Banglore", 200);
		CustomImmute2 cm = new CustomImmute2("Nazeer", 33, locations);
		System.out.println(cm.getName());
		System.out.println(cm.getAge());
		System.out.println(cm.getLocations());

		locations.put("Kolkata", 500);
		//cm.age=34;
		//cm.name="Pooja";

		System.out.println(cm.getName());
		System.out.println(cm.getAge());
		System.out.println(cm.getLocations());

	}

}
