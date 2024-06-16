package com.nt.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.nt.model.Student;

public class StudentStreamDemo {

	public static void main(String[] args) {

		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student("Ramu", 30, "Sales"));
		list.add(new Student("Sita", 50, "Service"));
		list.add(new Student("Giri", 10, "Development"));
		list.add(new Student("Kavya", 20, "Development"));
		list.add(new Student("Ravi", 60, "RnD"));

		Map<String, Double> map = list.stream()
				.collect(Collectors.groupingBy(Student::getDepartment, Collectors.averagingInt(Student::getRank)));
		System.out.println(map);

		HashMap<String, Integer> linkedHashMap = list.stream()
				.collect(Collectors.toMap(Student::getDepartment, Student::getRank, Integer::min, HashMap::new));
		System.out.println(linkedHashMap);

	}

}
