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

    @Test 
    public void testThatTheIncreaseGearMethodWorks() {
        function.increaseGear();
        int newGear = function.getGear();
        assertTrue(newGear == 2);
    }

    @Test 
    public void testThatIncreaseGearMethodCanBeCalledMultipleTimes() {
        function.increaseGear();
        function.increaseGear();
        int newGear = function.getGear();
        assertTrue(newGear == 3);
    }

    @Test 
    public void testThatIncreaseGearDoesNotExceedMaxGear(){
        function.setGear(4);
        function.increaseGear();
        int newGear = function.getGear();  
        assertTrue(newGear == 4);
    }

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
    @Test 
    public void testThatGearNeverGoesBelowOne(){
        function.reduceGear();
        int newGear = function.getGear();
        assertEquals(1, newGear);
    }

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
    }
}