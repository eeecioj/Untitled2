import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DeleteEmployeeFrame extends JFrame {
    private String employeeNumber;
    private EmployeeTableModel tableModel;
    private JLabel detailsLabel;
    private JButton deleteButton;

    public DeleteEmployeeFrame(String employeeNumber, EmployeeTableModel tableModel) {
        this.employeeNumber = employeeNumber;
        this.tableModel = tableModel;
        setTitle("Delete Employee");
        setLayout(null);

        detailsLabel = new JLabel();
        detailsLabel.setBounds(20, 20, 400, 100);
        add(detailsLabel);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(100, 140, 100, 25);
        add(deleteButton);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteEmployee();
            }
        });

        loadEmployeeDetails();

        setSize(450, 200);
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

    private void deleteEmployee() {
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this employee?", "Delete Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            tableModel.deleteEmployee(employeeNumber);
            JOptionPane.showMessageDialog(this, "Employee deleted successfully.");
            dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DeleteEmployeeFrame("123", new EmployeeTableModel()).setVisible(true));
    }
}
