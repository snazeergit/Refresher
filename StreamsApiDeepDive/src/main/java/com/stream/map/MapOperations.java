package com.stream.map;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.stream.model.Employee;
import com.stream.util.EmployeeUtil;

public class MapOperations {

	public static void main(String[] args) {
		List<Employee> employees = EmployeeUtil.getEmployees();

		//1. Department wise Employees count 
		Map<String, Long> map = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));
		System.out.println("1-> " + map);

		//2. Department wise Employees List
		Map<String, List<Employee>> map2 = employees.stream().collect(Collectors.groupingBy(Employee::getDeptName));
		System.out.println("2-> " + map2);

		//3. Department wise highest salary of the Emp
		System.out.println("3-> ");
		employees.stream()
				.collect(Collectors.groupingBy(Employee::getDeptName,
						Collectors.maxBy(Comparator.comparing(Employee::getSalary))))
				.forEach((dept, empList) -> System.out.println(dept + "->" + empList.get().getSalary()));

		//4. Department wise second highest salary of the Emp
		Map<String, Optional<Employee>> map3 = employees.stream()
				.collect((Collectors.groupingBy(Employee::getDeptName,
						Collectors.collectingAndThen(Collectors.toList(), empList -> empList.stream()
								.sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst()))));
		System.out.println(map3);

		//5. Department wise List of Emp in Ascending order
		Map<String, List<Employee>> map4 = employees.stream()
				.collect((Collectors.groupingBy(Employee::getDeptName,
						Collectors.collectingAndThen(Collectors.toList(), empList -> empList.stream()
								.sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList())))));
		System.out.println(map4);

		//6. Department wise List of Emp in Descending order
		Map<String, List<Employee>> map5 = employees.stream().collect((Collectors.groupingBy(Employee::getDeptName,
				Collectors.collectingAndThen(Collectors.toList(), empList -> empList.stream()
						.sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList())))));
		System.out.println(map5);

		

	}

}
