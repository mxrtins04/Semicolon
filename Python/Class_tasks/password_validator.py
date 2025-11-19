def validate_password(password):
    uppercase_count = 0
    lowercase_count = 0
    digits_count = 0
    symbols_count = 0
    minimum_number_count = 0
    number_of_digits = 0

    symbols = ["!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_" ,"+", "-", "=", "[" ,"]", "{", "}" ,";","'",":",'"',"|",",",".", "<",">" ,"/","?","~","`"]
    if password.strip() == "":
        return "Password is required."
    else:
        for char in password:
            if char.isupper():
                if uppercase_count <  1:
                    uppercase_count = uppercase_count + 1
            if char.islower():
                if lowercase_count < 1:
                    lowercase_count = lowercase_count + 1
            if char.isdigit():
                if digits_count < 1:
                    digits_count = digits_count + 1
            if char in symbols:
                if symbols_count < 1:
                    symbols_count = symbols_count + 1
            number_of_digits = number_of_digits + 1
    if number_of_digits >= 10:
        if minimum_number_count < 1:
            minimum_number_count = minimum_number_count + 1

    password_strength = minimum_number_count + uppercase_count + lowercase_count + digits_count + symbols_count
    print(password_strength, minimum_number_count, uppercase_count, lowercase_count, digits_count, symbols_count)
    if password_strength == 1:
        return "Password is too weak."
    if password_strength >1 and password_strength <= 3:
        return "Medium password"
    if password_strength == 5:
        return "Strong password"

    return password_strength

print(validate_password("MayO&pi3efssdc"))

