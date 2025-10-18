import java.util.Scanner;

public class EvenAverageSum{

public static void main(String[] args){

Scanner scanner = new Scanner(System.in);

int[] even = new int[11];

int evenNum = 0;
int count = 0;
int num = 0;

for(count = 1; count <= 10; count++){
System.out.print("Enter a number " + count + ": ");
num = scanner.nextInt();
even[count] = num;
if(num % 2 == 0){evenNum += num;
}

}
double average = evenNum / count;
System.out.println("The sum is: " + evenNum);
System.out.println("The average is: " + average);

}
}
