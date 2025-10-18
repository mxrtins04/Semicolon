import java.util.Scanner;

public class AverageValidScores{
public static void main(String[] args){

	Scanner input = new Scanner(System.in);

	int[] scores = new int[10];
		int sum = 0;
		int score = 0;
		int count = 1;
		int count2 = 0;
		for(count = 1; count <= 10;count++){
			System.out.print("Enter a score: );
			score = input.nextInt();
       			if(score <= 100){
			count2++;
			scores[count] = score;
			sum += score;}
}



int average = sum / count2;
System.out.print("The average is: " + average);


}
}