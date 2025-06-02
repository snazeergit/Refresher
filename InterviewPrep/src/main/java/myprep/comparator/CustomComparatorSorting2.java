package myprep.comparator;

import java.util.List;
import java.util.stream.Collectors;

/*
 *PriorityCountry names has to appear first irrespective of the sorting order applied 
 */
public class CustomComparatorSorting2 {

	public static void main(String[] args) {
		List<String> countries = List.of("Canada", "Australia", "India", "Germany", "France", "USA", "China");
		List<String> priorityCountries = List.of("India", "USA"); // top priority countries in order

		//Ascending
		List<String> countriesAscend = countries.stream().sorted((c1, c2) -> {
			int index1 = priorityCountries.indexOf(c1);
			int index2 = priorityCountries.indexOf(c2);

			if (index1 != -1 && index2 != -1)
				return Integer.compare(index1, index2); // both in priority list
			if (index1 != -1)
				return -1; // c1 is in priority list
			if (index2 != -1)
				return 1;  // c2 is in priority list

			return c1.compareTo(c2); // normal alphabetical sort
		}).collect(Collectors.toList());

		System.out.println("Ascending	:"+countriesAscend);

		//Descending
		List<String> countriesDescend = countries.stream().sorted((c1, c2) -> {
			int index1 = priorityCountries.indexOf(c1);
			int index2 = priorityCountries.indexOf(c2);

			if (index1 != -1 && index2 != -1)
				return Integer.compare(index1, index2); // both in priority list
			if (index1 != -1)
				return -1; // c1 is in priority list
			if (index2 != -1)
				return 1;  // c2 is in priority list

			return c2.compareTo(c1); // reversed alphabetical sort
		}).collect(Collectors.toList());

		System.out.println("Descending	:"+countriesDescend);
	}

}
