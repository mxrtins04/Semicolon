import java.util.Scanner;

public class AverageRay{
public static void main(String[] args){

	Scanner scanner = new Scanner(System.in);

	int[] scores = new int[10];
		int sum = 0;
		double average = 0;
		int count = 0;
		for(count = 0; count < 10; count++){
			System.out.print("Enter number: ");
			int score = scanner.nextInt();
			scores[count] = score;
			sum += score;
			
}

average = sum / count;


System.out.print("The average is: " + average);


}
}
