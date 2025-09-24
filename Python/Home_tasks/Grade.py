"""
- Prompt a user to enter three scores.
- Assign the user's input to the variables score1, score2, score3 respectively
- Initialize a new variable, sum, to the sum of score1, score2 and score3
- Initialize a new variable, average, to sum divided by 3
- Check if average is greater than or equal to 90 and less than or equal to 100. If so print "A". If not,
- Check if average is greater than or equal to 80 and less than 90. If so print "B". If not,
- Check if average is greater than or equal to 70 and less than 80. If so print "C". If not,
- Check if average is greater than or equal to 60 and less than 70. If so print "D". If not,
- - Check if average is greater than or equal to 0 and less than 60. If so print "E". If not,

"""

score1 = int(input("Input your first score: "))
score2 = int(input("Input your second score: "))
score3 = int(input("Input your third score: "))

sum = score1 + score2 + score3
average = sum / 3

if average >=90 and average <= 100:
	print("Your grade is A")
if average >=80 and average < 90:
	print("Your grade is B")
if average >=70 and average < 80:
	print("Your grade is C")
if average >=60 and average < 70:
	print("Your grade is D")
if average >= 0 and average < 60:
	print("You got an F... Damn")