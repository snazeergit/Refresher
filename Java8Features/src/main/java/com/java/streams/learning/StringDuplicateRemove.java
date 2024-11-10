package com.java.streams.learning;

public class StringDuplicateRemove {

	public static void main(String[] args) {
		String str = "ABBCCCDDDDEEEEE";
		StringBuilder sb = new StringBuilder();
		str.chars().distinct().forEach(c -> sb.append((char) c));
		System.out.println(sb);
	}

}
