import java.io.*;
import java.util.Scanner;

public class Gym {

	private String name;
    private PersonLinkedList personList;
    
    // we use this to make a unique name for every gym file
    private String fileName;

    public Gym(String n) {
        name = n;
        personList = new PersonLinkedList();
        
        /*   replace every space in the name with _ so if:
             * gym name in main: fitness time 
             * file name: fitness_time_gym_people.txt   */
        fileName = name.replace(" ","_") + "gym_people.txt";
    }

    public boolean removePersonById(int id) {
        return personList.remove(id);
    }

    public boolean addPerson(Person p) {
        if (p == null) {
            return false;
        }
        personList.add(p);
        System.out.println(p.getName() + " was added");
        System.out.println("Assigned ID: " + p.getId());
        return true;
    }

    public boolean searchPerson(int id) {
        return personList.search(id);
    }
    
    
    
    public void saveToFile() throws IOException {
        FileWriter writer = new FileWriter(fileName);

        Node current = personList.getHead();

        while (current != null) {
            Person p = current.getData();

            if (p instanceof Trainer) {
                Trainer t = (Trainer) p;

                writer.write("Trainer," 
                        + t.getId() + "," 
                        + t.getName() + "," 
                        + t.getJobTitle() + "," 
                        + t.getHoursWorked() + "," 
                        + t.getHourlyRate() + "\n");

            } else if (p instanceof Employee) {
                Employee e = (Employee) p;

                writer.write("Employee," 
                        + e.getId() + "," 
                        + e.getName() + "," 
                        + e.getJobTitle() + "\n");

            } else if (p instanceof GymMember) {
                GymMember m = (GymMember) p;

                writer.write("GymMember," 
                        + m.getId() + "," 
                        + m.getName() + "," 
                        + m.getPlan().getPlanType() + "," 
                        + m.getPlan().getMonths() + "\n");
            }

            current = current.getNext();
        }

        writer.close();
    }
    
    
    
    
    public void loadFromFile() throws IOException {
        File file = new File(fileName);

        if (!file.exists()) {
            file.createNewFile();
            return;
        }

        Scanner reader = new Scanner(file);

        while (reader.hasNextLine()) {
            String line = reader.nextLine();

            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split(",");

            String type = parts[0];
            int id = Integer.parseInt(parts[1]);
            String name = parts[2];

            if (type.equals("Employee")) {
                String jobTitle = parts[3];

                Employee employee = new Employee(name, id, jobTitle);
                personList.add(employee);

            } else if (type.equals("Trainer")) {
                String jobTitle = parts[3];
                double hoursWorked = Double.parseDouble(parts[4]);
                double hourlyRate = Double.parseDouble(parts[5]);

                Trainer trainer = new Trainer(name, id, jobTitle, hoursWorked, hourlyRate);
                personList.add(trainer);

            } else if (type.equals("GymMember")) {
                String planType = parts[3];
                int months = Integer.parseInt(parts[4]);

                GymMember member = new GymMember(name, id, planType, months);
                personList.add(member);
            }
        }

        reader.close();
    }
       

    public void displayInfo() {
        System.out.println("-----------------------");
        System.out.println("Gym name: " + name);
        System.out.println("Current capacity of the gym: " + personList.getCount());
        System.out.println("Counting the current Persons in the Gym: ");
        personList.displayAll();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PersonLinkedList getPersonList() {
        return personList;
    }
	
		
}
