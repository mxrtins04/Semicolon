public class MotorcycleFunctions {

    private boolean bikeState;
    private int speed = 0;
    private int gear = 1;
    private int maxGear = 4;

    public void startBike(boolean bikeState) {
        this.bikeState = true;
    }


    public boolean getBikeState() {
        return this.bikeState;
    }
    public int getGear() {
        return this.gear;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
 

    public void setGear(int gear) {
         if (this.speed >= 0 && this.speed < 10)
            this.gear = 1;
        else if (this.speed >= 10 && this.speed < 20)
            this.gear = 2;
        else if (this.speed >= 30 && this.speed < 40)
            this.gear = 3;
        else if( this.speed >= 40)
            this.gear = 4;
    }

/*     public int reduceGear() {
        this.gear -= 1;
        if (this.gear < 1) {
            this.gear = 1;
        }

        return this.gear;
    } */


    public void accelerate() {
        if( gear == 1 ){
            this.speed += 1;
        } else if (gear == 2) {
            this.speed += 2;
        } else if (gear == 3) {
            this.speed += 3;
        } else if (gear == 4) {
            this.speed += 4;
        }

    }
    

    // Additional methods can be added here as needed
}