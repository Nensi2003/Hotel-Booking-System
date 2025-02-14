import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {


        Room room101 = new Room("101", "Single");
        Room room102 = new Room("102", "Double");
        List<Room> availableRooms = new ArrayList<>();
        availableRooms.add(room101);
        availableRooms.add(room102);

        Guest guest = new Guest("Nensi", "nensi@gmail.com");

        Booking booking1 = new Booking("Nensi", 101, LocalDate.of(2025, 5, 1), LocalDate.of(2025, 5, 5));
        room101.addBooking(booking1);


        Character.UnicodeBlock List = null;
        Hotel hotel = new Hotel(" Plaza", availableRooms);
        hotel.getBookings().add(booking1);

        hotel.cancelBooking(booking1.getBookingId());
    }

}
