package hotel;

public class DeluxeRoom extends Room {

    public DeluxeRoom(int roomNumber, double basePrice) {
        super(roomNumber, basePrice);
    }

    @Override
    public double calculatePrice(int days) {
       
        return (getBasePrice() * days) * 1.50; // +%50
    }

}