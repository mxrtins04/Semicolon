import random
def find_length_of_list(list):
    count = 0
    for(item in list):
        count = count + 1
    return count

def creat_list():
    random_list = []
    for i in range(10):
        random_number = random.randint(1,50)
        random_list.append(random_number)
    return random_list

def sum_all_elements_at_even_positions(list):
    index = 0
    sum_of_num_at_even_positions = 0
    for item in list:
        if index % 2 == 0:
            sum_of_num_at_even_positions += item
        index = index + 1
    return sum_of_num_at_even_positions

def sum_all_elements_at_odd_positions(list):
    index = 0
    sum_of_num_at_even_positions = 0
    for item in list:
        if index % 2 != 0:
            sum_of_num_at_even_positions += item
        index = index + 1
    return sum_of_num_at_even_positions

def multiply_elements_at_every_third_positions(list):
    index = 0
    multiple_of_num_at_third_positions = 1

    for item in list:
        if index % 3 == 0:
            multiple_of_num_at_third_positions *= item
        index = index + 1
    return multiple_of_num_at_third_positions

def calculate_the_average_of_all_elements_in_the_list(list):
    sum = 0
    for item in list:
        sum = sum + item
    average = sum / len(list)
    return average

def get_largest_number(list):
    largest_number = 0
    for item in list:
        if item > largest_number:
            largest_number = item
    return largest_number

def get_smallest_number(list):
    smallest_number = 1000
    for item in list:
        if item < smallest_number:
            smallest_number = item
    return smallest_number
def count_