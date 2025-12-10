package hotelManagement;

import Rooms.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HotelManagementTest {

    HotelManagement function;

    @BeforeEach
    void setup(){
        function = new HotelManagement();
    }

    @Test
    void testFindAvailableRoomReturnsAnAvailableRoom() {
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
    void testHotelManagementTellsUserIfSpecifiedRoomIsUnavailable(){
        HotelManagement function = new HotelManagement();
        Room[] rooms = function.getRooms();
        rooms[4].maintainRoom();
        rooms[5].maintainRoom();
        assertEquals("Room type is not available at the moment sorryyy", function.getAvailableRoom("suite"));
    }

    @Test
    void testHotelManagementCanCollectPayments(){
        HotelManagement function = new HotelManagement();
        String roomNumber = function.getAvailableRoom("double");
        function.getPayment("10000", "single");
        assertEquals(10000, function.getRevenue());
    }

    @Test
    void testGetPaymentOnlyCollectsNumbers(){
        HotelManagement function = new HotelManagement();
        String roomNumber = function.getAvailableRoom("double");
        assertThrows(NumberFormatException.class, () -> function.getPayment("100e", "single"));
    }

    @Test
    void testAllPaymentsAreAddedTogetherTest(){
        String roomNumber = function.getAvailableRoom("double");
        function.getPayment("10000", "single");
        String roomNumber2 = function.getAvailableRoom("double");
        function.getPayment("20000", "single");
        assertEquals(30000, function.getRevenue());
    }

    @Test
    void TenKIsCollectedFromUserIfSingleRoomIsSelectedTest(){
        String roomNumber = function.getAvailableRoom("double");
        function.getPayment("10000", "single");
        assertEquals(10000, function.getRevenue());
    }

    @Test
void amountApartFrom10kIsNotAddedToRevenueIfRoomIsSingleTest(){
        String roomNumber = function.getAvailableRoom("double");
        assertThrows(IllegalArgumentException.class, () -> function.getPayment("5000", "single"));
    }

    @Test
    void revenueIs20kIfAmountPaidIs20kAndRoomTypeIsDouble(){
        String roomNumber = function.getAvailableRoom("double");
        function.getPayment("20000", "double");
        assertEquals(20000, function.getRevenue());
    }

    @Test
    void getPaymentThrowsErrorWhenAmountPaidIsNot20kAndRoomIsDoubleTest(){
        String roomNumber = function.getAvailableRoom("double");
        assertThrows(IllegalArgumentException.class, () -> function.getPayment("353234", "double"));
    }

    @Test
    void amountPaidIsAddedToRevenueIfAmountPaidIs45kAndRoomIsSuiteTest(){
        String roomNumber = function.getAvailableRoom("double");
        function.getPayment("45000", "suite");
        assertEquals(45000, function.getRevenue());
    }

    @Test
    void getPaymentRaisesErrorIfRoomIsSuiteAndPriceIsNot45k(){
        String roomNumber = function.getAvailableRoom("double");
        assertThrows(IllegalArgumentException.class, () -> function.getPayment("10000", "suite"));
    }

    @Test
    void roomStatusCanBeTurnedToBooked(){
        String roomNumber = function.getAvailableRoom("double");
        function.bookRoom(roomNumber);
        Room[] rooms = function.getRooms();
        Room bookedRoom = function.getRoomByRoomNumber(roomNumber);
        assertEquals(true, bookedRoom.getBookedStatus());
    }

    @Test
    void roomStatusCanBeTurnedToBookedAfterSuccessfulPayment(){
        String roomNumber = function.getAvailableRoom("double");
        function.getPayment("20000", "double");
        Room[] rooms = function.getRooms();
        Room bookedRoom = function.getRoomByRoomNumber(roomNumber);
        assertEquals(true, bookedRoom.getBookedStatus());

    }

    @Test
    void getPaymentsBooksRoomGivenByGetAvailableRoomTest(){
        String roomNumber = function.getAvailableRoom("double");
        Room room = function.getRoomByRoomNumber(function.getAvailableRoom("double"));
        function.getPayment("20000", "double");
        Room[] rooms = function.getRooms();
        Room bookedRoom = function.getRoomByRoomNumber(roomNumber);
        assertEquals(true, bookedRoom.getBookedStatus());

    }


}