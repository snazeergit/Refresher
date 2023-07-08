package com.java.myutility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.java.pojo.Employee;
import com.java.pojo.Person;
import com.java.pojo.Student;

public class MyUtility {

	public static List<Person> getPersons() {
		List<Person> pList = new ArrayList<>();
		pList.add(new Person("Anil", 33, "male", List.of("Hyderabad", "Banglore", "Chennai")));
		pList.add(new Person("Sunil", 30, "male", List.of("Banglore", "Chennai")));
		pList.add(new Person("Elon", 25, "male", List.of("England", "London")));
		pList.add(new Person("Dravid", 26, "male", List.of("Tirupati", "Nellore", "Hyderabad")));
		pList.add(new Person("Bindu", 27, "female", List.of("Nellore", "Eluru", "Chennai")));
		pList.add(new Person("Govind", 27, "female", List.of("Nellore", "Eluru", "Chennai")));
		pList.add(new Person("Chenga", 25, "female", List.of("Tirupati", "Nellore")));
		return pList;
	}

	public static List<Student> getStudents() {
		List<Student> sList = new ArrayList<>();
		String[] loc1 = { "Hyderabad", "Banglore", "Chennai" };
		String[] loc2 = { "Tirupati", "Nellore", "Hyderabad" };
		String[] loc3 = { "Nellore", "Eluru", "Chennai" };
		String[] loc4 = { "Tirupati", "Nellore" };

		sList.add(new Student("Prakash", 60, 33, loc1));
		sList.add(new Student("Sundar", 40, 28, loc2));
		sList.add(new Student("Sundar", 40, 28, loc2));
		sList.add(new Student("Soniya", 80, 27, loc3));
		sList.add(new Student("Karim", 20, 25, loc4));
		sList.add(new Student("Karim", 20, 25, loc4));
		return sList;
	}

	public static List<Employee> getEmployees() {
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee("Nagesh", 33, "male", List.of("Hyderabad", "Banglore", "Chennai"), 70000.0, "Sales"));
		empList.add(new Employee("Malli", 28, "male", List.of("Tirupati", "Nellore", "Hyderabad"), 20000.0, "RnD"));
		empList.add(new Employee("Kavita", 27, "female", List.of("Nellore", "Eluru", "Chennai"), 30000.0, "Sales"));
		empList.add(new Employee("Sumana", 25, "female", List.of("Tirupati", "Nellore"), 40000.0, "Finance"));
		empList.add(new Employee("Kavita", 27, "female", List.of("Nellore", "Eluru", "Chennai"), 30000.0, "Sales"));
		return empList;
	}

	public static List<Integer> getIntegerList() {
		return Arrays.asList(2, 3, 1, 2);
	}
}
