public class Uppercase{

public static void main(String [] args){
	String word = "semicolon";
	for(int length = 0; length < word.length() ; length++){
		char letter = word.charAt(length);
		letter.toUpperCase()
		System.out.print(letter);
		System.out.println();
		}
	
}}

