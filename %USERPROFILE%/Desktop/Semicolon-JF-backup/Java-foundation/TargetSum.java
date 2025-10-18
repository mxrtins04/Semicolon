/*
- Prompt the user to enter target sum
- Assign user input to variable target
- Initialize variable sum to 0
- While sum is less than target:
. Prompt user to enter a number
. Assign user's input to value
. Add value to sum
- Display the sum
*/

import java.util.Scanner;
public class TargetSum{
public static void main(String [] args){
	Scanner input = new Scanner(System.in);
	System.out.print("Enter a target sum: ");
	int target = input.nextInt();
	int sum = 0;

	while(sum < target){
		System.out.print("Enter a number: ");
		int value = input.nextInt();
		sum += value;
}
	System.out.printf("The sum is %d", sum);
	}
}