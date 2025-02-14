import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class Booking {
    private String guestName;
    private int roomNumber;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int stayDuration;
    private String bookingID;
    private static int totalBookings = 0;

    public Booking(String guestName, int roomNumber, LocalDate checkInDate, LocalDate checkOutDate) {
        this.guestName = guestName;
        this.roomNumber = roomNumber;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        totalBookings += 1; //rritet me 1 per cdo rezervim te bere
    }

    //nje id e cfardoshme unike per rezervimin
    private String generateBookingId() {
        return UUID.randomUUID().toString();
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getStayDuration() {
        return stayDuration;
    }

    public void setStayDuration(int stayDuration) {
        this.stayDuration = stayDuration;
    }

    private int stayDuration() {
        Period period = Period.between(checkInDate, checkOutDate);
        return period.getDays();
    }

    public void modifyDates(LocalDate newCheckIn, LocalDate newCheckOut) {
        if (newCheckIn == null || newCheckOut == null) {
            System.out.println("Error: Chose valid dates.");
        }
        if (newCheckOut.isBefore(newCheckIn)) {
            System.out.println("Error: Check-out date must be after the check-in date.");
        }
        this.checkInDate = newCheckIn;
        this.checkOutDate = newCheckOut;
        System.out.println("Booking dates successfully modified.");
    }

    public String confirmBooking() {
        return "Customer: " + guestName + ", Room Type: " + roomNumber + ", Stay Duration: " + stayDuration() + " days";
    }

    public static int getTotalBookings() {
        return totalBookings;
    }

    public String getBookingId() {
        return bookingID;
    }

    public Room getRoom(){
        Room room = null;
        return room;
    }
}
