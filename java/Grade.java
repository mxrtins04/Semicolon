/*
- Prompt a user to enter three scores.
- Assign the user's input to the variables score1, score2, score3 respectively
- Initialize a new variable, sum, to the sum of score1, score2 and score3
- Initialize a new variable, average, to sum divided by 3
- Check if average is greater than or equal to 90 and less than or equal to 100. If so print "A". If not,
- Check if average is greater than or equal to 80 and less than 90. If so print "B". If not,
- Check if average is greater than or equal to 70 and less than 80. If so print "C". If not,
- Check if average is greater than or equal to 60 and less than 70. If so print "D". If not,
- - Check if average is greater than or equal to 0 and less than 60. If so print "F".
*/

import java.util.Scanner;

public class Grade{
public static void main(String [] args){
	Scanner input = new Scanner(System.in);
	System.out.print("Input your first score: ");
	int score1 = input.nextInt();
	System.out.print("Input your second score: ");
	int score2 = input.nextInt();
	System.out.print("Input your third score: ");
	int score3 = input.nextInt();
	
int sum = score1 + score2 + score3;
int average = sum / 3;

if (average >= 90 && average <= 100){
	System.out.print("Your grade is A");
}

if (average >= 80 && average < 90){
	System.out.print("Your grade is B");}

if (average >=70 && average < 80){
	System.out.print("Your grade is C");}

if (average >=60 && average < 70){
	System.out.print("Your grade is D");}

if (average >= 0 && average < 60){
	System.out.print("You got an F... Damn");}
	}
}
