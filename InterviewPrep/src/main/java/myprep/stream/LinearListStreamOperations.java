package myprep.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LinearListStreamOperations {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(7, 4, 2, 2, 6, 3, 7, 3, 5, 5, 7, 3, 8, 9, 0, 1);
		//sorting-ascending
		List<Integer> list2 = list.stream().sorted().collect(Collectors.toList());
		System.out.println(list2);

		//sorting-decending
		List<Integer> list3 = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(list3);

		//3rd smallest
		Integer integer = list.stream().sorted().skip(2).findFirst().get();
		System.out.println(integer);

		//4th highest
		Integer integer2 = list.stream().sorted(Comparator.reverseOrder()).skip(3).findFirst().get();
		System.out.println(integer2);

		//sum of all elements
		long sum = list.stream().collect(Collectors.summarizingInt(Integer::intValue)).getSum();
		System.out.println(sum);
		int sum2 = list.stream().mapToInt(Integer::intValue).sum();
		System.out.println(sum2);
		int intValue = list.stream().reduce(0, (n1, n2) -> n1 + n2);
		System.out.println(intValue);
		int intValue2 = list.stream().reduce((n1, n2) -> n1 + n2).get();
		System.out.println(intValue2);
		Integer reduce = list.stream().reduce(0, Integer::sum);
		System.out.println(reduce);

		//unique- Asceding
		List<Integer> list4 = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().filter(e -> e.getValue() == 1).map(e -> e.getKey()).sorted()
				.collect(Collectors.toList());
		System.out.println(list4);

		//distinct - Descending
		List<Integer> list5 = list.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(list5);

		//duplicate -Ascending
		List<Integer> list6 = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().filter(e -> e.getValue() >1).map(e -> e.getKey()).sorted()
				.collect(Collectors.toList());
		System.out.println(list6);
	}

}
