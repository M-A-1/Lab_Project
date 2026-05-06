

public class MembershipPlan implements IPayable{

	private String planType;
	private double basePrice;
	private int months;
	
	//copy constructor
	public MembershipPlan( MembershipPlan other) {
		if(other != null) {
		planType = other.planType;
		basePrice = other.basePrice;
		months = other.months;
		}
		else {
			
		}
	}
	//------------------------------------------------
	
	
	public MembershipPlan(String type , int m) {
		
		months = m;
				
		if(type.equalsIgnoreCase("Premium")) {
			basePrice = 100;
			planType = "Premium";
		}
		
		else if(type.equalsIgnoreCase("Normal")) {
			basePrice = 50;
			planType = "Normal";
		}
		
		else {
			throw new IllegalArgumentException("Invalid "
					+ "membership type: " + type);
		}
		
	}
	
	
	public double calculatePayment() {
		
		return basePrice * months;
		
	}
	
	
	//setters and getters
	
	public String getPlanType() {
		return planType;
	}
	public void setPlanType(String planType) {
		this.planType = planType;
	}
	public int getMonths() {
		return months;
	}
	public void setMonths(int months) {
		this.months = months;
	}
	
	//-----------------------------------------------
}
