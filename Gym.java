

public class Gym {

	private String name;
    private PersonLinkedList personList;

    public Gym(String n) {
        name = n;
        personList = new PersonLinkedList();
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
