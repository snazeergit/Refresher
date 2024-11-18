package com.vmware.top15;

//Problem: Count the number of vowels and consonants in a string.
public class Count_Vowels_and_Consonants_in_a_String {

	public static void main(String[] args) {
		String str="Syed Nazeer";
		int vowels=0,consonents=0;
		for(char c:str.toLowerCase().toCharArray()) {
			if("aeiou".indexOf(c)!=-1)
				vowels++;
			else if(c>='a' && c<='z') 
				consonents++;
		}
		System.out.println("Total Vowels: "+vowels);
		System.out.println("Total Consonents: "+consonents);
	}

}
