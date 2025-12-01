public class CarFuelSystem {
    private boolean carState = false;
    private boolean movingState = false;
    private int maximumFuelCapacity = 50;
    private int currentFuelLevel = 0;
    private int fuelEfficiency = 10;

    public int getFuelTankLevel() {
        return currentFuelLevel;
    }

    public int addFuel(int fuelAmount) {
        if (fuelAmount < 0) {
            return currentFuelLevel;
        }
        currentFuelLevel += fuelAmount;
        if (currentFuelLevel > maximumFuelCapacity) {
            currentFuelLevel = maximumFuelCapacity;
        }
        return currentFuelLevel;
    }


    public void startCar() {
        this.carState = true;
    }

    public boolean stopCar() {
        this.carState = false;
        return carState;
    }   


    public void driveCar(int distance) {
        if(!carState) {
            System.out.println("Start the car first.");
        }
        int fuelNeeded = distance / fuelEfficiency;
        if (currentFuelLevel >= fuelNeeded) {
            currentFuelLevel -= fuelNeeded;
            this.movingState = true;
        } 
        
        else {
            System.out.println("Not enough fuel to drive the desired distance.");
        }
    }
}
