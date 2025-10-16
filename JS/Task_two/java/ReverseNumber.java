public class ReverseNumber{
	public static void main(String [] args){
		String number = "1109";
		int last_index = number.length() - 1;
		
	
	for(;last_index >= 0; last_index--){
		System.out.print(number.charAt(last_index));	}

	
	}
}