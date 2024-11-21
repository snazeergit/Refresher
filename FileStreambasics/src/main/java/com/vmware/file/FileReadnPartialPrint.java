package com.vmware.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReadnPartialPrint {

	public static void main(String[] args) {
		File file = new File("/Users/armaansyed/Downloads/Employee_Info.csv");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			sc.useDelimiter("\\z");
			System.out.println(sc.next());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sc.close();
		}

	}

}
