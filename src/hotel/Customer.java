package hotel;
public class Customer {
    private String name;
    private String number;
    private int id;

    public Customer(String name, String number) {
        this.setName(name);
        this.setNumber(number);
    }

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}