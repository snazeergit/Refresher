package com.vmware.top15;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

//Problem: Remove duplicate characters from a string.
public class Remove_Duplicate_Characters {

	public static void main(String[] args) {
		String str = "My name is Nazeer";
		//approch-1
		Set<Character> unique = new LinkedHashSet<>();
		StringBuilder res = new StringBuilder();
		for (char c : str.toCharArray()) {
			unique.add(c);
		}
		for (char c : unique) {
			res.append(c);
		}
		System.out.println(res.toString());

		//approch-2
		Set<Character> set = new LinkedHashSet<>();
		StringBuilder result = new StringBuilder();
		for (char c : str.toCharArray()) {
			if (!set.contains(c)) {
				set.add(c);
				result.append(c);
			}
		}
		System.out.println(result.toString());

		//approch-3
		//Converts a String into an IntStream of Unicode values (integers) for each character.
		String resu = str.chars()
				//distinct elements will be picked
				.distinct()
				//Maps each int value from the IntStream to an object.
				//In this case, the lambda expression converts each integer (c) into 
				//a character ((char) c) and then wraps it into a string using String.valueOf.
				.mapToObj(c -> String.valueOf((char) c))
				//concatenates the input elements into a String, in encounter order.
				.collect(Collectors.joining());
		System.out.println(resu);

	}
}

/*
 mapToObj(c -> (char) c)

	•	Explanation:
	•	(char) c explicitly casts the int (Unicode value) from the IntStream to a primitive character (char).
	•	The mapToObj() method will autobox the primitive char into a Character object because streams of objects require boxed types.
	•	Behavior:
	•	The intermediate result is a Stream<Character> due to the automatic boxing of the char to Character. 
 */
