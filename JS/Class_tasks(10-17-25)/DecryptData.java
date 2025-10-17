import java.util.Scanner;

public class DecryptNumber{
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Input the 4 digit number you want to decrypt: ");
		int userInput = input.nextInt();
		int [] number = new int[4];
		int count = 0;
		int divisor = 1000;

		while(divisor >= 1){
			number[count] = userInput / divisor;
			count++;
			divisor *= 0.1;
			}

		for( int index = 0; index < number.length; index++ ){
			number[index] = (number[index] - 7) + 10;
			if( number[index] > 10 ) 
				number[index] = number[index] % 10;
			}
		
		int digit3Holder = number[2];
		int digit1Holder = number[0];
		int digit4Holder = number[3];
		int digit2Holder = number[1];

		number[0] = digit3Holder;
		number[2] = digit1Holder;
		number[1] = digit4Holder;
		number[3] = digit2Holder;
	
		for( int index = 0; index < number.length; index++ ){
			System.out.print(number[index]);}
	}}
		
