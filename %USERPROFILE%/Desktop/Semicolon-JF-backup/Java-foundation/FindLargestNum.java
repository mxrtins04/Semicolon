/*
- Initialize variable counter to 1
- Initialize variable largest to 0
- While counter is less than or equal to 10:
. Prompt the user to enter an integer
. Collect the user's input and assign it to number
. If number is greater than largest, then assifn number to largest.
. Increase counter by q
- When the loop ends display variable largest is the largest number
*/

import java.util.Scanner;

public class FindLargestNum {
public static void main(String [] args){
	 Scanner input = new Scanner(System.in);

	int counter = 1;
	int largest = 0;

	while (counter <= 10){
		System.out.printf("Enter integer %d: ", counter);
		int number = input.nextInt();
		
		if (number > largest) {
			largest = number;
		}
		counter++;
}
	System.out.printf("The largest number entered is %d", largest);
	}
}
	
