OFFERED_COURSES = {
	"Math", "Physics", "Computer Science", "Biology", "Chemistry",
	"Statistics", "English", "Economics", "History", "Philosophy",
	"Sociology", "Political Science", "Geography", "Psychology", "Art",
	"Music", "Engineering", "Law", "Medicine", "Business"
}

def create_course_verification_dict(offered_courses):
	lookup_dictionary = {}
	for course in offered_courses:
		if isinstance(course, str):
			lookup_dictionary[course.strip().lower()] = course.strip()
	return lookup_dictionary

lookup_dict = create_course_verification_dict(OFFERED_COURSES)

def create_student_record(username, full_name, age, courses, city_name, zip_code_value):
	if not isinstance(username, str) or username.strip() == "":
		raise ValueError("Student's username must be a non-empty string... Please!!!")
	if not isinstance(full_name, str) or full_name.strip() == "":
		raise ValueError("Student's name must be a non-empty string")
	try:
		int_age = int(age)
	except Exception:
		raise ValueError("age must be an integer")
	if int_age <= 0 or int_age > 100:
		raise ValueError("Please put in your actual age")
	if not isinstance(courses, (list, set, tuple)):
		raise ValueError("courses must be a collection")
	normalized_courses = set()
	for course_candidate in courses:
		if not isinstance(course_candidate, str):
			continue
		normalized_key = course_candidate.strip().lower()
		if normalized_key in lookup_dict:
			normalized_courses.add(lookup_dict[normalized_key])
	address_dictionary = {"city": None, "zip": None}
	if isinstance(city_name, str) and city_name.strip() != "":
		address_dictionary["city"] = city_name.strip()
	zip_string = str(zip_code_value).strip()
	if zip_string != "" and zip_string.isdigit():
		address_dictionary["zip"] = zip_string
	student_record = {
		"_username": username.strip(),
		"name": full_name.strip(),
		"age": int_age,
		"courses": normalized_courses,
		"address": address_dictionary
	}
	return student_record

def display_student_record(student_record):
	if not isinstance(student_record, dict):
		raise ValueError("student_record must be a dictionary")
	return {
		"username": student_record.get("_username"),
		"name": student_record.get("name"),
		"age": student_record.get("age"),
		"courses": set(student_record.get("courses", set())),
		"city": student_record.get("address", {}).get("city"),
		"zip": student_record.get("address", {}).get("zip")
	}

def display_student_courses(student_record):
	if not isinstance(student_record, dict):
		raise ValueError("Student record must be a dictionary")
	courses_value = student_record.get("courses")
	if courses_value is None:
		return set()
	if not isinstance(courses_value, set):
		return set(courses_value)
	return set(courses_value)

def display_student_zip(student_record):
	if not isinstance(student_record, dict):
		raise ValueError("student_record must be a dictionary")
	address_value = student_record.get("address")
	if not isinstance(address_value, dict):
		return None
	return address_value.get("zip")

def display_student_city(student_record):
	if not isinstance(student_record, dict):
		raise ValueError("student_record must be a dictionary")
	address_value = student_record.get("address")
	if not isinstance(address_value, dict):
		return None
	return address_value.get("city")

def add_course_to_student(student_record, course_name):
	if not isinstance(student_record, dict):
		raise ValueError("student_record must be a dictionary")
	if not isinstance(course_name, str) or course_name.strip() == "":
		raise ValueError("course_name must be a non-empty string")
	normalized_key = course_name.strip().lower()
	if normalized_key not in lookup_dict:
		return False
	new_course_name = lookup_dict[normalized_key]
	course_set = student_record.get("courses")
	if course_set is None or not isinstance(course_set, set):
		course_set = set()
		student_record["courses"] = course_set
	if new_course_name in course_set:
		return False
	course_set.add(new_course_name)
	return True

def update_student_course(student_record, old_course_name, new_course_name):
	if not isinstance(student_record, dict):
		raise ValueError("Student record must be a dictionary")
	if not isinstance(old_course_name, str) or old_course_name.strip() == "":
		raise ValueError("The course must be a non-empty string")
	course_set = student_record.get("courses")
	if course_set is None or not isinstance(course_set, set) or len(course_set) == 0:
		return False
	old_key = old_course_name.strip().lower()
	existing_old_course = None
	for existing_course in list(course_set):
		if isinstance(existing_course, str) and existing_course.strip().lower() == old_key:
			existing_old_course = existing_course
			break
	if existing_old_course is None:
		return False
	if new_course_name is None:
		course_set.discard(existing_old_course)
		return True
	if not isinstance(new_course_name, str) or new_course_name.strip() == "":
		raise ValueError("The new course name must be a non-empty string or None(If you just want to delete old course)")
	new_key = new_course_name.strip().lower()
	if new_key not in lookup_dict:
		return False
	new_course = lookup_dict[new_key]
	if new_course == existing_old_course:
		return False
	if new_course in course_set:
		course_set.discard(existing_old_course)
		return True
	course_set.discard(existing_old_course)
	course_set.add(new_course)
	return True

def update_student_field(student_record, field_name, new_value):
	if not isinstance(student_record, dict):
		raise ValueError("Student record must be a dictionary")
	if not isinstance(field_name, str) or field_name.strip() == "":
		raise ValueError("field_name must be a non-empty string")
	field_key = field_name.strip().lower()
	if field_key == "name":
		if not isinstance(new_value, str) or new_value.strip() == "":
			return False
		student_record["name"] = new_value.strip()
		return True
	if field_key == "age":
		try:
			int_age = int(new_value)
		except Exception:
			return False
		if int_age <= 0 or int_age > 100:
			return False
		student_record["age"] = int_age
		return True
	if field_key == "city":
		if not isinstance(new_value, str) or new_value.strip() == "" or new_value.isdigit():
			return False
		address_value = student_record.get("address")
		if not isinstance(address_value, dict):
			address_value = {}
			student_record["address"] = address_value
		address_value["city"] = new_value.strip()
		return True
	if field_key in ("zip", "zipcode"):
		zip_string = str(new_value).strip()
		if zip_string == "" or not zip_string.isdigit():
			return False
		address_value = student_record.get("address")
		if not isinstance(address_value, dict):
			address_value = {}
			student_record["address"] = address_value
		address_value["zip"] = zip_string
		return True
	return False

def count_students(students_database):
	if not isinstance(students_database, dict):
		return 0
	return len(students_database)

def add_student_to_database(students_database, username, full_name, age, courses, city_name, zip_code_value):
	if not isinstance(students_database, dict):
		raise ValueError("students_database must be a dictionary")
	if not isinstance(username, str) or username.strip() == "":
		raise ValueError("username must be a non-empty string")
	normalized_username = username.strip()
	if normalized_username in students_database:
		return False
	student_record = create_student_record(normalized_username, full_name, age, courses, city_name, zip_code_value)
	students_database[normalized_username] = student_record
	return True

def get_student_from_database(students_database, username):
	if not isinstance(students_database, dict):
		raise ValueError("Students database must be a dictionary")
	if not isinstance(username, str) or username.strip() == "":
		return None
	return students_database.get(username.strip())
