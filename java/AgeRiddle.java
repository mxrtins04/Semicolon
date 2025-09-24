/*
- Prompt the user to put in son's age and assign user's input to variable son_age
- Prompt the user to put in the father's age and assign user's input to variable dad_age
- Initialize a new variable, years, to dad_age plus 0
- Write a condition that let's the program keep iterating through the following processes while year is not equal to son_age multiplied by 2:
	- Check if years is greater than son_age multiplied by 2. If so:
		- reduce years by 1
	- Check if years is less than son_age multiplied by 2. If so;
		- Increase years by 1
		
- Check if years is greater than dad_age. If so, re-initialize years to years minus dad_age and display "The age of the father would be double that of the son in (variable years) years". Then reinitialize years to years plus dad_age. If not,
- Re-initialize years to dad_age minus years and display "The age of the father was double that of the son (variable years) years ago".
*/

import java.util.Scanner;

public class AgeRiddle{
public static void main(String [] args){
	Scanner input = new Scanner(System.in);
	System.out.print("Input the father's age: ");
	int dadAge = input.nextInt();
	
	
	System.out.print("Input the son's age: ");
	int sonAge = input.nextInt();

	int years = 0;

while(years != (2 * sonAge)){
	if (years  > (sonAge * 2)){
		years--;}

	if (years < (sonAge * 2)){
		years++;}
}

if (years > dadAge){
	years = years - dadAge;
	System.out.printf("The age of the father would be double that of the son in %d years", years);}

if (years < dadAge){
	years = dadAge - years;
	System.out.printf("The age of the father was double that of the son %d years ago", years);}
	}
}
		
	
	
	
	
	