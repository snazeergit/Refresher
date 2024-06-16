package com.java.core;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


/*
 * Demonstrates Serialization and Deserialization using transient keyword
*/
public class Student implements Serializable {

	String fullName;
	String email;
	transient String password;

	/*
	 * Constructor
	 */
	Student(String fullName, String email, String password) {
		this.fullName = fullName;
		this.email = email;
		this.password = password;
	}

	public static void main(String[] args) {
		Student student = new Student("Salman Khan", "salman.khan@gmail.com", "raindeer@123");

		serialize(student);
		deserialize();
	}

	private static void serialize(Student student) {
		try {
			System.out.println("Student serializing: " + student.toString());
			FileOutputStream fileOut = new FileOutputStream("student.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(student);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	private static void deserialize() {
		try {
			FileInputStream fileIn = new FileInputStream("student.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			Student student = (Student) in.readObject();
			in.close();
			fileIn.close();
			System.out.println("Student deserialized: " + student.toString());
		} catch (IOException | ClassNotFoundException i) {
			i.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return ("Student{" + "fullName='" + fullName + '\'' + ", email='" + email + '\'' + ", password='" + password
				+ '}');
	}
}
