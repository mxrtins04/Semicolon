public class CountLowercase{
	public static void main(String [] args){
		String word = "maRtINs";
		String lowercaseWord = word.toLowerCase();
		int lowercaseCount = 0;
		
	for(int count = 0; count < word.length(); count++){
		if( word.charAt(count) == lowercaseWord.charAt(count) )
			lowercaseCount ++;
		}

	System.out.print(lowercaseCount);
	}
}