/*
- Repeat the following processes 3 times 
- Prompt user to input their name
- Assign user input to variable name
- Prompt the user to put in annual earnings
- Assign user input to variable earnings
- Declare a new variable tax
- Check if earnings is less than or equal to 30000. If so initialize variable tax and let it be equal to 15% of earnings. If not
- Let tax be equal to 15% of 30000 plus 20% of everything above 30000
- Display the citizen's name and tax amount.
- After 3 citizens are processed display "Program finished"
*/

import java.util.Scanner;

public class TaxCalculator{
public static void main(String [] args){
	Scanner input = new Scanner(System.in);
	int count = 0;
	
	while(count < 3){
		System.out.print("Enter citizen's name: ");
		String name = input.next();

		System.out.print("Enter " + name + " annual earnings: ");
		double earnings = input.nextDouble();
		double tax:

		if (earnings <= 30000) {
			tax = earnings * 0.15;
}
		else{
		tax = 30000 * 0.15 + (earnings - 300000) * 0.20;
}
	System.out.printf("%s total tax: %f%n", name, tax);
	
	count++;
}

System.out.println("Program terminated");
	}
}