package Customer;

import Rooms.DoubleRoom;
import Rooms.Room;
import Rooms.SingleRoom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {
    @Test
    public void testGuestCanBookRoom(){
        Client client = new Client();
        Room room = new Room("001");
        client.bookRoom(room);
        assertEquals(room, client.getRoom());
    }

    @Test
    public void testClientCanBookASpecificTypeOfRoom(){
        Client client = new Client();
        Room room = new DoubleRoom("001");
        client.bookRoom(room);
        assertEquals(room, client.getRoom());

        Room room2 = new SingleRoom("001");
        client.bookRoom(room2);
        assertEquals(room2, client.getRoom());
    }

    @Test
    public void testPaymentMadeByClientIsZeroByDefault(){
        Client client = new Client();
        assertEquals(0, client.getAmountPaid());
    }

    @Test
    public void testClientCanMakePayment(){
        Client client = new Client();
        client.setPaymentMade(2000);
        assertEquals(2000, client.getAmountPaid());
    }

}
