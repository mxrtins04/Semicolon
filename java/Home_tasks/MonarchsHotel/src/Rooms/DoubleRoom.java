package Rooms;

public class DoubleRoom extends Room{
    private int price = 20000;

    public DoubleRoom(String roomNumber){
        super(roomNumber);
    }

    public int getPrice() {
        return price;
    }
}
