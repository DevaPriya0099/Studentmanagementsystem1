package Studentmanagementsystem1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class ExamsPage extends JFrame implements ActionListener {

    JLabel titleLabel;
    JTable examsTable;
    DefaultTableModel model;
    JButton backButton, viewButton, updateButton, downloadButton;

    public ExamsPage() {
        setTitle("Student Management System - Exams");
        setSize(680, 430);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 680, 430);
        panel.setBackground(new Color(240, 240, 255)); // light purple bg
        add(panel);

        titleLabel = new JLabel("Exams Details");
        titleLabel.setBounds(20, 15, 250, 35);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(new Color(75, 0, 130)); // deep purple
        panel.add(titleLabel);

        String[] columns = {
                "Exam ID", "Subject", "Exam Type", "Date",
                "Time", "Room", "Batch", "Total Students"
        };

        String[][] data = {
                {"E101", "DBMS", "Mid Exam", "25-03-2026", "10:00 AM", "Room 201", "Batch 2024", "120"},
                {"E102", "Java", "Lab Exam", "28-03-2026", "02:00 PM", "Lab 3", "Batch 2024", "115"},
                {"E103", "Operating Systems", "Semester Exam", "02-04-2026", "09:30 AM", "Room 105", "Batch 2024", "122"},
                {"E104", "Computer Networks", "Unit Test", "05-04-2026", "11:00 AM", "Room 210", "Batch 2024", "118"},
                {"E105", "AI", "Internal Exam", "08-04-2026", "01:00 PM", "Room 115", "Batch 2024", "105"},
                {"E106", "Cloud Computing", "Semester Exam", "12-04-2026", "09:30 AM", "Hall A", "Batch 2023", "210"},
                {"E107", "Data Science (ML Models)", "Final Project Viva", "15-04-2026", "10:30 AM", "Lab 7", "Batch 2023", "85"},
                {"E108", "Cybersecurity Fundamentals", "Lab Exam", "19-04-2026", "11:00 AM", "Lab 1", "Batch 2025", "130"},
                {"E109", "Blockchain Technology", "Seminar", "22-04-2026", "02:30 PM", "Auditorium", "Batch 2023", "250"},
                {"E110", "Ethics in AI", "Open Book Test", "26-04-2026", "01:30 PM", "Hall B", "Batch 2024", "100"}
        };

        model = new DefaultTableModel(data, columns);
        examsTable = new JTable(model);

        examsTable.setRowHeight(24);
        examsTable.setFont(new Font("Arial", Font.PLAIN, 12));
        examsTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));

        // Table colors
        examsTable.setGridColor(new Color(180, 180, 200));
        examsTable.setSelectionBackground(new Color(200, 180, 255));
        examsTable.setSelectionForeground(Color.BLACK);

        // Header colors
        JTableHeader header = examsTable.getTableHeader();
        header.setBackground(new Color(220, 210, 255));
        header.setForeground(new Color(75, 0, 130));
        header.setFont(new Font("Arial", Font.BOLD, 13));

        JScrollPane scrollPane = new JScrollPane(examsTable);
        scrollPane.setBounds(20, 60, 630, 245);
        panel.add(scrollPane);

        // Buttons with new colors
        viewButton = new JButton("View Details");
        viewButton.setBounds(90, 330, 110, 28);
        styleButton(viewButton, new Color(142, 68, 173)); // purple
        panel.add(viewButton);

        updateButton = new JButton("Update");
        updateButton.setBounds(225, 330, 100, 28);
        styleButton(updateButton, new Color(39, 174, 96)); // green
        panel.add(updateButton);

        backButton = new JButton("Back");
        backButton.setBounds(350, 330, 90, 28);
        styleButton(backButton, new Color(52, 58, 64)); // dark gray
        panel.add(backButton);

        downloadButton = new JButton("Download Schedule");
        downloadButton.setBounds(465, 330, 130, 28);
        styleButton(downloadButton, new Color(243, 156, 18)); // orange
        panel.add(downloadButton);

        setVisible(true);
    }

    private void styleButton(JButton button, Color color) {
        button.setFont(new Font("Arial", Font.BOLD, 13));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewButton) {
            int row = examsTable.getSelectedRow();

            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Please select an exam row first.");
            } else {
                String details =
                        "Exam ID: " + model.getValueAt(row, 0) + "\n" +
                        "Subject: " + model.getValueAt(row, 1) + "\n" +
                        "Exam Type: " + model.getValueAt(row, 2) + "\n" +
                        "Date: " + model.getValueAt(row, 3) + "\n" +
                        "Time: " + model.getValueAt(row, 4) + "\n" +
                        "Room: " + model.getValueAt(row, 5) + "\n" +
                        "Batch: " + model.getValueAt(row, 6) + "\n" +
                        "Total Students: " + model.getValueAt(row, 7);

                JOptionPane.showMessageDialog(this, details, "Exam Details", JOptionPane.INFORMATION_MESSAGE);
            }

        } else if (e.getSource() == updateButton) {
            int row = examsTable.getSelectedRow();

            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Please select a row to update.");
            } else {
                String examType = JOptionPane.showInputDialog(this, "Enter new Exam Type:", model.getValueAt(row, 2));
                String date = JOptionPane.showInputDialog(this, "Enter new Date:", model.getValueAt(row, 3));
                String time = JOptionPane.showInputDialog(this, "Enter new Time:", model.getValueAt(row, 4));
                String room = JOptionPane.showInputDialog(this, "Enter new Room:", model.getValueAt(row, 5));

                if (examType != null && date != null && time != null && room != null) {
                    model.setValueAt(examType, row, 2);
                    model.setValueAt(date, row, 3);
                    model.setValueAt(time, row, 4);
                    model.setValueAt(room, row, 5);
                    JOptionPane.showMessageDialog(this, "Exam details updated successfully.");
                }
            }

        } else if (e.getSource() == downloadButton) {
            try {
                FileWriter writer = new FileWriter("ExamSchedule.txt");
                writer.write("EXAM SCHEDULE\n\n");

                for (int i = 0; i < model.getRowCount(); i++) {
                    writer.write(
                            model.getValueAt(i, 0) + " | " +
                            model.getValueAt(i, 1) + " | " +
                            model.getValueAt(i, 2) + " | " +
                            model.getValueAt(i, 3) + " | " +
                            model.getValueAt(i, 4) + " | " +
                            model.getValueAt(i, 5) + " | " +
                            model.getValueAt(i, 6) + " | " +
                            model.getValueAt(i, 7) + "\n"
                    );
                }

                writer.close();
                JOptionPane.showMessageDialog(this, "Exam schedule downloaded successfully.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error while saving file.");
            }

        } else if (e.getSource() == backButton) {
            new Dashboard();
            dispose();
        }
    }

    public static void main(String[] args) {
        new ExamsPage();
    }
}