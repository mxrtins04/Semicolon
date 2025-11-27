const  { setGear, accelerate, startBike, switchOffBike, getSpeed} = require('./motorcycle')
let bike = {bikeState: false,
             speed: 0,
              gear: 1
            }
beforeEach(() => {
    bike.bikeState =false,
    bike.speed = 0,
    bike.gear = 1
            
});

test ("test bike is off by default", () =>{
    expect(bike.bikeState).toBeFalsy();
});

test ("test bike can be turned on", () =>{
    startBike(bike)
    expect(bike.bikeState).toBeFalsy();
})

test ("test that bike can be turned off when its on", () =>{
    startBike(bike);
    switchOffBike(bike);
    expect(bike.bikeState).toBeFalsy();
})

test ("test that initial speed of bike is 0", () =>{
    let speed = getSpeed(bike);
    expect(speed).toBe(0);
})

test ("test that accelerator increases speed", () =>{
    accelerate(bike);
    speed = getSpeed(bike);
    expect(speed).toBe(1);
})

test ("test that a")