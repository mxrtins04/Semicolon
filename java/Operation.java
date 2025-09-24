import java.util.Scanner;

public class Operation{
	public static void main(String [ ] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Input first number: ");
		int firstNum = input.nextInt();
		input.nextLine();

		System.out.print("What type of operation do you want to perform?");
		String operator = input.nextLine();
		
		System.out.print("Input second number: ");
		int secondNum = input.nextInt();

		int result = 0;

		if ( operator.equals ("+")){
			result = firstNum + secondNum;}
		else if ( operator.equals ("-")){
			 result = firstNum - secondNum;}
		else if ( operator.equals ("*")){
			 result = firstNum * secondNum;}
		else if ( operator.equals ("/")){
			 result = firstNum / secondNum;}

		else {
			System.out.print("The operator you put in isn't valid.");
		}
		System.out.printf("The result is %d", result);
		
		}
}