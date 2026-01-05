package hotel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DeluxeRoomTest {

	@Test
	public void testCalculatePrice() {
		DeluxeRoom DR = new DeluxeRoom(100,400);
		double totalPrice = DR.calculatePrice(5);
		assertEquals(3000.0, totalPrice,"fiyat yanlıs hesaplandı");
	}

}
