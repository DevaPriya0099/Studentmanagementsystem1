package Studentmanagementsystem1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;

public class StudentCRUD extends JFrame implements ActionListener {

    JLabel titleLabel, idLabel, nameLabel, deptLabel, yearLabel, emailLabel, phoneLabel, searchLabel;
    JTextField idField, nameField, deptField, yearField, emailField, phoneField, searchField;
    JButton addButton, updateButton, deleteButton, searchButton, clearButton, backButton;
    JTable table;
    DefaultTableModel model;

    Color bgColor = new Color(240, 244, 248);
    Color panelColor = new Color(255, 255, 255);
    Color titleColor = new Color(26, 54, 93);
    Color labelColor = new Color(52, 73, 94);
    Color fieldBorderColor = new Color(180, 190, 200);

    Color addColor = new Color(46, 204, 113);
    Color updateColor = new Color(52, 152, 219);
    Color deleteColor = new Color(231, 76, 60);
    Color clearColor = new Color(241, 196, 15);
    Color backColor = new Color(108, 117, 125);
    Color searchColor = new Color(155, 89, 182);

    public StudentCRUD() {
        setTitle("Student Management System - Student Details");
        setSize(1100, 700);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 1100, 700);
        panel.setBackground(bgColor);
        add(panel);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBounds(30, 20, 1020, 610);
        formPanel.setBackground(panelColor);
        formPanel.setBorder(BorderFactory.createLineBorder(new Color(210, 220, 230), 2));
        panel.add(formPanel);

        titleLabel = new JLabel("Student Details");
        titleLabel.setBounds(30, 20, 300, 40);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(titleColor);
        formPanel.add(titleLabel);

        idLabel = new JLabel("Student ID");
        idLabel.setBounds(30, 90, 100, 25);
        styleLabel(idLabel);
        formPanel.add(idLabel);

        idField = new JTextField();
        idField.setBounds(150, 90, 200, 34);
        styleTextField(idField);
        formPanel.add(idField);

        nameLabel = new JLabel("Name");
        nameLabel.setBounds(390, 90, 100, 25);
        styleLabel(nameLabel);
        formPanel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(500, 90, 200, 34);
        styleTextField(nameField);
        formPanel.add(nameField);

        deptLabel = new JLabel("Department");
        deptLabel.setBounds(740, 90, 100, 25);
        styleLabel(deptLabel);
        formPanel.add(deptLabel);

        deptField = new JTextField();
        deptField.setBounds(850, 90, 140, 34);
        styleTextField(deptField);
        formPanel.add(deptField);

        yearLabel = new JLabel("Year");
        yearLabel.setBounds(30, 145, 100, 25);
        styleLabel(yearLabel);
        formPanel.add(yearLabel);

        yearField = new JTextField();
        yearField.setBounds(150, 145, 200, 34);
        styleTextField(yearField);
        formPanel.add(yearField);

        emailLabel = new JLabel("Email");
        emailLabel.setBounds(390, 145, 100, 25);
        styleLabel(emailLabel);
        formPanel.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(500, 145, 200, 34);
        styleTextField(emailField);
        formPanel.add(emailField);

        phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(740, 145, 100, 25);
        styleLabel(phoneLabel);
        formPanel.add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(850, 145, 140, 34);
        styleTextField(phoneField);
        formPanel.add(phoneField);

        addButton = createButton("Add", 90, 210, addColor);
        updateButton = createButton("Update", 230, 210, updateColor);
        deleteButton = createButton("Delete", 370, 210, deleteColor);
        clearButton = createButton("Clear", 510, 210, clearColor);
        backButton = createButton("Back", 650, 210, backColor);

        formPanel.add(addButton);
        formPanel.add(updateButton);
        formPanel.add(deleteButton);
        formPanel.add(clearButton);
        formPanel.add(backButton);

        searchLabel = new JLabel("Search by ID");
        searchLabel.setBounds(30, 275, 110, 25);
        styleLabel(searchLabel);
        formPanel.add(searchLabel);

        searchField = new JTextField();
        searchField.setBounds(150, 272, 200, 34);
        styleTextField(searchField);
        formPanel.add(searchField);

        searchButton = createButton("Search", 390, 272, searchColor);
        formPanel.add(searchButton);

