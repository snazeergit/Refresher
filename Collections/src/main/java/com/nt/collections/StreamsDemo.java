package com.nt.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.nt.model.Person;

public class StreamsDemo {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(50);
		list.add(30);
		list.add(30);
		list.add(10);
		list.add(20);
		list.add(10);
		list.add(40);
		list.add(20);

		//list.stream().filter(n -> n > 20).collect(Collectors.toList()).forEach(System.out::println);
		//list.stream().map(n->n+1).collect(Collectors.toList()).forEach(System.out::println);
		//list.stream().sorted().forEach(System.out::println);
		//list.stream().sorted((a,b)->a<b?-1:a>b?1:0).forEach(System.out::println);
		//list.stream().sorted((a,b)->a<b?1:a>b?-1:0).forEach(System.out::println);
		//list.stream().sorted((a,b)->a.compareTo(b)).forEach(System.out::println);
		//list.stream().sorted((a,b)->-a.compareTo(b)).forEach(System.out::println);
		//Integer integer = list.stream().min((a,b)->a<b?-1:a>b?1:0).get();
		//System.out.println(integer);
		//Integer integer = list.stream().max((a,b)->a<b?-1:a>b?1:0).get();
		//System.out.println(integer);

		//long count = list.stream().count();
		//System.out.println(count);

		//long count = list.stream().filter(n->n%4==0).count();
		//System.out.println(count);

		//Integer[] integers = list.stream().toArray(Integer[]::new);
		//Stream.of(integers).forEach(System.out::println);

		List<Person> pList = new ArrayList<>();
		pList.add(new Person("Anil", 33, "male", List.of("Hyderabad", "Banglore", "Chennai")));
		pList.add(new Person("Sunil", 30, "male", List.of("Banglore", "Chennai")));
		pList.add(new Person("Elon", 25, "male", List.of("Banglore", "London")));
		pList.add(new Person("Chenga", 26, "male", List.of("Tirupati", "Nellore", "Hyderabad")));
		pList.add(new Person("Bindu", 27, "female", List.of("Nellore", "Eluru", "Chennai")));

		//pList.stream().filter(p->p.getGender()=="female").map(p->p.getName()).forEach(System.out::println);
		//pList.stream().filter(p -> p.getGender() == "male" && p.getAge() >= 30).map(p -> p.getName())
		//		.forEach(System.out::println);
		//list.stream().sorted().distinct().forEach(System.out::println);

		//HashSet<Integer> unique=new HashSet<Integer>();
		//list.stream().filter(n->!unique.add(n)).collect(Collectors.toSet()).stream().sorted().forEach(System.out::println);

		List<String> namesList = pList.stream().map(p -> p.getName()).collect(Collectors.toList());
		Map<String, Long> map = namesList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("Map: "+map);
		
		Map<String, Long> map4 = map.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o,n)->o,LinkedHashMap::new));
		System.out.println("Sorted Map: "+map4);
		//map.entrySet().stream().forEach(System.out::println);

		//names repeated more than once

		Set<Entry<String, Long>> entrySet = map.entrySet();
		//System.out.println(entrySet);

		entrySet.stream().filter(e -> e.getValue() > 1).forEach(System.out::println);
		entrySet.stream().filter(n -> Collections.frequency(entrySet, n) > 1).forEach(System.out::println);

		//
		List<Person> list2 = pList.stream().sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
				.collect(Collectors.toList());
		System.out.println(list2);

		Map<String, List<Person>> collect = pList.stream().collect(Collectors.groupingBy(p -> p.getGender()));
		System.out.println(collect);

		Map<String, Long> collect1 = pList.stream()
				.collect(Collectors.groupingBy(p -> p.getGender(), Collectors.counting()));

		System.out.println(collect1);

		Map<String, Map<String, Map<Integer, List<Person>>>> map2 = pList.stream().collect(Collectors.groupingBy(
				p -> p.getGender(), Collectors.groupingBy(p -> p.getName(), Collectors.groupingBy(p -> p.getAge()))));
		System.out.println(map2);

		Map<String, Map<String, List<Person>>> collect2 = pList.stream().collect(
				Collectors.groupingBy(p -> p.getGender(), Collectors.groupingBy(p -> p.getLocationPref().get(0))));
		System.out.println("------");
		System.out.println(collect2);

		List<Person> sorted = pList.stream().sorted((e1, e2) -> -e1.getAge().compareTo(e2.getAge()))
				.collect(Collectors.toList());
		System.out.println(sorted);

		Person person = pList.stream().sorted((e1, e2) -> -e1.getAge().compareTo(e2.getAge())).skip(1).findFirst()
				.get();
		System.out.println(person);

		Map<Integer, Long> map3 = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		LinkedHashMap<Integer, Long> linkedHashMap = map3.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
						LinkedHashMap::new));

		System.out.println(linkedHashMap);

		Entry<String, Long> entry = pList.stream()
				.collect(Collectors.groupingBy(Person::getGender, Collectors.counting())).entrySet().stream()
				.max(Map.Entry.comparingByValue()).get();
		System.out.println(entry);

		List<Person> collect3 = pList.stream().sorted(Comparator.comparing(Person::getName).reversed())
				.collect(Collectors.toList());
		System.out.println(collect3);
		
		
	}

}
