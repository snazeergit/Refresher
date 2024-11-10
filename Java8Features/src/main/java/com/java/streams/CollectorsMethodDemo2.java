package com.java.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import com.java.model.Employee;
import com.java.model.Student;
import com.java.myutility.MyUtility;

public class CollectorsMethodDemo2 {

	public static void main(String[] args) {
		List<Student> students = MyUtility.getStudents();
		List<Integer> intList = MyUtility.getIntegerList();
		List<Employee> employees = MyUtility.getEmployees();
		System.out.println(intList);

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
		Integer integer = intList.stream().collect(Collectors.reducing((n1, n2) -> n1 * n2)).get();
		System.out.println(integer);

		Map<String, Optional<Student>> map8 = students.stream().collect(Collectors.groupingBy(Student::getDeptName,
				Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Student::getMarks)))));
		for (Entry<String, Optional<Student>> entry : map8.entrySet()) {
			System.out.println(entry.getKey() + "	:	" + entry.getValue().get().getName() + "	->"
					+ entry.getValue().get().getMarks());
		}

		Integer integer2 = intList.stream().collect(Collectors.reducing(0, (n1, n2) -> n1 + n2));
		System.out.println(integer2);

		Map<String, Student> map9 = students.stream()
				.collect(Collectors.groupingBy(Student::getDeptName,
						Collectors.reducing(new Student("", 0, 0, "", new String[1]),
								BinaryOperator.maxBy(Comparator.comparing(Student::getMarks)))));
		for (Entry<String, Student> entry : map9.entrySet()) {
			System.out.println(
					entry.getKey() + "	:	" + entry.getValue().getName() + "	-> " + entry.getValue().getMarks());
		}

		Integer integer3 = intList.stream().collect(Collectors.reducing(0, n -> n * n, Integer::sum));
		System.out.println(integer3);

		Integer integer4 = students.stream().collect(Collectors.reducing(1, Student::getAge, Integer::max));
		System.out.println(integer4);

		//group first charactor in a employee name vs longest employee name starts with that charector
		Map<Character, Optional<Employee>> map2 = employees.stream()
				.collect(Collectors.groupingBy(e -> new Character(e.getName().charAt(0)),
						Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getName)))));
		for (Map.Entry<Character, Optional<Employee>> entry : map2.entrySet()) {
			System.out.println(entry.getKey() + "	-> " + entry.getValue().get().getName());
		}

		//reducing() method 3rd argument performs operation on second arguments result
		//2nd argument result returns Stream<Integer), in 3rd argument we are taking 
		//each integer and checking with another integer to return max integer as its maxBy() 
		Integer integer5 = students.stream().collect(Collectors.reducing(0, Student::getMarks,
				BinaryOperator.maxBy(Comparator.comparingInt(marks -> marks))));
		System.out.println(integer5);

		//sum of all student marks
		Integer integer6 = students.stream().collect(Collectors.reducing(0, Student::getMarks, Integer::sum));
		System.out.println("Total Student marks : " + integer6);

		Integer integer7 = students.stream().collect(Collectors.reducing(0, Student::getMarks, (n1, n2) -> n1 + n2));
		System.out.println(integer7);

		/* 
		 * first arg: identity
		 * second arg: mapper to perform an operation on all the stream elements  
		 * third arg: binary operation
		 *  
		 */
	}

}
