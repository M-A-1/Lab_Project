public class GymMember extends Person{

	private MembershipPlan plan;
	
	public GymMember(String name , String type , int months) {
		super(name);
		plan = new MembershipPlan( type, months );
		
	}
	
	
	//used when reading a file
	public GymMember(String name , int id, String type , int months) {
		super(name,id);
		plan = new MembershipPlan( type, months );
		
	}
	
	public void displayInfo() {
		System.out.println("Name of Member: " + name +
				"\nID of Member: " + id +
				"\nMembership Plan: " + plan.getPlanType()
				+"\nTime left on Membership: " + plan.getMonths());
	}
	
	public MembershipPlan getPlan() {
		/*this is done to prevent outside actions from changing the original plan*/
		return new MembershipPlan(plan);
	}
	
	public void setPlan(MembershipPlan p) {
		/*if we were to write plan = p whenever
		  p is modified that would also affect plan
		  so we have to make use of the copy constructor
		  to make a copy of p*/
		plan = new MembershipPlan(p);
		
	}
}