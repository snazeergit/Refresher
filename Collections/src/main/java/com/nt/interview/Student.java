package com.nt.interview;

public class Student {
	String firstName;
	String lastNmae;
	Integer totalMarks;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastNmae() {
		return lastNmae;
	}

	public void setLastNmae(String lastNmae) {
		this.lastNmae = lastNmae;
	}

	public Integer getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(Integer totalMarks) {
		this.totalMarks = totalMarks;
	}

	public Student(String firstName, String lastName, Integer totalMarks) {
		this.firstName = firstName;
		this.lastNmae = lastName;
		this.totalMarks = totalMarks;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastNmae=" + lastNmae + ", totalMarks=" + totalMarks + "]";
	}
	

}
