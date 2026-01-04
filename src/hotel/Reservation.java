package hotel;
public class Reservation {
    private Room room; 
    private Customer customer;
    private int sdays;
    private double totalPrice;

    public Reservation(Room room, Customer customer, int sdays) {
        this.setRoom(room);
        this.setCustomer(customer);
        this.setSdays(sdays);
        this.setTotalPrice(room.calculatePrice(sdays));
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

   
}