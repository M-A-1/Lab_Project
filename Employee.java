

public class Employee extends Person{

	private String jobTitle;
	
	public Employee( String name , String jT) {
		super(name);
		jobTitle = jT;
	}
	
	public void displayInfo() {
		
		System.out.println("Name of Employee: " + name +
				"\nID of Employee: " + id +
				"\nCurrent Job title: " + jobTitle);

		
	}

	//setter and getter
	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	//------------------------------------------------
}
