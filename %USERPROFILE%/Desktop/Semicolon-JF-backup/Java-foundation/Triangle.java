/*
- Prompt the user to enter the base length of the triangle(It must be between 1 and 10)
- Assign users input to baseLength
- Initialize new variable row and assign the value 1 to it
- While row is less than or equal to baseLength:
. Initialize star and assign it the value 1
. while star is less than or equal to row:
	. Print an asterik without moving to the next line
	. Increase star by 1
. When this loop ends, move to next line.
. Increase row by 1
*/

import java.util.Scanner;


public class Triangle {
public static void main(String [] args) {
	Scanner input = new Scanner(System.in);
	System.out.print("Enter the base length of the triangle(Must be between 1 and 10): ");
	
	int baseLength = input.nextInt();
	int row = 1;
	
	while (row <= baseLength) {
		int star = 1;

		while(star <= row){
			System.out.print("*");
			star++;
}
		System.out.println();
		row++;
}
	}
}
			