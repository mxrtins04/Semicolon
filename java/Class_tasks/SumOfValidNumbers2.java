import java.util.Scanner;
public class SumOfValidNumbers2{

public static void main(String[] args){

	Scanner input = new Scanner(System.in);

	int[] scores = new int[10];
	int sum = 0;
	int index = 0;

	while(index < 10){
		
		System.out.print("Input a number: ");
		int score = input.nextInt();
		scores[index] = score;
		index++;
		if( score >= 0 && score <= 100 ){
			
			sum += score;}
		
		
}



System.out.print("The sum of valid numbers are: " + sum);



}
}