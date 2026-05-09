import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class AddPersonGUI extends JFrame {

    public AddPersonGUI(Gym gym) {
        setTitle("Add Person to " + gym.getName()); //window title/header
        setSize(500, 500); //window size
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //closes window, not keeping it ghost running
        setLocationRelativeTo(null); //centering the window
        
        JPanel panel = new JPanel(); //creates panel/container
        panel.setLayout(new GridLayout(0, 2, 10, 10)); //layout of panel
        
        JLabel typeLabel = new JLabel("Person Type:");
        String[] types = {"Employee", "Trainer", "GymMember"}; //choice in dropdown menu
        JComboBox<String> dropdown = new JComboBox<>(types); //creates dropdown menu
        panel.add(typeLabel);
        panel.add(dropdown);
        
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        panel.add(nameLabel);
        panel.add(nameField);
        
        JLabel jobLabel = new JLabel("Job Title:");
        JTextField jobField = new JTextField();
        panel.add(jobLabel);
        panel.add(jobField);
        
        JLabel rateLabel = new JLabel("Hourly Rate:");
        JTextField rateField = new JTextField();
        panel.add(rateLabel);
        panel.add(rateField);
        
        JLabel hoursLabel = new JLabel("Hours Worked:");
        JTextField hoursField = new JTextField();
        panel.add(hoursLabel);
        panel.add(hoursField);
        
        JLabel planLabel = new JLabel("Plan (Normal/Premium):");
        JTextField planField = new JTextField();
        panel.add(planLabel);
        panel.add(planField);
        
        JLabel monthsLabel = new JLabel("Months:");
        JTextField monthsField = new JTextField();
        panel.add(monthsLabel);
        panel.add(monthsField);

        JButton addButton = new JButton("Add Person");
        panel.add(new JLabel()); //placed label on column 1 for button placement to be on the right
        panel.add(addButton);   
        add(panel);

        //we have to hide them first, so they appear later only based on selection
        //since Employee shows first as default, we show it fields only initially
        rateLabel.setVisible(false);
        rateField.setVisible(false);
        hoursLabel.setVisible(false);
        hoursField.setVisible(false);
        planLabel.setVisible(false);
        planField.setVisible(false);
        monthsLabel.setVisible(false);
        monthsField.setVisible(false);

        dropdown.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String selected = (String) dropdown.getSelectedItem(); //since combobox holds objects not Strings

        // We Hide everything for specific ones to appear later only based on selection
        jobLabel.setVisible(false);
        jobField.setVisible(false);
        rateLabel.setVisible(false);
        rateField.setVisible(false);
        hoursLabel.setVisible(false);
        hoursField.setVisible(false);
        planLabel.setVisible(false);
        planField.setVisible(false);
        monthsLabel.setVisible(false);
        monthsField.setVisible(false);

        if (selected.equals("Employee")) {
            jobLabel.setVisible(true);   jobField.setVisible(true);
        }
        else if (selected.equals("Trainer")) {
            jobLabel.setVisible(true);   jobField.setVisible(true);
            rateLabel.setVisible(true);   rateField.setVisible(true);
            hoursLabel.setVisible(true);  hoursField.setVisible(true);
        }
        else if (selected.equals("GymMember")) {
            planLabel.setVisible(true);   planField.setVisible(true);
            monthsLabel.setVisible(true); monthsField.setVisible(true);
        }
    }
});
        
        
        addButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String type = (String) dropdown.getSelectedItem();

        if (name.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "CANT HAVE A BLANK NAME!");
            return; //dont add the person if empty name
        }

        try {
        if (type.equals("Employee")) {
            String job = jobField.getText();
            if (job.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "CANT HAVE A BLANK JOB TITLE!");
                return; //dont add the person if empty name
            }
            Employee emp = new Employee(name, job);
            gym.getPersonList().add(emp);
            JOptionPane.showMessageDialog(null, name + " added as Employee!\nID: " + emp.getId());
        }
        else if (type.equals("Trainer")) {
            String job = jobField.getText();
            if (job.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "CANT HAVE A BLANK JOB TITLE!");
                return; //dont add the person if empty name
            }

            double rate = Double.parseDouble(rateField.getText());
            double hours = Double.parseDouble(hoursField.getText());

            if(rate <= 0 || hours <= 0)
            {
                JOptionPane.showMessageDialog(null, "Hourly rate and hours worked must be positive");
                return; //dont add the person if invalid rate or hours
            }

            Trainer trainer = new Trainer(name, job, hours, rate);
            gym.getPersonList().add(trainer);
            JOptionPane.showMessageDialog(null, name + " added as Trainer!\nID: " + trainer.getId());
        }
        else if (type.equals("GymMember")) {
            String plan = planField.getText();
            if (plan.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "CANT HAVE A BLANK PLAN!");
                return; //dont add the person if empty name
            }
            int months = Integer.parseInt(monthsField.getText()); //converting string to int
            if (months <= 0) {
                JOptionPane.showMessageDialog(null, "CANT HAVE A BLANK MEMBERSHIP PERIOD!");
                return; //dont add the person if empty name
            }
            GymMember member = new GymMember(name, plan, months);
            gym.getPersonList().add(member);
            JOptionPane.showMessageDialog(null, name + " added as GymMember!\nID: " + member.getId()); //popup window message
        }
        try {
            gym.saveToFile();
        } catch (IOException e2) {
            JOptionPane.showMessageDialog(null, "Could not save to file");
        }
    } catch (NumberFormatException e3) {
        JOptionPane.showMessageDialog(null, "Invalid number format!\nRate/Hours/Months must be a number!");
    }
    }

});
        setVisible(true); //turning the lights on aka frame now showing


    }
}
