sentence = "Jakande is now a big boy o."
print("Type the following sentence:")
print(sentence)
start_time = time.time()
typed_text = input("\nYour input: ")
end_time = time.time()

time_taken = end_time - start_time
word_count = len(typed_text.split())
time_minutes = time_taken / 60
wpm = word_count / time_minutes if time_minutes > 0 else 0
accuracy = calculate_accuracy(sentence, typed_text)

print(f"\nResults:")
print(f"Time taken: {time_taken:.2f} seconds")
print(f"Words per minute: {wpm:.2f}")
print(f"Accuracy: {accuracy:.2f}%")
