import java.util.Scanner;

public class sumEven{

public static void main(String[] args){

	Scanner scanner = new Scanner(System.in);

	int[] even = new int[10];

	int evenNum = 0;
	int count = 0;
	

	for(count = 0; count < 10; count++){
		System.out.print("Enter a number: ");
		int num = scanner.nextInt();
		even[count] = num;
		if(num % 2 == 0){
			evenNum += num;
}

}

System.out.println(evenNum);

}
}
