public class MorningTeaMain{
public static void main(String [] args){
	MorningTea function = new MorningTea();
	String word = "aabb";
	
	char answer = function.findNonRepetitiveCharacter(word);
	System.out.print(answer);
	
}
}