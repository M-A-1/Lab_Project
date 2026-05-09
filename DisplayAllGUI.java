import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DisplayAllGUI extends JFrame {

    public DisplayAllGUI(Gym gym) {
        setTitle("All people in the " + gym.getName()); //window title/header
        setSize(500, 500); //window size
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //closes window, not keeping it ghost running
        setLocationRelativeTo(null); //centering the window
        
        String[] columns = {"Type", "ID", "Name", "Extra Info"}; //table fields/keys
        DefaultTableModel model = new DefaultTableModel(columns, 0); //table model that shows columns and rows based on the gym member

        Node current = gym.getPersonList().getHead();
        while (current != null) {
            Person p = current.getData();
            if (p instanceof Trainer) {
                Trainer trainer = (Trainer) p;
                model.addRow(new Object[]{ //adding the trainer data into the table
                    "Trainer",
                    trainer.getId(),
                    trainer.getName(),
                    "Job: " + trainer.getJobTitle() + " | Pay: " + trainer.calculatePayment()
                });
            } else if (p instanceof Employee) {
                Employee employee = (Employee) p;
                model.addRow(new Object[]{ //adding the employee data into the table
                    "Employee",
                    employee.getId(),
                    employee.getName(),
                    "Job: " + employee.getJobTitle()
                });
            } else if (p instanceof GymMember) {
                GymMember member = (GymMember) p;
                model.addRow(new Object[]{ //adding the gym member data into the table
                    "GymMember",
                    member.getId(),
                    member.getName(),
                    "Plan: " + member.getPlan().getPlanType() + " | " + member.getPlan().getMonths() + " months"
                });
            }
            
            current = current.getNext(); //getting the next person in the list
        }
        
        JTable table = new JTable(model); //creates table with the model
        table.setEnabled(false); //disables user from editing/interacting with the table rows and columns
        JScrollPane scrollPane = new JScrollPane(table); //creates scroll feature for table
        add(scrollPane); //adding scrolling pane to frame

        setVisible(true); //turning the lights on aka frame now showing
    }
    
}
