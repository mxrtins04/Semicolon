package hotelManagement;

import Rooms.DoubleRoom;
import Rooms.Room;
import Rooms.SingleRoom;
import Rooms.Suite;

public class HotelManagement {
    private final Room[] rooms = new Room[6];
    private int revenue;

    public HotelManagement() {
        rooms[0] = new SingleRoom("001");
        rooms[1] = new SingleRoom("002");
        rooms[2] = new DoubleRoom("003");
        rooms[3] = new DoubleRoom("004");
        rooms[4] = new Suite("005");
        rooms[5] = new Suite("006");

    }
    public String getAvailableRoom(String type) {
        if( !type.equalsIgnoreCase("double" ) && !type.equalsIgnoreCase("single") && !type.equalsIgnoreCase("suite") )
            return "Type is not available in this hotel";
        for(Room room : rooms){
            if(room.getIsAvailable() == true){
                if( room.getType().equals(type.toLowerCase()) )
                    return room.getRoomNumber();
            }
        }
        return "Room type is not available at the moment sorryyy";
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void getPayment(String payment) {
        revenue += verifyPaymentInput(payment);

    }

    private static int verifyPaymentInput(String payment){
        try{
           int validPayment = Integer.parseInt(payment);
           return validPayment;
        }catch(NumberFormatException e){
            throw new NumberFormatException("Please put in a number.");
        }
    }

    public int getRevenue() {
        return revenue;
    }
}
