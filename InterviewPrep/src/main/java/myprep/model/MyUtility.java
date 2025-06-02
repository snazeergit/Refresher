package myprep.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

		sList.add(new Student("Prakash", 60, 33, "Sales", loc1));
		sList.add(new Student("Sundari", 40, 28, "Sales", loc2));
		sList.add(new Student("Sundar", 40, 28, "Finance", loc2));
		sList.add(new Student("Sony", 80, 27, "Finance", loc3));
		sList.add(new Student("Karim", 20, 25, "Dev", loc4));
		sList.add(new Student("Karim", 20, 25, "Dev", loc4));
		return sList;
	}

	public static List<Student1> getStudents1() {
		List<Student1> studentslist = Arrays.asList(
				new Student1(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
				new Student1(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
				new Student1(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
				new Student1(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
				new Student1(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
				new Student1(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
				new Student1(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
				new Student1(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
				new Student1(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
				new Student1(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));
		return studentslist;
	}

	public static List<Employee> getEmployees() {
		List<Employee> empList = new ArrayList<>();
		empList.add(
				new Employee("Abhilash", 33, "male", List.of("Hyderabad", "Banglore", "Chennai"), 70000.0, "Sales"));
		empList.add(new Employee("Chaitanya", 28, "male", List.of("Tirupati", "Nellore", "Hyderabad"), 20000.0, "RnD"));
		empList.add(new Employee("David", 28, "male", List.of("Tirupati", "Nellore", "Hyderabad"), 20000.0, "RnD"));
		empList.add(new Employee("Eesha", 27, "female", List.of("Nellore", "Eluru", "Chennai"), 30000.0, "Sales"));
		empList.add(new Employee("Eesha", 27, "female", List.of("Nellore", "Eluru", "Chennai"), 40000.0, "Sales"));
		empList.add(new Employee("Fathima", 25, "female", List.of("Tirupati", "Nellore"), 40000.0, "Finance"));
		empList.add(new Employee("Bhargav", 21, "male", List.of("Trichi", "Nellore"), 20000.0, "Finance"));
		return empList;
	}

	public static List<Integer> getIntegerList() {
		return Arrays.asList(2, 3, 1, 2);
	}
}
