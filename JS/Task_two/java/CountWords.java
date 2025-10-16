public class CountWords{
	public static void main(String [] args){
		String sentence = "I am a boy jumping up and down";
		int count = 0;
		
	
	for(int index = 0; index <= sentence.length(); index++){
		
		if( sentence.charAt(index).equals(" ") ){	
			count++;}

		}
	count += 1;
	System.out.print(count);
	
	}
}





