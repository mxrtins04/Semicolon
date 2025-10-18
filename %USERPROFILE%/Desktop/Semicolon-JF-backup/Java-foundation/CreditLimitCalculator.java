/* 
- Prompt the user enter account number and to input -1 to quit
- Assign users input to accountNumber
- While accountNumber is not -1:
. Ask user for beginning balance and assign it to beginningBalance.
. Ask user for total charges and assign it to totalCharges.
. Ask user for total credits and assign it to totalCredits.
. Ask user for credit limit and assign it to creditLimit
. Initialize a new variable newBalance and let it be equal to beginningBalance + totalCharges - totalCredits
. Display the account number and new balance.
. if newBalance is greater than creditLimit, display "Credit limit exceeded".
. Prompt user to enter next account number and -1 to stop the program.
. Assign the users input to accountNumber

- Once the program ends print "Program finished."
*/

import java.util.Scanner;

public class CreditLimitCalculator{
public static void main(String [] args){
	Scanner input = new Scanner(System.in);
	System.out.print("Enter accont number(Enter -1 to quit): ");
	int accountNumber = input.nextInt();
	
	while (accountNumber != -1){
		System.out.print("Enter beginning balance: ");
		int beginningBalance = input.nextInt();

		System.out.print("Enter total charges: ");
		int totalCharges = input.nextInt();

		System.out.print("Enter total credits: ");
		int totalCredits = input.nextInt();
		
		System.out.print("Enter allowed credit limit: ");
		int creditLimit = input.nextInt();
		int newBalance = beginningBalance + totalCharges - totalCredits;

		
		System.out.printf("Account: %d%n", accountNumber);

		System.out.printf("New balance is: %d%n", newBalance);

	if (newBalance > creditLimit) {
		System.out.println("Credit limit is exceeded");
}

		System.out.print("Enter account number (Enter -1 to quit) ");
		accountNumber = input.nextInt();
}
	System.out.println("Program finished.");
	}
}
		