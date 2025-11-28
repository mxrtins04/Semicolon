const {
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
} = require('./motorcycle');

let bike = {
	bikeState: false,
	speed: 0,
	gear: 1
};

beforeEach(() => {
	bike.bikeState = false;
	bike.speed = 0;
	bike.gear = 1;
});

test("test bike is off by default", () => {
	expect(getBikeState(bike)).toBeFalsy();
});

test("test bike can be turned on", () => {
	startBike(bike);
	expect(getBikeState(bike)).toBeTruthy();
});

test("test bike can be turned off", () => {
	startBike(bike);
	switchOffBike(bike);
	expect(getBikeState(bike)).toBeFalsy();
});

test("test initial gear is one", () => {
	expect(getGear(bike)).toBe(1);
});

test("test initial speed is zero", () => {
	expect(getSpeed(bike)).toBe(0);
});

test("test accelerator increases speed by 1 in gear 1", () => {
	startBike(bike);
	accelerate(bike);
	expect(getSpeed(bike)).toBe(1);
});

test("test accelerator can be called multiple times", () => {
	startBike(bike);
	accelerate(bike);
	accelerate(bike);
	accelerate(bike);
	expect(getSpeed(bike)).toBe(3);
});

test("test acceleration depends on gear", () => {
	startBike(bike);
	setSpeed(bike, 25);
	accelerate(bike);
	expect(getSpeed(bike)).toBe(27);

	setSpeed(bike, 35);
	accelerate(bike);
	expect(getSpeed(bike)).toBe(38);
});

test("test bike cannot accelerate when off", () => {
	accelerate(bike);
	expect(getSpeed(bike)).toBe(0);
});

test("test setGear works automatically based on speed", () => {
	startBike(bike);
	setSpeed(bike, 19);
	accelerate(bike);
	accelerate(bike);
	expect(getGear(bike)).toBe(2);

	setSpeed(bike, 30);
	accelerate(bike);
	expect(getGear(bike)).toBe(3);
});

test("test brake reduces speed", () => {
	setSpeed(bike, 10);
	brake(bike);
	expect(getSpeed(bike)).toBe(9);
});

test("test rate of deceleration increases with gear", () => {
	setSpeed(bike, 25);
	brake(bike);
	expect(getSpeed(bike)).toBe(23);
});

test("test speed never goes below zero", () => {
	brake(bike);
	brake(bike);
	expect(getSpeed(bike)).toBe(0);
});

test("test speed resets to zero when bike is turned off", () => {
	startBike(bike);
	setSpeed(bike, 20);
	switchOffBike(bike);
	expect(getSpeed(bike)).toBe(0);
});

test("test increaseGear works", () => {
	increaseGear(bike);
	expect(getGear(bike)).toBe(2);
});

test("test increaseGear cannot exceed 4", () => {
	setSpeed(bike, 50);
	expect(getGear(bike)).toBe(4);
	increaseGear(bike);
	expect(getGear(bike)).toBe(4);
});

test("test reduceGear works", () => {
	setSpeed(bike, 35);
	expect(getGear(bike)).toBe(3);
	reduceGear(bike);
	expect(getGear(bike)).toBe(2);
});

test("test reduceGear never goes below 1", () => {
	reduceGear(bike);
	expect(getGear(bike)).toBe(1);
});
