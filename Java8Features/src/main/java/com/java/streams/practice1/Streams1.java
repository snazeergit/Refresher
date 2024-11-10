package com.java.streams.practice1;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.java.model.Employee;
import com.java.myutility.MyUtility;

public class Streams1 {

	public static void main(String[] args) {
		List<Employee> list = MyUtility.getEmployees();
		//Dept wise emp count, names, highest salrary, second highest salary, salary in descending and ascending

		Map<String, Long> map = list.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println("1. Dept wise count	:" + map);
		map.forEach((k, v) -> {
			System.out.println("	" + k + " : " + v);
		});

		Map<String, List<Employee>> map2 = list.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println("2. Dept wise empNames	:" + map2);
		map2.forEach((k, vList) -> {
			System.out.println("	" + k + " : ");
			for (Employee employee : vList) {
				System.out.println("		" + employee.getName());
			}
		});

		Map<String, Employee> map3 = list.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(Collectors.toList(),
						list11 -> list11.stream().max(Comparator.comparing(Employee::getSal)).get())));
		System.out.println("3. Dept wise high sal	:" + map3);
		map3.forEach((k, v) -> {
			System.out.println("	" + k + "	: " + v.getName() + "(" + v.getSal() + ")");
		});

		Map<String, Employee> map4 = list.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,
						Collectors.collectingAndThen(Collectors.toList(), list22 -> list22.stream()
								.sorted(Comparator.comparing(Employee::getSal).reversed()).skip(1).findFirst().get())));
		System.out.println("4. Dept wise 2nd high sal	:" + map4);
		map4.forEach((k, v) -> {
			System.out.println("	" + k + " : " + v.getName() + "(" + v.getSal() + ")");
		});

		Map<String, List<Employee>> map5 = list.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,
						Collectors.collectingAndThen(Collectors.toList(), list22 -> list22.stream()
								.sorted(Comparator.comparing(Employee::getSal)).collect(Collectors.toList()))));
		System.out.println("5. Dept wise sal ascending	:" + map5);
		map5.forEach((k, vList) -> {
			System.out.println("	" + k + " : ");
			for (Employee employee : vList) {
				System.out.println("		" + employee.getName() + "(" + employee.getSal() + ")");
			}
		});

		Map<String, List<Employee>> map6 = list.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,
						Collectors.collectingAndThen(Collectors.toList(),
								list22 -> list22.stream().sorted(Comparator.comparing(Employee::getSal).reversed())
										.collect(Collectors.toList()))));
		System.out.println("6. Dept wise sal descending	:" + map6);
		map6.forEach((k, vList) -> {
			System.out.println("	" + k + " : ");
			for (Employee employee : vList) {
				System.out.println("		" + employee.getName() + "(" + employee.getSal() + ")");
			}
		});

		//Dept wise avg sal
		Map<String, Double> map7 = list.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSal)));
		System.out.println("7. Dept wise avg sal :" + map7);
		map7.forEach((k, v) -> {
			System.out.println("		" + k + " : " + v);
		});

		//Dept wise avg sal sorting desc
		LinkedHashMap<String, Double> map8 = list.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSal)))
				.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors
						.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldV, newV) -> oldV, LinkedHashMap::new));
		System.out.println("8. Dept wise avr sal in sorting :" + map8);
		map8.forEach((k, v) -> {
			System.out.println("		" + k + " : " + v);
		});
	}

}
