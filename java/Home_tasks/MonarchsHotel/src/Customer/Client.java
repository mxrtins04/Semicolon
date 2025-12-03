package Customer;

import Rooms.Room;


public class Client extends Customer{

    private Room room;
    private int amountPaid;


    public void bookRoom(Room roomToBeAssigned) {
        room = roomToBeAssigned;
    }

    public Room getRoom() {
        return room;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public void setPaymentMade(int i) {
        amountPaid = i;
    }

}
