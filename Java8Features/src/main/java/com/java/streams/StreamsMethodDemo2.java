package com.java.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

public class StreamsMethodDemo2 {

	public static void main(String[] args) {

		Stream<String> stream = Stream.of("This", "forms", "forms", "a", "short", "a", "sentence", "sentence");

		Consumer<String> con = new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		};

		stream.collect(Collectors.toSet()).forEach(con);

		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(5);
		list.add(4);
		list.add(2);
		list.add(4);
		list.add(3);
		list.add(1);
		Set<Integer> set = list.stream().map(n -> n).sorted().collect(Collectors.toSet());
		System.out.println();
		//reduce(T, BinaryOperator)
		Integer integer = list.stream().reduce(0, (a, b) -> a + b);
		System.out.println(integer);

		Integer integer1 = list.stream().reduce(1, (a, b) -> a * b);
		System.out.println(integer1);

		//reduce(BinaryOperator)
		Optional<Integer> optional = list.stream().reduce(Integer::sum);
		System.out.println(optional.get());

		//distinct()
		List<Integer> list2 = list.stream().distinct().collect(Collectors.toList());
		System.out.println(list2);

		//findFirst()
		Optional<Integer> optional1 = list.stream().findFirst();
		System.out.println(optional1);

		//findAny()
		Optional<Integer> optional2 = list.stream().findAny();
		System.out.println(optional2.get());

		int arr[] = { 1, 2, 3, 4, 5 };
		IntStream intStream = Arrays.stream(arr);

		//flatMapToInt(Function)
		Stream<int[]> stream2 = Stream.of(arr);
		IntStream flatMapToInt = stream2.flatMapToInt(Arrays::stream);
		flatMapToInt.forEachOrdered(System.out::print);

		//generate(Supplier)
		List<Integer> list3 = Stream.generate(new Random()::nextInt).limit(5).collect(Collectors.toList());
		list3.forEach(System.out::println);

		//builder() and build()
		Builder<Object> builder = Stream.builder();
		Stream<Object> stream3 = builder.add(4).add(5).add(2).add(1).add(3).add(3).build();
		stream3.forEach(System.out::println);

		//anyMatch(Predicate) function to check whether any element in list is divisible by 2.
		boolean match2 = list.stream().anyMatch(n -> n % 2 == 0);
		System.out.println(match2);

		//allMatch(Predicate) function to check whether all elements are divisible by 2. 
		boolean match = list.stream().allMatch(n -> n % 2 == 0);
		System.out.println(match);

		//findAny() it just returns ‘any’ first element and terminate the rest of the iteration.
		Optional<Integer> optional3 = list.stream().findAny();
		if (optional3.isPresent())
			System.out.println(optional3.get());
		else
			System.out.println("No value");

		//ofNullable(T)
		Stream<Integer> stream4 = Stream.ofNullable(null);
		stream4.toList().forEach(System.out::println);

		Stream<Integer> stream5 = Stream.ofNullable(9);
		stream5.toList().forEach(System.out::println);

		//concat(Stream, Stream)
		Stream<Integer> stream6 = Stream.of(3, 2, 4, 5, 1);
		Stream<Integer> stream7 = Stream.of(6, 9, 7, 8, 0);
		Stream<Integer> stream8 = Stream.concat(stream6, stream7);
		stream8.collect(Collectors.toSet()).forEach(System.out::println);

		System.out.println("---------------");
		list.stream().peek(System.out::println).count();

		Stream.of("one", "two", "three", "four").filter(e -> e.length() > 3)
				.peek(e -> System.out.println("Filtered value: " + e)).map(String::toUpperCase)
				.peek(e -> System.out.println("Mapped value: " + e)).collect(Collectors.toList());

	}
}
