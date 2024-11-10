package com.java.core;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReductionOperation {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Nazeer", "Zaheer", "Karuna", "Afjal");
		List<Integer> list1 = Arrays.asList(6, 2, 8, 4, 2, 1);

		long count = list.stream().count();
		System.out.println(count);

		List<String> sorted = list.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
		//List<String> sorted = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		//List<String> sorted = list.stream().sorted().collect(Collectors.toList());
		System.out.println(sorted);

		Optional<String> max = list.stream().max(Comparator.naturalOrder());
		System.out.println(max.get());

		Optional<String> min = list.stream().min(Comparator.naturalOrder());
		System.out.println(min.get());

		Optional<String> optional = list.stream().reduce((i, j) -> i + "," + j);
		System.out.println(optional.get());

		IntSummaryStatistics statistics = list1.stream().collect(Collectors.summarizingInt(Integer::intValue));
		System.out.println(statistics.getAverage());
		System.out.println(statistics.getCount());
		System.out.println(statistics.getMax());
		System.out.println(statistics.getMin());
		System.out.println(statistics.getSum());

	}

}
