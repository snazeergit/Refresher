package com.stream.list;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import com.stream.model.Employee1;
import com.stream.util.EmployeeUtil;

public class StreamsPractise1 {

	public static void main(String[] args) {

		List<Employee1> list = EmployeeUtil.getEmployee1();

		System.out.println("---------1---------");
		//Query 3.1 : How many male and female employees are there in the organization?
		Map<String, Long> map = list.stream()
				.collect(Collectors.groupingBy(Employee1::getGender, Collectors.counting()));
		//approach:1
		map.forEach((k, v) -> System.out.println(k + " -> " + v));

		//approach:2
		Set<Entry<String, Long>> set = map.entrySet();
		for (Entry<String, Long> entry : set) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}

		System.out.println("---------2---------");

		//Query 3.2 : Print the name of all departments in the organization?
		list.stream().map(Employee1::getDepartment).collect(Collectors.toSet()).forEach(System.out::println);
		System.out.println("---------3---------");

		//Query 3.3 : What is the average age of male and female employees?
		Map<String, Double> map2 = list.stream()
				.collect(Collectors.groupingBy(Employee1::getGender, Collectors.averagingInt(Employee1::getAge)));
		map2.forEach((k, v) -> System.out.println(k + " -> " + v));
		System.out.println("---------4---------");

		//Query 3.4 : Get the details of highest paid employee in the organization?
		Employee1 employee1 = list.stream().max(Comparator.comparing(Employee1::getSalary)).get();
		System.out.println(employee1.getName() + " -> " + employee1.getSalary());
		System.out.println("---------5---------");

		//Query 3.5 : Get the names of all employees who have joined after 2015?
		List<Employee1> list2 = list.stream().filter(s -> s.getYearOfJoining() > 2015).collect(Collectors.toList());
		for (Employee1 employee12 : list2) {
			System.out.println(employee12.getName());
		}
		System.out.println("---------6---------");

		//Query 3.6 : Count the number of employees in each department?
		Map<String, Long> map3 = list.stream()
				.collect(Collectors.groupingBy(Employee1::getDepartment, Collectors.counting()));
		map3.forEach((k, v) -> System.out.println(k + " -> " + v));
		System.out.println("---------7---------");

		//Query 3.7 : What is the average salary of each department?
		Map<String, Double> map4 = list.stream().collect(
				Collectors.groupingBy(Employee1::getDepartment, Collectors.averagingDouble(Employee1::getSalary)));
		map4.forEach((k, v) -> System.out.println(k + " -> " + v));
		System.out.println("---------8---------");

		//Query 3.8 : Get the details of youngest male employee in the product development department?
		Employee1 employee12 = list.stream().filter(s -> s.getDepartment().equals("Product Development"))
				.filter(s -> s.getGender().equals("Male")).min(Comparator.comparing(Employee1::getAge)).get();
		System.out.println(employee12.getName() + " -> " + employee12.getAge() + " -> " + employee12.getGender()
				+ " -> " + employee12.getDepartment());
		System.out.println("---------9---------");

		//Query 3.9 : Who has the most working experience in the organization?
		Employee1 employee13 = list.stream().min(Comparator.comparing(Employee1::getYearOfJoining)).get();
		System.out.println(
				employee13.getName() + " -> " + (LocalDate.now().getYear() - employee13.getYearOfJoining()) + " yrs");
		System.out.println("---------10---------");

		//Query 3.10 : How many male and female employees are there in the sales and marketing team?
		Map<String, Long> map5 = list.stream().filter(s -> s.getDepartment().equalsIgnoreCase("Sales And Marketing"))
				.collect(Collectors.groupingBy(Employee1::getGender, Collectors.counting()));
		System.out.println(map5);
		System.out.println("---------11---------");

		//Query 3.11 : What is the average salary of male and female employees?
		Map<String, Double> map6 = list.stream()
				.collect(Collectors.groupingBy(Employee1::getGender, Collectors.averagingDouble(Employee1::getSalary)));
		System.out.println(map6);
		System.out.println("---------12---------");

		//Query 3.12 : List down the names of all employees in each department?
		//approach:1
		Map<String, List<String>> map7 = list.stream().collect(Collectors.groupingBy(Employee1::getDepartment,
				Collectors.mapping(Employee1::getName, Collectors.toList())));
		map7.forEach((k, v) -> System.out.println(k + " -> " + v));
		System.out.println();
		//approach:2
		Map<String, List<String>> map8 = list.stream().collect(
				Collectors.groupingBy(Employee1::getDepartment, Collectors.collectingAndThen(Collectors.toList(),
						list1 -> list1.stream().map(Employee1::getName).collect(Collectors.toList()))));
		map8.forEach((k, v) -> System.out.println(k + " -> " + v));
		System.out.println();
		Set<Entry<String, List<String>>> set2 = map8.entrySet();
		for (Entry<String, List<String>> entry : set2) {
			System.out.println(entry.getKey() + " : ");
			List<String> list3 = entry.getValue();
			list3.forEach(System.out::println);
		}
		System.out.println("---------13---------");

		//Query 3.13 : What is the average salary and total salary of the whole organization?
		DoubleSummaryStatistics statistics = list.stream().collect(Collectors.summarizingDouble(Employee1::getSalary));
		System.out.println(statistics.getAverage());
		System.out.println(statistics.getSum());
		System.out.println("---------14---------");

		//Query 3.14 : Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
		//approach:1
		List<Employee1> lt25 = list.stream().filter(e -> e.getAge() <= 25).collect(Collectors.toList());
		List<Employee1> gt25 = list.stream().filter(e -> e.getAge() > 25).collect(Collectors.toList());
		System.out.println("Employees having Age <= 25: ");
		for (Employee1 employee14 : lt25) {
			System.out.println(employee14.getName());
		}
		System.out.println();
		System.out.println("Employees having Age > 25: ");
		for (Employee1 employee14 : gt25) {
			System.out.println(employee14.getName());
		}
		System.out.println();
		//approach:2
		Map<Boolean, List<Employee1>> map9 = list.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 25));
		Set<Entry<Boolean, List<Employee1>>> set3 = map9.entrySet();
		for (Entry<Boolean, List<Employee1>> entry : set3) {
			if (entry.getKey()) {
				System.out.println("Employees having Age > 25: ");
			} else {
				System.out.println("Employees having Age <= 25: ");
			}

			for (Employee1 employee14 : entry.getValue()) {
				System.out.println(employee14.getName());
			}
			System.out.println();
		}
		System.out.println("---------15---------");

		//Query 3.15 : Who is the oldest employee in the organization? What is his age and which department he belongs to?	
		Employee1 employee14 = list.stream().max(Comparator.comparing(Employee1::getAge)).get();
		System.out.println(employee14.getName() + " -> " + employee14.getAge() + " -> " + employee14.getDepartment());
		System.out.println("--------- THE END ---------");
	}

}
