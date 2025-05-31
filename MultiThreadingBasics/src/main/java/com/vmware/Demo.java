package com.vmware;

import java.util.Optional;

public class Demo {

	public static void main(String[] args) {

		System.out.println("-------------empty()---------");
		Optional<Object> empty = Optional.empty();
		System.out.println(empty.isPresent());

		System.out.println("---------------of()-----------");
		//throws NullpointerException if null value passed
		//Optional<Object> op2 = Optional.of(null);
		Optional<Object> op2 = Optional.of("Nazeer");
		System.out.println(op2.isPresent());

		System.out.println("----------ofNullable()---------");
		Optional<Object> nonEmpty = Optional.ofNullable(new String("Nazeer"));
		Optional<Object> op1 = Optional.ofNullable(null);
		System.out.println(op1.isPresent());

		System.out.println("----------ifPresent()----------");
		empty.ifPresent(name -> System.out.println(empty.get()));
		nonEmpty.ifPresent(name -> System.out.println(nonEmpty.get()));

		System.out.println("-----------orElse()------------");
		Object object = empty.orElse("Syed");
		System.out.println(object);

		Object object1 = nonEmpty.orElse("Syed");
		System.out.println(object1);

		System.out.println("-----------orElseThrow()------------");
		//throw an exception if optional is empty
		Object object2 = nonEmpty.orElseThrow(IllegalStateException::new);
		System.out.println(object2);

	}
}
