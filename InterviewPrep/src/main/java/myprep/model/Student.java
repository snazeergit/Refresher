package myprep.model;

import java.util.Arrays;
import java.util.Objects;

public class Student {
	String name;
	Integer marks;
	Integer age;
	String deptName;
	String[] loc;

	public Student(String name, Integer marks, Integer age, String deptName, String[] loc) {
		super();
		this.name = name;
		this.marks = marks;
		this.age = age;
		this.deptName = deptName;
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

	public String getDeptName() {
		return deptName;
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

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String[] getLoc() {
		return loc;
	}

	public void setLoc(String[] loc) {
		this.loc = loc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(loc);
		result = prime * result + Objects.hash(age, deptName, marks, name);
		return result;
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
		return Objects.equals(age, other.age) && Objects.equals(deptName, other.deptName)
				&& Arrays.equals(loc, other.loc) && Objects.equals(marks, other.marks)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", marks=" + marks + ", age=" + age + ", deptName=" + deptName + ", loc="
				+ Arrays.toString(loc) + "]";
	}

}
