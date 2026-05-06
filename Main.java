

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
				System.out.print("Gym Capacity: ");
				int capacity = input.nextInt();
				input.nextLine();
				
				Gym gym = new Gym(name, capacity);
				
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
					System.out.println(" ");
					System.out.print("---> Option Number: ");
					
					option = input.nextInt();
					input.nextLine();
					switch (option) {
					case 1:
						if(gym.isFull()) {
							System.out.println("The array is full! please remove a person first");						}
						else {
						System.out.print("Enter Employee Name: ");
		                String EmployeeName = input.nextLine();

		                System.out.print("Enter Employee Job Title: ");
		                String EmployeeJob = input.nextLine();

		                Employee employee = new Employee(EmployeeName, EmployeeJob);
		                gym.addPerson(employee);
						}
		                break;
					
					case 2:
						if(gym.isFull()) {
							System.out.println("The array is full! please remove a person first");						}
						else {
						System.out.print("Enter Trainer Name: ");
		                String TrainerName = input.nextLine();

		                System.out.print("Enter Trainer Job Title: ");
		                String TrainerJob = input.nextLine();

		                System.out.print("Enter Hourly Rate: ");
		                double HourlyRate = input.nextDouble();
		                input.nextLine();
		                
		                System.out.print("Enter Hours Worked: ");
		                double HoursWorked = input.nextDouble();
		                input.nextLine();
		                
		                Trainer trainer = new Trainer(TrainerName, TrainerJob, HoursWorked, HourlyRate);
		                gym.addPerson(trainer);
						}
		                break;
		                
					case 3:
						if(gym.isFull()) {
							System.out.println("The array is full! please remove a person first");
						}
						else {
						System.out.print("Enter Member Name: ");
		                String MemberName = input.nextLine();

		                
		                System.out.print("Enter Membership Type (Normal/Premium): ");
		                String MembershipType = input.nextLine();

		                System.out.print("Enter Number of Months: ");
		                int months = input.nextInt();
		                input.nextLine();
		                
		                GymMember member = new GymMember(MemberName, MembershipType, months);
		                gym.addPerson(member);
						}
		                break;
					
					case 4:
						System.out.print("Enter The Person's ID: ");
		                int searchId = input.nextInt();
		                input.nextLine();

		                gym.searchPerson(searchId);
		                break;
		                
					case 5:
						System.out.print("Enter The Person's ID: ");
		                int id = input.nextInt();
		                input.nextLine();
		                
		                gym.removePersonById(id);		 
		                break;
		                
					case 6:
						gym.displayInfo();
		                break;
		                
					case 7:
						System.out.println("Adios.. (Bye)");
		                button = false;
		                break;
		                
					default:
		                System.out.println("Invalid option");
					}
				} while (button);
				
				input.close();
			}
			
			

		}
		
	