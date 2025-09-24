import java.util.Scanner;

public class EvenOdd{
	public static void main(String [ ] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Input 4 digits (in this format 4 2 5 3): ");
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		int d = input.nextInt();

		int odd = 0;
		int even = 0;

		if (a % 2 == 0){
		even = even + a;}
		if (a % 2 != 0){
		odd = odd + a;}
		

		if (b % 2 == 0){
		even = even + b;}
		if (b % 2 != 0){
		odd = odd + b;}

		if (c % 2 == 0){
		even = even + c;}
		if (c % 2 != 0){
		odd = odd + c;}

		if (d % 2 == 0){
		even = even + d;}
		if (d % 2 != 0){
		odd = odd + d;}

		System.out.printf("The sum of the odd numbers are: %d%nThe sum of the even numbers is: %d", odd, even);

}
}