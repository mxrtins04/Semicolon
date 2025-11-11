import java.util.Arrays;
public class AddendsMain{
public static void main(String [] args){
	Addends function = new Addends();
	int[] numbers = {7, 5, 2, -4, 10};
	int[] answers = function.findAddends(numbers, 1);
	
		System.out.print(Arrays.toString(answers));
	
}
}
