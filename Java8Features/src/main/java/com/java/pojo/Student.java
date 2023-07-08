package com.java.pojo;

import java.util.Arrays;

public class Student {
	String name;
	Integer marks;
	Integer age;
	String[] loc;

	public Student(String name, int marks, int age, String[] loc) {
		super();
		this.name = name;
		this.marks = marks;
		this.age = age;
		this.loc = loc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String[] getLoc() {
		return loc;
	}

	public void setLoc(String[] loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", marks=" + marks + ", age=" + age + ", loc=" + Arrays.toString(loc) + "]";
	}

}
