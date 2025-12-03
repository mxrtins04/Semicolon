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
        function.getPayment("10000", "single");
        assertEquals(10000, function.getRevenue());
    }

    @Test
    void testGetPaymentOnlyCollectsNumbers(){
        HotelManagement function = new HotelManagement();
        assertThrows(NumberFormatException.class, () -> function.getPayment("100e", "single"));
    }

    @Test
    void testAllPaymentsAreAddedTogetherTest(){
        function.getPayment("10000", "single");
        function.getPayment("20000", "single");
        assertEquals(30000, function.getRevenue());
    }

    @Test
    void TenKIsCollectedFromUserIfSingleRoomIsSelectedTest(){
        function.getPayment("10000", "single");
        assertEquals(10000, function.getRevenue());
    }

    @Test
void amountApartFrom10kIsNotAddedToRevenueIfRoomIsSingleTest(){
        assertThrows(IllegalArgumentException.class, () -> function.getPayment("5000", "single"));
    }

    @Test
    void revenueIs20kIfAmountPaidIs20kAndRoomTypeIsDouble(){
        function.getPayment("20000", "double");
        assertEquals(20000, function.getRevenue());
    }

    @Test
    void getPaymentThrowsErrorWhenAmountPaidIsNot20kAndRoomIsDoubleTest(){
        assertThrows(IllegalArgumentException.class, () -> function.getPayment("353234", "double"));
    }

    @Test
    void amountPaidIsAddedToRevenueIfAmountPaidIs45kAndRoomIsSuiteTest(){
        function.getPayment("45000", "suite");
        assertEquals(45000, function.getRevenue());
    }

    @Test
    void getPaymentRaisesErrorIfRoomIsSuiteAndPriceIsNot45k(){
        assertThrows(IllegalArgumentException.class, () -> function.getPayment("10000", "suite"));
    }

    @Test
    void
}