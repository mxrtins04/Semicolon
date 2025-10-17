number = input("Input the number you want to decrypt: ")
number = [(int(count) - 7 + 10) for count in number]
decrypted = ""
digit3Holder = number[2];
digit1Holder = number[0];
digit4Holder = number[3];
digit2Holder = number[1];

number[0] = digit3Holder;
number[2] = digit1Holder;
number[1] = digit4Holder;
number[3] = digit2Holder;

for digit in number:
	decrypted += str(digit)

print(decrypted)