import java.util.Scanner;

public class TaskNine{
public static void main(String [] args){

int pair = 0;


	for(int count = 1; count <= 10; count++){
		while(count % 4 == 0){
		

		int num1 = count;
		int num2 = count * count;
		int num3 = count * count * count;
		int num4 = count * count * count * count;
		int num5 = count * count * count * count * count;
		
		pair = pair + num1 + num2 + num3 +num4 + num5;
		
		break;
		}
		

				}
		int square = pair * pair;
		System.out.printf("%d ", square);	}
	
}

