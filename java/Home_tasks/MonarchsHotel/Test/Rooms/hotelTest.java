package Rooms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class hotelTest {
    @Test
    public void testRoomsDefaultIsBookedStatusIsfalse() {
        Room room = new Room("001");
        assertFalse(room.getBookedStatus());
    }

    @Test
    public void testRoomCanBeBooked(){
        Room room = new Room("001");
        room.bookRoom();
        assertTrue(room.getBookedStatus());
    }

    @Test
    public void testRoomsUnderMaintenanceStatusIsFalseByDefault(){
        Room room = new Room("001");
        assertFalse(room.getMaintenanceStatus());
    }

    @Test
    public void testRoomsMaintenanceStatusCanBeChanged(){
        Room room = new Room("001");
        room.maintainRoom();
        assertTrue(room.getMaintenanceStatus());
    }

    @Test
    public void testMaintenanceStatusCanBeChangedWhenRoomIsFixed(){
        Room room = new Room("001");
        room.maintainRoom();
        room.fixRoom();
        assertFalse(room.getMaintenanceStatus());
    }

    @Test
    public void testRoomCannotBeBookedIfRoomIsUnderMaintenance() {
        Room room = new Room("001");
        room.maintainRoom();
        room.bookRoom();
        assertFalse(room.getBookedStatus());
    }

    @Test
    public void testSingleRoomsPriceIs10KByDefault(){
        Room room = new SingleRoom("001");
        assertEquals(10000, room.getPrice());
    }

    @Test
    public void testSingleRoomCanBeBooked(){
        SingleRoom room = new SingleRoom("001");
        room.bookRoom();
        assertTrue(room.getBookedStatus());
    }

    @Test
    public void testDoubleRoomPriceIs20KByDefault(){
        Room room = new DoubleRoom("001");
        assertEquals(20000, room.getPrice());
    }

    @Test
    public void testSuitesDefaultPriceIs45k(){
        Room room = new Suite("001");
        assertEquals(45000, room.getPrice());
    }

}
