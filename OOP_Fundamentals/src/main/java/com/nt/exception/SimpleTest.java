package com.nt.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SimpleTest {

	public static void main(String[] args) throws FileNotFoundException {

		//Reads date from Keyboard and writes it to a file.
		/*
		 * Scanner s = new Scanner(System.in); System.out.println("Enter your name");
		 * String name = s.nextLine(); PrintWriter writer = new PrintWriter(new
		 * File("test.txt")); writer.print(name); writer.close();
		 * System.out.println(12/0);
		 */

		//Read data from a file and write to another file
		int[] a = { 1, 2, 3, 4, 5, 6 };
		System.out.println(Arrays.toString(a));
		int[] copyOfRange = Arrays.copyOfRange(a, 1, 3);
		System.out.println(Arrays.toString(copyOfRange));

		int[] copyOf = Arrays.copyOf(a, 4);
		System.out.println(Arrays.toString(copyOf));
		int[] copyOf1 = Arrays.copyOf(a, 10);
		System.out.println(Arrays.toString(copyOf1));

		int b[] = new int[3];
		b[0] = 0;
		b[2] = 2;
		//b[1] = 1;
		System.out.println(Arrays.toString(b));
		

		
	}

}
