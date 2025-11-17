public class Test1{


public String reverseSentence(String sentence){
	String[] words = sentence.split(" ");
	int wordsLength = words.length;
	String reverse = "";
	for( int index = 0; index < wordsLength; index++ ){
		String word = words[index];
		int wordLength = word.length();
		
		while( wordLength - 1 >= 0 ){
			reverse += word.charAt(wordLength - 1);
			wordLength --;
			
		}
	reverse += " ";
	}
	return reverse;
}
}