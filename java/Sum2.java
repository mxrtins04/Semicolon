import java.util.Scanner;

public class Sum2{
	public static void main(String [ ] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Input a 3 digit integer: ");
		int number = input.nextInt();
		
		int a = number / 100;
		int b = (number % 100) / 10;
		int c = (number % 100) % 10;
		int sum = a + b +c;

		System.out.printf("The individual digits are: %d, %d, %d%nThe sum is: %d.", a, b, c, sum);

		}
}