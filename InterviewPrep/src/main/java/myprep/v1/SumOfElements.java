package myprep.v1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SumOfElements {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(2, 4, 7, 2, 7);

		//way-1
		Integer integer = list.stream().collect(Collectors.summingInt(Integer::intValue));
		System.out.println(integer);

		//way-2
		int sum = list.stream().mapToInt(Integer::intValue).sum();
		System.out.println(sum);

		//way-3
		Integer integer4 = list.stream().reduce((a, b) -> a + b).get();
		System.out.println(integer4);
		
		//way-4
		Integer integer2 = list.stream().reduce(0, (a, b) -> a + b);
		System.out.println(integer2);

		//way-5
		Integer integer3 = list.stream().reduce(0, Integer::sum);
		System.out.println(integer3);
	}

}
