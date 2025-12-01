package Rooms;

public class Suite extends Room{
    private int price = 45000;
    private String type = "suite";

    public Suite(String roomNumber) {
        super(roomNumber);
    }

    public String  getType() {
        return type;
    }

    public int getPrice(){
        return price;
    }


}
