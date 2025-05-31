package com.vmware.immutable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateMutableAndImmutableList {

	public static void main(String[] args) {
		//A. Immutable list, also allows nulls
		List<Integer> list1 = Stream.of(null, 1, 4, 2, 5, 3).toList();
		// java.lang.UnsupportedOperationException as list2 is a ImmutableCollection
		// list1.add(12);

		//B. Mutable or Modifiable list, also allows nulls
		List<Integer> list2 = Stream.of(null, 1, 4, 2, 5, 3).collect(Collectors.toList());
		list2.add(12);
		System.out.println(list2);

		//*****---Ways to create Immutable List---********

		/*
		1. Using Collections.unmodifiableList()
		Creates an unmodifiable view of the provided list.
		The original list still can be modified, affecting the unmodifiable list.
		 */
		List<String> mutableList = new ArrayList<>(Arrays.asList("A", "B", "C"));
		List<String> immutableList = Collections.unmodifiableList(mutableList);
		System.out.println(immutableList); // Output: [A, B, C]
		// Attempt to modify throws UnsupportedOperationException
		//immutableList.add("D");
		// Modifying the original list affects the unmodifiable list
		mutableList.add("D");
		System.out.println(immutableList); // Output: [A, B, C, D]

		/*
		2. Using List.of() (Java 9 and Later)
		Creates an immutable list directly.
		Does not allow null elements; will throw NullPointerException if null is added.
		 */
		List<String> immutableList1 = List.of("A", "B", "C");
		System.out.println(immutableList1); // Output: [A, B, C]
		// Attempt to modify throws UnsupportedOperationException
		//immutableList1.add("D");

		/*
		3. Using Collections.singletonList()
		Creates an immutable list with a single element.
		Suitable for lists with exactly one element.
		 */
		List<String> immutableList2 = Collections.singletonList("A");
		System.out.println(immutableList2); // Output: [A]

		// Attempt to modify throws UnsupportedOperationException
		// immutableList2.add("B");

		/*
		4. Using Stream API and Collectors.toUnmodifiableList() (Java 10 and Later)
		Collects elements into an immutable list.
		Does not allow null elements.
		*/
		List<String> immutableList3 = Stream.of("A", "B", "C").collect(Collectors.toUnmodifiableList());
		System.out.println(immutableList3); // Output: [A, B, C]

		// Attempt to modify throws UnsupportedOperationException
		// immutableList3.add("D");

		List<Integer> list3 = Arrays.asList(1, 4, 2, 5, 3);
		//list3.add(12);// This line throws the java.lang.UnsupportedOperationException
		/*
		1.Arrays.asList(...) Behavior:
			Creates a fixed-size list backed by the array provided as input.
			The list cannot grow or shrink because it is tied to the original array’s size.
			Modifying elements within the size (e.g., set(index, value)) is allowed.
			Adding or removing elements (add(), remove()) is not allowed, and such attempts will throw UnsupportedOperationException.
		
		2.What Happens Here:
			list3 is a fixed-size list, so attempting to add an element violates its size constraint.
		
		How to Create a Fully Modifiable List:
			If you need a modifiable list, copy the list created by Arrays.asList() into a new modifiable list, 
			such as an ArrayList as shown below.
		 */

		List<Integer> list4 = new ArrayList<>(Arrays.asList(1, 4, 2, 5, 3));
		list4.add(12); // Now this works
		System.out.println(list4); // Output: [1, 4, 2, 5, 3, 12]
	}

}
