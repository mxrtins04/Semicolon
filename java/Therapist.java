import java.util.Scanner;

public class Therapist{

	public static void main(String [ ] args){
		Scanner input = new Scanner(System.in);
		System.out.print("What's your name?");
		String name = input.nextLine();
		
		
		System.out.print("Whats your age?");
		int age = input.nextInt();
		input.nextLine();

		

		System.out.print("How do you feel currently(Depressed, happy, sad, excited or tired?");
		String mood = input.nextLine();
		
		System.out.print("Guess a number");
		int guessedNum = input.nextInt();

		System.out.print("Want a piece of advice that could change your life?");
		String advice = input.next();
		
		System.out.printf("Hello %s, I'm Jakande, your assigned therapist. It's nice to meet you%n", name); 
		
		System.out.println("Young one, try and enjoy your life... while you can.");


		if ( age < 13 ){
		System.out.print("You are a young explorer");

}
		if (age >= 13 && age <= 19){
			System.out.println("Teen life is fun, enjoy it!");
}
		if ( age >= 20 && age <= 59 ){
			System.out.printf("You are %d years old... if you like don't be wise... Body go tell you%n", age);
}
		if (age > 60){
			System.out.println("Wisdom looks good on you.");
}
		if (mood.equals ("depressed")){
			System.out.println("Go to the gym.");
}
		if (mood.equals ("happy")){
			System.out.println("There are turbulent times ahead, dont forget.");
}
		if (mood.equals ("sad")){
			System.out.println("You are not sad, you're just broke... Let's not decieve ourselves.");
}
		if (mood.equals ("excited")){
			System.out.println("Clearly all your needs and wants are handled by your parents, cause i don't see any reason for you to be excited... Spoilt brat.");
}
		if (mood.equals ("tired")){
			System.out.println("Give up... You've been trying that side hustle for 3 years now, we both know it is never going to work out.");
}
		if (guessedNum == 15){
			System.out.println("Correct!!! I'll advice you, quickly go and gamble... before the grace on your head finishes");
}

		if (advice.equals ("yes")){
			System.out.println("Ok, here it goes... You might look up to the sky and see the stars today but look up to the sky tomorrow and see the sun, either ways never forget that to be diligent requires you to be wise and foolish at the same time.");
}
		else if(advice.equals ("no")){
			System.out.print("Ok then... Your loss.");
}
}}
