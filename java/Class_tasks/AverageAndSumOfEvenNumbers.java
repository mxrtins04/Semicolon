import java.util.Scanner;
public class AverageAndSumOfEvenNumbers{

public static void main(String[] args){

	Scanner input = new Scanner(System.in);

	int[] scores = new int[10];
	int sum = 0;
	int count = 0;
	

	for(int index = 0; index < 10; index++){
		System.out.print("Input a number: ");
		int score = input.nextInt();
		scores[index] = score;
		if( score % 2 == 0){
			sum += score;
			count ++;}
}


	int average = sum / count;

System.out.print("The average of the sum of the even indexes is: " + average);
System.out.printf("%nThe sum of the even indexes is: %d", sum);


}
}