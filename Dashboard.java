package Studentmanagementsystem1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

    JPanel sidebarPanel, topPanel, mainPanel;
    JLabel titleLabel, welcomeLabel;

    JButton dashboardButton, admissionButton, studentsButton, facultyButton, coursesButton,
            examsButton, assignmentsButton, libraryButton, feesButton,
            reportsButton, settingsButton, logoutButton;

    JTextArea recentActivityArea, todoArea, notificationsArea, examsArea, assignmentsArea, libraryArea, admissionArea;

    JPanel enrollmentPanel, activityPanel, todoPanel, graphPanel, notificationPanel,
            examsPanel, assignmentsPanel, libraryPanel, admissionPanel;

    Color sidebarColor = new Color(24, 40, 72);
    Color sidebarButtonColor = new Color(35, 58, 99);
    Color topPanelColor = Color.WHITE;
    Color mainBgColor = new Color(242, 246, 252);
    Color textDark = new Color(33, 37, 41);
    Color textLight = Color.WHITE;

    public Dashboard() {
        setTitle("Student Management System - Dashboard");
        setSize(1100, 760);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Sidebar Panel
        sidebarPanel = new JPanel();
        sidebarPanel.setLayout(null);
        sidebarPanel.setBounds(0, 0, 220, 760);
        sidebarPanel.setBackground(sidebarColor);
        add(sidebarPanel);

        JLabel portalLabel = new JLabel("ACADEMIC PORTAL");
        portalLabel.setBounds(20, 25, 180, 30);
        portalLabel.setForeground(textLight);
        portalLabel.setFont(new Font("Arial", Font.BOLD, 20));
        sidebarPanel.add(portalLabel);

        dashboardButton = createSidebarButton("Dashboard", 90);
        admissionButton = createSidebarButton("Admission", 135);
        studentsButton = createSidebarButton("Students", 180);
        facultyButton = createSidebarButton("Faculty", 225);
        coursesButton = createSidebarButton("Courses", 270);
        examsButton = createSidebarButton("Exams", 315);
        assignmentsButton = createSidebarButton("Assignments", 360);
        libraryButton = createSidebarButton("Library", 405);
        feesButton = createSidebarButton("Fees", 450);
        reportsButton = createSidebarButton("Reports", 495);
        settingsButton = createSidebarButton("Settings", 540);
        logoutButton = createSidebarButton("Logout", 585);

        sidebarPanel.add(dashboardButton);
        sidebarPanel.add(admissionButton);
        sidebarPanel.add(studentsButton);
        sidebarPanel.add(facultyButton);
        sidebarPanel.add(coursesButton);
        sidebarPanel.add(examsButton);
        sidebarPanel.add(assignmentsButton);
        sidebarPanel.add(libraryButton);
        sidebarPanel.add(feesButton);
        sidebarPanel.add(reportsButton);
        sidebarPanel.add(settingsButton);
        sidebarPanel.add(logoutButton);

        // Top Panel
        topPanel = new JPanel();
        topPanel.setLayout(null);
        topPanel.setBounds(220, 0, 880, 80);
        topPanel.setBackground(topPanelColor);
        add(topPanel);

        titleLabel = new JLabel("Student Management System");
        titleLabel.setBounds(20, 10, 400, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(textDark);
        topPanel.add(titleLabel);

        welcomeLabel = new JLabel("Welcome, Admin");
        welcomeLabel.setBounds(20, 42, 200, 20);
        welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        welcomeLabel.setForeground(Color.GRAY);
        topPanel.add(welcomeLabel);

        JTextField searchField = new JTextField("Search");
        searchField.setBounds(650, 22, 180, 32);
        searchField.setFont(new Font("Arial", Font.PLAIN, 14));
        topPanel.add(searchField);

        // Main Panel
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(220, 80, 880, 680);
        mainPanel.setBackground(mainBgColor);
        add(mainPanel);

        JLabel overviewLabel = new JLabel("Overview");
        overviewLabel.setBounds(20, 15, 150, 30);
        overviewLabel.setFont(new Font("Arial", Font.BOLD, 22));
        overviewLabel.setForeground(textDark);
        mainPanel.add(overviewLabel);

        // Cards
        JPanel card1 = createCard(20, 60, "Total Students", "4520", new Color(52, 152, 219));
        JPanel card2 = createCard(230, 60, "Active Faculty", "315", new Color(46, 204, 113));
        JPanel card3 = createCard(440, 60, "Courses Offered", "188", new Color(241, 196, 15));
        JPanel card4 = createCard(650, 60, "Enrollment Rate", "94%", new Color(231, 76, 60));

        mainPanel.add(card1);
        mainPanel.add(card2);
        mainPanel.add(card3);
        mainPanel.add(card4);

        // Enrollment Panel
        enrollmentPanel = createBoxPanel(20, 170, 280, 180, "Current Enrollment Status");
        JLabel enrollmentText = new JLabel("<html>Undergrad: 65%<br><br>Grad: 24%<br><br>Other: 11%</html>");
        enrollmentText.setBounds(30, 50, 200, 100);
        enrollmentText.setFont(new Font("Arial", Font.PLAIN, 16));
        enrollmentPanel.add(enrollmentText);
        addOpenFeature(enrollmentPanel, "Enrollment Status",
                "Current Enrollment Details\n\nUndergrad: 65%\nGrad: 24%\nOther: 11%");
        mainPanel.add(enrollmentPanel);

        // Recent Activity Panel
        activityPanel = createBoxPanel(320, 170, 250, 180, "Recent Activity");
        recentActivityArea = new JTextArea();
        recentActivityArea.setText(
                "• Jane Doe registered for CS101\n\n" +
                "• Grade for Smith updated\n\n" +
                "• New faculty added"
        );
        recentActivityArea.setFont(new Font("Arial", Font.PLAIN, 14));
        recentActivityArea.setEditable(false);
        recentActivityArea.setBackground(Color.WHITE);
        recentActivityArea.setBounds(15, 45, 210, 110);
        activityPanel.add(recentActivityArea);
        addOpenFeature(activityPanel, "Recent Activity",
                "Recent Activity Details\n\n" +
                "1. Jane Doe registered for CS101\n" +
                "2. Grade for Smith updated\n" +
                "3. New faculty added");
        mainPanel.add(activityPanel);

        // To-Do Panel
        todoPanel = createBoxPanel(590, 170, 250, 180, "To-Do List");
        todoArea = new JTextArea();
        todoArea.setText(
                "□ Approve enrollment requests\n\n" +
                "□ Update syllabus\n\n" +
                "□ Review reports"
        );
        todoArea.setFont(new Font("Arial", Font.PLAIN, 14));
        todoArea.setEditable(false);
        todoArea.setBackground(Color.WHITE);
        todoArea.setBounds(15, 45, 210, 110);
        todoPanel.add(todoArea);
        addOpenFeature(todoPanel, "To-Do List",
                "Pending Tasks\n\n" +
                "1. Approve enrollment requests\n" +
                "2. Update syllabus\n" +
                "3. Review reports");
        mainPanel.add(todoPanel);

        // Graph Panel
        graphPanel = createBoxPanel(20, 370, 400, 180, "Student Statistics Graph");
        GraphPanel chart = new GraphPanel();
        chart.setBounds(15, 40, 360, 120);
        graphPanel.add(chart);
        addOpenFeature(graphPanel, "Student Statistics",
                "Department-wise Student Performance\n\n" +
                "CSE : 65\n" +
                "ECE : 80\n" +
                "EEE : 55\n" +
                "IT  : 90");
        mainPanel.add(graphPanel);

        // Notifications Panel
        notificationPanel = createBoxPanel(440, 370, 400, 180, "Notifications");
        notificationsArea = new JTextArea();
        notificationsArea.setText(
                "• Alerts for system updates\n\n" +
                "• Pending faculty request\n\n" +
                "• New student applications received"
        );
        notificationsArea.setFont(new Font("Arial", Font.PLAIN, 14));
        notificationsArea.setEditable(false);
        notificationsArea.setBackground(Color.WHITE);
        notificationsArea.setBounds(15, 45, 350, 110);
        notificationPanel.add(notificationsArea);
        addOpenFeature(notificationPanel, "Notifications",
                "System Notifications\n\n" +
                "1. Alerts for system updates\n" +
                "2. Pending faculty request\n" +
                "3. New student applications received");
        mainPanel.add(notificationPanel);

        // Exams Panel
        examsPanel = createBoxPanel(20, 570, 250, 90, "Upcoming Exams");
        examsArea = new JTextArea();
        examsArea.setText(
                "• DBMS - 25 Mar\n" +
                "• Java - 28 Mar"
        );
        examsArea.setFont(new Font("Arial", Font.PLAIN, 13));
        examsArea.setEditable(false);
        examsArea.setBackground(Color.WHITE);
        examsArea.setBounds(15, 35, 210, 40);
        examsPanel.add(examsArea);
        addOpenFeature(examsPanel, "Upcoming Exams",
                "Upcoming Exams Details\n\n" +
                "1. Mid Exam - DBMS - 25 Mar\n" +
                "2. Lab Exam - Java - 28 Mar\n" +
                "3. Semester Exam - OS - 02 Apr");
        mainPanel.add(examsPanel);

        // Assignments Panel
        assignmentsPanel = createBoxPanel(290, 570, 250, 90, "Pending Assignments");
        assignmentsArea = new JTextArea();
        assignmentsArea.setText(
                "• AI - Due 22 Mar\n" +
                "• CN - Due 24 Mar"
        );
        assignmentsArea.setFont(new Font("Arial", Font.PLAIN, 13));
        assignmentsArea.setEditable(false);
        assignmentsArea.setBackground(Color.WHITE);
        assignmentsArea.setBounds(15, 35, 210, 40);
        assignmentsPanel.add(assignmentsArea);
        addOpenFeature(assignmentsPanel, "Pending Assignments",
                "Assignment Details\n\n" +
                "1. AI Assignment - Due 22 Mar\n" +
                "2. CN Record - Due 24 Mar\n" +
                "3. Java Mini Project - Due 30 Mar");
        mainPanel.add(assignmentsPanel);

        // Library Panel
        libraryPanel = createBoxPanel(560, 570, 130, 90, "Library");
        libraryArea = new JTextArea();
        libraryArea.setText(
                "• 320 Books\n" +
                "• 18 Issued"
        );
        libraryArea.setFont(new Font("Arial", Font.PLAIN, 12));
        libraryArea.setEditable(false);
        libraryArea.setBackground(Color.WHITE);
        libraryArea.setBounds(10, 35, 105, 40);
        libraryPanel.add(libraryArea);
        addOpenFeature(libraryPanel, "Library Details",
                "Library Details\n\n" +
                "1. Total Books: 320\n" +
                "2. Issued Books: 18\n" +
                "3. New Arrivals: 12");
        mainPanel.add(libraryPanel);

        // Admission Panel
        admissionPanel = createBoxPanel(710, 570, 130, 90, "Admission");
        admissionArea = new JTextArea();
        admissionArea.setText(
                "• New: 46\n" +
                "• Pending: 9"
        );
        admissionArea.setFont(new Font("Arial", Font.PLAIN, 12));
        admissionArea.setEditable(false);
        admissionArea.setBackground(Color.WHITE);
        admissionArea.setBounds(10, 35, 105, 40);
        admissionPanel.add(admissionArea);
        addOpenFeature(admissionPanel, "Admission Details",
                "Admission Details\n\n" +
                "1. New Admissions: 46\n" +
                "2. Pending Applications: 9\n" +
                "3. Approved Today: 5");
        mainPanel.add(admissionPanel);

        setVisible(true);
    }

    private JButton createSidebarButton(String text, int y) {
        JButton button = new JButton(text);
        button.setBounds(20, y, 180, 38);
        button.setFont(new Font("Arial", Font.BOLD, 15));
        button.setFocusPainted(false);
        button.setBackground(sidebarButtonColor);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.addActionListener(this);
        return button;
    }

    private JPanel createCard(int x, int y, String title, String value, Color bgColor) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(x, y, 190, 90);
        panel.setBackground(bgColor);
        panel.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));

        JLabel cardTitleLabel = new JLabel(title);
        cardTitleLabel.setBounds(15, 15, 150, 20);
        cardTitleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        cardTitleLabel.setForeground(Color.WHITE);
        panel.add(cardTitleLabel);

        JLabel valueLabel = new JLabel(value);
        valueLabel.setBounds(15, 40, 120, 30);
        valueLabel.setFont(new Font("Arial", Font.BOLD, 28));
        valueLabel.setForeground(Color.WHITE);
        panel.add(valueLabel);

        return panel;
    }

    private JPanel createBoxPanel(int x, int y, int w, int h, String title) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(x, y, w, h);
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createLineBorder(new Color(210, 210, 210), 1));

        JLabel boxTitleLabel = new JLabel(title);
        boxTitleLabel.setBounds(15, 10, 250, 25);
        boxTitleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        boxTitleLabel.setForeground(textDark);
        panel.add(boxTitleLabel);

        return panel;
    }

    private void addOpenFeature(JPanel panel, String title, String message) {
        panel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JTextArea area = new JTextArea(message);
                area.setEditable(false);
                area.setFont(new Font("Arial", Font.PLAIN, 15));
                area.setLineWrap(true);
                area.setWrapStyleWord(true);

                JScrollPane scrollPane = new JScrollPane(area);
                scrollPane.setPreferredSize(new Dimension(350, 220));

                JOptionPane.showMessageDialog(
                        Dashboard.this,
                        scrollPane,
                        title,
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
    }

    class GraphPanel extends JPanel {
        int[] values = {65, 80, 55, 90};
        String[] labels = {"CSE", "ECE", "EEE", "IT"};
        Color[] barColors = {
                new Color(52, 152, 219),
                new Color(46, 204, 113),
                new Color(241, 196, 15),
                new Color(231, 76, 60)
        };

        public GraphPanel() {
            setBackground(Color.WHITE);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int width = getWidth();
            int height = getHeight();

            int padding = 40;
            int chartBottom = height - padding;
            int chartTop = 15;
            int chartHeight = chartBottom - chartTop;

            int barWidth = 45;
            int gap = 25;
            int startX = 45;

            int maxValue = 100;

            for (int i = 0; i <= 5; i++) {
                int y = chartBottom - (i * chartHeight / 5);

                g2.setColor(new Color(225, 225, 225));
                g2.drawLine(padding, y, width - 15, y);

                g2.setColor(Color.GRAY);
                g2.setFont(new Font("Arial", Font.PLAIN, 10));
                g2.drawString(String.valueOf(i * 20), 10, y + 4);
            }

            g2.setColor(Color.BLACK);
            g2.drawLine(padding, chartTop, padding, chartBottom);
            g2.drawLine(padding, chartBottom, width - 15, chartBottom);

            int x = startX;

            for (int i = 0; i < values.length; i++) {
                int barHeight = (values[i] * chartHeight) / maxValue;
                int y = chartBottom - barHeight;

                g2.setColor(barColors[i]);
                g2.fillRoundRect(x, y, barWidth, barHeight, 12, 12);

                g2.setColor(Color.BLACK);
                g2.setFont(new Font("Arial", Font.BOLD, 11));
                g2.drawString(String.valueOf(values[i]), x + 12, y - 5);

                g2.setFont(new Font("Arial", Font.PLAIN, 11));
                g2.drawString(labels[i], x + 8, chartBottom + 16);

                x += barWidth + gap;
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dashboardButton) {
            JOptionPane.showMessageDialog(this, "Dashboard opened");
        } else if (e.getSource() == admissionButton) {
            new AdmissionPage();
            dispose();
        } else if (e.getSource() == studentsButton) {
            new StudentCRUD();
            dispose();
        } else if (e.getSource() == facultyButton) {
            new FacultyDetails();
            dispose();
        } else if (e.getSource() == coursesButton) {
            new CoursesDetails();
            dispose();
        } else if (e.getSource() == examsButton) {
            new ExamsPage();
            dispose();
        } else if (e.getSource() == assignmentsButton) {
            new AssignmentsPage();
            dispose();
        } else if (e.getSource() == libraryButton) {
            new LibraryPage();
            dispose();
        } else if (e.getSource() == feesButton) {
            new FeesPage();
            dispose();
        } else if (e.getSource() == reportsButton) {
            new ReportsPage();
            dispose();
        } else if (e.getSource() == settingsButton) {
            new SettingsPage();
            dispose();
        } else if (e.getSource() == logoutButton) {
            int choice = JOptionPane.showConfirmDialog(
                    this,
                    "Do you want to logout?",
                    "Logout",
                    JOptionPane.YES_NO_OPTION
            );
            if (choice == JOptionPane.YES_OPTION) {
                new Login();
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}