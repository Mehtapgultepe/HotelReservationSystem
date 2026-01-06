package hotel;


import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * Müşteri ve oda arasındaki rezervasyon ilişkisini yöneten sınıftır.
 * Giriş-çıkış tarihleri ve toplam maliyet bilgilerini tutar.
 */
public class Reservation {
	/** Rezervasyon yapılan oda */
    private Room room; 
    /** Rezervasyonu yapan müşteri */
    private Customer customer;
    /** Kalınacak gün sayısı */
    private int sdays;
    /** Rezervasyonun toplam fiyatı */
    private double totalPrice;
    /** Rezervasyon oluşturulma tarihi */
    private LocalDate reservationDate;


    public Reservation(Room room, Customer customer, int sdays) {
        this.setRoom(room);
        this.setCustomer(customer);
        this.setSdays(sdays);
        this.setTotalPrice(room.calculatePrice(sdays));
        this.reservationDate = LocalDate.now();
    }
    

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public int getSdays() {
		return sdays;
	}

	public void setSdays(int sdays) {
		this.sdays = sdays;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
	public void showDetails() {
	
		System.out.println("\n++ RESERVATION ++");
		System.out.println("Room : " + room.getRoomNumber());
		System.out.println("Room Type : " + room.getClass().getSimpleName()); //
		System.out.println("Guest : " + customer.getName());
		System.out.println("Stay days: " + sdays);
		System.out.println("Total price : " + totalPrice + "TL");
		System.out.println("\n++++++++++++++++++");

		
	}
	public void saveReservationToFile() {

		try(FileWriter fw = new FileWriter("reservations.txt", true)){
	        fw.write(room.getRoomNumber() + ";" +
	                 customer.getName() + ";" +
	                 customer.getCustid() + ";" +
	                 customer.getNumber() + ";" +
	                 sdays + System.lineSeparator());   
	    }catch(Exception e){
	        e.printStackTrace();
	    }
	}
	public String getReservationDate(){
	    DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    return reservationDate.format(f);
	}

   
}