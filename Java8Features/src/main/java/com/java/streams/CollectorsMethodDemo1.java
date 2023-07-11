package com.java.streams;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;

import com.java.myutility.MyUtility;
import com.java.pojo.Employee;
import com.java.pojo.Person;

public class CollectorsMethodDemo1 {

	public static void main(String[] args) {
		List<Person> people = MyUtility.getPersons();
		List<Employee> employees = MyUtility.getEmployees();

		System.out.println("averagingDouble():----------------------------------------");

		Double double1 = people.stream().collect(Collectors.averagingInt(Person::getAge));
		System.out.println(double1);

		Double double2 = employees.stream().collect(Collectors.averagingDouble(Employee::getSal));
		System.out.println(double2);

		System.out.println("collectingAndThen():----------------------------------------");
		//This method is most commonly used for creating immutable collections.
		//A List can contain duplicates, but a Set can't.
		//A List will preserve the order of insertion, but a Set may or may not.
		//Since insertion order may not be maintained in a Set, it doesn't allow index-based access as in the List.
		//Please note that there are a few implementations of the Set interface which maintain order, for example, LinkedHashSet.
		List<Person> list2 = people.stream().filter(p -> p.getAge() > 30)
				.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
		System.out.println(list2);

		//A Set maintains order depending on the implementation. For example, a HashSet is not guaranteed to preserve order, but a LinkedHashSet is.
		//By default Collectors.toSet() internally implemented using HashSet so even if we try to collect sorted elements, HashSet can return them in any order. 
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

		System.out.println("count():----------------------------------------");
		Long count = people.stream().map(p -> p.getName()).collect(Collectors.counting());
		System.out.println(count);

		System.out.println("groupingBy():----------------------------------------");
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

		System.out.println("groupingByConcurrent():----------------------------------------");
		ConcurrentMap<String, List<Employee>> concurrentMap1 = employees.stream()
				.collect(Collectors.groupingByConcurrent(e -> e.getDepartment()));
		System.out.println(concurrentMap1);
		ConcurrentMap<String, Set<Employee>> concurrentMap2 = employees.stream()
				.collect(Collectors.groupingByConcurrent(e -> e.getDepartment(), Collectors.toSet()));
		System.out.println(concurrentMap2);
		ConcurrentMap<String, Set<Employee>> concurrentMap3 = employees.stream().collect(Collectors
				.groupingByConcurrent(e -> e.getDepartment(), ConcurrentSkipListMap::new, Collectors.toSet()));
		System.out.println(concurrentMap3);

		System.out.println("joining():----------------------------------------");
		// Convert elements to strings and concatenate them, separated by commas
		String string1 = people.stream().map(p -> p.getName()).collect(Collectors.joining());
		String string2 = people.stream().map(p -> p.getName()).collect(Collectors.joining(","));
		String string3 = people.stream().map(p -> p.getName()).collect(Collectors.joining(",", "E", "N"));
		System.out.println(string1);
		System.out.println(string2);
		System.out.println(string3);

	}

}
