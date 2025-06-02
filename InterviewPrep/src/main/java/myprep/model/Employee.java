package myprep.model;

import java.util.List;
import java.util.Objects;

public class Employee {
	String name;
	Integer age;
	String gender;
	List<String> locationPref;
	Double sal;
	String department;

	public Employee(String name, Integer age, String gender, List<String> locationPref, Double sal, String department) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.locationPref = locationPref;
		this.sal = sal;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<String> getLocationPref() {
		return locationPref;
	}

	public void setLocationPref(List<String> locationPref) {
		this.locationPref = locationPref;
	}

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", gender=" + gender + ", locationPref=" + locationPref
				+ ", sal=" + sal + ", department=" + department + "]";
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
		Employee other = (Employee) obj;
		return Objects.equals(age, other.age) && Objects.equals(name, other.name);
	}

}
