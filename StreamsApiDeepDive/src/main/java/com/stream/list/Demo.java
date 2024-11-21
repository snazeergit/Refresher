package com.stream.list;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import com.stream.model.Employee;
import com.stream.util.EmployeeUtil;

public class Demo {

	public static void main(String[] args) {

		List<Employee> employees = EmployeeUtil.getEmployees();

		//Question 1: Grouping Employees by City
		Map<String, List<Employee>> map = employees.stream().collect(Collectors.groupingBy(Employee::getCity));
		System.out.println("1-> " + map);

		//Question 2: Grouping Employees by Age
		Map<Integer, List<Employee>> map1 = employees.stream().collect(Collectors.groupingBy(Employee::getAge));
		System.out.println("2-> " + map1);

		//Question 3: Finding the Count of Male and Female Employees
		Map<String, Long> map2 = employees.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println("3-> " + map2);

		//Question 4: Printing Names of All Departments
		long count = employees.stream().map(Employee::getDeptName).distinct().count();
		System.out.println("4-> " + count);

		//Question 5: Printing Employee Details by Age Criteria
		Map<Integer, List<Employee>> map3 = employees.stream().collect(Collectors.groupingBy(Employee::getAge));
		System.out.println("5-> " + map3);
		Map<Integer, List<String>> map4 = employees.stream().collect(
				Collectors.groupingBy(Employee::getAge, Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println("5-> " + map4);

		//Question 6: Finding Maximum Age of Employee
		Employee employee = employees.stream().max(Comparator.comparing(Employee::getAge)).get();
		System.out.println("6-> " + employee);

		//Question 7: Printing Average Age of Male and Female Employees
		Map<String, Double> map5 = employees.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
		System.out.println("7-> " + map5);

		//Question 8: Printing the Number of Employees in Each Department
		Map<String, Long> map6 = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));
		System.out.println("8-> " + map6);

		//Question 9: Finding the Oldest Employee
		Employee employee2 = employees.stream().max(Comparator.comparing(Employee::getAge)).get();
		System.out.println("9-> " + employee2);

		//Question 10: Finding the Youngest Female Employee
		Employee employee3 = employees.stream().filter(e -> e.getGender().equals("F"))
				.min(Comparator.comparing(Employee::getAge)).get();
		System.out.println("10-> " + employee3);

		//Question 11: Finding Employees by Age Range
		List<Employee> list = employees.stream().filter(e -> e.getAge() > 20 & e.getAge() < 25)
				.collect(Collectors.toList());
		System.out.println("11-> " + list);

		//Question 12: Finding Department with Highest Number of Employees
		Entry<String, Long> entry = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting())).entrySet().stream()
				.max(Comparator.comparing(Map.Entry::getValue)).get();
		System.out.println("12->" + entry);

		//Question 13: Find if there are any employees from the HR Department
		List<Employee> list2 = employees.stream().filter(e -> e.getDeptName() == "HR").collect(Collectors.toList());
		System.out.println("13->" + list2);

		//Question 14: Finding Departments with Over 3 Employees
		List<String> list3 = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting())).entrySet().stream()
				.filter(m -> m.getValue() > 3).map(m -> m.getKey()).collect(Collectors.toList());
		System.out.println("14->" + list3);

		//Question 15: Finding Distinct Department Names
		List<String> list4 = employees.stream().map(e -> e.getDeptName()).distinct().collect(Collectors.toList());
		System.out.println("15->" + list4);

		//Question 16: Finding and Sorting Employees by City
		List<Employee> list5 = employees.stream().sorted(Comparator.comparing(Employee::getCity))
				.collect(Collectors.toList());
		System.out.println("16->" + list5);

		//Question 17: Counting the Number of Employees in the Organization
		System.out.println("17->" + employees.stream().count());

		//Question 18: Finding Employee Count in Every Department
		Map<String, Long> map7 = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));
		System.out.println("18->" + map7);

		//Question 19: Finding Department with the Highest Number of Employees
		LinkedHashMap<String, Long> map8 = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting())).entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors
						.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldVal, newVal) -> oldVal, LinkedHashMap::new));
		System.out.println("19->" + map8);

		//Question 20: Sorting Employees by Name and Age
		List<Employee> list6 = employees.stream().sorted(Comparator.comparing(Employee::getName))
				.collect(Collectors.toList());
		System.out.println("20->" + list6);

		//Question 21: Finding the Highest Experienced Employee
		Employee employee4 = employees.stream().max(Comparator.comparing(Employee::getYearOfJoining)).get();
		System.out.println("21->" + employee4);

		//Question 22: Printing Average and Total Salary of the Organization
		System.out.println("22->" + employees.stream().collect(Collectors.averagingLong(Employee::getSalary)));
		System.out.println("22->" + employees.stream().collect(Collectors.summingLong(Employee::getSalary)));

		//Question 23: Printing Average Salary of Each Department
		Map<String, Double> map9 = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDeptName, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("23->" + map9);

		//Question 24: Finding the Highest Salary in the Organization
		Employee employee7 = employees.stream().max(Comparator.comparing(Employee::getSalary)).get();
		System.out.println("24->" + employee7.getName() + "-->" + employee7.getSalary());

		//Question 25: Finding the Second Highest Salary in the Organization
		System.out.println("25->" + employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
				.skip(1).findFirst().get().getSalary());

		//Question 26: Finding the Nth Highest Salary with emp name in the Organization
		Entry<Long, List<String>> entry2 = employees.stream()
				.collect(Collectors.groupingBy(Employee::getSalary, Collectors.mapping(Employee::getName, Collectors.toList())))
				.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldV, newV) -> oldV, LinkedHashMap::new))
				.entrySet().stream().skip(1).findFirst().get();
		System.out.println("26->" + entry2);

		//Question 27: Finding the Highest Paid Salary in the Organization Based on Gender
		Employee employee5 = employees.stream().filter(e -> e.getGender() == "F")
				.max(Comparator.comparing(Employee::getSalary)).get();
		System.out.println("27->" + employee5);

		//Question 28: Finding the Lowest Paid Salary in the Organization Based on Gender
		Employee employee6 = employees.stream().filter(e -> e.getGender() == "M")
				.min(Comparator.comparing(Employee::getSalary)).get();
		System.out.println("28->" + employee6);

		//Question 29: Sorting Employees' Salary in Ascending Order
		LinkedHashMap<Long, List<String>> map10 = employees.stream()
				.collect(Collectors.groupingBy(Employee::getSalary,
						Collectors.mapping(Employee::getName, Collectors.toList())))
				.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey,
						Map.Entry::getValue, (oldV, newV) -> oldV, LinkedHashMap::new));
		System.out.println("29->" + map10);

		//Question 30: Sorting Employees' Salary in Descending Order:
		LinkedHashMap<Long, List<String>> map11 = employees.stream()
				.collect(Collectors.groupingBy(Employee::getSalary,
						Collectors.mapping(Employee::getName, Collectors.toList())))
				.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).collect(Collectors
						.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldV, newV) -> oldV, LinkedHashMap::new));
		System.out.println("30->" + map11);

		//Question 31: Finding the Highest Salary Based on Department:
		Map<String, Optional<Employee>> map12 = employees.stream().collect(Collectors.groupingBy(Employee::getDeptName,
				Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
		System.out.println("31->" + map12);

		map12.forEach((dept, emp) -> System.out.println(dept + "-->" + emp.get().getSalary()));

		//Question 32: Printing the List of Employee's Second Highest Salary Record Based on Department:
		//TODO Learning
		Map<String, Employee> map13 = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDeptName,
						Collectors.collectingAndThen(Collectors.toList(), elist -> elist.stream()
								.sorted(Comparator.comparing(Employee::getSalary)).skip(1).findFirst().get())));
		System.out.println("32->" + map13);
		//Question 33: Sorting the Employees' Salary in Each Department in Ascending Order:
		Map<String, List<Employee>> map14 = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDeptName,
						Collectors.collectingAndThen(Collectors.toList(), elist -> elist.stream()
								.sorted(Comparator.comparingLong(Employee::getSalary)).collect(Collectors.toList()))));
		System.out.println("33->" + map14);
		map14.forEach((dept, listOfEmp) -> {
			System.out.println(dept + ": ");
			listOfEmp.forEach(System.out::println);
		});

		//Question 34: Sorting the Employees' Salary in Each Department in Descending Order:
		Map<String, List<Employee>> map15 = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDeptName,
						Collectors.collectingAndThen(Collectors.toList(),
								empList -> empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
										.collect(Collectors.toList()))));
		System.out.println("34->" + map15);

		map15.forEach((dept, empList) -> {
			System.out.println(dept + " : ");
			empList.forEach(System.out::println);
		});
	}

}