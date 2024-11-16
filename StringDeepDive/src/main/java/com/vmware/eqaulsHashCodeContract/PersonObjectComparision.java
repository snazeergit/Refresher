package com.vmware.eqaulsHashCodeContract;

/*
 * To Verify two persons are equal or not uncomment the equals() and hashCode() in Person class
 */
public class PersonObjectComparision {

	public static void main(String[] args) {

		Person p1=new Person(100, "Narasimha", 38);
		Person p2=new Person(100, "Narasimha", 42);
		Person p3=new Person(102, "Narasimha", 42);
		Person p4=new Person(103, "Narasimha", 58);
		
		if(p1.equals(p2))
			System.out.println(" p1 and p2 is same person");
		else
			System.out.println(" p1 and p2 are two different persons");
		
		
		if(p2.equals(p3))
			System.out.println(" p2 and p3 is same person");
		else
			System.out.println(" p2 and p3 are two different persons");
		
		
		if(p3.equals(p4))
			System.out.println(" p3 and p4 is same person");
		else
			System.out.println(" p3 and p4 are two different persons");
	}

}

/*
 * Outputs:-
 * 
 Criteria: If two persons are same if their names same
 p1 and p2 is same person
 p2 and p3 is same person
 p3 and p4 is same person
 
 Criteria: If two persons are same if their names and ages are same
 p1 and p2 are two different persons
 p2 and p3 is same person
 p3 and p4 are two different persons
 
 Criteria: If two persons are same if their names, ages and ids are same
 p1 and p2 are two different persons
 p2 and p3 are two different persons
 p3 and p4 are two different persons
 *
 *
 */
