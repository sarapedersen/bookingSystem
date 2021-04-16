package bookingSystem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class dateTester {
	
	private static LocalDate checkInDate;
	private static LocalDate checkInDate2;
	private static LocalDate checkOutDate;
	
	
	
	public void checkIn(LocalDate date, int days) {
		List<LocalDate> period = new ArrayList<>();
		
		if (!date.isBefore(LocalDate.now())) {					//ved gyldig dato:
			for (int i= 0; i < days; i++) {
				period.add(date.plusDays(i));					//legg inn datoene i lista periode
				System.out.println(date.plusDays(i));
			}
		}
	}
	
	
	
	public static void main(String[] args) {

		checkInDate = LocalDate.of(2021, Month.MARCH, 19);
		checkInDate2 = LocalDate.of(2021, Month.MARCH, 20);
		
		dateTester test = new dateTester();
		dateTester test2 = new dateTester();
		test.checkIn(checkInDate, 4);
		test2.checkIn(checkInDate2, 2);
		
//		checkOutDate = checkInDate.plusDays(4);
//		System.out.println(checkOutDate);
		
		
		
	}
}
