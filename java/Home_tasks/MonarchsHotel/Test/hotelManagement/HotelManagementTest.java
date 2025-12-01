package hotelManagement;

import Rooms.Room;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HotelManagementTest {

    @Test
    void testFindAvailableRoomReturnsAnAvailableRoom() {
        HotelManagement function = new HotelManagement();
        assertEquals("001", function.getAvailableRoom("single"));
    }

    @Test
    void testHotelManagementDoesNotReturnAnUnavailableRoom() {
        HotelManagement function = new HotelManagement();
        Room[] rooms = function.getRooms();
        rooms[0].maintainRoom();
        assertEquals("002", function.getAvailableRoom("single"));
    }

    @Test
    void testHotelManagementReturnsRoomTypeSpecifiedByCustomer(){
        HotelManagement function = new HotelManagement();
        Room[] rooms = function.getRooms();
        assertEquals("005", function.getAvailableRoom("suite"));

    }

    @Test
    void testHotelManagementDoesNotReturnRoomTypeSpecifiedByCustomerIfItIsUnavailable(){
        HotelManagement function = new HotelManagement();
        Room[] rooms = function.getRooms();
        rooms[4].maintainRoom();
        assertEquals("006", function.getAvailableRoom("suite"));
    }

    @Test
    void testHotelManagementReturnsTellsUserSpecifiedRoomIsUnavailableIfRoomIsUnavailable(){
        HotelManagement function = new HotelManagement();
        Room[] rooms = function.getRooms();
        rooms[4].maintainRoom();
        rooms[5].maintainRoom();
        assertEquals("Room type is not available at the moment sorryyy", function.getAvailableRoom("suite"));
    }

    @Test
    void testHotelManagementCanCollectPayments(){
        HotelManagement function = new HotelManagement();
        function.getPayment("10000");
        assertEquals(10000, function.getRevenue());
    }

    @Test
    void testGetPaymentOnlyCollectsNumbers(){
        HotelManagement function = new HotelManagement();
        assertThrows(NumberFormatException.class, () -> function.getPayment("100e"));
    }
}