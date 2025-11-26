import java.util.Scanner;
public class CCValidator {
public static void main(String[] args) {
Scanner input = new Scanner(System.in);

System.out.print("Hello, kindly Enter Card details to verify: ");
while(!input.hasNext()) {
	System.out.print("Invalid input!");
	System.out.print("Hello, kindly Enter Card details to verify: ");
	input.nextLine();
}
String cardNumber = input.next();
System.out.println("Credit Card Type: " + CCValidatorFunctions.determineCardType(cardNumber));
System.out.println("Credit Card Number: " + cardNumber);
System.out.println("Credit Card Digit Length: " + cardNumber.length());
if(!(CCValidatorFunctions.determineCardType(cardNumber).equals("Invalid card type")) && !(CCValidatorFunctions.isValidLength(cardNumber) == false)) 
	if (CCValidatorFunctions.getTotalSum(cardNumber) % 10 == 0)
	System.out.print("Credit Card Validity Status is: valid");

else System.out.print("Credit Card Validity Status: Invalid");


}

}
	