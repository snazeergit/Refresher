package com.nt.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
	
	String name;
	Integer age;
	String gender;
	List<String> locationPref;
	
	

}
