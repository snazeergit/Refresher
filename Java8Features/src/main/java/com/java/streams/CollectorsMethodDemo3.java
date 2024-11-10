package com.java.streams;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import com.java.model.Employee;
import com.java.model.Person;
import com.java.model.Student;
import com.java.myutility.MyUtility;

public class CollectorsMethodDemo3 {

	public static void main(String[] args) {
		List<Person> people = MyUtility.getPersons();
		List<Student> students = MyUtility.getStudents();
		List<Integer> intList = MyUtility.getIntegerList();
		List<Employee> employees = MyUtility.getEmployees();

		System.out.println("summarizingInt():----------------------------------------");
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

		System.out.println("summingInt():----------------------------------------");
		// Compute sum of salaries of employee
		Integer integer = people.stream().collect(Collectors.summingInt(Person::getAge));
		System.out.println(integer);

		System.out.println("toCollection():----------------------------------------");
		// Accumulate names into a TreeSet
		TreeSet<String> set = people.stream().map(p -> p.getName()).collect(Collectors.toCollection(TreeSet::new));
		System.out.println(set);

		System.out.println("toConcurrentMap():----------------------------------------");
		//if duplicate keys found then it throws IllegalStateException
		//in the below example same student name(keyMapper) can throw the exception, hence to avoid it 
		// provide the third argument(mergeFunction) as shown below to handle it.
		ConcurrentMap<String, Integer> concurrentMap = students.stream().distinct()
				.collect(Collectors.toConcurrentMap(Student::getName, Student::getMarks));
		System.out.println(concurrentMap);

		//if same Key appears with two different values then either max value or min value selected for the key.
		//same emp name with two different salaries(2nd arg) found then emp name(1st arg) with max value(3rd arg) will be selected
		ConcurrentMap<String, Double> concurrentMap2 = employees.stream()
				.collect(Collectors.toConcurrentMap(Employee::getName, Employee::getSal, Double::max));
		System.out.println(concurrentMap2);

		ConcurrentHashMap<String, Integer> concurrentHashMap = employees.stream().collect(
				Collectors.toConcurrentMap(Employee::getName, Employee::getAge, Integer::max, ConcurrentHashMap::new));
		System.out.println(concurrentHashMap);

		System.out.println("toList():----------------------------------------");
		// Accumulate names into a List
		List<String> list = people.stream().map(p -> p.getName()).collect(Collectors.toList());
		System.out.println(list);

		System.out.println("toMap():----------------------------------------");
		// Accumulate emp names vs emp LocPref into a Key, Value pair.
		//if duplicate keys found it will throw exception
		Map<String, Integer> map6 = employees.stream().distinct()
				.collect(Collectors.toMap(Employee::getName, Employee::getAge));
		System.out.println(map6);

		//creates a K,V pair with keys as employee names and values as emp salary
		//if same emp name with different values found, then emp name with max salary value considered(3rd arg)
		Map<String, Double> map = employees.stream()
				.collect(Collectors.toMap(e -> e.getName(), Employee::getSal, Double::max));
		System.out.println(map);

		//creates a K,V pair with keys as student names and values as student marks
		//if same key with different values found, then Key with max value considered(3rd arg)
		//key, value pairs will be sorted based on keys in natural sorting order
		TreeMap<String, Integer> treeMap = students.stream()
				.collect(Collectors.toMap(Student::getName, Student::getMarks, Integer::max, TreeMap::new));
		System.out.println(treeMap);

		System.out.println("toSet():----------------------------------------");
		// Accumulate names into a Set
		Set<String> set1 = people.stream().map(p -> p.getName()).collect(Collectors.toSet());
		System.out.println(set1);

	}

}
