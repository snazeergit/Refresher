package com.java.streams.learning;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VikramDiscussion {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2, 4, 7, 2, 7);

		Integer integer = list.stream().collect(Collectors.summingInt(Integer::intValue));
		System.out.println(integer);

		int sum = list.stream().mapToInt(Integer::intValue).sum();
		System.out.println(sum);

		Integer integer2 = list.stream().reduce(0, (a, b) -> a + b);
		System.out.println(integer2);

		Integer integer3 = list.stream().reduce(0, Integer::sum);
		System.out.println(integer3);
	}

}
