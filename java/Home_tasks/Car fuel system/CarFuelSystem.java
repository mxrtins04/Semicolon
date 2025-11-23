public class CarFuelSystem {
    boolean carState = false;
    boolean movingState = false;
    int maximumFuelCapacity = 50;
    int currentFuelLevel = 0;
    public int getFuelTankLevel() {
        return currentFuelLevel;
    }

    public int addFuel(int fuelAmount) {
        currentFuelLevel += fuelAmount;
        if (currentFuelLevel > maximumFuelCapacity) {
            currentFuelLevel = maximumFuelCapacity;
        }
        return currentFuelLevel;
    }

    public int getCurrentFuelLevel() {
        return currentFuelLevel;
    }   

    public boolean startCar() {
        this.carState = true;
        return carState;
    }

    public boolean stopCar() {
        this.carState = false;
        return carState;
    }   

    public void driveCar(int distance) {
        if(!carState) {
            System.out.println("Start the car first.");
        }
        int fuelNeeded = distance / 10;
        if (currentFuelLevel >= fuelNeeded) {
            currentFuelLevel -= fuelNeeded;
            this.movingState = true;
        } else {
            System.out.println("Not enough fuel to drive the desired distance.");
        }
    }
}
