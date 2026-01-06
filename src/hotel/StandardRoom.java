package hotel;
/**
 * Standart oda tipini temsil eden ve Room sınıfından türetilen sınıftır.
 * Odaya özgü fiyatlandırma hesaplamalarını içerir.
 */

public class StandardRoom extends Room {
    public StandardRoom(int roomNumber, double basePrice) {
        super(roomNumber, basePrice);
    }

    @Override
    public double calculatePrice(int days) {
        return getBasePrice() * days;
    }
}

