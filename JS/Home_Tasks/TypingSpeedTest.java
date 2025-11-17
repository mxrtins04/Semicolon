import java.util.Scanner;

public class TypingSpeedTest{
public static void main(String[] args) {
	CalculateAccuracy function = new CalculateAccuracy();
	Scanner scanner = new Scanner(System.in);
	String sentence = "The quick brown fox jumps over the lazy dog.";
	System.out.println("Type the following sentence:");
	System.out.println(sentence);

	long startTime = System.currentTimeMillis();
	System.out.print("\nYour input: ");
	String typedText = scanner.nextLine();
	long endTime = System.currentTimeMillis();

	double timeTaken = (endTime - startTime) / 1000.0;
	int wordCount = typedText.split(" ").length;
	double timeMinutes = timeTaken / 60.0;

	double wpm = 0;
	if( timeMinutes > 0 )
		wpm = wordCount / timeMinutes;
	else
		wpm = 0;
	double accuracy = calculateAccuracy(sentence, typedText);

	System.out.println("\nResults:");
	System.out.printf("Time taken: %.2f seconds%n", timeTaken);
	System.out.printf("Words per minute: %.2f%n", wpm);
	System.out.printf("Accuracy: %.2f%%%n", accuracy);
	scanner.close();
	}
}