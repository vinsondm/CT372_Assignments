import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class DavesUserInterface extends JFrame {
    private JTextArea textArea;
    
    public DavesUserInterface() {
        // Initial settings for jframe (extension)
        setTitle("Dave's User Interface");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    
        // Create text area
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setOpaque(true);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create menu
        JMenu menu = new JMenu("Options");

        // Create menu items
        JMenuItem dateTimeItem = new JMenuItem("Print Date and Time");
        dateTimeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printDateTime();
            }
        });

        // save menu item
        JMenuItem saveLogItem = new JMenuItem("Save Log");
        saveLogItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveLogToFile();
            }
        });

        // change color menu item
        JMenuItem changeColorItem = new JMenuItem("Change Background Color");
        changeColorItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeBackgroundColor();
            }
        });

        // exit menu item
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Add menu items to menu
        menu.add(dateTimeItem);
        menu.add(saveLogItem);
        menu.add(changeColorItem);
        menu.add(exitItem);

        // Add menu to menu bar
        menuBar.add(menu);

        // Add menu bar to frame
        setJMenuBar(menuBar);
    }

    // date time function
    private void printDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        textArea.append("Current Date and Time: " + dtf.format(now) + "\n");
    }

    // save log function
    private void saveLogToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt"))) {
            textArea.write(writer);
            textArea.append("Log saved to log.txt\n");
        } catch (IOException e) {
            textArea.append("Error saving log to file\n");
        }
    }

    // color change function
    private void changeBackgroundColor() {
        Random rand = new Random();
        float green = rand.nextFloat();
        Color bgColor = new Color(0, green, 0);
        this.textArea.setBackground(bgColor);
        this.textArea.setVisible(true);
        textArea.append(String.format("Background color changed to " + bgColor.toString() + "\n"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DavesUserInterface().setVisible(true);
            }
        });
    }
}
