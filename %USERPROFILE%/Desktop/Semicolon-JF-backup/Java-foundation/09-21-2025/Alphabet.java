/*
- Prompt the user to put in an alphabet
- Assign the user's input to the variable letter
- Set a pre-defined list of letters(the vowels)
- Check if letter is the same as any of the predefined list of letters. If so, print "This alphabet is a vowel". If not,
- Display "This alphabet is a consonant"
*/

import java.util.Scanner;

public class Alphabet{
public static void main(String [] args){
	Scanner input = new Scanner(System.in);
	System.out.print("Input an alphabet(Uppercase please...): ");
	String letter = input.nextLine();

	switch (letter){
		case "A": 
			System.out.print("This letter is a vowel");
		case "E": 
			System.out.print("This letter is a vowel");
		case "I": 
			System.out.print("This letter is a vowel");
		case "O": 
			System.out.print("This letter is a vowel");
		case "U": 
			System.out.print("This letter is a vowel");
		break;
		
		default:
			System.out.print("This letter is a consonant!");
			}
					}
}