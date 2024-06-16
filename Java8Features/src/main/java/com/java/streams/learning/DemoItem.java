package com.java.streams.learning;

import java.util.Arrays;
import java.util.List;

import com.java.model.Item;

public class DemoItem {

	public static void main(String[] args) {
		List<Item> list = Arrays.asList(new Item("apple", 200), new Item("Pineapple", 100));
		Integer sum=list.stream().map(i->i.getItemPrice()).mapToInt(Integer::new).sum();
		System.out.println(sum);
	}

}
