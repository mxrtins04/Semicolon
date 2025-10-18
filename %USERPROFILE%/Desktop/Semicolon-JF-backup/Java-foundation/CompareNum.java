/*
- Prompt the user to enter the first number
- Assign user input to num1
- Prompt the user to enter the second number
- Assign user input to num2
- Check if num1 is equal to num2. If so print 0. If not
- Check if num1 is greater num2. If so print 1. if not
- Print -1
*/

import java.util.Scanner;

public class CompareNum{
public static void main(String [] args){
	Scanner input = new Scanner(System.in);


	System.out.print("Enter first number: ");
	int num1 = input.nextInt();
	
	System.out.print("Enter second number: ");
	int num2 = input.nextInt();

	if(num1 == num2){
		System.out.println("0");
}
	else if(num1 > num2){
		System.out.println("1");
}
	else{
		System.out.println("-1");
}
	}
}