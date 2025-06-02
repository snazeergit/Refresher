package myprep.v1;

public class Find_SubString_Count_In_Given_String {

	public static void main(String[] args) {
		
		String[] str = { "a", "abc", "bc", "d", "cd" };
		String word = "abc";
		
		//Using contains(-)
		int count=0;
		for(String s:str) {
			if(word.contains(s))
				count++;
		}
		System.out.println("Given string "+word+" has "+count+" substrings in the given String array");
		
		//Using indexOf(-)
		count=0;
		for(String s:str) {
			if(word.indexOf(s) !=-1)
				count++;
		}
		System.out.println("Given string "+word+" has "+count+" substrings in the given String array");
	}

}
