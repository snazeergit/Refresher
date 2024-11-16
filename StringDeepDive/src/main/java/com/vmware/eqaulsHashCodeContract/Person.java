package com.vmware.eqaulsHashCodeContract;

import java.util.Objects;

public class Person {

	Integer id;
	String name;
	Integer age;

	public Person(Integer id, String name, Integer age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Person : [ id= " + id + ", name=" + name + ", age=" + age + "]";
	}


	//If two persons are having same name they are equal
	
	/*@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person p = (Person) obj;
		return Objects.equals(name, p.name);
	}
	*/
	
	//If two persons are having same name,age they are equal
	/*@Override
	public int hashCode() {
		return Objects.hash(name, age);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person p = (Person) obj;
		return Objects.equals(name, p.name) && Objects.equals(age, p.age);
	}
	*/
	
	
	//If two persons are having same id,name,age they are equal
	@Override
	public int hashCode() {
		return Objects.hash(id, name, age);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person p = (Person) obj;
		return Objects.equals(id, p.id) && Objects.equals(name, p.name) && Objects.equals(age, p.age);
	}
	
}
