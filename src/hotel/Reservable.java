package hotel;

public interface Reservable {
	boolean isAvailable();
	void reserve(Customer customer);
	void cancel();
}