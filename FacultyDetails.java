package Studentmanagementsystem1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;

public class FacultyDetails extends JFrame implements ActionListener {

    JLabel titleLabel, idLabel, nameLabel, deptLabel, subjectLabel, contactLabel;
    JTextField idField, nameField, deptField, subjectField, contactField, searchField;
    JButton addButton, deleteButton, clearButton, sortButton, filterButton;
    JTable facultyTable;
    DefaultTableModel model;
    JScrollPane scrollPane;
    TableRowSorter<DefaultTableModel> sorter;

    public FacultyDetails() {
        setTitle("Faculty Details");
        setSize(1000, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Background Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(0, 0, 1000, 600);
        mainPanel.setBackground(new Color(180, 200, 220));
        add(mainPanel);

        // Title
        titleLabel = new JLabel("Faculty Details", SwingConstants.CENTER);
        titleLabel.setBounds(20, 20, 940, 50);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(90, 65, 45));
        mainPanel.add(titleLabel);

        // Left Panel
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(null);
        leftPanel.setBounds(20, 90, 310, 435);
        leftPanel.setBackground(new Color(255, 255, 255, 180));
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true));
        mainPanel.add(leftPanel);

        idLabel = new JLabel("Faculty ID");
        idLabel.setBounds(20, 20, 120, 25);
        idLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        leftPanel.add(idLabel);

        idField = new JTextField();
        idField.setBounds(20, 50, 260, 30);
        leftPanel.add(idField);

        nameLabel = new JLabel("Faculty Name");
        nameLabel.setBounds(20, 100, 140, 25);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        leftPanel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(20, 130, 260, 30);
        leftPanel.add(nameField);

        deptLabel = new JLabel("Department");
        deptLabel.setBounds(20, 180, 140, 25);
        deptLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        leftPanel.add(deptLabel);

        deptField = new JTextField();
        deptField.setBounds(20, 210, 260, 30);
        leftPanel.add(deptField);

        subjectLabel = new JLabel("Subject");
        subjectLabel.setBounds(20, 260, 140, 25);
        subjectLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        leftPanel.add(subjectLabel);

        subjectField = new JTextField();
        subjectField.setBounds(20, 290, 260, 30);
        leftPanel.add(subjectField);

        contactLabel = new JLabel("Contact");
        contactLabel.setBounds(20, 340, 140, 25);
        contactLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        leftPanel.add(contactLabel);

        contactField = new JTextField();
        contactField.setBounds(20, 370, 260, 30);
        leftPanel.add(contactField);

        addButton = new JButton("Add");
        addButton.setBounds(20, 410, 80, 30);
        addButton.setBackground(new Color(52, 120, 246));
        addButton.setForeground(Color.WHITE);
        addButton.addActionListener(this);
        leftPanel.add(addButton);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(105, 410, 90, 30);
        deleteButton.setBackground(new Color(220, 53, 69));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.addActionListener(this);
        leftPanel.add(deleteButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(200, 410, 80, 30);
        clearButton.setBackground(new Color(120, 120, 120));
        clearButton.setForeground(Color.WHITE);
        clearButton.addActionListener(this);
        leftPanel.add(clearButton);

        // Right Panel
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBounds(355, 90, 605, 435);
        rightPanel.setBackground(new Color(255, 255, 255, 180));
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true));
        mainPanel.add(rightPanel);

        searchField = new JTextField();
        searchField.setBounds(20, 15, 115, 28);
        rightPanel.add(searchField);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(140, 15, 80, 28);
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchFaculty();
            }
        });
        rightPanel.add(searchButton);

        sortButton = new JButton("Sort");
        sortButton.setBounds(465, 15, 55, 28);
        sortButton.addActionListener(this);
        rightPanel.add(sortButton);

        filterButton = new JButton("Filter");
        filterButton.setBounds(525, 15, 65, 28);
        filterButton.addActionListener(this);
        rightPanel.add(filterButton);

        // Table
        String[] columns = {"Faculty ID", "Faculty Name", "Department", "Subject", "Contact"};
        model = new DefaultTableModel(columns, 0);

        model.addRow(new Object[]{"F101", "Dr. Ramesh", "CSE", "Java", "9876543210"});
        model.addRow(new Object[]{"F102", "Ms. Anitha", "ECE", "Signals", "9876501234"});
        model.addRow(new Object[]{"F103", "Mr. Suresh", "EEE", "Machines", "9845612300"});
        model.addRow(new Object[]{"F104", "Dr. Kavita", "IT", "DBMS", "9988776655"});
        model.addRow(new Object[]{"F105", "Prof. Alex", "CSE", "AI", "9911222344"});
        model.addRow(new Object[]{"F106", "Dr. Sarah", "ECE", "Robotics", "9922334455"});
        model.addRow(new Object[]{"F107", "Mr. Ben", "ME", "Thermal Eng", "9933445566"});
        model.addRow(new Object[]{"F108", "Dr. Priya", "CHE", "Organic", "9944556677"});
        model.addRow(new Object[]{"F109", "Prof. Lee", "CIVIL", "Structural", "9955667788"});
        model.addRow(new Object[]{"F110", "Dr. Fatima", "BIOTECH", "Genetics", "9966778899"});
        model.addRow(new Object[]{"F111", "Mr. David", "CSE", "Networks", "9977889900"});

        facultyTable = new JTable(model);
        facultyTable.setRowHeight(25);
        facultyTable.setFont(new Font("Arial", Font.PLAIN, 14));
        facultyTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        sorter = new TableRowSorter<>(model);
        facultyTable.setRowSorter(sorter);

        facultyTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = facultyTable.getSelectedRow();
                if (row != -1) {
                    int modelRow = facultyTable.convertRowIndexToModel(row);
                    idField.setText(model.getValueAt(modelRow, 0).toString());
                    nameField.setText(model.getValueAt(modelRow, 1).toString());
                    deptField.setText(model.getValueAt(modelRow, 2).toString());
                    subjectField.setText(model.getValueAt(modelRow, 3).toString());
                    contactField.setText(model.getValueAt(modelRow, 4).toString());
                }
            }
        });

        scrollPane = new JScrollPane(facultyTable);
        scrollPane.setBounds(20, 55, 570, 360);
        rightPanel.add(scrollPane);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            addFaculty();
        } else if (e.getSource() == deleteButton) {
            deleteFaculty();
        } else if (e.getSource() == clearButton) {
            clearFields();
        } else if (e.getSource() == sortButton) {
            sorter.toggleSortOrder(0); // Sort by Faculty ID
        } else if (e.getSource() == filterButton) {
            filterFaculty();
        }
    }

    private void addFaculty() {
        String id = idField.getText().trim();
        String name = nameField.getText().trim();
        String dept = deptField.getText().trim();
        String subject = subjectField.getText().trim();
        String contact = contactField.getText().trim();

        if (id.isEmpty() || name.isEmpty() || dept.isEmpty() || subject.isEmpty() || contact.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.");
            return;
        }

        model.addRow(new Object[]{id, name, dept, subject, contact});
        clearFields();
        JOptionPane.showMessageDialog(this, "Faculty added successfully.");
    }

    private void deleteFaculty() {
        int row = facultyTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.");
            return;
        }

        int modelRow = facultyTable.convertRowIndexToModel(row);
        model.removeRow(modelRow);
        clearFields();
        JOptionPane.showMessageDialog(this, "Faculty deleted successfully.");
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        deptField.setText("");
        subjectField.setText("");
        contactField.setText("");
        searchField.setText("");
        sorter.setRowFilter(null);
    }

    private void searchFaculty() {
        String text = searchField.getText().trim();
        if (text.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
    }

    private void filterFaculty() {
        String dept = JOptionPane.showInputDialog(this, "Enter Department to filter:");
        if (dept != null && !dept.trim().isEmpty()) {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + dept, 2));
        }
    }

    public static void main(String[] args) {
        new FacultyDetails();
    }
}