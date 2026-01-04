package hotel;

import java.util.ArrayList;

public class Hotel {
	private String hotelName;
	private ArrayList<Room> rooms;
	private ArrayList<Reservation> reservations;
	private String paymentMethod;
	
	public Hotel(String hotelName) {
		this.hotelName = hotelName;
		this.rooms = new ArrayList<>();
		this.setReservations(new ArrayList<>());
	}
	
	//yeni oda ekleme
	public void addRoom(Room room) {
		rooms.add(room);
	}
	
	public void listAvailableRooms() {
		System.out.println("\n+++ Available Rooms in " + hotelName + "+++");
		for(Room r : rooms) {
			if(r.isAvailable()) {
				System.out.println(r.getRoomNumber() + " - Price : " + r.getBasePrice() + " TL (" + r.getClass().getSimpleName() + ")");
			}
		}
	}
	
	//oda numarası ile oda bulma kodu
	public Room getRoom(int roomNumber) {
		for(Room r: rooms) {
			if(r.getRoomNumber() == roomNumber) {
				return r;
			}
		}
		return null;
	}
//rez olustur
	public void createReservation(int roomNumber,String name,String phone,int days, String paymentMethod) {
		Room room = getRoom(roomNumber);
		if (room != null && room.isAvailable()) {
			Customer customer = new Customer(name , phone);
			room.reserve(customer);
			Reservation rez = new Reservation(room, customer, days);
			reservations.add(rez);
			rez.showDetails();
			Payment payment = new Payment(rez.getTotalPrice(),paymentMethod);
			payment.processPayment();
		}else {
			System.out.println("xxERRORxx : Room not found or already booked");
		}
	}
	
	//rez iptal etmek
	public void cancelReservation(int roomNumber) {
		Room room = getRoom(roomNumber);
		if(room != null && !room.isAvailable()) {
			room.cancel();
			//rez listesinden oda kaydını silmek
			reservations.removeIf(rez -> rez.getRoom().getRoomNumber() == roomNumber);
			System.out.println("Reservation cancelled successfully.");
		}else {
			System.out.println("this room is not booked.");
		}
	}
	
	

	public ArrayList<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(ArrayList<Reservation> reservations) {
		this.reservations = reservations;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	

}
