import javax.swing.*;

public class MainFrame extends JFrame {
    private JTable employeeTable;
    private EmployeeTableModel tableModel;

    public MainFrame() {
        setTitle("Employee Management System");
        setLayout(null);

        tableModel = new EmployeeTableModel();
        employeeTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(employeeTable);
        scrollPane.setBounds(20, 20, 600, 200);
        add(scrollPane);

        JButton viewButton = new JButton("View Employee");
        viewButton.setBounds(20, 240, 150, 25);
        add(viewButton);

        JButton updateButton = new JButton("Update Employee");
        updateButton.setBounds(180, 240, 150, 25);
        add(updateButton);

        JButton deleteButton = new JButton("Delete Employee");
        deleteButton.setBounds(340, 240, 150, 25);
        add(deleteButton);

        viewButton.addActionListener(e -> {
            int selectedRow = employeeTable.getSelectedRow();
            if (selectedRow >= 0) {
                String employeeNumber = (String) tableModel.getValueAt(selectedRow, 0);
                new EmployeeDetailsFrame(employeeNumber).setVisible(true);
            }
        });

        updateButton.addActionListener(e -> {
            int selectedRow = employeeTable.getSelectedRow();
            if (selectedRow >= 0) {
                String employeeNumber = (String) tableModel.getValueAt(selectedRow, 0);
                new UpdateEmployeeFrame(employeeNumber, tableModel).setVisible(true);
            }
        });

        deleteButton.addActionListener(e -> {
            int selectedRow = employeeTable.getSelectedRow();
            if (selectedRow >= 0) {
                String employeeNumber = (String) tableModel.getValueAt(selectedRow, 0);
                new DeleteEmployeeFrame(employeeNumber, tableModel).setVisible(true);
            }
        });

        setSize(650, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginFrame::new);
    }
}
