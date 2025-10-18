/*
- Create a new variable, row and assign the value 1 to it
- While row is less than or equal to 8:
. Check if row has no remainder when its divided by 2, if so print a space((i.e " "). Then,
. Initialize the vairiable col to 1
. While col is less than or equal to 8:
	. Print asterik followed by a space ("* ")
	. Increase col by 1
. Print a newline. Then,
. Increase row by 1
*/

public class Checkers{
public static void main(String [] args){
	int row = 1;
	
	while(row <= 8) {
		if(row %2 == 0){
			System.out.print(" ");
}
		int col = 1;
		while (col <= 8){
			System.out.print("* ");
			col++;
}
		System.out.println();
		row++;
}
	}
}