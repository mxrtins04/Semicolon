import unittest
from uni_system_functions import *

class TestUniSystem(unittest.TestCase):

    def test_if_create_and_add_student_works(self):
        students_database = {}
        add_student_to_database(students_database, "jakubu123", "jakubu jk", 22, ["Math"], "New York", "10001")
        self.assertIn("jakubu123", students_database)
        self.assertEqual(students_database["jakubu123"]["name"], "jakubu jk")
        self.assertEqual(students_database["jakubu123"]["age"], 22)
        self.assertIn("Math", students_database["jakubu123"]["courses"])
        
    def test_that_add_student_does_not_take_in_duplicatea(self):
        students_database = {}
        add_student_to_database(students_database, "jakubu123", "jakubu jk", 22, ["Math"], "semi", "10001")
        result = add_student_to_database(students_database, "jakubu123", "jakubusemi", 23, ["Physics"], "Lagos", "90001")
        self.assertFalse(result)
        
    def test_that_update_student_name_works_like_mad(self):
        students_database = {}
        add_student_to_database(students_database, "jakubu123", "jakubu jk", 22, [], "semi", "10001")
        update_student_field(students_database["jakubu123"], "name", "jakubusemi")
        self.assertEqual(students_database["jakubu123"]["name"], "jakubusemi")
        
    def test_that_update_student_name_does_not_collect_invalid_input(self):
        students_database = {}
        add_student_to_database(students_database, "johnxxx", "mohamed", 22, [], "semi", "10001")
        result = update_student_field(students_database["johnxxx"], "name", "")
        self.assertFalse(result)
        self.assertEqual(students_database["johnxxx"]["name"], "mohamed")
            
    def test_update_student_age_works(self):
        students_database = {}
        add_student_to_database(students_database, "littlemonkey17", "ife", 17, [], "jungle", "12301")
        update_student_field(students_database["littlemonkey17"], "age", 18)
        self.assertEqual(students_database["littlemonkey17"]["age"], 18)
        
    def test_that_update_student_age_does_not_collect_invalid_input(self):
        students_database = {}
        add_student_to_database(students_database, "mxr13", "martins", 21, [], "semicolon", "10001")
        result = update_student_field(students_database["mxr13"], "age", -5)
        self.assertFalse(result)
        self.assertEqual(students_database["mxr13"]["age"], 21)
        
    def test_add_course_works(self):
        students_database = {}
        add_student_to_database(students_database, "jakubu123", "jakubu jk", 22, [], "san torini", "18001")
        result = add_course_to_student(students_database["jakubu123"], "Math")
        self.assertTrue(result)
        self.assertIn("Math", students_database["jakubu123"]["courses"])
        
    def test_add_course_does_not_collect_duplicates(self):
        students_database = {}
        add_student_to_database(students_database, "jakubu123", "jakubu jk", 22, ["Math"], "semi", "10781")
        result = add_course_to_student(students_database["jakubu123"], "Math")
        self.assertFalse(result)
        
    def test_add_course_does_not_take_in_coureses_that_are_not_offered(self):
        students_database = {}
        add_student_to_database(students_database, "jjj", "jaih", 22, [], "semi", "10001")
        result = add_course_to_student(students_database["jjj"], "Ballet")
        self.assertFalse(result)
        
    def test_that_remove_course_works(self):
        students_database = {}
        add_student_to_database(students_database, "ponytailking", "pjk", 22, ["Math", "Physics"], "White house", "10001")
        result = update_student_course(students_database["ponytailking"], "Math", None)
        self.assertTrue(result)

        
    def test_that_user_cant_remove_a_course_that_student_doesnt_have(self):
        students_database = {}
        add_student_to_database(students_database, "shawn555", "sgawn", 22, ["Math"], "USA", "10001")
        result = update_student_course(students_database["shawn555"], "Physics", None)
        self.assertFalse(result)

    def test_update_city_works(self):
        students_database = {}
        add_student_to_database(students_database, "sendez", "wahab", 22, [], "semicolon", "10781")
        update_student_field(students_database["sendez"], "city", "go mycode")
        self.assertEqual(students_database["sendez"]["address"]["city"], "go mycode")
            
    def test_update_city_does_not_collect_invalid_input(self):
        students_database = {}
        add_student_to_database(students_database, "jakss", "jakubu jk", 22, [], "semi", "67001")
        result = update_student_field(students_database["jakss"], "city", "12345")
        self.assertFalse(result)
        
    def test_that_update_zip_works(self):
        students_database = {}
        add_student_to_database(students_database, "minny", "mane", 22, [], "mars", "10801")
        update_student_field(students_database["minny"], "zip", "90001")
        self.assertEqual(students_database["minny"]["address"]["zip"], "90001")
            
    def test_that_update_zip_does_not_collect_invalid_input(self):
        students_database = {}
        add_student_to_database(students_database, "godin", "jk", 22, [], "oyo", "10001")
        result = update_student_field(students_database["godin"], "zip", "abcde")
        self.assertFalse(result)
        
    def test_count_students_works(self):
        students_database = {}
        self.assertEqual(count_students(students_database), 0)
        add_student_to_database(students_database, "billy444", "thebills jk", 22, [], "oyo", "10001")
        add_student_to_database(students_database, "Bimpe56", "Bimpe Osemie", 20, [], "lagos", "90001")
        self.assertEqual(count_students(students_database), 2)
       
    def test_that_add_course_works_with_whitespace_and_mixed_case(self):   
        students_database = {}    
        add_student_to_database(students_database, "hk", "hakimi", 22, [], "semi", "19881")
        result1 = add_course_to_student(students_database["hk"], " math ")
        result2 = add_course_to_student(students_database["hk"], "English")
        self.assertTrue(result1)
        self.assertTrue(result2)
            
"""  def test_that_remove_course_cant_remove_course_from_empty_set(self):
        students_database = {}
        add_student_to_database(students_database, "john", "john legend", 22, [], "semi", "10001")
        result = update_student_course(students_database["john"], "Math", None)
        self.assertFalse(result) """
        