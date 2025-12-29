package hotel;
public class Customer {
    private String name;
    private String number;

    public Customer(String name, String number) {
        this.name = name;
        this.setNumber(number);
    }
    public String getName() { return name; }
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
}