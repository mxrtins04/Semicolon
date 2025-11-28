function startBike(bike) {
	bike.bikeState = true;
}

function switchOffBike(bike) {
	bike.bikeState = false;
	bike.speed = 0;
	bike.gear = 1;
}

function getBikeState(bike) {
	return bike.bikeState;
}

function getSpeed(bike) {
	return bike.speed;
}

function getGear(bike) {
	return bike.gear;
}

function setSpeed(bike, newSpeed) {
	if (newSpeed < 0) {
		bike.speed = 0;
	} else {
		bike.speed = newSpeed;
	}
	updateGear(bike);
}

function updateGear(bike) {
	let currentSpeed = bike.speed;

	if (currentSpeed >= 0 && currentSpeed <= 20) {
		bike.gear = 1;
	} else if (currentSpeed >= 21 && currentSpeed <= 30) {
		bike.gear = 2;
	} else if (currentSpeed >= 31 && currentSpeed <= 40) {
		bike.gear = 3;
	} else if (currentSpeed > 40) {
		bike.gear = 4;
	}
}

function accelerate(bike) {
	if (bike.bikeState === false) {
		return;
	}

	if (bike.gear === 1) {
		bike.speed = bike.speed + 1;
	} else if (bike.gear === 2) {
		bike.speed = bike.speed + 2;
	} else if (bike.gear === 3) {
		bike.speed = bike.speed + 3;
	} else if (bike.gear === 4) {
		bike.speed = bike.speed + 4;
	}

	updateGear(bike);
}

function brake(bike) {
	if (bike.gear === 1) {
		bike.speed = bike.speed - 1;
	} else if (bike.gear === 2) {
		bike.speed = bike.speed - 2;
	} else if (bike.gear === 3) {
		bike.speed = bike.speed - 3;
	} else if (bike.gear === 4) {
		bike.speed = bike.speed - 4;
	}

	if (bike.speed < 0) {
		bike.speed = 0;
	}

	updateGear(bike);
}

function increaseGear(bike) {
	if (bike.gear < 4) {
		bike.gear = bike.gear + 1;
	}
}

function reduceGear(bike) {
	if (bike.gear > 1) {
		bike.gear = bike.gear - 1;
	}
}

module.exports = {
	startBike,
	switchOffBike,
	getBikeState,
	getSpeed,
	getGear,
	setSpeed,
	accelerate,
	brake,
	increaseGear,
	reduceGear
};
