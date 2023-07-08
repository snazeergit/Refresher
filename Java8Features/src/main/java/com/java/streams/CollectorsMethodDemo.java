package com.java.streams;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.java.myutility.MyUtility;
import com.java.pojo.Employee;
import com.java.pojo.Person;
import com.java.pojo.Student;

public class CollectorsMethodDemo {

	public static void main(String[] args) {
		List<Person> people = MyUtility.getPersons();
		List<Student> students = MyUtility.getStudents();

		System.out.println("averagingDouble():----");

		System.out.println("collectingAndThen():----");
		//This method is most commonly used for creating immutable collections.
		//A List can contain duplicates, but a Set can't.
		//A List will preserve the order of insertion, but a Set may or may not.
		//Since insertion order may not be maintained in a Set, it doesn't allow index-based access as in the List.
		//Please note that there are a few implementations of the Set interface which maintain order, for example, LinkedHashSet.
		List<Person> list2 = people.stream().filter(p -> p.getAge() > 30)
				.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
		System.out.println(list2);

		//A Set maintains order depending on the implementation. For example, a HashSet is not guaranteed to preserve order, but a LinkedHashSet is. 
		Set<Person> set2 = people.stream().filter(p -> p.getAge() < 30).distinct()
				.sorted(Comparator.comparing(Person::getAge)).collect(Collectors
						.collectingAndThen(Collectors.toCollection(LinkedHashSet::new), Collections::unmodifiableSet));
		System.out.println(set2);

		
		//There are two interfaces for implementing Map in java: Map and SortedMap, and three classes: HashMap, LinkedHashMap, and TreeMap.
		//A Map doesn't allow duplicate keys, but you can have duplicate values. HashMap and LinkedHashMap allow null keys and values, 
		//but TreeMap doesn't allow any null key or value.
		Map<String, List<String>> map2 = people.stream().filter(p -> p.getAge() < 27)
				.collect(Collectors.collectingAndThen(Collectors.toMap(p -> p.getName(), p -> p.getLocationPref()),
						Collections::unmodifiableMap));
		System.out.println(map2);

		System.out.println("count():----");
		Long count = people.stream().map(p -> p.getName()).collect(Collectors.counting());
		System.out.println(count);

		System.out.println("groupingBy():----");
		List<Employee> employees = MyUtility.getEmployees();
		// Group employees by department
		Map<String, List<Employee>> map1 = employees.stream().collect(Collectors.groupingBy(e -> e.getDepartment()));
		System.out.println(map1);
		// Group unique employees by department
		Map<String, Set<Employee>> map3 = employees.stream()
				.collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.toSet()));
		System.out.println(map3);
		// Group unique employees by department and departments in sorted order
		TreeMap<String, Set<Employee>> treemap = employees.stream()
				.collect(Collectors.groupingBy(e -> e.getDepartment(), TreeMap::new, Collectors.toSet()));
		System.out.println(treemap);

		System.out.println("groupingByConcurrent():----");
		ConcurrentMap<String, List<Employee>> concurrentMap1 = employees.stream()
				.collect(Collectors.groupingByConcurrent(e -> e.getDepartment()));
		System.out.println(concurrentMap1);
		ConcurrentMap<String, Set<Employee>> concurrentMap2 = employees.stream()
				.collect(Collectors.groupingByConcurrent(e -> e.getDepartment(), Collectors.toSet()));
		System.out.println(concurrentMap2);
		ConcurrentMap<String, Set<Employee>> concurrentMap3 = employees.stream().collect(Collectors
				.groupingByConcurrent(e -> e.getDepartment(), ConcurrentSkipListMap::new, Collectors.toSet()));
		System.out.println(concurrentMap3);

		System.out.println("joining():----");
		// Convert elements to strings and concatenate them, separated by commas
		String string1 = people.stream().map(p -> p.getName()).collect(Collectors.joining());
		String string2 = people.stream().map(p -> p.getName()).collect(Collectors.joining(","));
		String string3 = people.stream().map(p -> p.getName()).collect(Collectors.joining(",", "E", "N"));
		System.out.println(string1);
		System.out.println(string2);
		System.out.println(string3);

		System.out.println("mapping():----");
		Set<String> set3 = employees.stream().collect(Collectors.mapping(e -> e.getDepartment(), Collectors.toSet()));
		System.out.println(set3);
		Map<String, Set<String>> map4 = employees.stream().collect(Collectors.groupingBy(e -> e.getName(),
				Collectors.mapping(e -> e.getDepartment(), Collectors.toSet())));
		System.out.println(map4);

		System.out.println("maxBy():----");
		//maxBy(Comparator.naturalOrder) gives max number
		//maxBy(Comparator.reverseOrder) gives min number
		Optional<Employee> optional = employees.stream()
				.collect(Collectors.maxBy(Comparator.comparing(e -> e.getSal())));
		System.out.println(optional.get().getSal());
		Optional<Employee> optional1 = employees.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSal)));
		System.out.println(optional1.get().getSal());
		Optional<Double> optional2 = employees.stream().map(e -> e.getSal())
				.collect(Collectors.maxBy(Comparator.naturalOrder()));
		System.out.println(optional2.get());

		System.out.println("minBy():----");
		//minBy(Comparator.reverseOrder) gives max number
		//minBy(Comparator.naturalOrder) gives min number
		Optional<Double> optional3 = employees.stream().map(e -> e.getSal())
				.collect(Collectors.minBy(Comparator.naturalOrder()));
		System.out.println(optional3.get());
		Optional<Employee> optional4 = employees.stream()
				.collect(Collectors.minBy(Comparator.comparingDouble(e -> e.getSal())));
		System.out.println(optional4.get().getSal());

		System.out.println("partitioningBy():----");
		// Partition students into passing and failing
		Map<Boolean, List<Student>> studentPartitioning = students.stream()
				.collect(Collectors.partitioningBy(s -> s.getMarks() > 30));
		System.out.println(studentPartitioning);

		System.out.println("reducing():----");

		System.out.println("summarizingInt():----");

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
		Map<String, List<String>> map = people.stream()
				.collect(Collectors.toMap(e -> e.getName(), e -> e.getLocationPref()));
		System.out.println(map);

		System.out.println("toSet():----");
		// Accumulate names into a Set
		Set<String> set1 = people.stream().map(p -> p.getName()).collect(Collectors.toSet());
		System.out.println(set1);

	}

}
