package com.java.streams.learning;

public class StringDuplicateRemove {

	public static void main(String[] args) {
		String str="Vikram  Kasse";
		//StringBuilder sb=new StringBuilder();
		//str.chars().distinct().forEach(e->sb.append((char)e));
		
		StringBuilder sb = new StringBuilder();
		str.chars().distinct().forEach(c -> sb.append((char) c));
		System.out.println(sb);
	}

}
