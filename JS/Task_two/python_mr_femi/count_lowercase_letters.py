word = "sEmIcoLOn"
lowercase_word = word.lower()
count = 0

for index in range(len(word)):
	if( word[index] == lowercase_word[index] ):
		count += 1

print(count)