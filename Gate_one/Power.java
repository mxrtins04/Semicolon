import java.util.Scanner;

public class Power{
public static void main(String [] args){
	int result1 = 1;
	int result 2= 2;

	Scanner input = new Scanner(System.in);
	System.out.print("Input two numbers: ");
	int num1 = input.nextInt();
	int num2 = input.nextInt();

	for(int power = 1; power <= num2; power++){
		result1 *= num1;}
		System.out.printf("%d raised to the power of %d is %d%n"), num1, num2, result1);

	for(int power = 2; power <= num1; power++){
		result2 *= num2;}

		System.out.printf("%d raised to the power of %d is %d%n", num2, num1, result2);