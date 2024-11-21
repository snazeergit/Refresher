package com.stream.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stream.model.Employee;
import com.stream.model.Employee1;
import com.stream.model.Student;

public class EmployeeUtil {

	public static List<Employee> getEmployees() {
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(1, "Arun", 28, 15000, "F", "HR", "Banglore", 2020));
		empList.add(new Employee(2, "Xavier", 29, 12000, "F", "HR", "Hyderabad", 2015));
		empList.add(new Employee(3, "Eshwar", 30, 11500, "M", "HR", "Chennai", 2014));
		empList.add(new Employee(4, "Deepu", 32, 12500, "F", "HR", "Chennai", 2013));
		empList.add(new Employee(5, "Illiyana", 22, 15000, "F", "IT", "Noida", 2013));
		empList.add(new Employee(6, "Manoj", 27, 14000, "M", "IT", "Gurugram", 2017));
		empList.add(new Employee(7, "Urvasi", 26, 13000, "F", "DEV", "Pune", 2016));
		empList.add(new Employee(8, "Pratap", 23, 14500, "M", "DEV", "Trivandrum", 2015));
		empList.add(new Employee(9, "Suman", 25, 16000, "M", "DEV", "Banglore", 2010));
		return empList;
	}

	public static Map<String, Integer> getMap() {
		Map<String, Integer> map = new HashMap<>();
		map.put("John", 1000);
		map.put("Mike", 1300);
		map.put("Peter", 1200);
		map.put("Kevin", 1300);
		map.put("James", 1200);
		map.put("Justin", 1300);
		return map;
	}

	public List<Student> getStudents() {
		List<Student> list = Arrays.asList(
				new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
				new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
				new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
				new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
				new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
				new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
				new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
				new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
				new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
				new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));
		return list;
	}

	public static List<Integer> getIntegerList() {

		return Arrays.asList(10, 40, 20, 40, 30, 55, 70, 40, 85, 85);
	}

	public static List<String> getStringList() {

		return Arrays.asList("Ramu", "Giri", "Ramu", "Raja", "Aravind", "Kamal", "Seeta", "Gokul");
	}

	public static List<Employee1> getEmployee1() {
		List<Employee1> employeeList = new ArrayList<Employee1>();
		employeeList.add(new Employee1(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee1(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee1(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee1(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee1(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee1(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee1(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee1(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee1(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee1(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee1(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee1(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee1(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee1(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee1(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee1(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee1(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
		return employeeList;
	}

}
