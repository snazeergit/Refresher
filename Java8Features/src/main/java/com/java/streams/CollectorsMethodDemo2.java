package com.java.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import com.java.myutility.MyUtility;
import com.java.pojo.Employee;
import com.java.pojo.Student;

public class CollectorsMethodDemo2 {

	public static void main(String[] args) {
		List<Student> students = MyUtility.getStudents();
		List<Integer> intList = MyUtility.getIntegerList();
		List<Employee> employees = MyUtility.getEmployees();

		System.out.println("mapping():--------------------------------");
		Set<String> set3 = employees.stream().collect(Collectors.mapping(e -> e.getDepartment(), Collectors.toSet()));
		System.out.println(set3);
		Map<String, Set<String>> map4 = employees.stream().collect(Collectors.groupingBy(e -> e.getName(),
				Collectors.mapping(e -> e.getDepartment(), Collectors.toSet())));
		System.out.println(map4);

		System.out.println("maxBy():--------------------------------");
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

		System.out.println("minBy():--------------------------------");
		//minBy(Comparator.reverseOrder) gives max number
		//minBy(Comparator.naturalOrder) gives min number
		Optional<Double> optional3 = employees.stream().map(e -> e.getSal())
				.collect(Collectors.minBy(Comparator.naturalOrder()));
		System.out.println(optional3.get());
		Optional<Employee> optional4 = employees.stream()
				.collect(Collectors.minBy(Comparator.comparingDouble(e -> e.getSal())));
		System.out.println(optional4.get().getSal());

		System.out.println("partitioningBy():--------------------------------");
		// Partition students into passing and failing
		Map<Boolean, List<Student>> map = students.stream().collect(Collectors.partitioningBy(s -> s.getMarks() > 30));
		System.out.println(map);

		Map<Boolean, List<Employee>> map5 = employees.stream().sorted(Comparator.comparing(Employee::getSal))
				.collect(Collectors.partitioningBy(e -> e.getGender() == "male"));
		System.out.println(map5);

		Map<Boolean, Set<Employee>> map7 = employees.stream()
				.collect(Collectors.partitioningBy(e -> e.getAge() < 30, Collectors.toSet()));
		System.out.println(map7);

		System.out.println("reducing():--------------------------------");
		Optional<Integer> optional5 = intList.stream().collect(Collectors.reducing((n1, n2) -> n1 * n2));
		System.out.println(optional5.get());
		Map<String, Optional<Student>> map8 = students.stream().collect(Collectors.groupingBy(s -> s.getName(),
				Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Student::getMarks)))));
		System.out.println(map8);

		Integer integer2 = intList.stream().collect(Collectors.reducing(0, (n1, n2) -> n1 + n2));
		System.out.println(integer2);
		Map<String, Student> map9 = students.stream().collect(
				Collectors.groupingBy(Student::getName, Collectors.reducing(new Student("", 0, 0, new String[1]),
						BinaryOperator.maxBy(Comparator.comparing(Student::getMarks)))));
		System.out.println(map9);

		Integer integer3 = intList.stream().collect(Collectors.reducing(0, n -> n * n, Integer::sum));
		System.out.println(integer3);
		Integer integer4 = students.stream().collect(Collectors.reducing(1, Student::getAge, Integer::max));
		System.out.println(integer4);
		//reducing() method 3rd argument performs operation on second arguments result
		//2nd argument result returns Stream<Integer), in 3rd argument we are taking 
		//each integer and checking with another integer to return max integer as its maxBy() 
		Integer integer5 = students.stream().collect(
				Collectors.reducing(0, Student::getMarks, BinaryOperator.maxBy(Comparator.comparingInt(mark -> mark))));
		System.out.println(integer5);

	}

}
