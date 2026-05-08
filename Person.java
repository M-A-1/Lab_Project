

public abstract class Person {
		
		protected String name;
		protected int id;
		
		private static int idCounter = 1000;
		
		public Person(String name) {
			this.name = name;
			this.id = idCounter++;
		}
		
		/* we use this constructor
		for reading a file so the counter doesn't 
		update after we read a old Person*/
		public Person(String name, int id) {
			this.name = name;
			this.id = id;
			
			// we should update the counter to after the largest id's
			if(id>= idCounter) {
				idCounter = id + 1;
			}
		}
		
		// getters and setters

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getId() {
			return id;
		}
		
		
		/////////////////////////////////
		
		public abstract void displayInfo(); // for the polymorphism
		
		
		

	
}
