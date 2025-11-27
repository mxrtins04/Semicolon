let bike = {bikeState: false,
             speed: 0,
              gear: 1
            }

function startBike(bike){
    let bikeState = bike.bikeState
    bikeState = true;

}

function switchOffBike(bike){
    let bikeState = bike.bikeState;
    bikeState = false;
}

function getSpeed(bike){
    let speed = bike.speed;
    return speed;
}

function setGear(){
    if (speed > 0 && speed <=20){
        bike["gear"] = 1;
    }
    else if (speed >= 21 && speed <=30){
        bike["gear"] = 2;
    }
    else if (speed >= 31 && speed <=40){
        bike["gear"] = 3;
    }
    else if( speed > 40)
        bike["gear"] = 4;

}

function accelerate(bike){
    bike.speed += 1;
}
module.exports = {setGear, startBike, switchOffBike, getSpeed, accelerate}



