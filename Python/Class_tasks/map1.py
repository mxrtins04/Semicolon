numbers = [1, 2, 3, 4, 5]

def square(numbers):
	return numbers ** 2
output = list(map(square, numbers))
print(output)