def calculate_accuracy(original_text, typed_text):
	total_characters = len(original_text)
	if total_characters == 0:
		return 0.0
	correct_characters = 0
	for index in range(total_characters):
		if index < len(typed_text) and original_text[index] == typed_text[index]:
			correct_characters += 1
	return (correct_characters / total_characters) * 100
