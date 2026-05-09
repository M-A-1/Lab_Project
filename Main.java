import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
			
			public static void main(String[] args) {
				Scanner input = new Scanner(System.in);
				
				System.out.println("-------------------------------------------");
		        System.out.println("Welcome to your Gym Management Simulator");
		        System.out.println("-------------------------------------------");
		        System.out.println(" ");
		        System.out.println("To Start Managing Your Gym, You Need To Create One");
		        System.out.println(" ");

		        System.out.print("Gym Name: ");
		        String name = input.nextLine();

				while (name.trim().isEmpty()) {
    				System.out.println("Gym name cannot be empty!");
    				System.out.print("Gym Name: ");
    				name = input.nextLine();
				}

		        Gym gym = new Gym(name);

		        
		        //handling by propagation:
		        try {
		        	gym.loadFromFile();
		        }catch(IOException e) {
		        	System.out.println("Could not load file: " + e.getMessage());
		        }
		        
		        
		        
		        
		        
		        boolean button = true;
		        int option;
		        do {
		            System.out.println("------------------------");
		            System.out.println("Manage Your Gym");
		            System.out.println("------------------------");
		            System.out.println(" ");
		            System.out.println("1) Add Employee");
		            System.out.println("2) Add Trainer");
		            System.out.println("3) Add Member");
		            System.out.println("4) Search Person");
		            System.out.println("5) Remove Person");
		            System.out.println("6) Display Gym Info");
		            System.out.println("7) Exit");
					System.out.println("8) Add Person (GUI)");
					System.out.println("9) Display All (GUI)");	
		            System.out.println(" ");
		            System.out.print("---> Option Number: ");

					try {
						option = input.nextInt();
						input.nextLine();
					} catch (InputMismatchException e) {
						System.out.println("Please enter a valid number!");
						input.nextLine();
						continue;
					}
		            switch (option) {
		                case 1:
		                    System.out.print("Enter Employee Name: ");
		                    String EmployeeName = input.nextLine();
							if (EmployeeName.trim().isEmpty()) {
    								System.out.println("Employee name cannot be empty!");
    								continue;
								}

		                    System.out.print("Enter Employee Job Title: ");
		                    String EmployeeJob = input.nextLine();
							if (EmployeeJob.trim().isEmpty()) {
								System.out.println("Employee job title cannot be empty!");
								continue;
							}

		                    Employee employee = new Employee(EmployeeName, EmployeeJob);
		                    gym.addPerson(employee);
		                    break;

		                case 2:
		                    System.out.print("Enter Trainer Name: ");
		                    String TrainerName = input.nextLine();
							if (TrainerName.trim().isEmpty()) {
    								System.out.println("Trainer name cannot be empty!");
    								continue;
							}

		                    System.out.print("Enter Trainer Job Title: ");
		                    String TrainerJob = input.nextLine();
							if (TrainerJob.trim().isEmpty()) {
								System.out.println("Trainer job title cannot be empty!");
								continue;
							}
		                    
							try {
		                    System.out.print("Enter Hourly Rate: ");
		                    double HourlyRate = input.nextDouble();
		                    input.nextLine();

		                    System.out.print("Enter Hours Worked: ");
		                    double HoursWorked = input.nextDouble();
		                    input.nextLine();

							if (HoursWorked <= 0 || HourlyRate <= 0) {
								System.out.println("Hourly rate and hours worked must be positive");
								continue; 
							}

		                    Trainer trainer = new Trainer(TrainerName, TrainerJob, HoursWorked, HourlyRate);
		                    gym.addPerson(trainer);
						}
						catch(InputMismatchException e) {
							System.out.println("Hourly Rate and Hours Worked should be numbers!");
							input.nextLine();
							continue;
						}
		                    break;

		                case 3:
		                    System.out.print("Enter Member Name: ");
		                    String MemberName = input.nextLine();

		                    System.out.print("Enter Membership Type (Normal/Premium): ");
		                    String MembershipType = input.nextLine();

		                    System.out.print("Enter Number of Months: ");
							try {
								int months = input.nextInt();
								input.nextLine();

								if (MemberName.trim().isEmpty()) {
    								System.out.println("Member name cannot be empty!");
    								continue;
								}

								if (MembershipType.trim().isEmpty()) {
    								System.out.println("Membership type cannot be empty!");
    								continue;
								}
								// MembershipType could cause an unchecked exception and is handled in the constructor.
								GymMember member = new GymMember(MemberName, MembershipType, months);
								gym.addPerson(member);
							} catch (InputMismatchException e) {
								System.out.println("Please enter a valid number!");
								input.nextLine();
								continue;
							}
		                    
		                    break;

		                case 4:
		                    System.out.print("Enter The Person's ID: ");
							try {
								int searchId = input.nextInt();
								input.nextLine();

								if (searchId <= 0) {
									System.out.println("ID should be greater than 0!");
									continue;
								}

								gym.searchPerson(searchId);
							} catch (InputMismatchException e) {
								System.out.println("ID should be a number!");
								input.nextLine();
								continue;
							}
		                    
		                    break;

		                case 5:
		                    System.out.print("Enter The Person's ID: ");
		                    try {
								int id = input.nextInt();
								input.nextLine();

								if (id <= 0) {
									System.out.println("ID should be greater than 0!");
									continue;
								}
								gym.removePersonById(id);
							} catch (InputMismatchException e) {
								System.out.println("ID should be a number!");
								input.nextLine();
								continue;
							}

		                    break;

		                case 6:
		                    gym.displayInfo();
		                    break;

		                case 7:
		                	
		                	//handling by propagation:
		                	try {
		                		gym.saveToFile();
		                		System.out.println("Gym data saved successfully :D");
		                	}catch(IOException e) {
		                		System.out.println("Could not save file: " + e.getMessage()  + " :(");
		                	}
		                	
		                	
		                    System.out.println("Adios.. (Bye)");
		                    button = false;
		                    break;
							
						case 8:
							new AddPersonGUI(gym); //calling the GUI to add a person
							break;
						case 9:
							new DisplayAllGUI(gym); //calling the GUI to display all people
							break;

		                default:
		                    System.out.println("Invalid option");
		            }
		        } while (button);

		        input.close();
		    }
			
			

		}
		
	