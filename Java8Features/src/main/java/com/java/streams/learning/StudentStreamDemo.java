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

import com.java.model.Student1;

public class StudentStreamDemo {

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
		List<Student1> list2 = list.stream().filter(s -> s.getFirstName().startsWith("A")).collect(Collectors.toList());
		System.out.println(list2);

		//2- Group The Student By Department Names
		Map<String, List<Student1>> map = list.stream().collect(Collectors.groupingBy(s -> s.getDepartmantName()));
		System.out.println(map);

		//3- Find the total count of student using stream
		long count = list.stream().count();
		System.out.println("Total Students: " + count);

		//4- Find the max age of student
		int max2 = list.stream().max((s1, s2) -> Integer.valueOf(s1.getAge()).compareTo(Integer.valueOf(s2.getAge())))
				.get().getAge();

		int max = list.stream().max(Comparator.comparing(Student1::getAge)).get().getAge();
		System.out.println("Max age: " + max);

		int max1 = list.stream()
				.sorted((s1, s2) -> -Integer.valueOf(s1.getAge()).compareTo(Integer.valueOf(s2.getAge()))).skip(1)
				.findFirst().get().getAge();
		System.out.println("Second Max age: " + max1);

		int min = list.stream().min((s1, s2) -> Integer.valueOf(s1.getAge()).compareTo(Integer.valueOf(s2.getAge())))
				.get().getAge();
		System.out.println("Min age: " + min);
		int min1 = list.stream()
				.sorted((s1, s2) -> Integer.valueOf(s1.getAge()).compareTo(Integer.valueOf(s2.getAge()))).skip(1)
				.findFirst().get().getAge();
		System.out.println("Second Min age: " + min1);

		//5- Find all departments names
		Set<String> set = list.stream().map(s -> s.getDepartmantName()).collect(Collectors.toSet());
		System.out.println(set);
		List<String> list3 = set.stream().sorted().collect(Collectors.toList());
		System.out.println(list3);

		//6- Find the count of student in each department
		Map<String, Long> map2 = list.stream()
				.collect(Collectors.groupingBy(s -> s.getDepartmantName(), Collectors.counting()));
		System.out.println(map2);

		LinkedHashMap<String, Long> linkedHashMap = map2.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldVal, newVal) -> oldVal,
						LinkedHashMap::new));
		System.out.println(linkedHashMap);

		//7- Find the list of students whose age is less than 30
		List<Student1> list4 = list.stream().filter(s -> s.getAge() < 30).collect(Collectors.toList());
		System.out.println(list4);

		List<Student1> list5 = list.stream().filter(s -> s.getAge() < 30).collect(Collectors.toList()).stream()
				.sorted((s1, s2) -> Integer.valueOf(s1.getAge()).compareTo(Integer.valueOf(s2.getAge())))
				.collect(Collectors.toList());
		System.out.println(list5);

		//8- Find the list of students whose rank is in between 50 and 100
		List<Student1> list6 = list.stream().filter(s -> (s.getRank() > 50 && s.getRank() < 100))
				.collect(Collectors.toList());
		System.out.println(list6);

		//9- Find the average age of male and female students
		Map<String, Double> map3 = list.stream()
				.collect(Collectors.groupingBy(s -> s.getGender(), Collectors.averagingInt(Student1::getAge)));
		System.out.println(map3);

		//10- Find the department who is having maximum number of students
		//Created a Map with DeptName and no of students and mapped to TreeMap as it has ability to fetch last entry in the Map so collected to TreeMap
		//Then fetched the last entry(Key, value) pair
		TreeMap<String, Long> map4 = list.stream()
				.collect(Collectors.groupingBy(Student1::getDepartmantName, Collectors.counting())).entrySet().stream()
				.sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(oldVal, newVal) -> oldVal, TreeMap<String, Long>::new));
		System.out.println(map4);
		Entry<String, Long> lastEntry = map4.lastEntry();

		System.out.println("Department with highest students: " + lastEntry);

		String value = map4.lastEntry().getKey();
		System.out.println("Department name with max students: " + value);

		//11- Find the Students who stays in Karnataka and sort them by their names
		List<Student1> list7 = list.stream().filter(s -> s.getCity().equalsIgnoreCase("Karnataka"))
				.sorted((s1, s2) -> s1.getFirstName().compareTo(s2.getFirstName())).collect(Collectors.toList());
		System.out.println(list7);

		//12- Find the average rank in all departments
		Map<String, Double> map5 = list.stream()
				.collect(Collectors.groupingBy(Student1::getDepartmantName, Collectors.averagingInt(Student1::getRank)));
		System.out.println(map5);

		//13- Find the highest rank in each department
		Map<String, Student1> map6 = list.stream().collect(Collectors.groupingBy(Student1::getDepartmantName, Collectors
				.collectingAndThen(Collectors.minBy(Comparator.comparingInt(Student1::getRank)), Optional::get)));
		System.out.println(map6);

		//14- Find the list of students and sort them by their rank
		List<Student1> list8 = list.stream()
				.sorted((s1, s2) -> Integer.valueOf(s1.getRank()).compareTo(Integer.valueOf(s2.getRank())))
				.collect(Collectors.toList());
		System.out.println(list8);

		List<Student1> list10 = list.stream().sorted(Comparator.comparingInt(Student1::getRank).reversed())
				.collect(Collectors.toList());
		System.out.println(list10);

		List<Student1> list9 = list.stream().sorted(Comparator.comparingInt(Student1::getRank))
				.collect(Collectors.toList());
		System.out.println(list9);

		//15- Find the student who has second rank
		Student1 student1 = list.stream()
				.sorted((s1, s2) -> -Integer.valueOf(s1.getRank()).compareTo(Integer.valueOf(s2.getRank()))).skip(1)
				.findFirst().get();
		System.out.println("Second highest rank: " + student1.getRank());

		int rank = list.stream().sorted(Comparator.comparing(Student1::getRank).reversed()).skip(1).findFirst().get()
				.getRank();
		System.out.println("Second highest rank: " + rank);

		Student1 student2 = list.stream().sorted(Comparator.comparingInt(Student1::getRank).reversed()).skip(0)
				.findFirst().get();
		System.out.println("First highest rank: " + student2.getRank());

		//16. Find Student's Firstname department wise Map<String, List<String>>
		Map<String, List<String>> map9 = list.stream().collect(Collectors.groupingBy(Student1::getDepartmantName,
				Collectors.mapping(Student1::getFirstName, Collectors.toList())));
		System.out.println("-->"+map9);

		//17: Sorting Employees by Name and Age | sorting using two feilds
		Comparator<Student1> comparator1 = Comparator.comparing(Student1::getAge);
		Comparator<Student1> comparator2 = Comparator.comparing(Student1::getFirstName);

		List<Student1> students = list.stream().sorted(comparator1.thenComparing(comparator2))
				.collect(Collectors.toList());
		System.out.println(students);

	}

}
