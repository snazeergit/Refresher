package com.nt.exception;

import java.util.ArrayList;
import java.util.List;

final class Student {
	private final String name;
	private final int age;
	private final List<String> hobbies;

	public Student(String name, int age, List<String> hobbies) {
		this.name = name;
		this.age = age;
		List<String> tempList = new ArrayList<String>();
		for (String hobby : hobbies) {
			tempList.add(hobby);
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
		for (String hobby : hobbies) {
			tempList.add(hobby);
		}
		return tempList;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", hobbies=" + hobbies + "]";
	}

}

public class MyImmutable1 {

	public static void main(String[] args) {

		List list1 = new ArrayList<String>();
		list1.add("Cricket");
		list1.add("Football");
		Student s1 = new Student("Nazeer", 33, list1);

		System.out.println(s1.toString());
		list1.add("Kabaddi");
		System.out.println(s1.toString());

	}

}
