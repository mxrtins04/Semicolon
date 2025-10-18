import java.util.Scanner;

public class Max{

public static void main(String[] args){


Scanner scanner = new Scanner(System.in);

System.out.print("Enter a number: ");
int max = scanner.nextInt();

 

for(int count = 1; count < 5; count++){
System.out.print("Enter a number: ");
int num = scanner.nextInt();

if(num > max){max = num;}

else{max = max;}


}

System.out.println("The largest is " + max);







}







}