import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeSheetFrame extends JFrame {
    private JTextField employeeNameField;
    private JTable timeSheetTable;

    public TimeSheetFrame(String employeeName) {
        setTitle("Time Sheet");
        setLayout(new BorderLayout());

        // Employee Information Panel
        JPanel employeeInfoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        employeeInfoPanel.add(new JLabel("Employee Name: "));
        employeeNameField = new JTextField(employeeName);
        employeeNameField.setEditable(false);
        employeeInfoPanel.add(employeeNameField);
        add(employeeInfoPanel, BorderLayout.NORTH);

        // Time Sheet Table
        String[] columnNames = {"Date", "Hours Worked"};
        Object[][] data = new Object[7][2]; // 7 days, 2 columns
        SimpleDateFormat sdf = new SimpleDateFormat("EEE dd/MM");
        Calendar calendar = Calendar.getInstance();
        for (int i = 0; i < 7; i++) {
            data[i][0] = sdf.format(calendar.getTime());
            data[i][1] = ""; // Blank hours worked
            calendar.add(Calendar.DAY_OF_MONTH, 1); // Move to the next day
        }
        timeSheetTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(timeSheetTable);
        add(scrollPane, BorderLayout.CENTER);

        // Save Button
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveTimeSheet();
            }
        });
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(saveButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setSize(450, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void saveTimeSheet() {
        // Implement save functionality here
        // You can retrieve data from the JTable and perform necessary actions
    }
}
