import java.util.Scanner;


public class RockPaperScissors{
public static void main(String[]args){
	Scanner input = new Scanner(System.in);
	System.out.println("You are playing a game, choose a number 	scissor(0), rock(1), paper(2)" );
	int number = input.nextInt();
	int computerGuess = number - 1;

	while(number == 1){
		if(computerGuess == 1 ){
		System.out.println("Draw");
	
}
		if(computerGuess == 0 ){
		System.out.println("The computer is scissor, you are rock. You win.");
		
}
		if(computerGuess == 2 ){
		System.out.println("The computer is paper, you are rock. You losw.");
		
}
	break;	

}
	while(number == 0){
		computerGuess = 2;
		if(computerGuess == 0 ){
		System.out.println("The computer is scissors, you are scissors. draw");
}
		if(computerGuess == 1 ){
		System.out.println("The computer rock, you are scissors. You lose.");
}
		if(computerGuess == 2 ){
		System.out.println("The computer is paper, you are scissors. You win.");
}
break;
}
	while(number == 2){
		if(computerGuess == 0 ){
		System.out.println("The computer is scissors, you are paper. You lose");
}
		if(computerGuess == 1 ){
		System.out.println("The computer rock, you are paper. You win.");
}
		if(computerGuess == 2 ){
		System.out.println("The computer is paper, you are paper. Draw.");
}
break;	}
		}
}
