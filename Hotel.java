import java.time.LocalDate;
import java.util.List;

public class Hotel {
    private String hotelName;
    private List<Room> availableRooms;
    private List<Booking> bookings;

    public Hotel(String hotelName, List<Room> availableRooms) {
        this.hotelName = hotelName;
        this.availableRooms = availableRooms;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public List<Room> getAvailableRooms() {
        return availableRooms;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void setAvailableRooms(List<Room> availableRooms) {
        this.availableRooms = availableRooms;
    }

    public void checkAvailability(Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        //Bredhja neper rezervime per te kontrolluar per perplasje datash
        for (Booking booking : room.getBookings()) {
            if ((checkInDate.isBefore(booking.getCheckOutDate()) && checkOutDate.isAfter(booking.getCheckInDate())) ||
                    (checkInDate.isEqual(booking.getCheckInDate()) || checkOutDate.isEqual(booking.getCheckOutDate())) ||
                    (checkInDate.isBefore(booking.getCheckInDate()) && checkOutDate.isAfter(booking.getCheckOutDate()))) {

                System.out.println("Room is booked");
            }
        }
        System.out.println("Room is available");
    }

    public void cancelBooking(String bookingId) {
        Booking bookingToCancel = null;

        for (Booking booking : bookings) {
            if (booking.getBookingId().equals(bookingId)) {
                bookingToCancel = booking;
                break;
            }
        }
        System.out.println("Booking with this ID is not found.");

        bookings.remove(bookingToCancel);
        System.out.println("Booking " + bookingId + " has been canceled.");

        Room room = bookingToCancel.getRoom();
        room.getBookings().remove(bookingToCancel);

        availableRooms.add(room);
    }

    public void listAllBookings() {
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }
}

