package com.nt.model;

public class Student {

	private String name;
	private Integer rank;
	private String department;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", rank=" + rank + ", department=" + department + "]";
	}

	public Student(String name, Integer rank, String department) {
		this.name = name;
		this.rank = rank;
		this.department = department;
	}

}
