package com.vmware.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class FileReadnPrint {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		try {
			BufferedReader reader = new BufferedReader(
					new FileReader(new File("/Users/armaansyed/Downloads/Employee_Info.csv")));
			String st = reader.readLine();

			while (st != null) {
				System.out.println(st);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}