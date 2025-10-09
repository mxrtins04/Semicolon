import java.util.Scanner;
public class SumOfEvenIndexes{

public static void main(String[] args){

	Scanner input = new Scanner(System.in);

	int[] scores = new int[10];
	int sum = 0;
	

	for(int index = 0; index < 10; index++){
		System.out.print("Input a number: ");
		int score = input.nextInt();
		scores[index] = score;
		if( index % 2 == 0)
			sum += score;
}


	int average = sum / (scores.length);

System.out.print("The sum of the even indexes is: " + sum);



}
}