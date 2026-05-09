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
		//handling in the method it occurred:	
		
		/*  must handle type and price in a different try 
		   than months since they both could cause different 
		   types of error at the same time */
		
		try {
			
		if(type.equalsIgnoreCase("Premium")) {
			basePrice = 100;
			planType = "Premium";
		}
		
		else if(type.equalsIgnoreCase("Normal")) {
			basePrice = 50;
			planType = "Normal";
		}
		
		else {
			
			throw new IllegalArgumentException("Invalid membership type setting default value to Normal.");
		   }
		
		}
		
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			basePrice = 50;        //default value
			planType = "Normal";   //default value
		}
		
		
		
		try {
			
			
			if(m <= 0) {
				throw new InvalidMonthsException("Invalid number of months setting default value to 1 month.");
			}
			
			
			months = m;
			
			}
			
			catch(InvalidMonthsException e) {
				System.out.println(e.getMessage());
				months = 1;            //default value
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
