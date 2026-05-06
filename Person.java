

public abstract class Person {
		
		protected String name;
		protected int id;
		
		private static int idCounter = 1000;
		
		public Person(String name) {
			this.name = name;
			this.id = idCounter++;
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
