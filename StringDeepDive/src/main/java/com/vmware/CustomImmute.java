package com.vmware;

import java.util.ArrayList;
import java.util.List;

public final class CustomImmute {

	private final String name;
	private final Integer age;
	private final List<String> locations;

	public CustomImmute(String name, Integer age, List<String> locations) {
		super();
		this.name = name;
		this.age = age;
		List<String> tempList = new ArrayList<String>();
		for (String location : locations) {
			tempList.add(location);
		}
		this.locations = tempList;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public List<String> getLocations() {
		List<String> tempList = new ArrayList<String>();
		for (String location : locations) {
			tempList.add(location);
		}

		return tempList;
	}

	public static void main(String[] args) {
		List<String> locations = new ArrayList<String>();
		locations.add("Nellore");
		locations.add("Banglore");
		CustomImmute cm = new CustomImmute("Nazeer", 33, locations);
		System.out.println(cm.getName());
		System.out.println(cm.getAge());
		System.out.println(cm.getLocations());

		locations.add("Kolkata");
		//cm.age=34;
		//cm.name="Pooja";

		System.out.println(cm.getName());
		System.out.println(cm.getAge());
		System.out.println(cm.getLocations());

	}

}
