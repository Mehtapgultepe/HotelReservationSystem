package hotel;

public class DeluxeRoom extends Room {

    public DeluxeRoom(int roomNumber, double basePrice) {
        super(roomNumber, basePrice);
    }

    @Override
    public double calculatePrice(int days) {
        // Lüks oda servisi ve manzarası için %20 ek ücret
        return (getBasePrice() * days) * 1.20;
    }

    @Override
    public String toString() {
        return super.toString() + " (Type: Deluxe)";
    }
}