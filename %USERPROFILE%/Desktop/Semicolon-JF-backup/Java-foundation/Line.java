/*
- Prompt user to enter a point(x1 and y1)
- Assign user input to variables x1 and y1 respectively
- Prompt user to enter a point(x2 and y2)
- Assign user input to variables x2 and y2 respectively
- Check if x1 is equal to x2. If so print "this line is perpendicular to the y axis". If not
- Check if y1 is equal to y2. If so print "This line is perpendicular to the x axis". If not
- Print "The line isn't perpendicular to any axis"
*/

import java.util.Scanner;

public class Line{
public static void main(String [] args){
	Scanner input = new Scanner(System.in);

	System.out.print("Enter x1 and y1: ");
	int x1 = input.nextInt();
	int y1 = input.nextInt();

	System.out.print("Enter x2 and y2: ");
	int x2 = input.nextInt();
	int y2 = input.nextInt();

	if (x1 == x2){
		System.out.println("The line is perpendicular to the y axis.");
}
	else if (y1 == y2){
		System.out.println("The line is perpendicular to the x axis.");
}
	else{
		System.out.println("The line is not perpendicular to any axis."); 
}
	}
}