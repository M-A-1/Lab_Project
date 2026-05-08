

public class Trainer extends Employee implements IPayable{

	private double hourlyRate;
	private double hoursWorked;
	
	public Trainer(String name , String jT , double hW , double hR ) {
		super(name , jT);
		hourlyRate = hR;
		hoursWorked = hW;
	}
	
	// used when reading a file
	public Trainer(String name , int id , String jT , double hW , double hR ) {
		super(name , id , jT);
		hourlyRate = hR;
		hoursWorked = hW;
	}
	
	
	public double calculatePayment() {
		return hourlyRate * hoursWorked;
	}
	
	
	public void displayInfo() {
		
		super.displayInfo();
		System.out.println("Hourly rate: " + hourlyRate + 
				"\nHourlyWorked: " + hoursWorked);
		
	}
	
	
	//setters and getters
	public double getHourlyRate() {
		return hourlyRate;
	}
	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	public double getHoursWorked() {
		return hoursWorked;
	}
	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
	
	//----------------------------------------------------

	
}
