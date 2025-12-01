package Rooms;

public class Room {
    private boolean isAvailable = true;
    private boolean isBooked = false;
    private boolean underMaintenance = false;
    private int price;
    private String roomNumber;

    public Room(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setIsAvailable() {
        if( isBooked || !underMaintenance) {
            isAvailable = false;
        }
    }

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

    public String getRoomNumber() {
        return this.roomNumber;
    }
}