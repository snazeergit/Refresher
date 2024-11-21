package com.nt.generics;

import java.util.ArrayList;
import java.util.List;

public class LowerBondedWildCardsTest {

	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(1);
		l1.add(2);
		l1.add(3);

		List<Number> l2 = new ArrayList<Number>();
		l2.add(10);
		l2.add(20);

		printLowerBound(l1);
		printLowerBound(l2);

		List<Float> l3 = new ArrayList<Float>();
		l3.add(1.2f);
		l3.add(3.2f);

		printHigherBound(l1);
		printHigherBound(l3);

	}

	public static void printLowerBound(List<? super Integer> num) {
		for (Object object : num) {
			System.out.println(object);
		}
	}

	public static void printHigherBound(List<? extends Number> num) {
		for (Number number : num) {
			System.out.println(number);
		}
	}

}
