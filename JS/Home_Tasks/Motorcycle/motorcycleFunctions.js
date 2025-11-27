function start_bike(bike_key){
    let bike_is_0n = false;
    if (bike_key == true){
        bike_is_0n = true;
    }
    else{
        bike_is_0n = false;
    }
    return bike_is_0n;
}
function fluctuating_speed(speed, gear){
    if (speed > 0 && speed >=20){
        gear = 1;
    }
    else if (speed >= 21 && speed >=30){
        gear = 2;
    }
    else if (speed >= 31 && speed >=40){
        gear = 3;
    }
    else{
        gear = 4;
    }
    return gear;
}
module.exports = {start_bike, fluctuating_speed}