package com.vmware;

import java.util.Objects;

public class Student {

	private Integer rollNo;
	private String name;
	private Double marks;

	public Student(String name, Integer rollNo, Double marks) {
		this.rollNo = rollNo;
		this.name = name;
		this.marks = marks;
	}

	public Integer getRollNo() {
		return rollNo;
	}

	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getMarks() {
		return marks;
	}

	public void setMarks(Double marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", marks=" + marks + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(marks, name, rollNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Student st = (Student) obj;
		return Objects.equals(marks, st.marks) && Objects.equals(name, st.name) && Objects.equals(rollNo, st.rollNo);
	}

}
