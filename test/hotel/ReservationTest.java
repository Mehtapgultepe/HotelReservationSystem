package hotel;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class ReservationTest {

    private StandardRoom standardRoom;
    private Customer testCustomer;
    private Reservation reservation;

    @BeforeEach
    void setUp() {
        // Arrange (Hazırlık): Test için gerekli nesneleri oluşturuyoruz
        // StandardRoom(odaNo, gunlukFiyat) şeklinde bir constructor olduğunu varsaydık
        standardRoom = new StandardRoom(101, 1000.0); 
        testCustomer = new Customer("Can Demir", "98765432101", "5321112233");
        
        // Act (Eylem): Rezervasyon nesnesini oluşturuyoruz
        reservation = new Reservation(standardRoom, testCustomer, 5);
    }

    @Test
    @DisplayName("Rezervasyon içindeki nesne referansları doğru tutulmalı")
    void testObjectReferences() {
        assertAll("Nesne Kontrolleri",
            () -> assertEquals(101, reservation.getRoom().getRoomNumber()),
            () -> assertEquals("Can Demir", reservation.getCustomer().getName()),
            () -> assertEquals(5, reservation.getSdays())
        );
    }

}