# test_motorcycle.py
import unittest
from functions import *
class TestMotorcycle(unittest.TestCase):

    def test_bike_starts(self):
        start_bike()
        self.assertTrue(get_bike_state())

    def test_bike_stops(self):
        start_bike()  # ensure it's on
        turn_off_bike()
        self.assertFalse(get_bike_state())
        self.assertEqual(get_speed(), 0)

    def test_acceleration(self):
        start_bike()
        accelerate()
        self.assertEqual(get_speed(), 1)

    def test_brake(self):
        start_bike()
        accelerate()
        brake()
        self.assertEqual(get_speed(), 0)


    def test_accelerate_when_off(self):
        turn_off_bike()
        accelerate()
        self.assertEqual(get_speed(), 0)
