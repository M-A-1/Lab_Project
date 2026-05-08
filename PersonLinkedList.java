
public class PersonLinkedList {

	private Node head;

    public PersonLinkedList() {
        this.head = null;
    }

    public void add(Person p) {
        Node newNode = new Node(p);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public boolean remove(int id) {
        if (head == null) {
            System.out.println("Couldnt find a Person with ID " + id + " to remove");
            return false;
        }

        if (head.getData().getId() == id) {
            String nameOfPerson = head.getData().getName();
            head = head.getNext();
            System.out.println(nameOfPerson + " was removed");
            return true;
        }

        Node current = head;
        while (current.getNext() != null && current.getNext().getData().getId() != id) {
            current = current.getNext();
        }

        if (current.getNext() != null) {
            String nameOfPerson = current.getNext().getData().getName();
            current.setNext(current.getNext().getNext());
            System.out.println(nameOfPerson + " was removed");
            return true;
        }

        System.out.println("Couldnt find a Person with ID " + id + " to remove");
        return false;
    }

    public boolean search(int id) {
        Node current = head;
        while (current != null) {
            if (current.getData().getId() == id) {
                System.out.println("Person with ID " + id + " has been found");
                return true;
            }
            current = current.getNext();
        }
        System.out.println("No Person with ID " + id + " exists");
        return false;
    }

    public void displayAll() {
        Node current = head;
        int count = 1;
        while (current != null) {
            System.out.println("Person " + count + "'s info:");
            System.out.println("-----------------------");
            current.getData().displayInfo();
            System.out.println("-----------------------");
            current = current.getNext();
            count++;
        }
    }

    public int getCount() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }
    
    
    
    public Node getHead() {
    	return head;
    }
}
