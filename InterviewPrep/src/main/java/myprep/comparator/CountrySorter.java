package myprep.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 *PriorityCountry name has to appear at first index(zero-based index) irrespective of the sorting order applied 
 */
public class CountrySorter {

    public static void main(String[] args) {
        List<String> countries = new ArrayList<>(List.of("USA", "India", "Canada", "Germany", "Japan"));

        int desiredPosition = 1; // Zero-based index

        // Step 1: Sort naturally
        Collections.sort(countries);

        // Step 2: Remove and re-add "India" at the desired position
        if (countries.remove("India")) {
            countries.add(desiredPosition, "India");
        }

        // Print final result
        System.out.println(countries);
    }
}
