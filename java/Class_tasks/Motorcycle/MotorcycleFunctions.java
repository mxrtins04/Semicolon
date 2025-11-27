public class MotorcycleFunctions {

    private boolean bikeState = false;
    private int speed = 0;
    private int gear = 1;
    private int maxGear = 4;

    public void startBike() {
        this.bikeState = true;
    }

    public void turnOffBike() {
        this.bikeState = false;
        this.speed = 0;
        this.gear = 1;
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
 

    public void setGear() {
         if (this.speed >= 0 && this.speed <= 20)
            this.gear = 1;
        else if (this.speed > 20 && this.speed <= 30)
            this.gear = 2;
        else if (this.speed > 30 && this.speed <= 40)
            this.gear = 3;
        else if( this.speed > 40)
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
        setGear();
        if( this.gear == 1 ){
            this.speed += 1;
        } else if (this.gear == 2) {
            this.speed += 2;
        } else if (this.gear == 3) {
            this.speed += 3;
        } else if (this.gear == 4) {
            this.speed += 4;
        }
        setGear();

        
    }

    public void brake() {
        setGear();
        int newSpeed = 0;
        if( gear == 1 ){
            newSpeed = this.speed - 1;
        } else if (gear == 2) {
            newSpeed = this.speed - 2;
        } else if (gear == 3) {
            newSpeed = this.speed - 3;
        } else if (gear == 4) {
            newSpeed = this.speed - 4;
        }

        if( newSpeed < 0 ){
            this.speed = 0;
        } else {
            this.speed = newSpeed;
        }
        setGear();
    }
    


}