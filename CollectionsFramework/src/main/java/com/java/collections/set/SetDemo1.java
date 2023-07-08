package com.java.collections.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo1 {

	public static void main(String[] args) {
		hashSet();
		linkedHashSet();
		treeSet();

	}

	/*Note: From Java 8, the HashSet implementation uses a different hashing algorithm that produces a more deterministic order of elements.
	As a side effect, the iteration order of a HashSet might appear sorted for some specific inputs, but this behavior is not guaranteed 
	and should not be relied upon.*/
	public static void hashSet() {
		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(3);
		set1.add(2);
		set1.add(4);
		set1.add(2);
		set1.add(5);
		set1.add(1);
		set1.add(0);
		set1.add(3);

		System.err.println("HashSet:	[Unique Elements | Do not Maintains any order]");
		System.out.println(set1);
	}

	public static void linkedHashSet() {
		Set<Integer> set1 = new LinkedHashSet<Integer>();
		set1.add(3);
		set1.add(2);
		set1.add(4);
		set1.add(2);
		set1.add(5);
		set1.add(1);
		set1.add(0);
		set1.add(3);

		System.err.println("LinkedHashSet:	[Unique Elements | Maintains Insertion order]");
		System.out.println(set1);
	}

	public static void treeSet() {
		Set<Integer> set1 = new TreeSet<Integer>();
		set1.add(3);
		set1.add(2);
		set1.add(4);
		set1.add(2);
		set1.add(5);
		set1.add(1);
		set1.add(0);
		set1.add(3);

		System.err.println("TreeSet:	[Unique Elements | Maintains Natural Sorting order]");
		System.out.println(set1);
	}

}
