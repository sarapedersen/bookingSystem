package bookingSystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class ReservationTest {

private Reservation reservation;
	
	@BeforeEach
	public void setup() {
		reservation = new Reservation();
	
	}
	
//	@Test
//	@DisplayName("Konstruktør")
//	public void testConstructor() {								//usikker på om det skal være med parametre i konstruktøren
//		Assertions.assertEquals(0.0, reservation.get, );
//	}
	
	@Test
	@DisplayName("Totalsum")
	public void testCaluculateTotalPrice() {
		reservation.setNights(3);
		reservation.setRoom(Hotel.premium);
		reservation.setPeople(10);
		reservation.caluculateTotalPrice();
		Assertions.assertEquals(15741, reservation.getTotalPrice());
	}
	
}
