package Studentmanagementsystem1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;

public class AssignmentsPage extends JFrame implements ActionListener {

    JLabel titleLabel, idLabel, subjectLabel, statusLabel, dueDateLabel, descriptionLabel, attachmentLabel, priorityLabel, searchLabel;
    JTextField idField, subjectField, dueDateField, searchField;
    JTextArea descriptionArea;
    JComboBox<String> statusBox, priorityBox;
    JButton browseButton, addButton, updateButton, deleteButton, clearButton, viewButton, backButton, searchButton;
    JTable assignmentTable;
    DefaultTableModel model;
    String attachmentPath = "";

    public AssignmentsPage() {
        setTitle("Student Management System - Assignments");
        setSize(920, 540);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 920, 540);
        panel.setBackground(new Color(245, 240, 255));
        add(panel);

        titleLabel = new JLabel("Assignments Details");
        titleLabel.setBounds(20, 15, 260, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(new Color(88, 44, 131));
        panel.add(titleLabel);

        idLabel = new JLabel("Assignment ID:");
        idLabel.setBounds(20, 65, 100, 20);
        idLabel.setFont(new Font("Arial", Font.BOLD, 11));
        idLabel.setForeground(new Color(60, 40, 90));
        panel.add(idLabel);

        idField = new JTextField();
        idField.setBounds(120, 62, 95, 22);
        idField.setBackground(Color.WHITE);
        panel.add(idField);

        subjectLabel = new JLabel("Subject:");
        subjectLabel.setBounds(290, 42, 60, 20);
        subjectLabel.setFont(new Font("Arial", Font.BOLD, 11));
        subjectLabel.setForeground(new Color(60, 40, 90));
        panel.add(subjectLabel);

        subjectField = new JTextField();
        subjectField.setBounds(350, 39, 95, 22);
        subjectField.setBackground(Color.WHITE);
        panel.add(subjectField);

        statusLabel = new JLabel("Status:");
        statusLabel.setBounds(470, 42, 50, 20);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 11));
        statusLabel.setForeground(new Color(60, 40, 90));
        panel.add(statusLabel);

        statusBox = new JComboBox<>(new String[]{
                "Draft",
                "Pending Faculty Review",
                "Approved",
                "Resubmission Required",
                "Submitted"
        });
        statusBox.setBounds(525, 39, 150, 22);
        statusBox.setBackground(Color.WHITE);
        panel.add(statusBox);

        dueDateLabel = new JLabel("Due Date:");
        dueDateLabel.setBounds(20, 92, 100, 20);
        dueDateLabel.setFont(new Font("Arial", Font.BOLD, 11));
        dueDateLabel.setForeground(new Color(60, 40, 90));
        panel.add(dueDateLabel);

        dueDateField = new JTextField();
        dueDateField.setBounds(120, 89, 95, 22);
        dueDateField.setBackground(Color.WHITE);
        panel.add(dueDateField);

        descriptionLabel = new JLabel("Description:");
        descriptionLabel.setBounds(290, 69, 75, 20);
        descriptionLabel.setFont(new Font("Arial", Font.BOLD, 11));
        descriptionLabel.setForeground(new Color(60, 40, 90));
        panel.add(descriptionLabel);

        descriptionArea = new JTextArea();
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setBackground(Color.WHITE);
        JScrollPane descScroll = new JScrollPane(descriptionArea);
        descScroll.setBounds(350, 66, 150, 52);
        panel.add(descScroll);

        attachmentLabel = new JLabel("Attachment:");
        attachmentLabel.setBounds(290, 124, 75, 20);
        attachmentLabel.setFont(new Font("Arial", Font.BOLD, 11));
        attachmentLabel.setForeground(new Color(60, 40, 90));
        panel.add(attachmentLabel);

        browseButton = new JButton("Browse...");
        browseButton.setBounds(350, 122, 85, 22);
        styleButton(browseButton, new Color(230, 230, 250), new Color(55, 55, 55));
        panel.add(browseButton);

        priorityLabel = new JLabel("Priority:");
        priorityLabel.setBounds(470, 124, 50, 20);
        priorityLabel.setFont(new Font("Arial", Font.BOLD, 11));
        priorityLabel.setForeground(new Color(60, 40, 90));
        panel.add(priorityLabel);

        priorityBox = new JComboBox<>(new String[]{"High", "Medium", "Low"});
        priorityBox.setBounds(525, 122, 150, 22);
        priorityBox.setBackground(Color.WHITE);
        panel.add(priorityBox);

        addButton = new JButton("Add");
        addButton.setBounds(90, 165, 80, 28);
        styleButton(addButton, new Color(142, 68, 173), Color.WHITE);
        panel.add(addButton);

        updateButton = new JButton("Update");
        updateButton.setBounds(185, 165, 80, 28);
        styleButton(updateButton, new Color(39, 174, 96), Color.WHITE);
        panel.add(updateButton);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(280, 165, 80, 28);
        styleButton(deleteButton, new Color(192, 57, 43), Color.WHITE);
        panel.add(deleteButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(375, 165, 80, 28);
        styleButton(clearButton, new Color(243, 156, 18), Color.WHITE);
        panel.add(clearButton);

        viewButton = new JButton("View");
        viewButton.setBounds(470, 165, 80, 28);
        styleButton(viewButton, new Color(155, 89, 182), Color.WHITE);
        panel.add(viewButton);

        backButton = new JButton("Back");
        backButton.setBounds(565, 165, 80, 28);
        styleButton(backButton, new Color(52, 58, 64), Color.WHITE);
        panel.add(backButton);

        searchLabel = new JLabel("Search:");
        searchLabel.setBounds(20, 212, 50, 20);
        searchLabel.setFont(new Font("Arial", Font.BOLD, 11));
        searchLabel.setForeground(new Color(60, 40, 90));
        panel.add(searchLabel);

        searchField = new JTextField();
        searchField.setBounds(70, 209, 170, 22);
        searchField.setBackground(Color.WHITE);
        panel.add(searchField);

        searchButton = new JButton("Search");
        searchButton.setBounds(250, 207, 80, 26);
        styleButton(searchButton, new Color(72, 61, 139), Color.WHITE);
        panel.add(searchButton);

        String[] columns = {"Assignment ID", "Subject", "Title", "Due Date", "Faculty", "Status"};
        String[][] data = {
                {"A101", "AI", "Machine Learning Basics", "25-03-2026", "Dr. Ramesh", "Pending"},
                {"A102", "CN", "Network Topologies Record", "30-03-2026", "Mrs. Kavya", "Draft"},
                {"A103", "Java", "Mini Project", "05-04-2026", "Mr. Suresh", "Submitted"},
                {"A104", "DBMS", "Normalization Task", "10-04-2026", "Dr. Meena", "Approved"},
                {"A105", "OS", "Process Scheduling Report", "12-04-2026", "Mr. Arjun", "Resubmission Required"},
                {"A106", "Cloud Computing", "AWS Architecture Paper", "18-04-2026", "Dr. Meena", "Submitted"},
                {"A107", "Cybersecurity", "Vulnerability Scan Report", "22-04-2026", "Mr. Suresh", "Draft"},
                {"A108", "Web Development", "Full-Stack App Deploy...", "28-04-2026", "Dr. Ramesh", "Pending Faculty Review"},
                {"A109", "Big Data Analytics", "Hadoop Hive Query...", "02-05-2026", "Mrs. Kavya", "Pending"},
                {"A110", "Ethics in AI", "Bias Mitigation Essay", "05-05-2026", "Dr. Arjun", "Approved"},
                {"A111", "Advanced Java", "Multi-threading Lab...", "10-05-2026", "Dr. Meena", "Resubmission Required"}
        };

        model = new DefaultTableModel(data, columns);
        assignmentTable = new JTable(model);
        assignmentTable.setRowHeight(19);
        assignmentTable.setFont(new Font("Arial", Font.PLAIN, 11));
        assignmentTable.setGridColor(new Color(190, 180, 210));
        assignmentTable.setSelectionBackground(new Color(215, 190, 255));
        assignmentTable.setSelectionForeground(Color.BLACK);

        JTableHeader header = assignmentTable.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 11));
        header.setBackground(new Color(230, 220, 250));
        header.setForeground(new Color(75, 0, 130));

        JScrollPane tableScroll = new JScrollPane(assignmentTable);
        tableScroll.setBounds(20, 245, 870, 230);
        panel.add(tableScroll);

        assignmentTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = assignmentTable.getSelectedRow();
                if (row != -1) {
                    idField.setText(model.getValueAt(row, 0).toString());
                    subjectField.setText(model.getValueAt(row, 1).toString());
                    descriptionArea.setText(model.getValueAt(row, 2).toString());
                    dueDateField.setText(model.getValueAt(row, 3).toString());
                    statusBox.setSelectedItem(model.getValueAt(row, 5).toString());
                }
            }
        });

        setVisible(true);
    }

    private void styleButton(JButton button, Color bgColor, Color fgColor) {
        button.setFont(new Font("Arial", Font.BOLD, 11));
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setFocusPainted(false);
        button.addActionListener(this);
    }

    private void clearFields() {
        idField.setText("");
        subjectField.setText("");
        dueDateField.setText("");
        descriptionArea.setText("");
        searchField.setText("");
        attachmentPath = "";
        statusBox.setSelectedIndex(0);
        priorityBox.setSelectedIndex(0);
        assignmentTable.clearSelection();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == browseButton) {
            JFileChooser chooser = new JFileChooser();
            int result = chooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                attachmentPath = chooser.getSelectedFile().getAbsolutePath();
                JOptionPane.showMessageDialog(this, "Attachment Selected:\n" + attachmentPath);
            }

        } else if (e.getSource() == addButton) {
            String id = idField.getText().trim();
            String subject = subjectField.getText().trim();
            String desc = descriptionArea.getText().trim();
            String dueDate = dueDateField.getText().trim();
            String status = statusBox.getSelectedItem().toString();

            if (id.isEmpty() || subject.isEmpty() || desc.isEmpty() || dueDate.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all required fields.");
            } else {
                model.addRow(new Object[]{id, subject, desc, dueDate, "Dr. Meena", status});
                JOptionPane.showMessageDialog(this, "Assignment added successfully.");
                clearFields();
            }

        } else if (e.getSource() == updateButton) {
            int row = assignmentTable.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Please select a row to update.");
            } else {
                model.setValueAt(idField.getText().trim(), row, 0);
                model.setValueAt(subjectField.getText().trim(), row, 1);
                model.setValueAt(descriptionArea.getText().trim(), row, 2);
                model.setValueAt(dueDateField.getText().trim(), row, 3);
                model.setValueAt(statusBox.getSelectedItem().toString(), row, 5);
                JOptionPane.showMessageDialog(this, "Assignment updated successfully.");
                clearFields();
            }

        } else if (e.getSource() == deleteButton) {
            int row = assignmentTable.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Please select a row to delete.");
            } else {
                model.removeRow(row);
                JOptionPane.showMessageDialog(this, "Assignment deleted successfully.");
                clearFields();
            }

        } else if (e.getSource() == clearButton) {
            clearFields();

        } else if (e.getSource() == viewButton) {
            int row = assignmentTable.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Please select a row to view.");
            } else {
                String details =
                        "Assignment ID: " + model.getValueAt(row, 0) + "\n" +
                        "Subject: " + model.getValueAt(row, 1) + "\n" +
                        "Title: " + model.getValueAt(row, 2) + "\n" +
                        "Due Date: " + model.getValueAt(row, 3) + "\n" +
                        "Faculty: " + model.getValueAt(row, 4) + "\n" +
                        "Status: " + model.getValueAt(row, 5) + "\n" +
                        "Priority: " + priorityBox.getSelectedItem().toString() + "\n" +
                        "Attachment: " + (attachmentPath.isEmpty() ? "No file selected" : attachmentPath);

                JOptionPane.showMessageDialog(this, details, "Assignment Details", JOptionPane.INFORMATION_MESSAGE);
            }

        } else if (e.getSource() == searchButton) {
            String searchText = searchField.getText().trim().toLowerCase();
            boolean found = false;

            for (int i = 0; i < model.getRowCount(); i++) {
                String rowData = "";
                for (int j = 0; j < model.getColumnCount(); j++) {
                    rowData += model.getValueAt(i, j).toString().toLowerCase() + " ";
                }

                if (rowData.contains(searchText)) {
                    assignmentTable.setRowSelectionInterval(i, i);
                    assignmentTable.scrollRectToVisible(assignmentTable.getCellRect(i, 0, true));
                    found = true;
                    break;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(this, "No matching assignment found.");
            }

        } else if (e.getSource() == backButton) {
            new Dashboard();
            dispose();
        }
    }

    public static void main(String[] args) {
        new AssignmentsPage();
    }
}