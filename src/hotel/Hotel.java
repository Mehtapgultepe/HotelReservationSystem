package hotel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import java.util.List;


import javax.swing.JOptionPane;

/**
* Hotel sınıfı, otelin odalarını ve rezervasyonlarını yönetmek için kullanılır.
* 
*Bu sınıf odaları dosyadan yükler, rezervasyon oluşturur, iptal eder ve
* rezervasyon listesini günceller. Ayrıca ödeme işlemlerini ve müşteri bilgilerini yönetir.
*/
public class Hotel {

    private String hotelName;
    /** Oteldeki tüm odaların listesi */
    private List<Room> rooms;
    

    /** Oteldeki tüm rezervasyonların listesi */
    private ArrayList<Reservation> reservations;

    public Hotel(String hotelName) {
        this.setHotelName(hotelName);
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        loadRoomsFromFile(); 
    }

    public Room getRoom(int roomNumber) {
        for(Room r : rooms){
            if(r.getRoomNumber() == roomNumber)
                return r;
        }
        return null;
    }
    public boolean cancelReservation(int roomNo){

        Room room = getRoom(roomNo);

        if(room == null || room.isAvailable())
            return false;

        room.cancel();

        reservations.removeIf(r -> r.getRoom().getRoomNumber() == roomNo);

        rewriteReservationFile();

        return true;
    }

    public Reservation createReservation(int roomNumber, String name, String custid,
                                         String phone, int days, String paymentMethod){

        Room room = getRoom(roomNumber);

        if(room == null || !room.isAvailable())
            return null;

        Customer customer = new Customer(name, phone, custid);
        room.reserve(customer);

        Reservation rez = new Reservation(room, customer, days);
        reservations.add(rez);

        Payment p = new Payment(rez.getTotalPrice(), paymentMethod);
        p.processPayment();
        rewriteReservationFile();
        return rez;
    }

    public ArrayList<Reservation> getReservations(){
        return reservations;
    }

    public List<Room> getRooms(){
        return rooms;
    }

    public void loadRoomsFromFile(){
        try(BufferedReader br = new BufferedReader(new FileReader("rooms.txt"))){
            String line;
            while((line = br.readLine()) != null){
                String[] p = line.split(";");
                int no = Integer.parseInt(p[0]);
                String type = p[1];
                double price = Double.parseDouble(p[2]);

                if(type.equalsIgnoreCase("DELUXE"))
                    rooms.add(new DeluxeRoom(no, price));
                else
                    rooms.add(new StandardRoom(no, price));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"rooms.txt not found!");
        }
    }

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	private void rewriteReservationFile(){

	    try(FileWriter fw = new FileWriter("reservations.txt")){
	        for(Reservation r : reservations){
	            fw.write(r.getRoom().getRoomNumber() + ";" +
	            		 r.getCustomer().getName() + ";" +
	                     r.getCustomer().getCustid() + ";" +
	                     r.getCustomer().getNumber() + ";" +
	                     r.getSdays() + ";" +
	                     r.getTotalPrice() + ";" +
	                     r.getReservationDate() + "\n");
	        }
	    }catch(Exception e){
	        e.printStackTrace();
	    }
	}
}
