package com.nt.interview;

import java.util.ArrayList;

public class StackDemo {
	static ArrayList<Integer> list;

	public static void main(String[] args) {
		list = new ArrayList<Integer>();
		StackDemo s = new StackDemo();
		s.myPush(10);
		s.myPush(20);
		s.myPush(40);
		s.myPush(10);
		s.myPush(50);
		System.out.println(list);
		s.myPop();
		s.myPop();
		System.out.println(list);
		System.out.println(s.myPeak());

	}

	public void myPush(Integer n) {
		//add at first position everytime.
		list.add(0, n);
	}

	public void myPop() {
		list.remove(0);
	}

	public Integer myPeak() {
		if (list.isEmpty())
			return null;
		else
			return list.get(0);
	}

}

//stack Push pop peak LIFO