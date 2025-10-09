import java.util.Scanner;
public class AverageOfValidNumbers{

public static void main(String[] args){

	Scanner input = new Scanner(System.in);

	int[] scores = new int[10];
	double sum = 0;
	double count = 0;
	int index = 0;

	while(index < 10){
		
		System.out.print("Input a number: ");
		int score = input.nextInt();
		scores[index] = score;
		index++;
		
		if( score >= 0 && score <= 100 ){
			count ++;
			sum += score;}
		
		
}


	double average = sum / count;

System.out.print("The average of the valid numbers are: " + average);



}
}