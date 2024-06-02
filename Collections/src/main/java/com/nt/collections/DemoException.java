package com.nt.collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DemoException {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("test.txt")); 
		PrintWriter p = new PrintWriter(new File("wire.txt"));
		
		try (s;p) {

		}

		try {
			DemoException d = new DemoException();
		} catch (NullPointerException | NumberFormatException e) {
			// TODO: handle exception
		}

	}
}
