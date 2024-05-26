import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;

public class AgeCalculator {

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Age Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        
        // Create the panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        
        // Add components to the panel
        panel.add(new JLabel("Year:"));
        JTextField yearField = new JTextField();
        panel.add(yearField);
        
        panel.add(new JLabel("Month:"));
        JTextField monthField = new JTextField();
        panel.add(monthField);
        
        panel.add(new JLabel("Day:"));
        JTextField dayField = new JTextField();
        panel.add(dayField);
        
        // Create button and add action listener
        JButton calculateButton = new JButton("Calculate Age");
        panel.add(calculateButton);
        
        // Add the result label
        JLabel resultLabel = new JLabel();
        panel.add(resultLabel);
        
        // Add the panel to the frame
        frame.add(panel);
        
        // Define the action listener
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int year = Integer.parseInt(yearField.getText());
                    int month = Integer.parseInt(monthField.getText());
                    int day = Integer.parseInt(dayField.getText());
                    
                    LocalDate birthDate = LocalDate.of(year, month, day);
                    LocalDate currentDate = LocalDate.now();
                    
                    if (birthDate.isAfter(currentDate)) {
                        resultLabel.setText("Birth date cannot be in the future.");
                    } else {
                        Period age = Period.between(birthDate, currentDate);
                        resultLabel.setText("Age: " + age.getYears() + " years");
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter valid numbers.");
                } catch (Exception ex) {
                    resultLabel.setText("Error: " + ex.getMessage());
                }
            }
        });
        
        // Make the frame visible
        frame.setVisible(true);
    }
}
