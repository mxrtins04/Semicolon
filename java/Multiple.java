import java.util.Scanner;

public class Multiple{
	public static void main(String [ ] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Input a whole number: ");
		int number = input.nextInt();
		
		if (number % 6 == 0){
			System.out.printf("%d is a multiple of 6", number);}
		if (number % 7 == 0){
			System.out.printf("%d is a multiple of 7", number);}
		else if (number % 6 != 0 && number % 7 != 0){ 
			System.out.print("The number inputted isn't a multiple of 6 or 7");
}
	}
}