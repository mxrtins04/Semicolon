import java.util.Scanner;

public class ScorePrinterStudent{
	public static void main(String [ ] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String name1 = input.nextLine();
		System.out.print("Enter your score: ");
		int score1 = input.nextInt();
		
		System.out.printf("Name: %s%nScore: %d%n", name1, score1);

		System.out.print("Enter your name: ");
		String name2 = input.next();
		System.out.print("Enter your score: ");
		int score2 = input.nextInt();

		System.out.printf("Name: %s%nScore: %d%n", name2, score2);

		System.out.print("Enter your name: ");
		String name3 = input.next();
		System.out.print("Enter your score: ");
		int score3 = input.nextInt();

		System.out.printf("Name: %s%nScore: %d%n", name3, score3);

		if (score1 >= score2 && score1 >= score3){
		System.out.printf("%s has the highest score of %d%n", name1, score1);}

		if (score2 >= score1 && score2 >= score3){
		System.out.printf("%s has the highest score of %d%n", name2, score2);}

		if (score3 >= score2 && score1 >= score1){
		System.out.printf("%s has the highest score of %d%n", name3, score3);}

		if (score1 <= score2 && score1 <= score3){
		System.out.printf("%s has the lowst score of %d%n", name1, score1);}
		
		if (score2 <= score3 && score2 <= score3){
		System.out.printf("%s has the lowst score of %d%n", name2, score2);}

		if (score3 <= score2 && score3 <= score1){
		System.out.printf("%s has the lowst score of %d", name3, score3);}



}}






