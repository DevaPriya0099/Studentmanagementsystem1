package Studentmanagementsystem1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CoursesDetails extends JFrame implements ActionListener {

    JButton backButton;
    JPanel contentPanel;

    public CoursesDetails() {
        setTitle("Student Management System - Courses Details");
        setSize(1000, 700);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(245, 247, 250));
        setResizable(false);

        JLabel titleLabel = new JLabel("Courses Details");
        titleLabel.setBounds(25, 20, 300, 35);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(new Color(35, 45, 60));
        add(titleLabel);

        contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setBackground(new Color(245, 247, 250));

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBounds(20, 70, 940, 540);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane);

        int y = 10;

        contentPanel.add(createCourseCard(
                y, "C101", "Introduction to Programming", "CSE", "4 Credits", "Dr. Ramesh", "Sem 1",
                new Color(74, 144, 226),
                "Course Code: C101\nCourse Name: Introduction to Programming\nDepartment: CSE\nCredits: 4\nFaculty: Dr. Ramesh\nSemester: Sem 1\nDescription: Basics of programming using C and Java."
        ));
        y += 75;

        contentPanel.add(createCourseCard(
                y, "C102", "Database Systems", "IT", "3 Credits", "Mr. Arun", "Sem 2",
                new Color(76, 175, 80),
                "Course Code: C102\nCourse Name: Database Systems\nDepartment: IT\nCredits: 3\nFaculty: Mr. Arun\nSemester: Sem 2\nDescription: Covers SQL, normalization, DBMS concepts."
        ));
        y += 75;

        contentPanel.add(createCourseCard(
                y, "C103", "Digital Electronics", "ECE", "4 Credits", "Mrs. Kavya", "Sem 3",
                new Color(205, 133, 63),
                "Course Code: C103\nCourse Name: Digital Electronics\nDepartment: ECE\nCredits: 4\nFaculty: Mrs. Kavya\nSemester: Sem 3\nDescription: Logic gates, flip-flops, digital circuits."
        ));
        y += 75;

        contentPanel.add(createCourseCard(
                y, "C104", "Cloud Computing", "IT", "3 Credits", "Dr. Patel", "Sem 1",
                new Color(76, 175, 80),
                "Course Code: C104\nCourse Name: Cloud Computing\nDepartment: IT\nCredits: 3\nFaculty: Dr. Patel\nSemester: Sem 1\nDescription: Introduction to cloud platforms and services."
        ));
        y += 75;

        contentPanel.add(createCourseCard(
                y, "C105", "Data Structures", "CSE", "4 Credits", "Prof. Sharma", "Sem 2",
                new Color(74, 144, 226),
                "Course Code: C105\nCourse Name: Data Structures\nDepartment: CSE\nCredits: 4\nFaculty: Prof. Sharma\nSemester: Sem 2\nDescription: Arrays, linked lists, stacks, queues, trees."
        ));
        y += 75;

        contentPanel.add(createCourseCard(
                y, "C106", "Microprocessors", "ECE", "3 Credits", "Mrs. Meena", "Sem 4",
                new Color(205, 133, 63),
                "Course Code: C106\nCourse Name: Microprocessors\nDepartment: ECE\nCredits: 3\nFaculty: Mrs. Meena\nSemester: Sem 4\nDescription: 8086 architecture, assembly basics, interfacing."
        ));
        y += 75;

        contentPanel.add(createCourseCard(
                y, "C107", "Ethics in Tech", "General", "2 Credits", "Mrs. Lata", "Sem 1",
                new Color(158, 158, 158),
                "Course Code: C107\nCourse Name: Ethics in Tech\nDepartment: General\nCredits: 2\nFaculty: Mrs. Lata\nSemester: Sem 1\nDescription: Professional ethics and values in technology."
        ));
        y += 75;

        contentPanel.add(createCourseCard(
                y, "C108", "Operating Systems", "CSE", "4 Credits", "Dr. Suresh", "Sem 3",
                new Color(74, 144, 226),
                "Course Code: C108\nCourse Name: Operating Systems\nDepartment: CSE\nCredits: 4\nFaculty: Dr. Suresh\nSemester: Sem 3\nDescription: Process management, memory, scheduling, file systems."
        ));
        y += 75;

        contentPanel.add(createCourseCard(
                y, "C109", "Computer Networks", "CSE", "3 Credits", "Mr. Naresh", "Sem 4",
                new Color(74, 144, 226),
                "Course Code: C109\nCourse Name: Computer Networks\nDepartment: CSE\nCredits: 3\nFaculty: Mr. Naresh\nSemester: Sem 4\nDescription: OSI model, TCP/IP, routing, switching."
        ));
        y += 75;

        contentPanel.add(createCourseCard(
                y, "C110", "Software Engineering", "IT", "3 Credits", "Mrs. Divya", "Sem 5",
                new Color(76, 175, 80),
                "Course Code: C110\nCourse Name: Software Engineering\nDepartment: IT\nCredits: 3\nFaculty: Mrs. Divya\nSemester: Sem 5\nDescription: SDLC, models, testing, maintenance."
        ));
        y += 75;

        contentPanel.add(createCourseCard(
                y, "C111", "Machine Learning", "CSE", "4 Credits", "Dr. Anil", "Sem 6",
                new Color(74, 144, 226),
                "Course Code: C111\nCourse Name: Machine Learning\nDepartment: CSE\nCredits: 4\nFaculty: Dr. Anil\nSemester: Sem 6\nDescription: Regression, classification, clustering basics."
        ));
        y += 75;

        contentPanel.add(createCourseCard(
                y, "C112", "VLSI Design", "ECE", "4 Credits", "Prof. Rekha", "Sem 5",
                new Color(205, 133, 63),
                "Course Code: C112\nCourse Name: VLSI Design\nDepartment: ECE\nCredits: 4\nFaculty: Prof. Rekha\nSemester: Sem 5\nDescription: CMOS design and VLSI fundamentals."
        ));
        y += 75;

        contentPanel.add(createCourseCard(
                y, "C113", "Cyber Security", "IT", "3 Credits", "Mr. Kiran", "Sem 6",
                new Color(76, 175, 80),
                "Course Code: C113\nCourse Name: Cyber Security\nDepartment: IT\nCredits: 3\nFaculty: Mr. Kiran\nSemester: Sem 6\nDescription: Threats, attacks, security principles and tools."
        ));
        y += 75;

        contentPanel.add(createCourseCard(
                y, "C114", "Artificial Intelligence", "CSE", "4 Credits", "Dr. Madhavi", "Sem 7",
                new Color(74, 144, 226),
                "Course Code: C114\nCourse Name: Artificial Intelligence\nDepartment: CSE\nCredits: 4\nFaculty: Dr. Madhavi\nSemester: Sem 7\nDescription: AI basics, search, reasoning, intelligent systems."
        ));
        y += 75;

        contentPanel.add(createCourseCard(
                y, "C115", "Embedded Systems", "ECE", "3 Credits", "Mrs. Anusha", "Sem 6",
                new Color(205, 133, 63),
                "Course Code: C115\nCourse Name: Embedded Systems\nDepartment: ECE\nCredits: 3\nFaculty: Mrs. Anusha\nSemester: Sem 6\nDescription: Embedded hardware, software and controllers."
        ));
        y += 75;

        contentPanel.add(createCourseCard(
                y, "C116", "Web Technologies", "IT", "3 Credits", "Mr. Sai Kumar", "Sem 4",
                new Color(76, 175, 80),
                "Course Code: C116\nCourse Name: Web Technologies\nDepartment: IT\nCredits: 3\nFaculty: Mr. Sai Kumar\nSemester: Sem 4\nDescription: HTML, CSS, JavaScript, backend basics."
        ));
        y += 75;

        contentPanel.add(createCourseCard(
                y, "C117", "Compiler Design", "CSE", "4 Credits", "Dr. Harish", "Sem 5",
                new Color(74, 144, 226),
                "Course Code: C117\nCourse Name: Compiler Design\nDepartment: CSE\nCredits: 4\nFaculty: Dr. Harish\nSemester: Sem 5\nDescription: Lexical analysis, parsing, code generation."
        ));
        y += 75;

        contentPanel.add(createCourseCard(
                y, "C118", "Signal Processing", "ECE", "4 Credits", "Mrs. Pooja", "Sem 7",
                new Color(205, 133, 63),
                "Course Code: C118\nCourse Name: Signal Processing\nDepartment: ECE\nCredits: 4\nFaculty: Mrs. Pooja\nSemester: Sem 7\nDescription: Signal analysis, transforms and DSP basics."
        ));

        contentPanel.setPreferredSize(new Dimension(920, y + 90));

        backButton = new JButton("Back");
        backButton.setBounds(430, 620, 120, 35);
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setBackground(new Color(70, 130, 180));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createEmptyBorder());
        backButton.addActionListener(this);
        add(backButton);

        setVisible(true);
    }

    private JPanel createCourseCard(int y, String code, String courseName, String dept, String credits,
                                    String faculty, String semester, Color accentColor, String details) {

        JPanel card = new JPanel();
        card.setLayout(null);
        card.setBounds(5, y, 900, 62);
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(new Color(225, 228, 232), 1));
        card.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JPanel accentBar = new JPanel();
        accentBar.setBounds(0, 0, 6, 62);
        accentBar.setBackground(accentColor);
        card.add(accentBar);

        JLabel codeLabel = new JLabel(code);
        codeLabel.setBounds(20, 18, 60, 25);
        codeLabel.setFont(new Font("Arial", Font.BOLD, 22));
        codeLabel.setForeground(new Color(50, 50, 50));
        card.add(codeLabel);

        JLabel nameLabel = new JLabel("<html>" + courseName + "</html>");
        nameLabel.setBounds(85, 10, 230, 40);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        nameLabel.setForeground(new Color(45, 45, 45));
        card.add(nameLabel);

        JLabel deptBadge = createBadge(" " + dept + " ", getDeptColor(dept));
        deptBadge.setBounds(360, 17, 70, 26);
        card.add(deptBadge);

        JLabel creditsBadge = createBadge(" " + credits + " ", new Color(214, 204, 176));
        creditsBadge.setBounds(500, 17, 85, 26);
        card.add(creditsBadge);

        JLabel avatar = new JLabel("👨‍🏫", SwingConstants.CENTER);
        avatar.setBounds(620, 10, 38, 38);
        avatar.setFont(new Font("SansSerif", Font.PLAIN, 24));
        card.add(avatar);

        JLabel facultyLabel = new JLabel(faculty);
        facultyLabel.setBounds(665, 18, 120, 25);
        facultyLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        facultyLabel.setForeground(new Color(60, 60, 60));
        card.add(facultyLabel);

        JLabel semBadge = createBadge(" " + semester + " ", new Color(220, 214, 190));
        semBadge.setBounds(810, 17, 70, 26);
        card.add(semBadge);

        MouseAdapter openDetails = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(
                        CoursesDetails.this,
                        details,
                        code + " - Course Details",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        };

        card.addMouseListener(openDetails);
        codeLabel.addMouseListener(openDetails);
        nameLabel.addMouseListener(openDetails);
        deptBadge.addMouseListener(openDetails);
        creditsBadge.addMouseListener(openDetails);
        facultyLabel.addMouseListener(openDetails);
        semBadge.addMouseListener(openDetails);
        avatar.addMouseListener(openDetails);

        return card;
    }

    private JLabel createBadge(String text, Color bgColor) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setOpaque(true);
        label.setBackground(bgColor);
        label.setForeground(new Color(70, 70, 70));
        label.setFont(new Font("Arial", Font.BOLD, 12));
        label.setBorder(BorderFactory.createLineBorder(new Color(210, 210, 210), 1));
        return label;
    }

    private Color getDeptColor(String dept) {
        if (dept.equalsIgnoreCase("CSE")) {
            return new Color(205, 220, 245);
        } else if (dept.equalsIgnoreCase("IT")) {
            return new Color(204, 232, 207);
        } else if (dept.equalsIgnoreCase("ECE")) {
            return new Color(220, 214, 245);
        } else {
            return new Color(230, 230, 230);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            new Dashboard();
            dispose();
        }
    }

    public static void main(String[] args) {
        new CoursesDetails();
    }
}