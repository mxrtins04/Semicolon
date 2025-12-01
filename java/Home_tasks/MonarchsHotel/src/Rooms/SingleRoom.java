package Rooms;

public class SingleRoom extends Room {
    public SingleRoom(String roomNumber)
    {
        super(roomNumber);
    }
    private int price = 10000;
    private String type = "single";

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }
}
