package com.java.model;

import java.util.Arrays;
import java.util.Objects;

public class Student {
	String name;
	Integer marks;
	Integer age;
	String[] loc;

	public Student(String name, Integer marks, Integer age, String[] loc) {
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

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
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

	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(age, other.age) && Objects.equals(name, other.name);
	}

}
