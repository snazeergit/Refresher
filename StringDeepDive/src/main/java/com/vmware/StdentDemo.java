package com.vmware;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StdentDemo {

	public static void main(String[] args) {

		Student s1 = new Student("Ramu", 10, 500.0);
		Student s2 = new Student("Giri", 50, 300.0);
		Student s3 = new Student("Ramu", 20, 470.0);
		Set<Student> stdSet = new HashSet<Student>();
		stdSet.add(s1);
		stdSet.add(s2);
		stdSet.add(s3);
		Student s4 = new Student("Ramu", 10, 500.0);
		stdSet.add(s4);

		Map<Student, List<String>> map = stdSet.stream().collect(
				Collectors.groupingBy(Function.identity(), Collectors.mapping(Student::getName, Collectors.toList())));
		//System.out.println(map);
		map.forEach((student, list) -> {
			System.out.println(student + "=" + list.get(0));
		});

		Map<Student, List<String>> map2 = stdSet.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.collectingAndThen(Collectors.toList(),
						list -> list.stream().map(Student::getName).collect(Collectors.toList()))));
		map2.forEach((student, list) -> {
			System.out.println(student + "=" + list.get(0));
		});
		
		
		//checking the object comparision by overrriding the hashcode() and equals() methods in Student class.
		if (s1.equals(s3)) {
			System.out.println("Equal");
		} else {
			System.out.println("Not Equal");
		}
	}

}
