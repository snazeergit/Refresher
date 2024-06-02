package com.java.strings;

import java.util.ArrayList;
import java.util.List;

final class Stud {
	private final String name;
	private final int age;
	private final List<String> hobbies;

	public Stud(String name, int age, List<String> hobbies) {
		this.name = name;
		this.age = age;
		List<String> tempList = new ArrayList<String>();
		for (String h : hobbies) {
			tempList.add(h);
		}
		this.hobbies = tempList;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	public List<String> getHobbies() {
		List<String> tempList = new ArrayList<String>();
		for (String h : hobbies) {
			tempList.add(h);
		}
		return tempList;
	}
}

public class ImmutableList {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Cricket");
		list.add("Football");

		Stud s = new Stud("Nazeer", 33, list);
		System.out.println(s.getName());
		System.out.println(s.getAge());
		System.out.println(s.getHobbies());
		list.add("Tennis");
		System.out.println(s.getHobbies());
		list.add("co-co");
		System.out.println(s.getHobbies());

	}
}
