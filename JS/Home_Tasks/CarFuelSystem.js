let carState = false;
let fuelEfficiency = 10;
let movingState = false;
let maxFuelCapacity = 50;       
let currentFuelLevel = 0;

function getFuelTankLevel() {
    return currentFuelLevel;
}

function addFuel(fuel) {
    if (fuel <= 0) {
        return 0;
    }
    if (currentFuelLevel + fuel > maxFuelCapacity) {
        currentFuelLevel = maxFuelCapacity;
        return currentFuelLevel;
    } else {
        currentFuelLevel += fuel;
        return currentFuelLevel;
    }
}

function startCar() {
    carState = true;
}   

function driveCar(distance) {
    if(!carState) {
        console.log("Start the car first.");
        return false;
    }
    let fuelNeeded = distance / fuelEfficiency;
    if (currentFuelLevel >= fuelNeeded) {
        currentFuelLevel -= fuelNeeded;
        movingState = true;
        return true;
    } else {
        console.log("Not enough fuel to drive the distance.");
        return false;
    }   

}
function stopCar() {
    carState = false;
    movingState = false;
    return carState;
}       

module.exports = {
    getFuelTankLevel,
    addFuel,    
    startCar,
    driveCar,
    stopCar
};


