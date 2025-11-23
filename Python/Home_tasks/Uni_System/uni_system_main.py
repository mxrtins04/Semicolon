from uni_system_functions import *

students_database = {}

while True:
    print("\n--- Bright Future University Student System ---")
    print("1. Add new student")
    print("2. Display full student record")
    print("3. Display student courses")
    print("4. Display student city")
    print("5. Display student zip code")
    print("6. Add a course for a student")
    print("7. Remove or update a student's course")
    print("8. Update student information")
    print("9. Count total students")
    print("0. Exit")

    choice = input("Enter your choice: ")

    if choice == "1":
        username = input("Enter a unique username for the student: ")
        name = input("Enter student's full name: ")
        age_input = input("Enter student's age: ")
        courses_input = input("Enter courses separated by commas: ")
        city = input("Enter city: ")
        zip_code = input("Enter zip code: ")

        try:
            age = int(age_input)
            courses = set(course.strip() for course in courses_input.split(",") )
            added = add_student_to_database(students_database, username, name, age, courses, city, zip_code)
            if added == True:
                print(f"Student {username} added successfully!")
            else:
                print("Username already exists or invalid input.")
        except ValueError:
            print("Invalid age entered. Student !added.")

    elif choice == "2":
        username = input("Enter the student's username: ")
        student = students_database.get(username)
        if student is not None:
            print("\nStudent Record:")
            print(student)
        else:
            print("Student not found.")

    elif choice == "3":
        username = input("Enter the student's username: ")
        student = students_database.get(username)
        if student is not None:
            print("Courses:", student["courses"])
        else:
            print("Student not found.")

    elif choice == "4":
        username = input("Enter the stuent's username: ")
        student = students_database.get(username)
        if student is not None:
            print("City:", student["address"]["city"])
        else:
            print("Student not found.")

    elif choice == "5":
        username = input("Enter the student's username: ")
        student = students_database.get(username)
        if student is not None:
            print("Zip code:", student["address"]["zip"])
        else:
            print("Student not found.")

    elif choice == "6":
        username = input("Enter the stuent's username: ")
        course = input("Enter course to add: ")
        student = students_database.get(username)
        if student is not None:
            added = add_course_to_student(student, course)
            if added == True:
                print(f"{course} added successfully.")
            else:
                print(f"Cannot add {course}. It may be invalid or already added.")
        else:
            print("Student not found.")

    elif choice == "7":
        username = input("Enter the student's username: ")
        course = input("Enter course to remove or update: ")
        student = students_database.get(username)
        if student is not None:
            removed = update_student_course(student, course, None)
            if removed == True:
                print(f"{course} removed successfully.")
            else:
                print(f"{course} not found in student's courses.")
        else:
            print("Student not found.")

    elif choice == "8":
        username = input("Enter the student's username: ")
        student = students_database.get(username)
        if student is not None:
            print("Which field do you want to update?")
            print("1. Name")
            print("2. Age")
            print("3. City")
            print("4. Zip code")
            field_choice = input("Enter choice: ")

            if field_choice == "1":
                new_name = input("Enter new name: ")
                if update_student_field(student, "name", new_name) == True:
                    print("Name updated successfully.")
                else:
                    print("Invalid name.")

            elif field_choice == "2":
                new_age_input = input("Enter new age: ")
                try:
                    new_age = int(new_age_input)
                    if update_student_field(student, "age", new_age) == True:
                        print("Age updated successfully.")
                    else:
                        print("Invalid age.")
                except ValueError:
                    print("Invalid input. Age must be a number.")

            elif field_choice == "3":
                new_city = input("Enter new city: ")
                if update_student_field(student, "city", new_city) == True:
                    print("City updated successfully.")
                else:
                    print("Invalid city.")

            elif field_choice == "4":
                new_zip = input("Enter new zip code: ")
                if update_student_field(student, "zip", new_zip) == True:
                    print("Zip code updated successfully.")
                else:
                    print("Invalid zip code.")

            else:
                print("Invalid choice.")
        else:
            print("Student not found.")

    elif choice == "9":
        total = count_students(students_database)
        print("Total students in system:", total)

    elif choice == "0":
        print("Exiting program. Goodbye!")
        break

    else:
        print("Invalid choice. Please select a number from 0 to 9.")
