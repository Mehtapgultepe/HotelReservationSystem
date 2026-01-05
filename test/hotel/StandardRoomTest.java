package hotel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StandardRoomTest {

	@Test
	public void calculatePriceTest() {
		
		StandardRoom SR = new StandardRoom(100,400);
		double totalPrice = SR.calculatePrice(5);
		assertEquals(2001.0, totalPrice,"fiyat dogru hesaplandı");
	}

}
