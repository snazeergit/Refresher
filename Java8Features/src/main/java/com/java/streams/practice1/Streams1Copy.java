package com.java.streams.practice1;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.java.model.Employee;
import com.java.myutility.MyUtility;

public class Streams1Copy {

	public static void main(String[] args) {
		List<Employee> list = MyUtility.getEmployees();
		//Dept wise emp count, 
		Map<String, Long> map = list.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println("1. Dept wise count	:");
		map.forEach((dept, count) -> {
			System.out.println(dept + "	:	" + count);
		});

		//Dept wise emp names, 
		Map<String, List<Employee>> map2 = list.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println("2. Dept wise empNames	:");
		map2.forEach((dept, emps) -> {
			System.out.println(dept + "	:	");
			for (Employee emp : emps) {
				System.out.println(emp.getName());
			}
		});

		//Dept wise emp highest salrary, 
		Map<String, Optional<Employee>> map3 = list.stream().collect(Collectors.groupingBy(Employee::getDepartment,
				Collectors.maxBy(Comparator.comparing(Employee::getSal))));
		System.out.println("3. Dept wise high sal	:");
		map3.forEach((dept, oEmps) -> {
			System.out.println(dept + "	:	" + oEmps.get().getName() + "(" + oEmps.get().getSal() + ")");

		});

		//Dept wise emp second highest salary, 
		Map<String, Employee> map4 = list.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(
						Collectors.toList(),
						l -> l.stream().sorted(Comparator.comparing(Employee::getSal).reversed()).skip(1).findFirst().get())));
		System.out.println("4. Dept wise 2nd high sal	:");
		map4.forEach((dept, emp) -> {
			System.out.println(dept + "	:	" + emp.getName() + "(" + emp.getSal() + ")");
		});

		//Dept wise emp salary in ascending
		Map<String, List<Employee>> map5 = list.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(
						Collectors.toList(),
						l -> l.stream().sorted(Comparator.comparing(Employee::getSal)).collect(Collectors.toList()))));
		System.out.println("5. Dept wise sal ascending	:");
		map5.forEach((dept, emps) -> {
			System.out.println(dept + "	:");
			for (Employee emp : emps) {
				System.out.println(emp.getName() + "(" + emp.getSal() + ")");
			}

		});
		//Dept wise emp salary in descending
		Map<String, List<Employee>> map6 = list.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,
						Collectors.collectingAndThen(Collectors.toList(),
								l -> l.stream().sorted(Comparator.comparing(Employee::getSal).reversed())
										.collect(Collectors.toList()))));

		System.out.println("6. Dept wise sal descending	:");
		map6.forEach((dept, emps) -> {
			System.out.println(dept + "	:");
			for (Employee emp : emps) {
				System.out.println(emp.getName() + "(" + emp.getSal() + ")");
			}

		});
		//Dept wise avg sal
		Map<String, Double> map7 = list.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSal)));
		System.out.println("7. Dept wise avg sal	:");
		map7.forEach((dept, sal) -> {
			System.out.println(dept + "	:	" + sal);
		});

		//Dept wise avg sal sorting desc
		LinkedHashMap<String, Double> map8 = list.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSal)))
				.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey,
						Map.Entry::getValue, (newK, newV) -> newK, LinkedHashMap::new));
		System.out.println("8. Dept wise avg sal sorting desc	:");
		map8.forEach((dept, Sal) -> {
			System.out.println(dept + "	:	" + Sal);
		});

	}

}
