package hotel;

public class Payment {
    private String paymentMethod; // "Credit Card" or "Cash"
    private double amount;

    public Payment(double amount, String paymentMethod) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public void processPayment() {
       
        System.out.println("\n**PAYMENT RECEIPT**");
        System.out.println("Amount: " + amount + " TL");
        System.out.println("Method: " + paymentMethod);
        System.out.println("Status: PAID SUCCESSFUL");

    }


    public double getAmount() { return amount; }
}