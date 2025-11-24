import random
import string


def determine_data_type(user_input):
    uppercase_letters = string.ascii_uppercase
    lowercase_letters = string.ascii_lowercase
    for character in user_input:
        if character == 'A':
            character = uppercase_letters[random.randrange(len(uppercase_letters))]
        if character == '#':
            character = random.randrange(9)
        if character == '@':
            character = lowercase_letters[random.randrange(len(lowercase_letters))]
