public static double CalculateAccuracy(String originalText, String typedText) {
	int totalCharacters = originalText.length();
	if (totalCharacters == 0) return 0.0;
	int correctCharacters = 0;
	for (int index = 0; index < totalCharacters; index++) {
		if (index < typedText.length() && originalText.charAt(index) == typedText.charAt(index)) {
			correctCharacters++;
		}
	}
	return ((double) correctCharacters / totalCharacters) * 100;
}
