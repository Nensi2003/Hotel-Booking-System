import java.util.ArrayList;
import java.util.List;

public class Guest {
    private String name;
    private String contactNumber;
    private String email;
    private List<Booking> bookings;

    public Guest(String name, String contactNumber) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
        this.bookings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getContactNumber() {
        return contactNumber;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<Booking> getBookings() {
        return bookings;
    }
    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }



    public void addBooking(Booking booking) {
        if (booking != null) {
            bookings.add(booking);
            System.out.println("Booking added for guest: " + name);
        } else {
            System.out.println("Error: Add a book!");
        }
    }

    public void viewBookingHistory() {
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }
}
