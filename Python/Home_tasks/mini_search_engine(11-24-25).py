def showMatches(input, keyword):
    lowercase_input = input.lower()
    lowercase_keyword = keyword.lower()
    number_of_matches = 0
    match_location = ()
    for word in input:
        index = 0
        if  word == lowercase_keyword:
            number_of_matches += 1
            match_location += (index,)
    return match_location
