package hotelManagement;

import Rooms.Room;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HotelManagementTest {

    @Test
    void testFindAvailableRoomReturnsAnAvailableRoom() {
        HotelManagement function = new HotelManagement();
        assertEquals("001", function.getAvailableRoom());
    }

    @Test
    void testRoomDoesNotReturnAnUnavailableRoom() {
        HotelManagement function = new HotelManagement();
        Room[] rooms = function.getRooms();
        rooms[0].maintainRoom();
        assertEquals("002", function.getAvailableRoom());

    }

}