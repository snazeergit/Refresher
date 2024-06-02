package com.nt.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.nt.model.Person;

class GFG {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
	/*	list.add(1);
		list.add(3);
		list.add(2);
		list.add(4);
		list.add(4);
		list.add(2);
		list.add(7);
		list.add(5);
		list.add(6);
		list.add(5);
	*/	
		list.add(50);
		list.add(30);
		list.add(30);
		list.add(10);
		list.add(20);
		list.add(10);
		list.add(40);
		list.add(20);

		System.out.println("INPUT	:" + list);
		List<Integer> list2 = list.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		System.out.println("Filter	:" + list2);

		List<Integer> list3 = list.stream().map(n -> n + 1).collect(Collectors.toList());
		System.out.println("Map	:" + list3);

		List<Person> pList = new ArrayList<>();
		pList.add(new Person("Anil", 33, "male", List.of("Hyderabad", "Banglore", "Chennai")));
		pList.add(new Person("Sunil", 30, "male", List.of("Banglore", "Chennai")));
		pList.add(new Person("Elon", 25, "male", List.of("England", "London")));
		pList.add(new Person("Chenga", 26, "male", List.of("Tirupati", "Nellore", "Hyderabad")));
		pList.add(new Person("Bindu", 27, "female", List.of("Nellore", "Eluru", "Chennai")));
		pList.add(new Person("Anil", 27, "female", List.of("Nellore", "Eluru", "Chennai")));
		pList.add(new Person("Chenga", 25, "female", List.of("Tirupati", "Nellore")));

		//emp location in unique and sorted order
		List<String> list4 = pList.stream().flatMap(p -> p.getLocationPref().stream()).sorted().distinct().collect(Collectors.toList());
		System.out.println("FlatMap	:" + list4);
		
		//duplicate elements using HashSet add method Java8
		HashSet<Integer> hset=new HashSet<Integer>();
		List<Integer> list5 = list.stream().filter(n->!hset.add(n)).sorted().collect(Collectors.toList());
		System.out.println("Duplicates	:"+list5);
		
		
		//duplicate elements using HashSet add method non Java8
		hset.clear();
		List<Integer> list6=new ArrayList<Integer>();
		
		for(Integer i : list) {
			if(hset.contains(i)) {
				list6.add(i);
			}else {
				hset.add(i);
			}
		}
		System.out.println("Duplicates	:"+list6);
		System.out.println("Unique		:"+hset);
		System.out.println("Distinct	:"+list.stream().distinct().collect(Collectors.toList()));
		
		
		//duplicate elements using Collectins.frequency()
		Set<Integer> set = list.stream().filter(n->Collections.frequency(list, n)>1).collect(Collectors.toSet());
		System.out.println("Duplicates	:"+set);
		
		//duplicate elements using Map groupingBy, count
		
		//Arranging List into Map with elements as key and values as no. of times the element is repeated
		//Function.identity() returns a Function that returns the input argument as output
		//Collectors.counting(), returns the no of times name is repeated
		Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		Set<Entry<Integer,Long>> entrySet = map.entrySet();
		System.out.println("entrySet	:"+entrySet);
		List<Integer> list7 = entrySet.stream().filter(entry->entry.getValue()>1).map(entry->entry.getKey()).collect(Collectors.toList());
		System.out.println("Duplicates	:"+list7);
		System.out.println("Unique		:"+entrySet.stream().map(entry->entry.getKey()).collect(Collectors.toList()));

		List<Integer> list8 = entrySet.stream().filter(entry->entry.getValue()==1).map(entry->entry.getKey()).collect(Collectors.toList());
		System.out.println("Unique	:"+list8);
		
	}
}
