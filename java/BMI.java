import java.util.Scanner;

public class BMI{
	public static void main(String [ ] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Input your weight(kg): ");
		int weight = input.nextInt();
		
		System.out.print("Input your height(metres): ");
		int height = input.nextInt();

		int BMI = weight / (height * height);
		
		System.out.printf("Your BMI is %d. Find your category below:%nBelow 18.5 - Underweight.%nBetween 18.5 - 24.9 - Healthy.%nBetween 25 - 29.9 - Overweight.%nAbove 30 - Obesity", BMI);
}}