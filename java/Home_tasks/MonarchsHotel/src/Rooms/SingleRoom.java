package Rooms;

public class SingleRoom extends Room {
    public SingleRoom(String roomNumber)
    {
        super(roomNumber);
    }
    private int price = 10000;
    public int getPrice() {
        return price;
    }
}
