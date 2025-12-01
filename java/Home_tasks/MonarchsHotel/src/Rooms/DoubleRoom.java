package Rooms;

public class DoubleRoom extends Room{
    private int price = 20000;
    private String type = "double";

    public DoubleRoom(String roomNumber){
        super(roomNumber);
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }
}
