import java.util.Scanner;

public class NumberClassifier{
	public static void main(String [ ] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Input 5 numbers(e.g 5 -5 0 3 54)");
		int firstNum = input.nextInt();
		int secondNum = input.nextInt();
		int thirdNum = input.nextInt();
		int fourthNum = input.nextInt();
		int fifthNum = input.nextInt();

		int numberOfNegative = 0;
		int numberOfPositive = 0;
		int numberOfZero = 0;
		if (firstNum < 0){
			numberOfNegative++;}

		if (secondNum < 0){
			numberOfNegative++;}

		if (thirdNum < 0){
			numberOfNegative++;}

		if (fourthNum < 0){
			numberOfNegative++;}

		if (fifthNum < 0){
			numberOfNegative++;}


		if (firstNum == 0){
			numberOfZero++;}

		if (secondNum == 0){
			numberOfZero++;}

		if (thirdNum == 0){
			numberOfZero++;}

		if (fourthNum == 0){
			numberOfZero++;}

		if (fifthNum == 0){
			numberOfZero++;}



		if (firstNum > 0){
			numberOfPositive++;}

		if (secondNum > 0){
			numberOfPositive++;}

		if (thirdNum > 0){
			numberOfPositive++;}

		if (fourthNum > 0){
			numberOfPositive++;}

		if (fifthNum > 0){
			numberOfPositive++;}

		System.out.printf("Number of positive inputs are: %d%nNumber of negative inputs are: %d%nNumber of zeros are:%d%n", numberOfPositive, numberOfNegative, numberOfZero);
	}
}