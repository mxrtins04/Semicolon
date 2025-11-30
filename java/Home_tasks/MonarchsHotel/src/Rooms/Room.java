package Rooms;

public class Room {

    private boolean isBooked = false;
    private boolean underMaintenance = false;
    private int price;

    public boolean getBookedStatus() {
        return isBooked;
    }

    public void bookRoom() {
        if (underMaintenance) this.isBooked = false;

        else this.isBooked = true;
    }

    public boolean getMaintenanceStatus() {
        return underMaintenance;
    }

    public void maintainRoom() {
        this.underMaintenance = true;
    }

    public void fixRoom() {
        this.underMaintenance = false;
    }

    public int getPrice() {
        return this.price;
    }
}