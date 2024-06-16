package com.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.java.model.Book;

public class BookDemo {

	public static void main(String[] args) {
		List<Book> books = Arrays.asList(
				new Book("The Fellowship of the Ring", "J.R.R. Tolkien", 1954, 30),
				new Book("The Hobbit", "J.R.R. Tolkien", 1937, 40), 
				new Book("Animal Farm", "George Orwell", 1945, 32),
				new Book("Nineteen Eighty-Four", "George Orwell", 1949, 50),
				new Book("Nineteen Eighty-Four", "George Orwell", 1949, 38));
		books.stream().filter(book -> book.getAuthor().equals("George Orwell") && book.getSoldCopies() > 30)
				.map(Book::getTitle).collect(Collectors.toSet()).forEach(System.out::println);

		Map<String, Long> map = books.stream()
				.collect(Collectors.groupingBy(b -> b.getAuthor(), Collectors.counting()));
		System.out.println(map);

	}

}