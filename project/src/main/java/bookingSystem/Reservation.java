package bookingSystem;

public class Reservation {
	private String regName;
	private int regAge;
	private int adults; 
	private int children;
	private int nights;
	private Room roomType;
	
	public Reservation(String regName, int regAge, int adults, int children, int nights, Room roomType) {
		this.regName = regName;
		this.regAge = regAge;
		this.adults = adults;
		this.children = children;
		this.nights = nights;
		this.roomType = roomType;
	}
	
	public String getRegName() {
		return regName;
	}

	public void setRegName(String regName) {
		this.regName = regName;
	}

	public int getRegAge() {
		return regAge;
	}

	public void setRegAge(int regAge) {
		isValidAge(regAge);
		this.regAge = regAge;
	}

	public int getAdults() {
		return adults;
	}

	public void setAdults(int adults) {
		this.adults = adults;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public int getNights() {
		return nights;
	}

	public void setNights(int nights) {
		this.nights = nights;
	}

	
	public boolean isValidAge(int age) {
		return age >= 18 && age <= 100;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
