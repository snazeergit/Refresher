package myprep.v1;

public class RemoveDuplicateCharsFromString {

	public static void main(String[] args) {
		String str = "ABBCCCDDDDEEEEE";
		StringBuilder sb = new StringBuilder();
		//chars() method returns IntStream so we are typecasting it back to char before we append
		str.chars().distinct().forEach(c -> sb.append((char) c));
		System.out.println(sb);
	}

}
