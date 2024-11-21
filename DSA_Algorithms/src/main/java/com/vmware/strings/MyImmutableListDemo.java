package com.vmware.strings;

import java.util.ArrayList;
import java.util.List;

final class Department {
	private final String name;
	private final List<String> sports;

	Department(String name, List<String> sports) {
		this.name = name;
		List<String> tempList = new ArrayList<String>();
		for (String sport : sports) {
			tempList.add(sport);
		}
		this.sports = tempList;
	}
	
	public String getName() {
		return name;
	}

	public List<String> getSports() {
		List<String> tempList = new ArrayList<String>();
		for (String sport : sports) {
			tempList.add(sport);
		}
		return tempList;
	}

	@Override
	public String toString() {
		return "Department [name=" + name + ", sports=" + sports + "]";
	}

}

public class MyImmutableListDemo {

	public static void main(String[] args) {
		List<String> sportsList = new ArrayList<String>();
		sportsList.add("Cricket");
		sportsList.add("Football");

		Department dept = new Department("Nazeer", sportsList);
		System.out.println(dept);
		sportsList.add("Kabaddi");
		System.out.println(dept.getSports());

	}

}
