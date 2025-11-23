start = False
movingStatus = False
current_fuel_level = 0.0
fuel_efficiency = 10
maximum_fuel_capacity = 50


def check_start():
    return start

def check_fuel_level():
    return current_fuel_level


def start_car():
    start = True


def stop_car():
    start = False

def add_fuel(fuel):
    if current_fuel_level + fuel <= maximum_fuel_capacity and fuel > 0:
        current_fuel += fuel

def move_car(distance):
    fuel_consumed = distance / fuel_efficiency
    if distance > 0 and start == True:
        current_fuel  -= fuel_consumed
    else:
        return

def get_distance_moved():
    return distance_moved