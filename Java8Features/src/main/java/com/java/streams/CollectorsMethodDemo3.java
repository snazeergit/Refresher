package com.java.streams;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.java.myutility.MyUtility;
import com.java.pojo.Employee;
import com.java.pojo.Person;
import com.java.pojo.Student;

public class CollectorsMethodDemo3 {

	public static void main(String[] args) {
		List<Person> people = MyUtility.getPersons();
		List<Student> students = MyUtility.getStudents();
		List<Integer> intList = MyUtility.getIntegerList();
		List<Employee> employees = MyUtility.getEmployees();

		System.out.println("summarizingInt():----");
		/*	IntSummaryStatistics stats1 = intList.stream().collect(Collectors.summarizingInt(i->i.intValue()));*/
		IntSummaryStatistics stats1 = intList.stream().collect(Collectors.summarizingInt(Integer::intValue));
		System.out.println("Sum: " + stats1.getSum());
		System.out.println("Average: " + stats1.getAverage());
		System.out.println("Maximum: " + stats1.getMax());
		System.out.println("Minimum: " + stats1.getMin());
		System.out.println("Count: " + stats1.getCount());
		/* IntSummaryStatistics stats2 = students.stream().collect(Collectors.summarizingInt(s->s.getMarks()));*/
		IntSummaryStatistics stats2 = students.stream().collect(Collectors.summarizingInt(Student::getMarks));
		System.out.println("Sum: " + stats2.getSum());
		System.out.println("Average: " + stats2.getAverage());
		System.out.println("Maximum: " + stats2.getMax());
		System.out.println("Minimum: " + stats2.getMin());
		System.out.println("Count: " + stats2.getCount());

		/*DoubleSummaryStatistics stats3 = employees.stream().collect(Collectors.summarizingDouble(e -> e.getSal()));*/
		DoubleSummaryStatistics stats3 = employees.stream().collect(Collectors.summarizingDouble(Employee::getSal));
		System.out.println("Sum: " + stats3.getSum());
		System.out.println("Average: " + stats3.getAverage());
		System.out.println("Maximum: " + stats3.getMax());
		System.out.println("Minimum: " + stats3.getMin());
		System.out.println("Count: " + stats3.getCount());
		
		System.out.println("summingInt():----");
		// Compute sum of salaries of employee
		Integer integer = people.stream().collect(Collectors.summingInt(Person::getAge));
		System.out.println(integer);

		System.out.println("toCollection():----");
		// Accumulate names into a TreeSet
		TreeSet<String> set = people.stream().map(p -> p.getName()).collect(Collectors.toCollection(TreeSet::new));
		System.out.println(set);

		System.out.println("toConcurrentMap():----");

		System.out.println("toList():----");
		// Accumulate names into a List
		List<String> list = people.stream().map(p -> p.getName()).collect(Collectors.toList());
		System.out.println(list);

		System.out.println("toMap():----");
		// Accumulate names into a Set
		Map<String, List<String>> map6 = people.stream()
				.collect(Collectors.toMap(e -> e.getName(), e -> e.getLocationPref()));
		System.out.println(map6);

		System.out.println("toSet():----");
		// Accumulate names into a Set
		Set<String> set1 = people.stream().map(p -> p.getName()).collect(Collectors.toSet());
		System.out.println(set1);

	}

}
