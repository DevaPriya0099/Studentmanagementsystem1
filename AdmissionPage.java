package Studentmanagementsystem1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;

public class AdmissionPage extends JFrame implements ActionListener {

    JLabel titleLabel, idLabel, nameLabel, dateLabel, statusLabel, searchLabel;
    JTextField idField, nameField, dateField, searchField;
    JComboBox<String> statusBox;
    JButton addButton, updateButton, deleteButton, clearButton, searchButton, backButton;
    JTable admissionTable;
    DefaultTableModel model;

    public AdmissionPage() {
        setTitle("Student Management System - Admission");
        setSize(980, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 980, 600);
        panel.setBackground(new Color(245, 240, 255));
        add(panel);

        titleLabel = new JLabel("Admission Details");
        titleLabel.setBounds(25, 20, 280, 35);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(new Color(88, 44, 131));
        panel.add(titleLabel);

        idLabel = new JLabel("Admission ID:");
        idLabel.setBounds(30, 85, 100, 20);
        idLabel.setFont(new Font("Arial", Font.BOLD, 12));
        panel.add(idLabel);

        idField = new JTextField();
        idField.setBounds(140, 82, 180, 24);
        panel.add(idField);

        nameLabel = new JLabel("Student Name:");
        nameLabel.setBounds(350, 85, 100, 20);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 12));
        panel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(460, 82, 180, 24);
        panel.add(nameField);

        dateLabel = new JLabel("Admission Date:");
        dateLabel.setBounds(30, 125, 105, 20);
        dateLabel.setFont(new Font("Arial", Font.BOLD, 12));
        panel.add(dateLabel);

        dateField = new JTextField();
        dateField.setBounds(140, 122, 180, 24);
        panel.add(dateField);

        statusLabel = new JLabel("Status:");
        statusLabel.setBounds(350, 125, 60, 20);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 12));
        panel.add(statusLabel);

        statusBox = new JComboBox<>(new String[]{"Pending", "Approved", "Rejected"});
        statusBox.setBounds(460, 122, 180, 24);
        panel.add(statusBox);

        addButton = new JButton("Add");
        addButton.setBounds(85, 180, 110, 34);
        styleButton(addButton, new Color(155, 89, 182));
        panel.add(addButton);

        updateButton = new JButton("Update");
        updateButton.setBounds(215, 180, 110, 34);
        styleButton(updateButton, new Color(39, 174, 96));
        panel.add(updateButton);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(345, 180, 110, 34);
        styleButton(deleteButton, new Color(192, 57, 43));
        panel.add(deleteButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(475, 180, 110, 34);
        styleButton(clearButton, new Color(243, 156, 18));
        panel.add(clearButton);

        searchLabel = new JLabel("Search:");
        searchLabel.setBounds(30, 245, 60, 20);
        searchLabel.setFont(new Font("Arial", Font.BOLD, 12));
        panel.add(searchLabel);

        searchField = new JTextField();
        searchField.setBounds(90, 242, 240, 26);
        panel.add(searchField);

        searchButton = new JButton("Search");
        searchButton.setBounds(350, 240, 100, 30);
        styleButton(searchButton, new Color(72, 61, 139));
        panel.add(searchButton);

        backButton = new JButton("Back");
        backButton.setBounds(490, 240, 110, 30);
        styleButton(backButton, new Color(52, 58, 64));
        panel.add(backButton);

        // Schedule Panel 1
        JPanel schedulePanel1 = new JPanel();
        schedulePanel1.setLayout(null);
        schedulePanel1.setBounds(730, 20, 220, 120);
        schedulePanel1.setBackground(Color.WHITE);
        schedulePanel1.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180)));
        panel.add(schedulePanel1);

        JLabel scheduleTitle1 = new JLabel("<html><center>Counseling Schedule - EECT<br>(Electronics & Electronics)</center></html>");
        scheduleTitle1.setBounds(10, 5, 200, 30);
        scheduleTitle1.setFont(new Font("Arial", Font.BOLD, 12));
        scheduleTitle1.setHorizontalAlignment(SwingConstants.CENTER);
        schedulePanel1.add(scheduleTitle1);

        JLabel upcoming1 = new JLabel("Upcoming Counseling Dates");
        upcoming1.setBounds(25, 35, 170, 18);
        upcoming1.setFont(new Font("Arial", Font.BOLD, 12));
        schedulePanel1.add(upcoming1);

        JTextArea scheduleArea1 = new JTextArea();
        scheduleArea1.setEditable(false);
        scheduleArea1.setFont(new Font("Monospaced", Font.PLAIN, 9));
        scheduleArea1.setText(
                "Date       Start    End      Stream   Round\n" +
                "2026-04-15 09:00 AM 12:00 PM EMECT   [Round 1]\n" +
                "2026-04-16 10:00 AM 01:00 PM EMECT   [Round 2]\n" +
                "2026-04-17 09:00 AM 12:30 PM EMECT   [Round 3]"
        );
        scheduleArea1.setBounds(8, 55, 204, 58);
        scheduleArea1.setBackground(Color.WHITE);
        schedulePanel1.add(scheduleArea1);

        // Schedule Panel 2
        JPanel schedulePanel2 = new JPanel();
        schedulePanel2.setLayout(null);
        schedulePanel2.setBounds(730, 150, 220, 120);
        schedulePanel2.setBackground(Color.WHITE);
        schedulePanel2.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180)));
        panel.add(schedulePanel2);

        JLabel scheduleTitle2 = new JLabel("<html><center>Counseling Schedule - EECT (Electronics)</center></html>");
        scheduleTitle2.setBounds(10, 5, 200, 20);
        scheduleTitle2.setFont(new Font("Arial", Font.BOLD, 12));
        scheduleTitle2.setHorizontalAlignment(SwingConstants.CENTER);
        schedulePanel2.add(scheduleTitle2);

        JLabel upcoming2 = new JLabel("Upcoming Counseling Dates");
        upcoming2.setBounds(25, 28, 170, 18);
        upcoming2.setFont(new Font("Arial", Font.BOLD, 12));
        schedulePanel2.add(upcoming2);

        JTextArea scheduleArea2 = new JTextArea();
        scheduleArea2.setEditable(false);
        scheduleArea2.setFont(new Font("Monospaced", Font.PLAIN, 9));
        scheduleArea2.setText(
                "Date       Start    End      Stream   Round\n" +
                "2026-04-18 09:30 AM 12:30 PM EECT    [Round 1]\n" +
                "2026-04-19 10:30 AM 01:30 PM EECT    [Round 2]\n" +
                "2026-04-20 09:30 AM 12:30 PM EECT    [All Ranks]"
        );
        scheduleArea2.setBounds(8, 48, 204, 62);
        scheduleArea2.setBackground(Color.WHITE);
        schedulePanel2.add(scheduleArea2);

        String[] columns = {"Admission ID", "Student Name", "Course", "Admission Date", "Status"};
        String[][] data = {
                {"AD101", "Anil Kumar", "B.Tech CSE", "2026-03-20", "Approved"},
                {"AD102", "Priya Sharma", "B.Tech ECE", "2026-03-21", "Pending"},
                {"AD103", "Rahul Reddy", "B.Tech IT", "2026-03-22", "Approved"},
                {"AD104", "Sneha Rao", "MBA", "2026-03-23", "Rejected"},
                {"AD105", "Kiran Kumar", "BBA", "2026-03-24", "Pending"},
                {"AD106", "Meera Sharma", "B.Tech ECE", "2026-03-28", "Pending"},
                {"AD107", "Ravi Patel", "B.Tech IT", "2026-03-30", "Pending"}
        };

        model = new DefaultTableModel(data, columns);
        admissionTable = new JTable(model);
        admissionTable.setRowHeight(27);
        admissionTable.setFont(new Font("Arial", Font.PLAIN, 12));
        admissionTable.setGridColor(new Color(200, 190, 220));
        admissionTable.setSelectionBackground(new Color(220, 200, 255));
        admissionTable.setSelectionForeground(Color.BLACK);

        JTableHeader header = admissionTable.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 12));
        header.setBackground(new Color(235, 228, 248));
        header.setForeground(Color.BLACK);

        JScrollPane scrollPane = new JScrollPane(admissionTable);
        scrollPane.setBounds(20, 295, 930, 240);
        panel.add(scrollPane);

        admissionTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = admissionTable.getSelectedRow();
                if (row != -1) {
                    idField.setText(model.getValueAt(row, 0).toString());
                    nameField.setText(model.getValueAt(row, 1).toString());
                    dateField.setText(model.getValueAt(row, 3).toString());
                    statusBox.setSelectedItem(model.getValueAt(row, 4).toString());
                }
            }
        });

        setVisible(true);
    }

    private void styleButton(JButton button, Color color) {
        button.setFont(new Font("Arial", Font.BOLD, 13));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.addActionListener(this);
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        dateField.setText("");
        searchField.setText("");
        statusBox.setSelectedIndex(0);
        admissionTable.clearSelection();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String id = idField.getText().trim();
            String name = nameField.getText().trim();
            String date = dateField.getText().trim();
            String status = statusBox.getSelectedItem().toString();

            if (id.isEmpty() || name.isEmpty() || date.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields.");
            } else {
                model.addRow(new Object[]{id, name, "B.Tech CSE", date, status});
                JOptionPane.showMessageDialog(this, "Admission added successfully.");
                clearFields();
            }

        } else if (e.getSource() == updateButton) {
            int row = admissionTable.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Please select a row to update.");
            } else {
                model.setValueAt(idField.getText().trim(), row, 0);
                model.setValueAt(nameField.getText().trim(), row, 1);
                model.setValueAt(dateField.getText().trim(), row, 3);
                model.setValueAt(statusBox.getSelectedItem().toString(), row, 4);
                JOptionPane.showMessageDialog(this, "Admission updated successfully.");
                clearFields();
            }

        } else if (e.getSource() == deleteButton) {
            int row = admissionTable.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Please select a row to delete.");
            } else {
                model.removeRow(row);
                JOptionPane.showMessageDialog(this, "Admission deleted successfully.");
                clearFields();
            }

        } else if (e.getSource() == clearButton) {
            clearFields();

        } else if (e.getSource() == searchButton) {
            String search = searchField.getText().trim().toLowerCase();
            boolean found = false;

            for (int i = 0; i < model.getRowCount(); i++) {
                String rowText = "";
                for (int j = 0; j < model.getColumnCount(); j++) {
                    rowText += model.getValueAt(i, j).toString().toLowerCase() + " ";
                }

                if (rowText.contains(search)) {
                    admissionTable.setRowSelectionInterval(i, i);
                    admissionTable.scrollRectToVisible(admissionTable.getCellRect(i, 0, true));
                    found = true;
                    break;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(this, "No matching admission found.");
            }

        } else if (e.getSource() == backButton) {
            new Dashboard();
            dispose();
        }
    }

    public static void main(String[] args) {
        new AdmissionPage();
    }
}