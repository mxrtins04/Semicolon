import java.util.Scanner;

public class EvenAverage{

public static void main(String[] args){

	Scanner scanner = new Scanner(System.in);

	int[] even = new int[10];

	int evenNum = 0;
	int count = 0;
	int num = 0;

	for(count = 0; count < 10; count++){
		System.out.print("Enter a number: ");
		num = scanner.nextInt();
		even[count] = num;
		if(num % 2 == 0){
			evenNum += num;}

}
	int average = evenNum / count;
	System.out.printf("The average is: %d", average);

}
}
