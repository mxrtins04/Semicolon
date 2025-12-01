package Rooms;

public class Room {
    private boolean isAvailable = true;
    private boolean isBooked = false;
    private boolean underMaintenance = false;
    private int price;
    private String type;
    private String roomNumber;

    public Room(String roomNumber) {
        this.roomNumber = roomNumber;
    }


    public boolean  getIsAvailable() {
        return isAvailable;
    }

    public String getType(){
        return type;
    }

    public boolean getBookedStatus() {
        return isBooked;
    }

    public void bookRoom() {
        if (underMaintenance)
            this.isBooked = false;

        else {
            this.isBooked = true;
            this.isAvailable = false;
        }
    }

    public boolean getMaintenanceStatus() {
        return underMaintenance;
    }

    public void maintainRoom() {
        this.underMaintenance = true;
        this.isAvailable = false;
    }

    public void fixRoom() {
        this.underMaintenance = false;
        this.isAvailable = true;
    }

    public int getPrice() {
        return this.price;
    }

    public String getRoomNumber() {
        return this.roomNumber;
    }
}