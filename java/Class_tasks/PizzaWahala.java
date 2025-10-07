import java.util.Scanner;

public class PizzaWahala{
public static void main( String [] args){

	Scanner input = new Scanner(System.in);
	
	
	System.out.print("How many people are you squandering your money on? ");
	int numOfPeople = input.nextInt();
	System.out.print("""

	----------------------------------------------------------
	| Pizza Type	 |Number of Slices|Price per box  |    	 |
	|________________|________________|_______________|______|
	| Sapa size	 |4		  |2500		  |    	 |
	|________________|________________|_______________|______|
	| Small money	 |6		  |2900		  |    	 |
	|________________|________________|_______________|______|
	| Big boys	 |8		  |4000		  |    	 |
	|________________|________________|_______________|______|
	| Odogwu	 |12		  |5200		  |    	 |
	|________________|________________ |_______________|______|	
	""");
	System.out.print("What pizza type would you like to order? ");
	input.nextLine();
	String pizzaType = input.nextLine().toLowerCase();
	
	switch(pizzaType){
		case "sapa size" -> {
			int numberOfSlices = 4;
			int pricePerBox = 2500;
	
			int numberOfBoxes = Kata.getNumberOfBoxes(numOfPeople, numberOfSlices);
			int leftover = Kata.getLeftOverPizza(numOfPeople, numberOfSlices, numberOfBoxes);
			int bill = Kata.getMoneySpentOnPizza(numberOfBoxes, pricePerBox);

			System.out.printf("%nNumber of boxes of pizza to buy = %d boxes", numberOfBoxes);


			if( leftover > 0)
				System.out.printf("%nNumber left over after serving = %d", leftover);

			System.out.printf("%nPrice = %d", bill);
			}

		case "small money" -> {
			int numberOfSlices = 6;
			int pricePerBox = 2900;
			int numberOfBoxes = Kata.getNumberOfBoxes(numOfPeople, numberOfSlices);
			int leftover = Kata.getLeftOverPizza(numOfPeople, numberOfSlices, numberOfBoxes);
			int bill = Kata.getMoneySpentOnPizza(numberOfBoxes, pricePerBox);



			System.out.printf("Number of boxes of pizza to buy = %d boxes", numberOfBoxes);


			if( leftover > 0)
				System.out.printf("%nNumber left over after serving = %d", leftover);

			System.out.printf("%nPrice = %d", bill);
			}

		case "big boys" -> {
			int numberOfSlices = 8;
			int pricePerBox = 4000;
			int numberOfBoxes = Kata.getNumberOfBoxes(numOfPeople, numberOfSlices);
			int leftover = Kata.getLeftOverPizza(numOfPeople, numberOfSlices, numberOfBoxes);
			int bill = Kata.getMoneySpentOnPizza(numberOfBoxes, pricePerBox);



			System.out.printf("Number of boxes of pizza to buy = %d boxes", numberOfBoxes);


			if( leftover > 0)
				System.out.printf("%nNumber left over after serving = %d", leftover);

			System.out.printf("%nPrice = %d", bill);
			}


		case "odogwu" -> {
			int numberOfSlices = 12;
			int pricePerBox = 5200;
			int numberOfBoxes = Kata.getNumberOfBoxes(numOfPeople, numberOfSlices);
			int leftover = Kata.getLeftOverPizza(numOfPeople, numberOfSlices, numberOfBoxes);
			int bill = Kata.getMoneySpentOnPizza(numberOfBoxes, pricePerBox);



			System.out.printf("Number of boxes of pizza to buy = %d boxes", numberOfBoxes);


			if( leftover > 0)
				System.out.printf("%nNumber left over after serving = %d", leftover);

			System.out.printf("%nPrice = %d", bill);
			}





	}
}}