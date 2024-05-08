package com.java.streams;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.java.myutility.MyUtility;
import com.java.pojo.Employee;

public class FetchDuplicateElements {

	public static void main(String[] args) {
		mapDemo();
		//empDemo();
	}

	public static void empDemo() {
		List<Employee> empList = MyUtility.getEmployees();

		Set<String> set = empList.stream().map(e -> e.getName()).sorted().collect(Collectors.toSet());
		set.forEach(System.out::println);

		empList.stream().peek(e -> e.getAge()).peek(System.out::println).collect(Collectors.toList());
	}

	public static void mapDemo() {
		List<String> list = List.of("Durian", "Durian", "Banana", "Apple", "Apple", "Carrot");
		//Approach-1
		HashSet<String> uniqueNames = new HashSet<>();
		Set<String> duplicateNames = list.stream().filter(name -> !uniqueNames.add(name)).collect(Collectors.toSet());
		System.out.println(duplicateNames);
		System.out.println(uniqueNames);
		System.out.println("------------------------------");

		
		//Approach-2
		//Arranging List into Map with names as key and name's frequency(no. of times repeated) as value
		//Function.identity() returns a Function that returns the input argument as output
		//Collectors.counting(), returns the no of times name is repeated
		Map<String, Long> map = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Set<Entry<String, Long>> entrySet = map.entrySet();
		System.out.println(entrySet);

		//fetching name that repeated more than once 
		Set<String> dupliNames = entrySet.stream().filter(entry -> entry.getValue() > 1).map(entry -> entry.getKey())
				.collect(Collectors.toSet());
		System.out.println(dupliNames);

		Set<String> uniqNames = entrySet.stream().map(entry -> entry.getKey()).collect(Collectors.toSet());
		System.out.println(uniqNames);
		System.out.println("------------------------------");

		
		//Approach-3
		//COllectins.frequency method search for a given name in the list and returns the frequency of the given name  
		HashSet<String> duplicateNames1 = list.stream().filter(name -> Collections.frequency(list, name) > 1)
				.collect(Collectors.toCollection(HashSet::new));
		System.out.println(duplicateNames1);
		//Elements in TreeSet will sorted in natural sorting order
		TreeSet<String> uniqueNames1 = list.stream().collect(Collectors.toCollection(TreeSet::new));
		System.out.println(uniqueNames1);
	}
}