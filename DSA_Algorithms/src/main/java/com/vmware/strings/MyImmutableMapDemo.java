package com.vmware.strings;

import java.util.HashMap;
import java.util.Map;

final class Person {
	private final String name;
	private final int age;
	private final Map<String, Integer> skillSet;

	public Person(String name, int age, Map<String, Integer> skillSet) {
		this.age = age;
		this.name = name;
		Map<String, Integer> tempSkillSet = new HashMap<String, Integer>();
		for (Map.Entry<String, Integer> entry : skillSet.entrySet()) {
			tempSkillSet.put(entry.getKey(), entry.getValue());
		}
		this.skillSet = tempSkillSet;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Map<String, Integer> getSkillSet() {
		Map<String, Integer> tempSkillSet = new HashMap<String, Integer>();
		for (Map.Entry<String, Integer> entry : skillSet.entrySet()) {
			tempSkillSet.put(entry.getKey(), entry.getValue());
		}
		return tempSkillSet;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", skillSet=" + skillSet + "]";
	}

}

public class MyImmutableMapDemo {

	public static void main(String[] args) {
		Map<String, Integer> skillSet = new HashMap<String, Integer>();
		skillSet.put("Java", 10);
		skillSet.put("SpringBoot", 6);
		skillSet.put("Microservices", 6);
		Person p1 = new Person("Nazeer", 33, skillSet);
		System.out.println(p1);
		skillSet.put("React", 1);
		skillSet.put("JS", 1);
		System.out.println(p1.getSkillSet());
	}

}
