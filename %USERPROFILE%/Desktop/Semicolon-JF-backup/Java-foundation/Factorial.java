/*
- Prompt the user to enter a non negative integer
- Assign user input to the variable n
- Initialize variable factorial to 1
- Initialize variable i to 1
- WHile i is less than or equal to n:
. Multiply factorial by i.
. Then increase i by 1
- After the loop ends, display "n! - (variable factorial)"
*/

import java.util.Scanner;

public class Factorial{
public static void main(String [] args){
	Scanner input = new Scanner(System.in);

	System.out.print("Enter a nonnegative integer: ");
	int n = input.nextInt();

	int factorial = 1;
	int i = 1;

	while (i <= n){
		factorial *= i;
		i++;
}
	System.out.printf("The factorial of %d is %d", n, factorial);
	}
}