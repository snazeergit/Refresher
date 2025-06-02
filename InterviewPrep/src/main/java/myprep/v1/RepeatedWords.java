package myprep.v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RepeatedWords {
	public static void main(String[] args) {
		String str = "This is 		a test  sentence 	and this test   IS just a TEST";
		String[] strings = str.split("\\s+");

		//using getOrDefault(-,-) method:
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		for (String s : strings) {
			map.put(s, map.getOrDefault(s, 0) + 1);
		}
		System.out.println(map);
		map.entrySet().stream().filter(entry -> entry.getValue() > 1).collect(Collectors.toList())
				.forEach(System.out::println);
		map.entrySet().stream().collect(Collectors.toList()).forEach(System.out::println);

		//Using Streams
		List<String> list = new ArrayList<String>(Arrays.asList(strings));
		list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)).forEach((key,value)->{
					System.out.println(key+" has repeated "+value+" time(s)");
				});
	}
}
