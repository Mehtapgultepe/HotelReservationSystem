package hotel;
/**
 * Oteldeki odaların temel özelliklerini ve davranışlarını tanımlayan soyut sınıftır.
 * Bu sınıf, farklı oda tipleri (Standard, Deluxe) için bir temel oluşturur.
 */


public abstract class Room implements Reservable {
    private int roomNumber;
    private double basePrice;
    private boolean isReserved;
    private Customer currentCustomer;

    public Room(int roomNumber, double basePrice) {
        this.roomNumber = roomNumber;
        this.basePrice = basePrice;
        this.isReserved = false;
    }

    public abstract double calculatePrice(int days);

    
 

    public boolean isAvailable() {
        return !isReserved;
    }

    @Override
    public void reserve(Customer customer) {
    	this.isReserved = true;
        this.currentCustomer = customer;
    }

    @Override
    public void cancel() {
        this.isReserved = false;
        this.currentCustomer = null;
        //System.out.println("Room " + roomNumber + " is now free.");
    }

    public int getRoomNumber() { return roomNumber; }
    public double getBasePrice() { return basePrice; }
    

    @Override
    public String toString() {
        String status = isReserved ? "Full (Customer: " + currentCustomer.getName() + ")" : "Empty";
        return "Room -" + roomNumber + " [" + status + "]"; 
    }
}