        String[] columns = {"Student ID", "Name", "Department", "Year", "Email", "Phone"};
        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);
        table.setRowHeight(30);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setSelectionBackground(new Color(214, 234, 248));
        table.setSelectionForeground(Color.BLACK);
        table.setGridColor(new Color(220, 220, 220));
        table.setShowGrid(true);

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 15));
        header.setBackground(new Color(26, 54, 93));
        header.setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 340, 960, 230);
        scrollPane.getViewport().setBackground(Color.WHITE);
        formPanel.add(scrollPane);

        // Sample Data
        model.addRow(new Object[]{"S101", "Ravi", "CSE", "2nd Year", "ravi@gmail.com", "9876543210"});
        model.addRow(new Object[]{"S102", "Priya", "ECE", "3rd Year", "priya@gmail.com", "9123456780"});
        model.addRow(new Object[]{"S103", "Kiran", "IT", "1st Year", "kiran@gmail.com", "9012345678"});

        sortTableByStudentId();

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                idField.setText(model.getValueAt(row, 0).toString());
                nameField.setText(model.getValueAt(row, 1).toString());
                deptField.setText(model.getValueAt(row, 2).toString());
                yearField.setText(model.getValueAt(row, 3).toString());
                emailField.setText(model.getValueAt(row, 4).toString());
                phoneField.setText(model.getValueAt(row, 5).toString());
            }
        });

        setVisible(true);
    }

    private void styleLabel(JLabel label) {
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setForeground(labelColor);
    }

    private void styleTextField(JTextField textField) {
        textField.setFont(new Font("Arial", Font.PLAIN, 15));
        textField.setBackground(Color.WHITE);
        textField.setBorder(BorderFactory.createLineBorder(fieldBorderColor, 1));
    }

    private JButton createButton(String text, int x, int y, Color color) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 120, 40);
        button.setFont(new Font("Arial", Font.BOLD, 15));
        button.setFocusPainted(false);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.addActionListener(this);
        return button;
    }

    private int extractNumber(String studentId) {
        String numberPart = studentId.replaceAll("[^0-9]", "");
        if (numberPart.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(numberPart);
    }

    private boolean isDuplicateStudentId(String id) {
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 0).toString().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    private void sortTableByStudentId() {
        for (int i = 0; i < model.getRowCount() - 1; i++) {
            for (int j = 0; j < model.getRowCount() - i - 1; j++) {
                String id1 = model.getValueAt(j, 0).toString();
                String id2 = model.getValueAt(j + 1, 0).toString();

                if (extractNumber(id1) > extractNumber(id2)) {
                    for (int col = 0; col < model.getColumnCount(); col++) {
                        Object temp = model.getValueAt(j, col);
                        model.setValueAt(model.getValueAt(j + 1, col), j, col);
                        model.setValueAt(temp, j + 1, col);
                    }
                }
            }
        }
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addButton) {
            String id = idField.getText().trim();
            String name = nameField.getText().trim();
            String dept = deptField.getText().trim();
            String year = yearField.getText().trim();
            String email = emailField.getText().trim();
            String phone = phoneField.getText().trim();

            if (id.isEmpty() || name.isEmpty() || dept.isEmpty() || year.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields");
            } else if (isDuplicateStudentId(id)) {
                JOptionPane.showMessageDialog(this, "Student ID already exists");
            } else {
                model.addRow(new Object[]{id, name, dept, year, email, phone});
                sortTableByStudentId();   // ఇదే main line
                JOptionPane.showMessageDialog(this, "Student added successfully");
                clearFields();
            }
        }

        if (e.getSource() == updateButton) {
            int row = table.getSelectedRow();

            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Please select a row to update");
            } else {
                String newId = idField.getText().trim();

                for (int i = 0; i < model.getRowCount(); i++) {
                    if (i != row && model.getValueAt(i, 0).toString().equalsIgnoreCase(newId)) {
                        JOptionPane.showMessageDialog(this, "Student ID already exists");
                        return;
                    }
                }

                model.setValueAt(idField.getText().trim(), row, 0);
                model.setValueAt(nameField.getText().trim(), row, 1);
                model.setValueAt(deptField.getText().trim(), row, 2);
                model.setValueAt(yearField.getText().trim(), row, 3);
                model.setValueAt(emailField.getText().trim(), row, 4);
                model.setValueAt(phoneField.getText().trim(), row, 5);

                sortTableByStudentId();
                JOptionPane.showMessageDialog(this, "Student updated successfully");
                clearFields();
            }
        }

        if (e.getSource() == deleteButton) {
            int row = table.getSelectedRow();

            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Please select a row to delete");
            } else {
                model.removeRow(row);
                JOptionPane.showMessageDialog(this, "Student deleted successfully");
                clearFields();
            }
        }

        if (e.getSource() == searchButton) {
            String searchId = searchField.getText().trim();
            boolean found = false;

            for (int i = 0; i < model.getRowCount(); i++) {
                if (model.getValueAt(i, 0).toString().equalsIgnoreCase(searchId)) {
                    table.setRowSelectionInterval(i, i);
                    idField.setText(model.getValueAt(i, 0).toString());
                    nameField.setText(model.getValueAt(i, 1).toString());
                    deptField.setText(model.getValueAt(i, 2).toString());
                    yearField.setText(model.getValueAt(i, 3).toString());
                    emailField.setText(model.getValueAt(i, 4).toString());
                    phoneField.setText(model.getValueAt(i, 5).toString());
                    found = true;
                    break;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(this, "Student ID not found");
            }
        }

        if (e.getSource() == clearButton) {
            clearFields();
        }

        if (e.getSource() == backButton) {
            new Dashboard();
            dispose();
        }
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        deptField.setText("");
        yearField.setText("");
        emailField.setText("");
        phoneField.setText("");
        searchField.setText("");
        table.clearSelection();
    }

    public static void main(String[] args) {
        new StudentCRUD();
    }
}