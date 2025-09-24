import java.util.Scanner;

public class NameAge{
	public static void main(String [ ] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Input a name and an age(i.e Martins 20): ");
		String firstName = input.next();
		int firstAge = input.nextInt();
		input.nextLine();
	
		System.out.print("Input second name and age: ");
		String secondName = input.next();
		int secondAge = input.nextInt();
		input.nextLine();

		System.out.print("Input a name and an age: ");
		String thirdName = input.next();
		int thirdAge = input.nextInt();
		input.nextLine();
	
		if (firstAge > secondAge && firstAge > thirdAge){
			System.out.printf("The oldest person is %s and is %d years old.%n", firstName, firstAge);}

		else if (secondAge > firstAge && secondAge >thirdAge){
			System.out.printf("The oldest person is %s and is %d years old.%n", secondName, secondAge);}
		else {
			System.out.printf("The oldest person is %s and is %d years old.%n", thirdName, thirdAge);}


		if (firstAge < secondAge && firstAge < thirdAge){
			System.out.printf("The youngest person is %s and is %d years old.%n", firstName, firstAge);}

		else if (secondAge < firstAge && secondAge < thirdAge){
			System.out.printf("The youngest person is %s and is %d years old.%n", secondName, secondAge);}
		else {
			System.out.printf("The youngest person is %s and is %d years old.%n", thirdName, thirdAge);}
}}