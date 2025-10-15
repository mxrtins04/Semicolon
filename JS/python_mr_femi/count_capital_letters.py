word = "semIcoLOn"
uppercase_word = word.upper()
count = 0

for index in range(len(word)):
	if( word[index] == uppercase_word[index] ):
		count += 1

print(count)