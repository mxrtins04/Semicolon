# test_motorcycle.py
import unittest
from functions import *
class TestMotorcycle(unittest.TestCase):

    def setUp(self):
        state = {
            "bikeState": False,
            "speed": 0,
            "gear": 1,
            "maxGear": 4
        }

    def test_that_the_bike_is_off_by_default(self):
        self.assertFalse(get_bike_state())

    def test_bike_starts(self):
        start_bike()
        self.assertTrue(get_bike_state())

    def test_bike_can_be_switched_off_after_starting(self):
        start_bike()
        turn_off_bike()
        self.assertFalse(get_bike_state())

    def test_acceleration(self):
        start_bike()
        accelerate()
        self.assertEqual(get_speed(), 1)
    def test_speed_is_zero_when_bike_is_off(self):
        start_bike()
        accelerate()
        accelerate()
        turn_off_bike()
        self.assertEqual(get_speed(), 0)

    def test_brake(self):
        start_bike()
        accelerate()
        accelerate()
        brake()
        self.assertEqual(get_speed(),  1)


    def test_accelerate_when_off(self):
        turn_off_bike()
        accelerate()
        self.assertEqual(get_speed(), 0)
