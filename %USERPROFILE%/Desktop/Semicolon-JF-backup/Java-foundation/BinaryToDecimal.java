/*
- Prompt the user to enter a binary number(0 or 1)
- Assign the user input into the variable binaryNumber
- declare a new variable decimalValue and assign the value 0 to it
- declare a new variable base and assign the value 1 to it
- while binaryNumber is not 0:
. Extract the rightmost digit using by dividing it by 10 and getting the remainder
. Let decimalValue be equal to digit * base
. Re-initialize binaryNumber to be equal to binaryNumber / 10.
-After the loop, display decimalValue
*/

import java.util.Scanner;

public class BinaryToDecimal{
public static void main(String [] args){
	Scanner input = new Scanner(System.in);
	System.out.print("Enter a binary number (only 0s and 1s): ");
	
	int binaryNumber = input.nextInt();
	int decimalValue = 0;
	int base = 1;

	while (binaryNumber > 0){
		int digit = binaryNumber % 10;
		decimalValue += digit * base;
		base *= 2;
		binaryNumber /= 10;
}
	System.out.printf("Decimal equivalent of %d is: %d", binaryNumber, decimalValue);
	}
}

