import java.util.Scanner;
public class TenNumber{
    public static void main(String []args){

	Scanner input = new Scanner(System.in);

	System.out.println("Enter ten numbers:");


	for(int i = 0; i < 10; i++){
            int number = Scanner.nextint();
            sum += number;

	System.out.println("The Sum of the ten numbers is: " + sum);

	}

}
}