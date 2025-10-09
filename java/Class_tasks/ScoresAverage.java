import java.util.Scanner;
public class Average{

public static void main(String[] args){

	Scanner input = new Scanner(System.in);

	int[] scores = new int[10];
	int sum = 0;
	

	for(int index = 0; index < 10; index++){
		System.out.print("Input a number: ");
		int score = input.nextInt();
		scores[index] = score;
		sum += score;
}


	int average = sum / (scores.length);

System.out.printf("The average of the numbers is %d", average);


}
}