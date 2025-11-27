import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.beans.Transient;

public class MotorcycleTest {
    boolean bikeState = false;
    MotorcycleFunctions function;

    @BeforeEach
    public void setUp() {
        function = new MotorcycleFunctions();
    }

    @Test
    public void testThatStartBikeWorks() {
        function.startBike(bikeState);
        assertTrue(function.getBikeState());
    }

    @Test 
    public void testThatInititalGearIsOne() {
        int initialGear = function.getGear();
        assertTrue(initialGear == 1);
    }

    @Test 
    public void testThatInitialSpeedIsZero() {
        int initialSpeed = function.getSpeed();
        assertTrue(initialSpeed == 0);
    }

 /*   @Test 
    public void testThatIncreaseGearMethodCanBeCalledMultipleTimes() {
        function.increaseGear();
        function.increaseGear();
        int newGear = function.getGear();
        assertTrue(newGear == 3);
    }*/

/*     @Test 
    public void testThatReduceGearWorks(){
        function.setGear(3);
        function.reduceGear();
        int newGear = function.getGear();
        assertTrue(newGear == 2);
    }
*/
 /*   @Test 
    public void testThatReduceGearCanBeCalledMultipleTimes(){
        function.setGear(4);
        function.reduceGear();
        function.reduceGear();
        int newGear = function.getGear();
        assertTrue(newGear == 2);
    }
*/
/*    @Test 
    public void testThatGearNeverGoesBelowOne(){
        function.reduceGear();
        int newGear = function.getGear();
        assertEquals(1, newGear);
    }
*/
    @Test 
    public void testThatAcceleratorWorks(){
       function.accelerate();
       int speed = function.getSpeed();
         assertEquals(1, speed);
    }

    @Test 
    public void testThatAcceleratorCanBeCalledMultipleTimes(){
       function.accelerate();
       function.accelerate();
       function.accelerate();
       int speed = function.getSpeed();
         assertEquals(3, speed);
    }

    @Test 
    public void testThatRateOfAccelerationIncreasesWithGear(){
        function.setSpeed(25);
        function.accelerate();
        int speed = function.getSpeed();
        assertEquals(27, speed);


        function.setSpeed(35);
        function.accelerate();
        speed = function.getSpeed();
        assertEquals(38, speed);
    }

/*    @Test 
    public void testThatSpeedDoesNotGoBeyondAssignedRangeForEachGear(){
        function.setGear(1);
        function.setSpeed(20);
        function.accelerate();
        int speed = function.getSpeed();
        assertEquals(20, speed);
    }
*/
    @Test 
    public void testThatSetGearSetsGearAccordingToSpeed(){
        function.setSpeed(19);
        function.accelerate();
        function.accelerate();
        
        int gear = function.getGear();
        assertEquals(2, gear);

        function.setSpeed(30);
        function.accelerate();
        gear = function.getGear();
        assertEquals(3, gear);
    }

    @Test 
    public void testThatBrakeWorks(){
        function.setSpeed(10);
        function.brake();
        int speed = function.getSpeed();
        assertEquals(9, speed);
    }

    @Test 
    public void testThatRateOfDecelerationIncreasesWithGear(){
        function.setSpeed(25);
        function.brake();
        int speed = function.getSpeed();
        assertEquals(23, speed);
    }

    @Test 
    public void testThatSpeedDoesNotGoBelowZero(){
        function.brake();
        function.brake();
        int speed = function.getSpeed();
        assertEquals(0, speed);
    }

    
}