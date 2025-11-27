state = {
    "bikeState": False,
    "speed": 0,
    "gear": 1,
    "maxGear": 4
}

def start_bike():
    state["bikeState"] = True

def turn_off_bike():
    state["bikeState"] = False
    state["speed"] = 0
    state["gear"] = 1

def get_bike_state():
    return state["bikeState"]

def get_gear():
    return state["gear"]

def get_speed():
    return state["speed"]

def set_speed(speed):
    state["speed"] = speed

def set_gear():
    speed = state["speed"]

    if 0 <= speed <= 20:
        state["gear"] = 1
    elif 20 < speed <= 30:
        state["gear"] = 2
    elif 30 < speed <= 40:
        state["gear"] = 3
    elif speed > 40:
        state["gear"] = 4

def accelerate():
    if state["bikeState"] == True:
        set_gear()
        gear = state["gear"]
        if gear == 1:
            state["speed"] += 1
        elif gear == 2:
            state["speed"] += 2
        elif gear == 3:
            state["speed"] += 3
        elif gear == 4:
            state["speed"] += 4

        set_gear()

def brake():
    set_gear()
    gear = state["gear"]
    if gear == 1:
        new_speed = state["speed"] - 1
    elif gear == 2:
        new_speed = state["speed"] - 2
    elif gear == 3:
        new_speed = state["speed"] - 3
    elif gear == 4:
        new_speed = state["speed"] - 4
    else:
        new_speed = state["speed"]

    if new_speed < 0:
        state["speed"] = 0
    else:
        state["speed"] = new_speed

    set_gear()
