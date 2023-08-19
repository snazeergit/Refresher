package com.java.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import com.java.myutility.MyUtility;
import com.java.pojo.Employee;
import com.java.pojo.Person;
import com.java.pojo.Student;

public class StreamsMethodDemo1 {

	public static void main(String[] args) {
		List<Employee> employees = MyUtility.getEmployees();
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(30);
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

		System.out.println("sorted()---------------------");
		List<Integer> list4 = list.stream().sorted().collect(Collectors.toList());
		System.out.println(list4);

		System.out.println("sorted(A)---------------------");
		List<Integer> list5 = list.stream().sorted((a, b) -> a < b ? -1 : a > b ? 1 : 0).collect(Collectors.toList());
		System.out.println(list5);

		System.out.println("sorted(D)---------------------");
		List<Integer> list6 = list.stream().sorted((a, b) -> a < b ? 1 : a > b ? -1 : 0).collect(Collectors.toList());
		System.out.println(list6);

		System.out.println("sorted(A)---------------------");
		List<Integer> list7 = list.stream().sorted((a, b) -> a.compareTo(b)).collect(Collectors.toList());
		System.out.println(list7);

		System.out.println("sorted(D)---------------------");
		List<Integer> list8 = list.stream().sorted((a, b) -> -a.compareTo(b)).collect(Collectors.toList());
		System.out.println(list8);

		System.out.println("min()---------------------");
		Integer min = list.stream().min((a, b) -> a < b ? -1 : a > b ? 1 : 0).get();
		System.out.println(min);

		System.out.println("max()---------------------");
		Integer max = list.stream().max((a, b) -> a.compareTo(b)).get();
		System.out.println(max);

		System.out.println("count()---------------------");
		long count = list.stream().count();
		System.out.println(count);

		System.out.println("count()---------------------");
		long count2 = list.stream().filter(n -> n > 5).count();
		System.out.println(count2);

		System.out.println("toArray(-)---------------------");
		Integer[] integers = list.stream().toArray(Integer[]::new);
		for (Integer integer : integers) {
			System.out.print(integer + " ");
		}
		//System.out.println(integers);
		System.out.println("forEach(-)---------------------");
		Stream.of(integers).forEach(System.out::println);

		System.out.println("filter(-)---------------------");
		List<Person> pList = MyUtility.getPersons();

		List<Person> list9 = pList.stream().filter(p -> p.getGender() == "female").collect(Collectors.toList());
		List<String> list10 = list9.stream().map(p -> p.getName()).collect(Collectors.toList());
		list10.stream().forEach(System.out::println);

		System.out.println("map(-)---------------------");
		pList.stream().filter(p -> p.getGender() == "male").map(p -> p.getName()).forEach(System.out::println);
		Person[] array = pList.stream().filter(p -> p.getAge() < 30).toArray(Person[]::new);
		Stream.of(array).map(p -> p.getName()).forEach(System.out::println);

		System.out.println("flatMap(-)---------------------");
		Set<List<String>> set = pList.stream().map(p -> p.getLocationPref()).collect(Collectors.toSet());

		Set<String> set1 = pList.stream().flatMap(p -> p.getLocationPref().stream()).collect(Collectors.toSet());
		set1.stream().sorted().forEach(System.out::println);

		List<Student> sList = MyUtility.getStudents();
		//System.out.println(sList);

		System.out.println("map(-)---------------------");
		List<String[]> list11 = sList.stream().map(p -> p.getLoc()).collect(Collectors.toList());
		Set<String> set2 = list11.stream().map(a -> Arrays.asList(a)).flatMap(l -> l.stream())
				.collect(Collectors.toSet());
		set2.stream().sorted((a, b) -> a.compareTo(b)).forEach(System.out::println);

		System.out.println("flatMap(-)---------------------");
		Set<String> set3 = sList.stream().flatMap(p -> Arrays.asList(p.getLoc()).stream()).collect(Collectors.toSet());
		set3.stream().sorted((a, b) -> a.compareTo(b)).forEach(System.out::println);

		System.out.println("flatMap(-)---------------------");
		sList.stream().flatMap(p -> Arrays.asList(p.getLoc()).stream()).collect(Collectors.toSet()).stream()
				.sorted((a, b) -> a.compareTo(b)).forEach(System.out::println);

		boolean match = list.stream().allMatch(n -> n % 5 == 0);
		System.out.println(match);
		boolean match1 = list.stream().anyMatch(n -> n % 3 == 0);
		System.out.println(match1);

		Stream.Builder<String> builder = Stream.builder();

		// Add elements to the builder
		builder.add("Hello");
		builder.add("World");

		// Build the stream
		Stream<String> stream = builder.build();

		// Process the stream
		stream.forEach(System.out::println);

		List<String> names = List.of("John", "Jane", "Adam", "Eve");

		// Supplier: Create a new ArrayList
		Supplier<List<String>> supplier = ArrayList::new;

		// Accumulator: Add each name to the ArrayList
		BiConsumer<List<String>, String> accumulator = List::add;

		// Combiner: Merge two ArrayLists into one
		BiConsumer<List<String>, List<String>> combiner = List::addAll;

		// Collect the names into an ArrayList
		List<String> collectedNames = names.stream().collect(supplier, accumulator, combiner);

		// Print the collected names
		System.out.println(collectedNames);

		Stream<Object> stream2 = Stream.empty();
		stream2.forEach(System.out::println);

		List<List<String>> listOfLists = Arrays.asList(Arrays.asList("1", "2"), Arrays.asList("5", "6"),
				Arrays.asList("3", "4"));

		DoubleStream flatMapToDouble = listOfLists.stream().flatMapToDouble(l -> l.stream().mapToDouble(Double::new));
		flatMapToDouble.forEach(System.out::println);

		IntStream flatMapToInt = listOfLists.stream().flatMapToInt(l -> l.stream().mapToInt(Integer::new));
		flatMapToInt.forEach(System.out::println);

		LongStream flatMapToLong = listOfLists.stream().flatMapToLong(l -> l.stream().mapToLong(Long::new));
		flatMapToLong.forEach(System.out::println);

		List<Integer> l1 = Arrays.asList(2, 4, 6, 8, 10);
		System.out.println("-----");
		l1.stream().parallel().forEach(System.out::println);
		System.out
				.println("--Parallel streams are unordered stream so preserve the order we can use forEachOrdred()--");
		l1.stream().parallel().forEachOrdered(System.out::println);
		System.out.println("-----");
		l1.stream().forEach(System.out::println);
		System.out.println("-----");
		l1.stream().forEachOrdered(System.out::println);
		l1.stream().skip(3).forEach(System.out::println);

		employees.stream().distinct().sorted(Comparator.comparingInt(Employee::getAge)).collect(Collectors.toList())
				.forEach(System.out::println);

	}

}
