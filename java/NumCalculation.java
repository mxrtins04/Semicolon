2.17
import java.util.Scanner;

public class NumCalculation{
	public static void main(String [ ] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Input first integer: ");
		int x = input.nextInt();
		System.out.print("Enter second integer: ");
		int y = input.nextInt();
		System.out.print("Enter third integer: ");
		int z = input.nextInt();
		int sum = x + y + z;

		int average = (x + y +z) / 3;

		int product = x * y * z;

		int highest = 0;
		int lowest = 0;

		if (x > y) {
			highest = x;
			lowest = y;}
		if (x < y) {
			highest = y;
			lowest = x;}



		if (z > highest) {
			highest = z;}

		if (z < lowest) {
			lowest = z;}


		System.out.printf("Sum is :%d%nAverage is: %d%nProduct is: %d%nHighest value is: %d%nLowest value is: %d%n", sum, average, product, highest, lowest);}

}