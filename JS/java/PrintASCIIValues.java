public class PrintASCIIValues{
	public static void main(String [] args){
		String word = "maRtINs";
		
		
		
	for(int count = 0; count < word.length(); count++){
		int ASCIIvalue = word.charAt(count);
		System.out.printf("The ASCII value of %s is: %d%n", word.charAt(count), ASCIIvalue);}

	
	}
}