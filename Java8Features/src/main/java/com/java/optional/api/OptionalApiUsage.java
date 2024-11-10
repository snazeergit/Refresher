package com.java.optional.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalApiUsage {

	public static void main(String[] args) {
		List<String> namesList = new ArrayList<String>();
		namesList.add("Naveen");
		namesList.add("Kassi");
		namesList.add("Akhila");
		namesList.add("Beebi");

		List<String> otherList = Arrays.asList("Raama", "Seeta");
		List<String> defaultList = Arrays.asList("Krishna", "Rukmini");

		//3 ways to create Optional obj
		Optional<Object> emptyOptional = Optional.empty();
		Optional<Integer> ofOptional = Optional.of(10);
		//throws NullPointerException as of(-) method does not allows null
		//Optional<Integer> ofOptional1 = Optional.of(null); 
		
		//isPresent()
		Optional<List<String>> nullableOptional = Optional.ofNullable(namesList);
		if (nullableOptional.isPresent()) {
			System.out.println("-1-");
			System.out.println(nullableOptional.get());
		}

		System.out.println("-2-");
		//orElse(-)
		//nullableOptional.orElse(otherList).forEach(System.out::println);
		List<String> list = nullableOptional.orElse(otherList);
		for (String string : list) {
			System.out.println(string);
		}
		
		
		System.out.println("-3-");
		Object object = emptyOptional.orElse(namesList);
		System.out.println(object);
		
		
		System.out.println("-4-");
		Integer integer = ofOptional.orElse(20);
		System.out.println(integer);

		
		System.out.println("-5-");
		//orElseGet(-)
		
		//it returns another ArrayList if optional is empty
		//nullableOptional.orElseGet(() -> Arrays.asList("Default List"));
		
		//invoking another method if optional obj is empty
		nullableOptional.orElseGet(() -> fetchNamesList()); 

		nullableOptional.orElseGet(() -> defaultList);
		List<String> list1 = nullableOptional.orElseGet(() -> otherList);
		for (String string : list1) {
			System.out.println(string);
		}
		System.out.println("-6-");
		Object object1 = emptyOptional.orElseGet(() -> namesList);
		System.out.println(object1);
		System.out.println("-7-");
		Integer integer1 = ofOptional.orElseGet(() -> 20);
		System.out.println(integer1);

		//orElseThrow() it always throws NoSuchElementException if optional obj is empty
		System.out.println("-8-");
		List<String> list2 = nullableOptional.orElseThrow();
		System.out.println(list2);
		System.out.println("-9-");
		//throws NoSuchElementException as optional obj is empty
		//Object object2 = emptyOptional.orElseThrow(); 
		//System.out.println(object2);
		System.out.println("-10-");
		Integer integer2 = ofOptional.orElseThrow();
		System.out.println(integer2);

		//orElseThrow(-)  it always throws specified exception if optional obj is empty
		System.out.println("-11-");
		List<String> list3 = nullableOptional.orElseThrow(IllegalArgumentException::new);
		System.out.println(list3);
		System.out.println("-12-");
		//Object object3 = emptyOptional.orElseThrow(IllegalArgumentException::new); //throws specified IllegalArgumentException as optional obj is empty
		//System.out.println(object3);
		System.out.println("-13-");
		Integer integer3 = ofOptional.orElseThrow(IllegalArgumentException::new);
		System.out.println(integer3);

		//ifPresent(Consumer)
		System.out.println("-14-");
		nullableOptional.ifPresent(list4 -> list4.forEach(System.out::println));
		ofOptional.ifPresent(num -> System.out.println(num));
		emptyOptional.ifPresent(num -> System.out.println());

	}

	static List<String> fetchNamesList() {
		List<String> names = Arrays.asList("Kiran", "Kumar");
		return names;

	}

}
