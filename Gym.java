package project;

public class Gym {

	private String name;
	private int capacity;
	private Person[] arrayOfPersons;
	private int numOfPersons;
	
	public Gym(String n , int c) {
		
		name = n;
		capacity = c;
		arrayOfPersons = new Person[c];
		numOfPersons = 0;
		
	}
	
	//
	public boolean isFull() {
		return numOfPersons == arrayOfPersons.length;
	}
	
	public boolean removePersonById(int id) {
      
        for (int i = 0; i < numOfPersons; i++) {
        	
            if (arrayOfPersons[i].getId() == id) {
                
            	String nameOfPerson = arrayOfPersons[i].getName();
            	
            	for(int j = i ; j<numOfPersons-1 ; j++) {
            		arrayOfPersons[j] = arrayOfPersons[j+1];   	
            	}
            	
            	arrayOfPersons[numOfPersons - 1] = null;
				numOfPersons--;
				System.out.println(nameOfPerson + " was removed");
				return true;
            	
                }
    		
            }
        
        System.out.println("Couldnt find a Person with ID " + id + " to remove");
		return false;
								
	}
	
			
	
	    public boolean addPerson( Person p) {
		//need to check for null first
		if(p == null ) {
			return false;
		}		
		
		
		arrayOfPersons[numOfPersons++] = p; 
		System.out.println(p.getName() + " was added");
		return true;
	}
	
   public boolean searchPerson(int id ) {
	   
	   boolean bool = searchHelper(id , 0);
	   
	   if(bool) {
	   System.out.println("Person with ID " + id + " has been found");
	   }
	   
	   else {
		   System.out.println("No Person with ID " + id + " exists");
	   }
	   
	   return bool;
   }
   
   private boolean searchHelper(int id , int index ) {
	   
	   if(index >= numOfPersons) { 
		   return false; 
	   }
	   
	   if(id == arrayOfPersons[index].getId()) {
		   return true;
	   }
	   
	   return searchHelper(id , index + 1);
   }
	
	public void displayInfo() {
		System.out.println("-----------------------");
        System.out.println("Gym name: " + name + 
        		"\nGym's maximum capacity: " + capacity
        		+ "\nCurrent capacity of the gym: " + 
        		numOfPersons + "\nCounting the current "
        				+ "Persons in the Gym: ");
        
        for(int i = 0 ; i<numOfPersons ; i++) {
        	
        	System.out.println("Person " + (i+1) + "'s info:");
    		System.out.println("-----------------------");
        	arrayOfPersons[i].displayInfo();
    		System.out.println("-----------------------");

        }
	}
	
	
	
	
	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Person[] getArrayOfPersons() {
		/* we don't want someone from outside the
		   class changing the original array so we 
		   make a copy of the original array  */
		Person[] copy = new Person[numOfPersons];
		
		for(int i = 0 ; i<numOfPersons ; i++) {
			copy[i] = arrayOfPersons[i];
		}
		return copy;
	}

	public void setArrayOfPersons(Person[] newArray , int count) {
		
		if(newArray == null || count > capacity || count > newArray.length) {
			System.out.println("Error! Invalid count or null Array");
			return;
		}

		/*using arrayOfPersons = newArray is risky since newArray could get modified
		  and will change arrayOfPersons therefore we have to make a copy of the array*/
		
		arrayOfPersons = new Person[capacity];
		numOfPersons = count;
		for(int i = 0 ; i<numOfPersons ; i++) {
			arrayOfPersons[i] = newArray[i];
		}
	}

	public int getNumOfPersons() {
		return numOfPersons;
	}

	public void setNumOfPersons(int numOfPersons) {
		this.numOfPersons = numOfPersons;
	}

	
	//---------------------------------------------------------------
	
	
	
}
