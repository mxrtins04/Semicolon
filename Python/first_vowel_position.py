word = "ten"
vowels = ["a","e","i","o","u"]

count = 0
for letter in word:
	for vowel in vowels:
		if letter == vowel:
			count += 1
			break
print(count)
					