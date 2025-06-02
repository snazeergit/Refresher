package myprep.comparator;

import java.util.List;
import java.util.stream.Collectors;

/*
 *PriorityCountry name has to appear first irrespective of the sorting order applied 
 */
public class CustomComparatorSorting1 {

	public static void main(String[] args) {
		List<String> countries = List.of("USA", "Canada", "India", "Australia", "Germany");
		String priorityCountry = "India";

		//Ascending
		List<String> countriesAscend1 = countries.stream().sorted((c1, c2) -> {
			if (c1.equals(priorityCountry))
				return -1;
			if (c2.equals(priorityCountry))
				return 1;
			return c1.compareTo(c2);
		}).collect(Collectors.toList());
		System.out.println("Ascending	:" + countriesAscend1);

		//Ascending
		List<String> countriesAscend2 = countries.stream()
				.sorted((c1, c2) -> c1.equals(priorityCountry) ? -1 : c2.equals(priorityCountry) ? 1 : c1.compareTo(c2))
				.collect(Collectors.toList());
		System.out.println("Ascending	:" + countriesAscend2);

		//Descending
		List<String> countriesDescend1 = countries.stream().sorted((c1, c2) -> {
			if (c1.equals(priorityCountry))
				return -1;
			if (c2.equals(priorityCountry))
				return 1;
			return c2.compareTo(c1);
		}).collect(Collectors.toList());

		System.out.println("Descending	:" + countriesDescend1);
		//Descending
		List<String> countriesDescend2 = countries.stream()
				.sorted((c1, c2) -> c1.equals(priorityCountry) ? -1 : c2.equals(priorityCountry) ? 1 : c2.compareTo(c1))
				.collect(Collectors.toList());
		System.out.println("Ascending	:" + countriesDescend2);
	}

}
