public class UpperCase{

public static void main(String [] args){
	String word = "semicolon";
	for(int length = 0; length < word.length() ; length++){
		char letter = word.charAt(length);
		
		System.out.print(letter.toUpperCase());
		System.out.println();
		}
	
}}

