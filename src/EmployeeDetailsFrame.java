import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EmployeeDetailsFrame extends JFrame {
    private String employeeNumber;
    private JLabel detailsLabel;
    private JTextField monthField;
    private JButton computeButton;

    public EmployeeDetailsFrame(String employeeNumber) {
        this.employeeNumber = employeeNumber;
        setTitle("Employee Details");
        setLayout(null);

        detailsLabel = new JLabel();
        detailsLabel.setBounds(20, 20, 400, 100);
        add(detailsLabel);

        JLabel monthLabel = new JLabel("Enter Month:");
        monthLabel.setBounds(20, 140, 80, 25);
        add(monthLabel);

        monthField = new JTextField();
        monthField.setBounds(100, 140, 165, 25);
        add(monthField);

        computeButton = new JButton("Compute");
        computeButton.setBounds(100, 170, 100, 25);
        add(computeButton);

        computeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String month = monthField.getText();
                    computeSalary(month);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        loadEmployeeDetails();

        setSize(450, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void loadEmployeeDetails() {
        try (BufferedReader reader = new BufferedReader(new FileReader("employees.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(employeeNumber)) {
                    detailsLabel.setText("<html>Employee Number: " + data[0] + "<br>" +
                            "Last Name: " + data[1] + "<br>" +
                            "First Name: " + data[2] + "<br>" +
                            "SSS No.: " + data[3] + "<br>" +
                            "PhilHealth No.: " + data[4] + "<br>" +
                            "TIN: " + data[5] + "<br>" +
                            "Pagibig No.: " + data[6] + "</html>");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void computeSalary(String month) {
        // Implement the salary computation logic based on the selected month
        // This is a placeholder for the actual computation logic
        JOptionPane.showMessageDialog(this, "Salary computed for " + month);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EmployeeDetailsFrame("123").setVisible(true));
    }
}
