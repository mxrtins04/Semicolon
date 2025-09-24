/*
-Initialize totalMiles to 0
- Initialize totalGallons to 0
- Prompt the user to put in miles driven for each trip and -1 to quit
- Assign users input to miles
- While miles is not -1:
-Prompt user to enter gallons used for trip
-Assign user input to variable gallons
-Create a new variable tripMpg and let it be equals to miles divided by gallons(make sure its floating-point)
-Display tripMpg
-Add miles to totalMiles
Add gallons to totalGallons
-Initialie a new  variable combinedMPG and let it be equals to totalMiles divided by totalGallons
-Display combinedMPG
-Prompt the user to enter miles driven for next trip(or -1 to quit).

- When the loop ends, display "Program finished"
*/

import java.util.Scanner;

public class GasMileage{
public static void main(String [] args){
	Scanner input = new Scanner(System.in);
	int totalMiles = 0;
	int totalGallons = 0;

	System.out.print("Enter miles driven (Enter -1 to quit): ");
	int miles = input.nextInt();
	
	while (miles != -1){
		System.out.print("Enter gallons used: ");
		int gallons = input.nextInt();
		double tripMpg = (double) miles / gallons;
		System.out.printf("Miles per gallon for this trip is: %f%n", tripMpg);
	
		totalMiles += miles;
		totalGallons += gallons;

		double combinedMpg = (double) totalMiles/ totalGallons;
 		System.out.printf("Combined miles per gallon so far: %f%n", combinedMpg);

		System.out.print("Enter miles driven (Enter -1 to quit): ");
		miles = input.nextInt();
		}
	System.out.println("Program finished.");
	}
}
