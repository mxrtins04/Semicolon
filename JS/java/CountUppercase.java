public class CountUppercase{
	public static void main(String [] args){
		String word = "maRtINs";
		String uppercaseWord = word.toUpperCase();
		int uppercaseCount = 0;
		
	for(int count = 0; count < word.length(); count++){
		if( word.charAt(count) == uppercaseWord.charAt(count) )
			uppercaseCount ++;
		}

	System.out.print(uppercaseCount);
	}
}