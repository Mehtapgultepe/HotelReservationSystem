package hotel;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	Hotel hotel = new Hotel("OOP HOTEL");
    	
    	//odalarım
    	hotel.addRoom(new StandardRoom (000,500));
    	hotel.addRoom(new StandardRoom (001,500));
    	hotel.addRoom(new StandardRoom (002,500));
    	hotel.addRoom(new DeluxeRoom (100,500));
    	hotel.addRoom(new DeluxeRoom (102,500));
    	hotel.addRoom(new DeluxeRoom (104,500));
    	


    	
    	
    	
    	while(true) {
    		System.out.println("\n+++++++HOTEL RESERVATION SYSTEM+++++++++++");
    		System.out.println("1- list available rooms");
    		System.out.println("2- make reservation");
    		System.out.println("3- cancel reservation");
    		System.out.println("4- exit");
    		System.out.println("enter choice: ");
    		int ch = scanner.nextInt();
    		if (ch == 4) {
    			System.out.println("exiting ");
    			break;
    		}
    		switch (ch) {
    		case 1:
    			hotel.listAvailableRooms();
    			break;
    		case 2:
    			System.out.println("enter room number : ");
    			int ronum = scanner.nextInt();
    			System.out.println("customer name : ");
    			String name = scanner.next();
    			System.out.println("phone : ");
    			String phone = scanner.next();
    			System.out.println("days to stay : ");
    			int days = scanner.nextInt();
    			System.out.println("payment method (1.credit card  2.cash) : ");
    			System.out.println("enter choice: ");
    			int paymet = scanner.nextInt();
    			String method = (paymet == 1) ? "Credit Card" : "Cash";
    			
    			hotel.createReservation(ronum, name, phone, days, method);
    			break;
    		case 3:
    		    System.out.println("enter room number to cancel: ");
    		    int canNum = scanner.nextInt();
    		    hotel.cancelReservation(canNum);
    		    break;
    		default:
    			System.out.println("wrong choice!!!!!!");
    		}
    	}
    	scanner.close();
    	
}
} 