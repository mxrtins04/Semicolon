/*
- Initialize counter, let it be equal to 1
- Initialize largest to 0
- Initialize variable secondLargest to 0
- While counter is less than or equal to 10:
. Prompt the user to input a number
. Assign user's input to variable number
. If number is greater than largest:
	. Assign secondLargest to Largest
	. Assign Largest to number.
. Else if number is greater than SecondLargest and not equal to Largest:
	. Let SecondLargest be equal to number
. Increas counter by 1
- When the loop ends display largest and secondLargest
*/

import java.util.Scanner;

public class TwoLargestNumbers{
public static void main(String [] args) {
	Scanner input = new Scanner(System.in);

	int counter = 1;
	int largest = 0;
	int secondLargest = 0;


	while (counter <= 10){
		System.out.print("Enter an integer");
		int number = input.nextInt();
		
		if(number > largest) {
			secondLargest = largest;
			largest = number;
}
		else if(number > secondLargest && number != largest) {
			secondLargest = number;
}
	counter++;}
	
	System.out.printf("The largest number is %d%n", largest);
	System.out.printf("The second largest number is %d", secondLargest);
	}
}
