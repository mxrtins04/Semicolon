
import java.util.Scanner;

public class FindSquare{
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Input a number: ");
		int num = input.nextInt();
		int count = 1;
		int square = 0;
		while(count <= num){
			++count;
			square = square + num;
			
}
System.out.print(square);
}

		
}