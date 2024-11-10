package com.java.optional.api;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalApiDemo {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Sathya", "Sneha", "Seshu", "Sheshadri");
		Optional<String> optional1 = Optional.ofNullable(list.get(1));
		Optional<String> optional2 = Optional.ofNullable(list.get(1));
		boolean flag = optional1.equals(optional2);
		System.out.println(flag);

		String msg = optional1.get();
		int hashCode = optional1.hashCode();
		System.out.println(msg + "   " + hashCode);

		optional1.ifPresent(System.out::println);
		boolean present = optional1.isPresent();
		System.out.println(present);

		boolean flag1 = optional1.isEmpty();
		boolean flag2 = optional2.isEmpty();
		System.out.println(flag1 + "   " + flag2);
		
		Integer integer = optional1.map(s -> s.length()).get();
		System.out.println(integer);
		
	}
}
