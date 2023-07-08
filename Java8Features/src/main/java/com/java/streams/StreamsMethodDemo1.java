package com.java.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.java.myutility.MyUtility;
import com.java.pojo.Person;
import com.java.pojo.Student;

public class StreamsMethodDemo1 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(0);
		list.add(25);
		list.add(5);
		list.add(15);

		System.out.println(list);
		
		System.out.println("---------------------");
		List<Integer> list2 = list.stream().filter(n -> n >= 10).collect(Collectors.toList());
		System.out.println(list2);
		
		System.out.println("---------------------");
		List<Integer> list3 = list.stream().map(n -> n + 1).collect(Collectors.toList());
		System.out.println(list3);
		
		System.out.println("---------------------");
		List<Integer> list4 = list.stream().sorted().collect(Collectors.toList());
		System.out.println(list4);
		
		System.out.println("---------------------");
		List<Integer> list5 = list.stream().sorted((a, b) -> a < b ? -1 : a > b ? 1 : 0).collect(Collectors.toList());
		System.out.println(list5);
		
		System.out.println("---------------------");
		List<Integer> list6 = list.stream().sorted((a, b) -> a < b ? 1 : a > b ? -1 : 0).collect(Collectors.toList());
		System.out.println(list6);
		
		System.out.println("---------------------");
		List<Integer> list7 = list.stream().sorted((a, b) -> a.compareTo(b)).collect(Collectors.toList());
		System.out.println(list7);
		
		System.out.println("---------------------");
		List<Integer> list8 = list.stream().sorted((a, b) -> -a.compareTo(b)).collect(Collectors.toList());
		System.out.println(list8);
		
		System.out.println("---------------------");
		Integer min = list.stream().min((a, b) -> a < b ? -1 : a > b ? 1 : 0).get();
		System.out.println(min);
		
		System.out.println("---------------------");
		Integer max = list.stream().max((a, b) -> a.compareTo(b)).get();
		System.out.println(max);
		
		System.out.println("---------------------");
		long count = list.stream().count();
		System.out.println(count);
		
		System.out.println("---------------------");
		long count2 = list.stream().filter(n -> n > 5).count();
		System.out.println(count2);
		
		System.out.println("---------------------");
		Integer[] integers = list.stream().toArray(Integer[]::new);
		for (Integer integer : integers) {
			System.out.print(integer + " ");
		}
		//System.out.println(integers);
		Stream.of(integers).forEach(System.out::println);
		
		System.out.println("---------------------");
		List<Person> pList = MyUtility.getPersons();

		List<Person> list9 = pList.stream().filter(p -> p.getGender() == "female").collect(Collectors.toList());
		List<String> list10 = list9.stream().map(p -> p.getName()).collect(Collectors.toList());
		list10.stream().forEach(System.out::println);
		
		System.out.println("---------------------");
		pList.stream().filter(p -> p.getGender() == "male").map(p -> p.getName()).forEach(System.out::println);
		Person[] array = pList.stream().filter(p -> p.getAge() < 30).toArray(Person[]::new);
		Stream.of(array).map(p -> p.getName()).forEach(System.out::println);
		
		System.out.println("---------------------");
		Set<List<String>> set = pList.stream().map(p -> p.getLocationPref()).collect(Collectors.toSet());
		
		Set<String> set1 = pList.stream().flatMap(p -> p.getLocationPref().stream()).collect(Collectors.toSet());
		set1.stream().sorted().forEach(System.out::println);

		List<Student> sList = MyUtility.getStudents();
		//System.out.println(sList);
		
		System.out.println("---------------------");
		List<String[]> list11 = sList.stream().map(p -> p.getLoc()).collect(Collectors.toList());
		Set<String> set2 = list11.stream().map(a -> Arrays.asList(a)).flatMap(l -> l.stream())
				.collect(Collectors.toSet());
		set2.stream().sorted((a, b) -> a.compareTo(b)).forEach(System.out::println);
		
		System.out.println("---------------------");
		Set<String> set3 = sList.stream().flatMap(p -> Arrays.asList(p.getLoc()).stream()).collect(Collectors.toSet());
		set3.stream().sorted((a, b) -> a.compareTo(b)).forEach(System.out::println);

		System.out.println("---------------------");
		sList.stream().flatMap(p -> Arrays.asList(p.getLoc()).stream()).collect(Collectors.toSet()).stream()
				.sorted((a, b) -> a.compareTo(b)).forEach(System.out::println);
	}

}
