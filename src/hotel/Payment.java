package hotel;

import java.util.Date;

public class Payment {
    private String paymentMethod; // "Credit Card" or "Cash"
    private double amount;
    private Date paymentDate;
    private boolean isProcessed;

    public Payment(double amount, String paymentMethod) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentDate = new Date(); 
        this.isProcessed = false;
    }

    public void processPayment() {
       
        this.isProcessed = true;
        System.out.println("\n--- PAYMENT RECEIPT ---");
        System.out.println("Date: " + paymentDate);
        System.out.println("Amount: " + amount + " TL");
        System.out.println("Method: " + paymentMethod);
        System.out.println("Status: PAID SUCCESSFUL");
        System.out.println("-----------------------\n");
    }


    public double getAmount() { return amount; }
    public boolean isProcessed() { return isProcessed; }
}