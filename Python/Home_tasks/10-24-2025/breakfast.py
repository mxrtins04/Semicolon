from functools import reduce
num_list = ["1", "2", "3"]

integers = map(lambda x: int(x), num_list)
print(list(integers))

list_2 = [0, 5, 10, 15]

print(list(map(lambda x: x + 10, list_2)))


list_3 =  [0, 20, 37, 100]
print(list(map(lambda x: x * 1.8 + 32, list_3)))

list_4 =  [1, None, 3, None, 5]
print(list(filter(lambda x: x != None, list_4)))

list_5 = [1, 3, 4, 6, 9, 12]
print(list(filter(lambda j: j % 3 == 0, list_5)))

list_6 = [-2, -1, 0, 1, 2]
print(list(filter(lambda Im_tired: Im_tired > 0, list_6)))

list_7 =  [{'name': 'Alice', 'age': 30}, {'name': 'Bob', 'age': 20}]
print(list(filter(lambda x: x['age'] >25, list_7)))

list_8 = [1, 2, 3, 4, 5]
print(reduce(lambda x, y: x + y, list_8))

list_9 = [2, 3, 4]
print(reduce(lambda x, y: x * y, list_9))

list_10 = [3, 7, 2, 9, 1]
print(reduce(lambda x, y: x if x > y else y, list_10))

list_11 = ["Hello", " ", "World"]
print(reduce(lambda x, y: x + y , list_11))

list_12 = [{'a': 1}, {'b': 2}, {'c': 3}]
print(reduce(lambda x, y: x | y , list_12))

list_13 = [2, 3, 4]
print(reduce(lambda x , y: x   + y ** 2, list_13))



