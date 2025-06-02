package myprep.model;

import java.util.List;
import java.util.Objects;

public class Person {
	String name;
	Integer age;
	String gender;
	List<String> locationPref;

	public Person(String name, Integer age, String gender, List<String> locationPref) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.locationPref = locationPref;
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

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + ", locationPref=" + locationPref + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(age, other.age) && Objects.equals(gender, other.gender)
				&& Objects.equals(name, other.name);
	}

}
