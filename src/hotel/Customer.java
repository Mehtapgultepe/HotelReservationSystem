package hotel;
public class Customer {
    private String name;
    private String number;
    private String custid;
    

    public Customer(String name, String number, String custid) {
        this.setName(name);
        this.setNumber(number);
        this.setCustid(custid);
        
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



	
	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}
	
	public void displayInfo() {
		System.out.println("tc no" + custid + "isim " + name);
	}
	
	
}