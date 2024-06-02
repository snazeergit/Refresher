package com.nt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Demo2 {

	public static void main(String[] args) {

		List<Student> sList = new ArrayList<Student>();

		sList.add(new Student("Ramu", "Rama", 550));
		sList.add(new Student("Bamu", "Kama", 150));
		sList.add(new Student("Ramu", "Pama", 350));
		sList.add(new Student("Tamu", "Kama", 550));
		sList.add(new Student("Aamu", "Lama", 450));

		List<Student> list = sList.stream().sorted(Comparator.comparing(Student::getFirstName))
				.collect(Collectors.toList());
		System.out.println(list);

		List<Student> sList1 = Arrays.asList(new Student("Ramu", "Rama", 550), new Student("Bamu", "Kama", 150),
				new Student("Ramu", "Pama", 350), new Student("Tamu", "Kama", 550), new Student("Aamu", "Lama", 450));

		List<Student> list1 = sList1.stream().sorted(Comparator.comparing(Student::getFirstName))
				.collect(Collectors.toList());
		System.out.println(list1);
	}
	//Aamu, Bamu, Ramu, Ramu, Tamu

}
