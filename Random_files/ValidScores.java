import java.util.Scanner;
public class ValidScores{

public static void main(String[] args){

	Scanner scanner = new Scanner(System.in);

	int[] scores = new int[11];
		int sum = 0;
		int score = 0;
		for(int count = 1; count <= 10; count++){
			System.out.print("Enter number " + count + " : ");
			score = scanner.nextInt();
       			if(score <= 100){
			scores[count] = score;
			sum += score;}
}




System.out.print("The sum is: " + sum);


}
}