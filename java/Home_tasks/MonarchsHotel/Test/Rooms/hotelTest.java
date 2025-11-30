package Rooms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class hotelTest {
    @Test
    public void testRoomsDefaultIsBookedStatusIsfalse() {
        Room room = new Room();
        assertFalse(room.getBookedStatus());
    }

    @Test
    public void testRoomCanBeBooked(){
        Room room = new Room();
        room.bookRoom();
        assertTrue(room.getBookedStatus());
    }

    @Test
    public void testRoomsUnderMaintenanceStatusIsFalseByDefault(){
        Room room = new Room();
        assertFalse(room.getMaintenanceStatus());
    }

    @Test
    public void testRoomsMaintenanceStatusCanBeChanged(){
        Room room = new Room();
        room.maintainRoom();
        assertTrue(room.getMaintenanceStatus());
    }

    @Test
    public void testMaintenanceStatusCanBeChangedWhenRoomIsFixed(){
        Room room = new Room();
        room.maintainRoom();
        room.fixRoom();
        assertFalse(room.getMaintenanceStatus());
    }

    @Test
    public void testRoomCannotBeBookedIfRoomIsUnderMaintenance() {
        Room room = new Room();
        room.maintainRoom();
        room.bookRoom();
        assertFalse(room.getBookedStatus());
    }

    @Test
    public void testSingleRoomsPriceIs10KByDefault(){
        Room room = new SingleRoom();
        assertEquals(10000, room.getPrice());
    }

    @Test
    public void testSingleRoomCanBeBooked(){
        SingleRoom room = new SingleRoom();
        room.bookRoom();
        assertTrue(room.getBookedStatus());
    }

    @Test
    public void testDoubleRoomPriceIs20KByDefault(){
        Room room = new DoubleRoom();
        assertEquals(20000, room.getPrice());
    }

    @Test
    public void testSuitesDefaultPriceIs45k(){
        Room room = new Suite();
        assertEquals(45000, room.getPrice());
    }

}
