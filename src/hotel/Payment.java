package hotel;
/**
 * Payment sınıfı, bir rezervasyon veya hizmet için ödeme işlemlerini temsil eder.
 * Ödeme miktarı ve yöntemi bilgilerini tutar ve ödemeyi işleyen bir metod içerir.
 * 
 *Ödeme yöntemleri genellikle "Credit Card" veya "Cash" olabilir.
 */
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


    public double getAmount() { 
    	return amount; }
}