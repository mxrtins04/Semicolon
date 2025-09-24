/*
- Prompt the user to input an integer
- Assign the user's input to the variable num
- Check if num has any remainders when divided by 2, if it does print "odd". 
- Check if num has any remainders when divided by 2, if it does not have any remainders print "even". 
- If none of the above outcomes occur print "Invalid" */

import java.util.Scanner;

public class OddEven{
public static void main(String [] args){
	Scanner input = new Scanner(System.in);
	System.out.print("Input an integer: :);
	int num = input.nextInt;

	if(num % 2 != 0){
	System.out.print("Odd");
}
	else if(num % 2 == 0){
	System.out.print("Even");
}
	else{System.out.print("Invalid");
}
	}
}
