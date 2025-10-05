import java.util.Scanner;

public class Factorial{
public static void main(String [] args){
	Scanner input = new Scanner(System.in);

	System.out.print("Enter a nonnegative integer: ");
	int n = input.nextInt();

	int factorial = 1;
	int i = 1;

	while (i <= n){
		factorial *= i;
		i++;
}
	System.out.printf("The factorial of %d is %d", n, factorial);
	}
}