import java.util.Scanner;

public class NegativeZero{
public static void main(String [] args){
	int sumPositive = 0;
	int sumNegative = 0;
	int sumZero = 0;

	do{
		Scanner input = new Scanner(System.in);
		System.out.print("Input a number: ");
		int number = input.nextInt();
		if(number < 0){
	sumNegative++;}
		else if(number > 0){
	sumPositive++;}
		else(number == 0){
	cumZero++;}}
	while(number != -1)
}}