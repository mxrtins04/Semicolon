package Customer;

import Rooms.Room;
import java.time.LocalDate;

public class Booking {
    private Client client;
    private Room room;
    private int nights;
    private int totalPayment;
    private String bookingReference;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    public Booking(Client client, Room room, int nights, int totalPayment, String bookingReference, LocalDate checkInDate) {
        this.client = client;
        this.room = room;
        this.nights = nights;
        this.totalPayment = totalPayment;
        this.bookingReference = bookingReference;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkInDate.plusDays(nights);
    }

    public Client getClient() {
        return client;
    }

    public Room getRoom() {
        return room;
    }

    public int getNights() {
        return nights;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public String getBookingReference() {
        return bookingReference;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }
}
