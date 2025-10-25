from functools import reduce

words = ["python", "programming", "data", "science", "learning", "challenge", "function", "variable", "loop", "string", "is", "fun"]

people = [
    {"name": "Alice", "age": 25, "city": "Lagos"},
    {"name": "Ben", "age": 30, "city": "Abuja"},
    {"name": "Clara", "age": 22, "city": "Port Harcourt"},
    {"name": "David", "age": 27, "city": "Enugu"},
    {"name": "Ella", "age": 35, "city": "Ibadan"},
    {"name": "Frank", "age": 29, "city": "Kano"},
    {"name": "Grace", "age": 24, "city": "Abeokuta"},
    {"name": "Henry", "age": 31, "city": "Jos"},
    {"name": "Ivy", "age": 28, "city": "Asaba"},
    {"name": "James", "age": 33, "city": "Uyo"}
]


numbers = [1,2,3,4,5,6,7,8,9,10]

result = (map(lambda x: x ** 2, numbers))

print(list(result))

even_numbers = filter(lambda j: j % 2 == 0, numbers)
print(list(even_numbers))

odd_numbers = filter(lambda j: j % 2 != 0, numbers)

cube_of_odd_numbers = map(lambda a: a ** 3, odd_numbers)
print(list(cube_of_odd_numbers))

sum_of_list = reduce(lambda x, y: x + y, numbers)
print(sum_of_list)


maximum_number = (lambda x, y: x if a > b else b, numbers)
print(maximum_number )

length_of_words = map(lambda x: len(x), words)
print(list(length_of_words))

words_shorter_than_four_letters = filter(lambda x: len(x) > 4, words)
print(list(words_shorter_than_four_letters))


print(reduce(lambda x, y: x + " " + y, words))

old_people = (list(filter(lambda x: x["age"] > 30, people)))
print(list(old_people))

names_of_old_people = (map(lambda x: print(x["name"]), old_people))
print(list(names_of_old_people))

mapped = list(map(lambda x: x ** 2, numbers))
filtered = list(filter(lambda x: x % 2 == 0, mapped))
reduced = reduce(lambda x, y: x + y, filtered)
print(reduced)


sentence_list = ["john is dumb", "The girl was broke", "Stop jumping"]
seperated = map(lambda x: print(x), sentence_list)
print(list(seperated))






