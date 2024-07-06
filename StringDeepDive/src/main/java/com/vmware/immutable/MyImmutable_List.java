package com.vmware.immutable;

import java.util.ArrayList;
import java.util.List;

final class Demo {
	private final Integer number;
	private final String name;
	private final List<Integer> favNum;

	public Demo(Integer number, String name, List<Integer> favNum) {
		this.number = number;
		this.name = name;
		List<Integer> tempList = new ArrayList<Integer>();
		for (Integer integer : favNum) {
			tempList.add(integer);
		}
		this.favNum = tempList;
	}

	public Integer getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public List<Integer> getFavNum() {
		List<Integer> tempList = new ArrayList<Integer>();
		for (Integer integer : favNum) {
			tempList.add(integer);
		}
		return tempList;
	}

	@Override
	public String toString() {
		return "Demo -> number=" + number + ", name=" + name + ", favNum=" + favNum;
	}

}

public class MyImmutable_List {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(7);
		list.add(10);
		list.add(18);
		Demo d1 = new Demo(1, "Nazeer", list);

		System.out.println(d1.getName());
		System.out.println(d1.getNumber());
		System.out.println(d1.getFavNum());
		list.add(22);
		list.add(23);
		System.out.println(d1.getFavNum());
		
	}

}
