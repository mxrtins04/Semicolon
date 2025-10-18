import java.util.Scanner;
public class EvenIndexes{

public static void main(String[] args){

	Scanner scanner = new Scanner(System.in);

	int[] scores = new int[11];
		int sum = 0;
		int count = 0;
		for(count = 1; count <= 10; count++){
			System.out.print("Enter number " + count + ": ");
			int score = scanner.nextInt();
			if(count % 2 == 0){
			scores[count] = score;
			sum += score;  
			}
}



System.out.println("The sum is: " + sum);



}
}
