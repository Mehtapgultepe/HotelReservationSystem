package hotel;
/**
 * Deluxe oda tipini temsil eden ve Room sınıfından türetilen sınıftır.
 * Odaya özgü fiyatlandırma hesaplamalarını içerir.
 */

public class DeluxeRoom extends Room {

    public DeluxeRoom(int roomNumber, double basePrice) {
        super(roomNumber, basePrice);
    }

    @Override
    public double calculatePrice(int days) {
       
        return (getBasePrice() * days) * 1.50; // +%50
    }

}