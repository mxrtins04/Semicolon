package hotelManagement;

import Rooms.DoubleRoom;
import Rooms.Room;
import Rooms.SingleRoom;

public class HotelManagement {
    private final Room[] rooms = new Room[4];

    public HotelManagement() {
        rooms[0] = new SingleRoom("001");
        rooms[1] = new SingleRoom("002");
        rooms[2] = new DoubleRoom("003");
        rooms[3] = new DoubleRoom("004");
    }
    public String getAvailableRoom() {
        for(Room room : rooms){
            if(room.getBookedStatus() == false)
                return room.getRoomNumber();
        }
        return null;
    }

    public Room[] getRooms() {
        return rooms;
    }
}
