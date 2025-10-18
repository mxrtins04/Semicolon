/*
- Prompt the user to input the first number.
- Assign the user's input to num1
- Initialize a new variable, max, and assign num1 to it.
- Initialize a new variable, count, and give it the value of 1.
- Collect the second number from the user and assign the user's input to num2.
- Check if num2 is greater than max. If so, assign num2 to max
- Check if num2 is equal to num1. If it is, increase count by 1
- Repeat this process for 6 different numbers. For each number check if it is greater than max. If it is assign it to the variable max, if it is equal to max increase count by 1.
- Add the last num7 and assign the value 0 to it.
- Print num1 to num7
- Print max and count

*/

import java.util.Scanner;

public class CompareNumbers{
public static void main(String [] args){
	Scanner input = new Scanner(System.in);
	System.out.print("Input the first number: ");
	int num1 = input.nextInt();
	
	int max = num1;
	int count = 0;

	System.out.print("Input the second number: ");
	int num2 = input.nextInt();

	if(num2 > max){
		max = num2;}
	else if (num2 == max){
		count++;}

	
	System.out.print("Input the third number: ");
	int num3 = input.nextInt();

	if(num3 > max){
		max = num3;}
	else if (num3 == max){
		count++;}



	System.out.print("Input the fourth number: ");
	int num4 = input.nextInt();

	if(num4 > max){
		max = num4;}
	else if (num4 == max){
		count++;}


	System.out.print("Input the fifth number: ");
	int num5 = input.nextInt();

	if(num5 > max){
		max = num5;}
	else if (num5 == max){
		count++;}


System.out.print("Input the sixth number: ");
	int num6 = input.nextInt();

	if(num6 > max){
		max = num6;}
	else if (num6 == max){
		count++;}


	int num7 = 0;

	System.out.printf("%d, %d, %d, %d, %d, %d, %d%n", num1, num2, num3, num4, num5, num6, num7);
	System.out.printf("The largest number is %d, and it appeared %d times", max, count);
	}
}