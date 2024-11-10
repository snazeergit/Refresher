package com.java.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.java.model.Employee;
import com.java.myutility.MyUtility;

public class StreamsMethodDemo3 {

	public static void main(String[] args) {
		List<Employee> employees = MyUtility.getEmployees();

		//Fetch the employees based on their salary in descending order
		employees.stream().sorted((e1, e2) -> -e1.getSal().compareTo(e2.getSal())).forEach(System.out::println);
		List<Employee> list = employees.stream().sorted(Comparator.comparing(Employee::getSal).reversed())
				.collect(Collectors.toList());
		for (Employee employee : list) {
			System.out.println(employee.getName() + "	->	" + employee.getSal());
		}
		System.out.println("---------------------------");

		//Fetch the top 3 salaried employees in descending order
		employees.stream().sorted((e1, e2) -> -e1.getSal().compareTo(e2.getSal())).limit(3)
				.forEach(System.out::println);

		List<Employee> list2 = employees.stream().sorted(Comparator.comparing(Employee::getSal).reversed()).limit(3)
				.collect(Collectors.toList());
		for (Employee employee : list2) {
			System.out.println(employee.getName() + "->" + employee.getSal());
		}

		System.out.println("-- sorted(-) --");
		employees.stream().map(e -> e.getSal()).sorted(Comparator.reverseOrder()).distinct()
				.forEach(System.out::println);

		Map<Double, List<String>> map = employees.stream()
				.collect(Collectors.groupingBy(Employee::getSal,
						Collectors.mapping(Employee::getName, Collectors.toList())))
				.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).collect(Collectors
						.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldV, newV) -> oldV, LinkedHashMap::new));
		System.out.println(map);
		for (Map.Entry<Double, List<String>> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : ");

			List<String> list3 = entry.getValue();
			list3.forEach(System.out::println);
		}

		System.out.println("---");

		//Fetch the bottom 3 salaried employees in descending order
		employees.stream().sorted((e1, e2) -> e1.getSal().compareTo(e2.getSal())).limit(3).forEach(System.out::println);
		System.out.println("---------------------------");

		//Fetch female employees whose salary in range from 30000 to 50000 descending order
		employees.stream().filter(e -> e.getSal() >= 30000.00 && e.getSal() <= 50000 && e.getGender() == "female")
				.sorted((e1, e2) -> -e1.getSal().compareTo(e2.getSal())).forEach(System.out::println);

		List<Integer> list1 = Arrays.asList(11, 33, 44, 21);
		Integer integer = list1.stream().filter(n -> n % 2 == 0).reduce(0, (ans, i) -> ans + i);

		System.out.println(integer);

		employees.stream().filter(e -> e.getAge() < 30).sorted((e1, e2) -> e1.getSal().compareTo(e2.getSal()))
				.collect(Collectors.toSet()).forEach(System.out::println);
		System.out.println();

		employees.stream().filter(e -> e.getAge() < 30).sorted(Comparator.comparingInt(Employee::getAge))
				.collect(Collectors.toSet()).forEach(System.out::println);
		System.out.println();

		employees.stream().distinct().sorted(Comparator.comparing(Employee::getAge)).collect(Collectors.toList())
				.forEach(System.out::println);
		System.out.println("---------------------------");

	}
}
