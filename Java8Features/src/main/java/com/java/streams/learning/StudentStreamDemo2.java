package com.java.streams.learning;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.java.core.Student;
import com.java.model.Employee;
import com.java.model.Student1;

public class StudentStreamDemo2 {

	public static void main(String[] args) {
		List<Student1> list = Arrays.asList(
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

		//1- Find list of students whose first name starts with alphabet A
		list.stream().filter(s -> s.getFirstName().startsWith("A")).map(s -> s.getFirstName())
				.forEach(System.out::println);
		System.out.println("----");
		//2- Group The Student By Department Names
		Map<String, List<Student1>> map = list.stream().collect(Collectors.groupingBy(Student1::getDepartmantName));
		System.out.println(map);
		System.out.println("----");
		//3- Find the total count of student using stream
		long count = list.stream().count();
		System.out.println(count);
		System.out.println("----");
		//4- Find the max age of student
		Student1 student1 = list.stream().sorted(Comparator.comparing(Student1::getAge).reversed()).findFirst().get();
		System.out.println(student1.getAge());

		Student1 student12 = list.stream().max(Comparator.comparing(Student1::getAge)).get();
		System.out.println(student12.getAge());
		System.out.println("----");
		//5- Find all departments names
		List<String> list2 = list.stream().map(Student1::getDepartmantName).distinct().collect(Collectors.toList());
		System.out.println(list2);

		list.stream().map(Student1::getDepartmantName).distinct().collect(Collectors.toSet())
				.forEach(System.out::println);
		System.out.println("----");
		//6- Find the count of student in each department
		Map<String, Long> map2 = list.stream()
				.collect(Collectors.groupingBy(Student1::getDepartmantName, Collectors.counting()));
		System.out.println(map2);
		System.out.println("----");
		//7- Find the list of students whose age is less than 30
		List<Student1> list3 = list.stream().filter(s -> s.getAge() < 30).collect(Collectors.toList());
		System.out.println(list3);
		for (Student1 student13 : list3) {
			System.out.println(student13.getFirstName() + "	->	" + student13.getAge());
		}
		System.out.println("----");
		//8- Find the list of students whose rank is in between 50 and 100
		List<Student1> list4 = list.stream().filter(s -> s.getRank() > 50 & s.getRank() < 100)
				.collect(Collectors.toList());
		for (Student1 student13 : list4) {
			System.out.println(student13.getFirstName() + "	->	" + student13.getRank());
		}
		System.out.println("----");
		//9- Find the average age of male and female students
		Map<String, Double> map3 = list.stream()
				.collect(Collectors.groupingBy(Student1::getGender, Collectors.averagingDouble(Student1::getAge)));
		System.out.println(map3);
		System.out.println("----");
		//10- Find the department who is having maximum number of students
		LinkedHashMap<String, Long> map4 = list.stream()
				.collect(Collectors.groupingBy(Student1::getDepartmantName, Collectors.counting())).entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors
						.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldVal, newVal) -> oldVal, LinkedHashMap::new));
		Entry<String, Long> entry = map4.entrySet().stream().findFirst().get();
		System.out.println(entry);
		System.out.println("----");
		//11- Find the Students who stays in Karnataka and sort them by their names
		List<Student1> list5 = list.stream().filter(s -> s.getCity().equals("Karnataka"))
				.sorted(Comparator.comparing(Student1::getFirstName)).collect(Collectors.toList());
		for (Student1 student13 : list5) {
			System.out.println(student13.getFirstName() + "	->	" + student13.getCity());
		}
		System.out.println("----");
		//12- Find the average rank in all departments
		Map<String, Double> map5 = list.stream().collect(
				Collectors.groupingBy(Student1::getDepartmantName, Collectors.averagingDouble(Student1::getRank)));
		System.out.println(map5);
		System.out.println("----");
		//13- Find the highest rank in each department
		Map<String, Optional<Student1>> map6 = list.stream().collect(Collectors.groupingBy(Student1::getDepartmantName,
				Collectors.maxBy(Comparator.comparing(Student1::getRank))));
		map6.forEach((dept, opt) -> System.out.println(dept + "	->	" + opt.get().getAge()));
		System.out.println("----");
		//14- Find the list of students and sort them by their rank
		List<Student1> list6 = list.stream().sorted(Comparator.comparing(Student1::getRank))
				.collect(Collectors.toList());
		for (Student1 student13 : list6) {
			System.out.println(student13.getRank() + "	->	" + student13.getFirstName());
		}
		System.out.println("----");
		//15- Find the student who has second highest rank
		Student1 student13 = list.stream().sorted(Comparator.comparing(Student1::getRank)).skip(1).findFirst().get();
		System.out.println(student13.getFirstName() + "	->	" + student13.getRank());
		System.out.println("----");
		//16. Find Student's Firstname department wise Map<String, List<String>>
		Map<String, List<String>> map7 = list.stream().collect(Collectors.groupingBy(Student1::getDepartmantName,
				Collectors.mapping(Student1::getFirstName, Collectors.toList())));
		map7.forEach((k, v) -> System.out.println(k + "->" + v));
		System.out.println("----");
		//17: Sorting Students by Name and Age | sorting using two feilds
		Comparator<Student1> comparator1 = Comparator.comparing(Student1::getFirstName);
		Comparator<Student1> comparator2 = Comparator.comparing(Student1::getAge);
		List<Student1> list7 = list.stream().sorted(comparator1.thenComparing(comparator2))
				.collect(Collectors.toList());
		for (Student1 student14 : list7) {
			System.out.println(student14.getFirstName() + "->" + student14.getAge());
		}
	}

}
