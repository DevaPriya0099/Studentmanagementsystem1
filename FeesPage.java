package Studentmanagementsystem1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class FeesPage extends JFrame implements ActionListener {

    JLabel titleLabel, studentIdLabel, studentNameLabel, courseLabel;
    JLabel totalFeesLabel, paidFeesLabel, dueFeesLabel, statusLabel, searchLabel;

    JTextField studentIdField, studentNameField, courseField;
    JTextField totalFeesField, paidFeesField, dueFeesField, searchField;

    JComboBox<String> statusBox;

    JButton addButton, updateButton, deleteButton, clearButton, backButton, searchButton;

    JTable feesTable;
    DefaultTableModel model;

    JTextArea summaryArea, transactionArea, dueArea;

    public FeesPage() {
        setTitle("Student Management System - Fees Details");
        setSize(1050, 650);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(0, 0, 1050, 650);
        mainPanel.setBackground(new Color(232, 236, 240));
        add(mainPanel);

        titleLabel = new JLabel("Fees Details");
        titleLabel.setBounds(30, 25, 250, 40);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(new Color(55, 85, 125));
        mainPanel.add(titleLabel);

        studentIdLabel = new JLabel("Student ID");
        studentIdLabel.setBounds(30, 95, 110, 30);
        studentIdLabel.setFont(new Font("Arial", Font.BOLD, 16));
        mainPanel.add(studentIdLabel);

        studentIdField = new JTextField();
        studentIdField.setBounds(150, 95, 180, 32);
        studentIdField.setFont(new Font("Arial", Font.PLAIN, 16));
        mainPanel.add(studentIdField);

        studentNameLabel = new JLabel("Student Name");
        studentNameLabel.setBounds(370, 95, 130, 30);
        studentNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        mainPanel.add(studentNameLabel);

        studentNameField = new JTextField();
        studentNameField.setBounds(500, 95, 180, 32);
        studentNameField.setFont(new Font("Arial", Font.PLAIN, 16));
        mainPanel.add(studentNameField);

        courseLabel = new JLabel("Course");
        courseLabel.setBounds(720, 95, 100, 30);
        courseLabel.setFont(new Font("Arial", Font.BOLD, 16));
        mainPanel.add(courseLabel);

        courseField = new JTextField();
        courseField.setBounds(835, 95, 180, 32);
        courseField.setFont(new Font("Arial", Font.PLAIN, 16));
        mainPanel.add(courseField);

        totalFeesLabel = new JLabel("Total Fees");
        totalFeesLabel.setBounds(30, 145, 100, 30);
        totalFeesLabel.setFont(new Font("Arial", Font.BOLD, 16));
        mainPanel.add(totalFeesLabel);

        totalFeesField = new JTextField();
        totalFeesField.setBounds(150, 145, 180, 32);
        totalFeesField.setFont(new Font("Arial", Font.PLAIN, 16));
        mainPanel.add(totalFeesField);

        paidFeesLabel = new JLabel("Paid Fees");
        paidFeesLabel.setBounds(370, 145, 100, 30);
        paidFeesLabel.setFont(new Font("Arial", Font.BOLD, 16));
        mainPanel.add(paidFeesLabel);

        paidFeesField = new JTextField();
        paidFeesField.setBounds(500, 145, 180, 32);
        paidFeesField.setFont(new Font("Arial", Font.PLAIN, 16));
        mainPanel.add(paidFeesField);

        dueFeesLabel = new JLabel("Due Fees");
        dueFeesLabel.setBounds(720, 145, 100, 30);
        dueFeesLabel.setFont(new Font("Arial", Font.BOLD, 16));
        mainPanel.add(dueFeesLabel);

        dueFeesField = new JTextField();
        dueFeesField.setBounds(835, 145, 180, 32);
        dueFeesField.setFont(new Font("Arial", Font.PLAIN, 16));
        dueFeesField.setEditable(false);
        mainPanel.add(dueFeesField);

        statusLabel = new JLabel("Status");
        statusLabel.setBounds(30, 195, 100, 30);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 16));
        mainPanel.add(statusLabel);

        String[] statusOptions = {"Paid", "Partial", "Unpaid"};
        statusBox = new JComboBox<>(statusOptions);
        statusBox.setBounds(150, 195, 180, 34);
        statusBox.setFont(new Font("Arial", Font.PLAIN, 16));
        mainPanel.add(statusBox);

        addButton = createButton("Add", 90, 255, new Color(39, 77, 126));
        updateButton = createButton("Update", 230, 255, new Color(95, 115, 135));
        deleteButton = createButton("Delete", 370, 255, new Color(175, 63, 46));
        clearButton = createButton("Clear", 510, 255, new Color(180, 180, 180));
        backButton = createButton("Back", 650, 255, new Color(90, 100, 110));

        mainPanel.add(addButton);
        mainPanel.add(updateButton);
        mainPanel.add(deleteButton);
        mainPanel.add(clearButton);
        mainPanel.add(backButton);

        searchLabel = new JLabel("Search by Student Name");
        searchLabel.setBounds(30, 320, 190, 30);
        searchLabel.setFont(new Font("Arial", Font.BOLD, 16));
        mainPanel.add(searchLabel);

        searchField = new JTextField();
        searchField.setBounds(220, 320, 180, 32);
        searchField.setFont(new Font("Arial", Font.PLAIN, 16));
        mainPanel.add(searchField);

        searchButton = createButton("Search", 440, 318, new Color(39, 77, 126));
        mainPanel.add(searchButton);

        String[] columns = {"Student ID", "Student Name", "Course", "Total Fees", "Paid Fees", "Due Fees", "Status"};
        model = new DefaultTableModel(columns, 0);
        feesTable = new JTable(model);
        feesTable.setRowHeight(28);
        feesTable.setFont(new Font("Arial", Font.PLAIN, 14));
        feesTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        feesTable.getTableHeader().setBackground(new Color(44, 74, 110));
        feesTable.getTableHeader().setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(feesTable);
        scrollPane.setBounds(30, 370, 750, 210);
        mainPanel.add(scrollPane);

        JPanel summaryPanel = new JPanel();
        summaryPanel.setLayout(null);
        summaryPanel.setBounds(800, 200, 220, 380);
        summaryPanel.setBackground(new Color(220, 224, 228));
        summaryPanel.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180)));
        mainPanel.add(summaryPanel);

        JLabel paymentSummaryLabel = new JLabel("Payment Summary");
        paymentSummaryLabel.setBounds(10, 10, 180, 25);
        paymentSummaryLabel.setFont(new Font("Arial", Font.BOLD, 18));
        summaryPanel.add(paymentSummaryLabel);

        JLabel breakdownLabel = new JLabel("Fee Type Breakdown");
        breakdownLabel.setBounds(10, 45, 180, 25);
        breakdownLabel.setFont(new Font("Arial", Font.BOLD, 15));
        summaryPanel.add(breakdownLabel);

        summaryArea = new JTextArea();
        summaryArea.setBounds(10, 75, 195, 100);
        summaryArea.setFont(new Font("Arial", Font.PLAIN, 13));
        summaryArea.setEditable(false);
        summaryArea.setBackground(new Color(245, 245, 245));
        summaryArea.setText(
                "Tuition Fees  : 40000\n" +
                "Lab Fees      : 5000\n" +
                "Library Fees  : 3000\n" +
                "Exam Fees     : 2000"
        );
        summaryPanel.add(summaryArea);

        JLabel recentTransactionsLabel = new JLabel("Recent Transactions");
        recentTransactionsLabel.setBounds(10, 190, 180, 25);
        recentTransactionsLabel.setFont(new Font("Arial", Font.BOLD, 15));
        summaryPanel.add(recentTransactionsLabel);

        transactionArea = new JTextArea();
        transactionArea.setBounds(10, 220, 195, 70);
        transactionArea.setFont(new Font("Arial", Font.PLAIN, 13));
        transactionArea.setEditable(false);
        transactionArea.setBackground(new Color(245, 245, 245));
        transactionArea.setText(
                "1. 2024-05-15, Cash, 10000\n" +
                "2. 2024-05-16, Online, 30000\n" +
                "3. 2024-05-17, Cash, 10000"
        );
        summaryPanel.add(transactionArea);

        JLabel duePenaltyLabel = new JLabel("Due Date and Penalty");
        duePenaltyLabel.setBounds(10, 305, 180, 25);
        duePenaltyLabel.setFont(new Font("Arial", Font.BOLD, 15));
        summaryPanel.add(duePenaltyLabel);

        dueArea = new JTextArea();
        dueArea.setBounds(10, 335, 195, 35);
        dueArea.setFont(new Font("Arial", Font.PLAIN, 13));
        dueArea.setEditable(false);
        dueArea.setBackground(new Color(245, 245, 245));
        dueArea.setText("No due date for full payment.\nNo penalty.");
        summaryPanel.add(dueArea);

        // Sample rows
        model.addRow(new Object[]{"S101", "Ravi", "CSE", "50000", "50000", "0", "Paid"});
        model.addRow(new Object[]{"S102", "Priya", "ECE", "50000", "30000", "20000", "Partial"});
        model.addRow(new Object[]{"S103", "Kiran", "IT", "50000", "0", "50000", "Unpaid"});
        model.addRow(new Object[]{"S104", "Anil", "CSE", "60000", "40000", "20000", "Partial"});
        model.addRow(new Object[]{"S105", "Sneha", "ECE", "55000", "55000", "0", "Paid"});

        feesTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = feesTable.getSelectedRow();
                if (row != -1) {
                    studentIdField.setText(model.getValueAt(row, 0).toString());
                    studentNameField.setText(model.getValueAt(row, 1).toString());
                    courseField.setText(model.getValueAt(row, 2).toString());
                    totalFeesField.setText(model.getValueAt(row, 3).toString());
                    paidFeesField.setText(model.getValueAt(row, 4).toString());
                    dueFeesField.setText(model.getValueAt(row, 5).toString());
                    statusBox.setSelectedItem(model.getValueAt(row, 6).toString());
                }
            }
        });

        totalFeesField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                calculateDueFees();
            }
        });

        paidFeesField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                calculateDueFees();
            }
        });

        setVisible(true);
    }

    public JButton createButton(String text, int x, int y, Color bgColor) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 120, 40);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.addActionListener(this);
        return button;
    }

    public void calculateDueFees() {
        try {
            int total = Integer.parseInt(totalFeesField.getText().trim());
            int paid = Integer.parseInt(paidFeesField.getText().trim());

            int due = total - paid;
            if (due < 0) {
                due = 0;
            }

            dueFeesField.setText(String.valueOf(due));

            if (due == 0) {
                statusBox.setSelectedItem("Paid");
            } else if (paid == 0) {
                statusBox.setSelectedItem("Unpaid");
            } else {
                statusBox.setSelectedItem("Partial");
            }

        } catch (Exception e) {
            dueFeesField.setText("");
        }
    }

    public void clearFields() {
        studentIdField.setText("");
        studentNameField.setText("");
        courseField.setText("");
        totalFeesField.setText("");
        paidFeesField.setText("");
        dueFeesField.setText("");
        searchField.setText("");
        statusBox.setSelectedIndex(0);
        feesTable.clearSelection();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addButton) {
            String id = studentIdField.getText().trim();
            String name = studentNameField.getText().trim();
            String course = courseField.getText().trim();
            String total = totalFeesField.getText().trim();
            String paid = paidFeesField.getText().trim();

            if (id.isEmpty() || name.isEmpty() || course.isEmpty() || total.isEmpty() || paid.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields.");
                return;
            }

            calculateDueFees();
            String due = dueFeesField.getText();
            String status = statusBox.getSelectedItem().toString();

            model.addRow(new Object[]{id, name, course, total, paid, due, status});
            JOptionPane.showMessageDialog(this, "Fee record added successfully.");
            clearFields();
        }

        else if (e.getSource() == updateButton) {
            int row = feesTable.getSelectedRow();

            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Please select a row to update.");
                return;
            }

            calculateDueFees();

            model.setValueAt(studentIdField.getText().trim(), row, 0);
            model.setValueAt(studentNameField.getText().trim(), row, 1);
            model.setValueAt(courseField.getText().trim(), row, 2);
            model.setValueAt(totalFeesField.getText().trim(), row, 3);
            model.setValueAt(paidFeesField.getText().trim(), row, 4);
            model.setValueAt(dueFeesField.getText().trim(), row, 5);
            model.setValueAt(statusBox.getSelectedItem().toString(), row, 6);

            JOptionPane.showMessageDialog(this, "Fee record updated successfully.");
            clearFields();
        }

        else if (e.getSource() == deleteButton) {
            int row = feesTable.getSelectedRow();

            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Please select a row to delete.");
                return;
            }

            model.removeRow(row);
            JOptionPane.showMessageDialog(this, "Fee record deleted successfully.");
            clearFields();
        }

        else if (e.getSource() == clearButton) {
            clearFields();
        }

        else if (e.getSource() == searchButton) {
            String searchText = searchField.getText().trim().toLowerCase();
            boolean found = false;

            for (int i = 0; i < model.getRowCount(); i++) {
                String name = model.getValueAt(i, 1).toString().toLowerCase();

                if (name.contains(searchText)) {
                    feesTable.setRowSelectionInterval(i, i);
                    studentIdField.setText(model.getValueAt(i, 0).toString());
                    studentNameField.setText(model.getValueAt(i, 1).toString());
                    courseField.setText(model.getValueAt(i, 2).toString());
                    totalFeesField.setText(model.getValueAt(i, 3).toString());
                    paidFeesField.setText(model.getValueAt(i, 4).toString());
                    dueFeesField.setText(model.getValueAt(i, 5).toString());
                    statusBox.setSelectedItem(model.getValueAt(i, 6).toString());
                    found = true;
                    break;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(this, "Student not found.");
            }
        }

        else if (e.getSource() == backButton) {
            JOptionPane.showMessageDialog(this, "Back button clicked");
            // new Dashboard();
            // dispose();
        }
    }

    public static void main(String[] args) {
        new FeesPage();
    }
}