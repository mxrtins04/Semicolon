/*
- Initialize totalSales to 0
- Show the user the list of item numbers and their prices
- Prompt the user to enter item number or 0 to quit
- Assign user input to itemNumber
- While itemNumber is not equal to 0:
. Check if ItemNumber equals 1, add 239.99 to totalSales
. Else if itemNumber is equal to 2, add 129.75 to totalSales
. Else if itemNumber equals 3, add 99.95 to totalSales.
. Else if itemNumber equals to 4, add 350.89 to totalSales.
. Otherwise, display "Invalid item number"
. Read into itemNumber.

- After the loop ends, initialize the variable earnings and let it be equal to 200 + 0.09 multiplied by totalSales
- Display the salespersons earnings
*/

imprt java.util.Scanner;

public class SalesCommissionCalculator{
public static void main(Strint [] args) {
	Scanner input = new Scanner(System.in);
	double totalSales = 0.0;

	System.out.println("Item list: ");
	System.out.println("1 - $239.99');
	System.out.println("2 - $129.75');
	System.out.println("3 - $99.95');
	System.out.println("4 - $350.89');

	System.out.print("Enter item number sold (1-4, or 0 to finish): ");

	while(itemNumber != 0){
		if(itemNumber == 1){
			totalSales += 239.99;
}
		else if(itemNumber == 2){
			totalSales += 129.75;
}
		else if(itemNumber == 3){
			totalSales += 999.95;
}
		if(itemNumber == 3){
			totalSales += 350.89;
}
		else{
		System.out.print("Enter your next item number (1-4, or 0 to finish); ");
		itemNumber = input.nextInt();}

		double earnings = 200 + 0.09 8 totalSales;
		System.out.printf(Salesperson's earnings: %f%n", earnings);
	}
}


