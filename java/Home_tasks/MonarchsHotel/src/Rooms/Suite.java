package Rooms;

public class Suite extends Room{
    private int price = 45000;

    public Suite(String roomNumber) {
        super(roomNumber);
    }

    public int getPrice(){
        return price;
    }


}
