import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;


public class CarFuelSystemTest {
    CarFuelSystem function;
    @BeforeEach
    void setup(){
    function = new CarFuelSystem();
    }

    @Test 
    public void testThatCarHasAFuelTank(){
        assertNotNull(function.getFuelTankLevel());
    }

    @Test
    public void testFuelCanBeAddedToFuelTank(){
        int actual = function.addFuel(30);
        int expected = 30;
        assertEquals(expected, actual);
    }

    @Test
    public void testThatFuelLevelCannotExceedMaximumCapacity(){
        function.addFuel(60);
        int actual = function.getCurrentFuelLevel();
        int expected = 50;
        assertEquals(expected, actual);
    }

    @Test
    public void testThatFuelLevelIncreasesWhenFuelIsAdded(){
        function.addFuel(20);
        int actual = function.getCurrentFuelLevel();
        int expected = 20;
        assertEquals(expected, actual);
    }

    /* @Test
    public void testThatCarCanBeDriven(){
        function.startCar();
        boolean actual = function.driveCar(50);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void testThatCarCannotBeDrivenWhenNotStarted(){
        boolean actual = function.driveCar(50);
        boolean expected = false;
        assertEquals(expected, actual);
    }*/

    @Test
    public void testThatYouCantAddNegativeFuel(){
        function.addFuel(-20);
        int actual = function.getCurrentFuelLevel();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test 
    
}