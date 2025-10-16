public class Palindrome{
	public static void main(String [] args){
		String number = "12321";
		int last_index = number.length() - 1;
		String second_number = "";
	
	for(;last_index >= 0; last_index--){	
		second_number += number.charAt(last_index);}

	if( number.equals(second_number))
		System.out.print("True");
	else
		System.out.print("False");

	
	}
}