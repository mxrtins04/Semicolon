import java.util.Scanner;
public class SumRay{

public static void main(String[] args){

	Scanner scanner = new Scanner(System.in);

	int[] scores = new int[11];
		int sum = 0;
		for(int count = 0; count < 10; count++){
			System.out.print("Enter number: ");
			int score = scanner.nextInt();
			scores[count] = score;
			sum += score;
}




System.out.print("The sum is: " + sum);


}
}