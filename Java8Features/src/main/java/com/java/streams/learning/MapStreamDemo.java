package com.java.streams.learning;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.java.model.Student1;

public class MapStreamDemo {

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

		//Department wise avg. rank
		Map<String, Double> map = list.stream().collect(
				Collectors.groupingBy(Student1::getDepartmantName, Collectors.averagingInt(Student1::getRank)));
		System.out.println(map);

		//Dept wise avg.rank sorting
		LinkedHashMap<String, Double> map2 = list.stream()
				.collect(Collectors.groupingBy(Student1::getDepartmantName, Collectors.averagingInt(Student1::getRank)))
				.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey,
						Map.Entry::getValue, (oldVal, newVal) -> oldVal, LinkedHashMap::new));
		System.out.println(map2);

	}

}
