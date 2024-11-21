package com.nt.exception;

import java.util.HashMap;
import java.util.Map;

final class Student1 {
	private final String name;
	private final int age;
	private final Map<String, Integer> skillSet;

	public Student1(String name, int age, Map<String, Integer> skillSet) {
		this.name = name;
		this.age = age;
		Map<String, Integer> tempSet = new HashMap<String, Integer>();

		for (Map.Entry<String, Integer> entry : skillSet.entrySet()) {
			tempSet.put(entry.getKey(), entry.getValue());
		}
		this.skillSet = tempSet;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	public Map<String, Integer> getSkillSet() {
		Map<String, Integer> tempSet = new HashMap<String, Integer>();
		for (Map.Entry<String, Integer> entry : skillSet.entrySet()) {
			tempSet.put(entry.getKey(), entry.getValue());
		}
		return tempSet;
	}

	@Override
	public String toString() {
		return "Student1 [name=" + name + ", age=" + age + ", skillSet=" + skillSet + "]";
	}

}

public class MyImmutable2 {

	public static void main(String[] args) {
		Map<String, Integer> mapSet = new HashMap<String, Integer>();
		mapSet.put("Java", 10);
		mapSet.put("SpringBoot", 6);
		Student1 s1 = new Student1("Nazeer", 33, mapSet);
		System.out.println(s1);
		mapSet.put("Microservices", 6);
		System.out.println(s1);

	}

}
