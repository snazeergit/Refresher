package com.java.collections.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListDemo1 {

	public static void main(String[] args) {
		linkedList();
		arrayList();
	}

	public static void linkedList() {
		List<Integer> list1 = new LinkedList<Integer>();
		list1.add(3);
		list1.add(2);
		list1.add(4);
		list1.add(2);
		list1.add(5);
		list1.add(1);
		list1.add(0);
		list1.add(3);

		System.err.println("LinkedList:	[Allows Duplicate Elements | Maintains Insertion order]");
		System.out.println(list1);
	}

	public static void arrayList() {
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(3);
		list1.add(2);
		list1.add(4);
		list1.add(2);
		list1.add(5);
		list1.add(1);
		list1.add(0);
		list1.add(3);

		System.err.println("ArrayList:	[Allows Duplicate Elements | Maintains Insertion order]");
		System.out.println(list1);
	}

}
