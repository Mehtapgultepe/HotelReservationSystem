package hotel;

/**
* Reservable arayüzü, bir nesnenin rezervasyona uygun olup olmadığını ve
* rezervasyon işlemlerini tanımlar.
* 
* Bu arayüzü implemente eden sınıflar, rezervasyon oluşturma, iptal etme ve
* müsaitlik kontrolü işlemlerini gerçekleştirmek zorundadır.
*/
public interface Reservable {
	boolean isAvailable();
	void reserve(Customer customer);
	/**
     * Mevcut rezervasyonu iptal eder ve nesneyi tekrar müsait hale getirir.
     */
	void cancel();
}