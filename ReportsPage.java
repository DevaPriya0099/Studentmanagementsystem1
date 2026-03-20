package Studentmanagementsystem1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ReportsPage extends JFrame implements ActionListener {

    JButton backButton;

    public ReportsPage() {
        setTitle("Student Management System - Reports");
        setSize(900, 560);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(245, 247, 250));
        setResizable(false);

        JLabel titleLabel = new JLabel("Reports");
        titleLabel.setBounds(30, 20, 200, 40);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(new Color(29, 53, 61));
        add(titleLabel);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(20, 80, 840, 360);
        mainPanel.setBackground(new Color(248, 249, 251));
        mainPanel.setBorder(BorderFactory.createLineBorder(new Color(220, 224, 230), 1));
        add(mainPanel);

        JPanel studentCard = createInfoCard(
                20, 20, 250, 135,
                new Color(66, 133, 244),
                "👥",
                "TOTAL STUDENTS",
                "4,520",
                "+2% from last month",
                new Color(34, 139, 34)
        );
        mainPanel.add(studentCard);

        JPanel facultyCard = createInfoCard(
                290, 20, 250, 135,
                new Color(76, 175, 80),
                "👤",
                "ACTIVE FACULTY",
                "315",
                "-1 new hires in progress",
                new Color(180, 50, 50)
        );
        mainPanel.add(facultyCard);

        JPanel coursesCard = createInfoCard(
                20, 175, 250, 135,
                new Color(0, 150, 136),
                "🎓",
                "COURSES OFFERED",
                "188",
                "+5 new courses added",
                new Color(34, 139, 34)
        );
        mainPanel.add(coursesCard);

        JPanel enrollmentCard = createInfoCard(
                290, 175, 250, 135,
                new Color(255, 152, 0),
                "◔",
                "ENROLLMENT RATE",
                "94%",
                "(High Enrollment)",
                new Color(60, 60, 60)
        );
        mainPanel.add(enrollmentCard);

        JPanel chartCard = new JPanel();
        chartCard.setLayout(null);
        chartCard.setBounds(560, 20, 250, 290);
        chartCard.setBackground(Color.WHITE);
        chartCard.setBorder(BorderFactory.createLineBorder(new Color(220, 224, 230), 1));
        mainPanel.add(chartCard);

        JLabel chartTitle = new JLabel("APPLICATION STATUS");
        chartTitle.setBounds(15, 15, 200, 25);
        chartTitle.setFont(new Font("Arial", Font.BOLD, 20));
        chartTitle.setForeground(new Color(40, 40, 40));
        chartCard.add(chartTitle);

        DonutChartPanel donutChart = new DonutChartPanel();
        donutChart.setBounds(35, 45, 180, 150);
        chartCard.add(donutChart);

        JLabel pendingColor = new JLabel();
        pendingColor.setBounds(35, 210, 14, 14);
        pendingColor.setOpaque(true);
        pendingColor.setBackground(new Color(244, 67, 54));
        chartCard.add(pendingColor);

        JLabel pendingLabel = new JLabel("Pending");
        pendingLabel.setBounds(55, 206, 90, 20);
        pendingLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        chartCard.add(pendingLabel);

        JLabel pendingValue = new JLabel("120");
        pendingValue.setBounds(170, 206, 50, 20);
        pendingValue.setFont(new Font("Arial", Font.PLAIN, 18));
        chartCard.add(pendingValue);

        JLabel acceptedColor = new JLabel();
        acceptedColor.setBounds(35, 235, 14, 14);
        acceptedColor.setOpaque(true);
        acceptedColor.setBackground(new Color(33, 150, 243));
        chartCard.add(acceptedColor);

        JLabel acceptedLabel = new JLabel("Accepted");
        acceptedLabel.setBounds(55, 231, 100, 20);
        acceptedLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        chartCard.add(acceptedLabel);

        JLabel acceptedValue = new JLabel("3800");
        acceptedValue.setBounds(170, 231, 60, 20);
        acceptedValue.setFont(new Font("Arial", Font.PLAIN, 18));
        chartCard.add(acceptedValue);

        JLabel rejectedColor = new JLabel();
        rejectedColor.setBounds(35, 260, 14, 14);
        rejectedColor.setOpaque(true);
        rejectedColor.setBackground(new Color(158, 158, 158));
        chartCard.add(rejectedColor);

        JLabel rejectedLabel = new JLabel("Rejected");
        rejectedLabel.setBounds(55, 256, 100, 20);
        rejectedLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        chartCard.add(rejectedLabel);

        JLabel rejectedValue = new JLabel("250");
        rejectedValue.setBounds(170, 256, 50, 20);
        rejectedValue.setFont(new Font("Arial", Font.PLAIN, 18));
        chartCard.add(rejectedValue);

        backButton = new JButton("Back  ↩");
        backButton.setBounds(380, 455, 120, 40);
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setBackground(new Color(76, 138, 196));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createEmptyBorder());
        backButton.addActionListener(this);
        add(backButton);

        setVisible(true);
    }

    private JPanel createInfoCard(int x, int y, int w, int h, Color iconColor, String iconText,
                                  String heading, String value, String footer, Color footerColor) {
        JPanel card = new JPanel();
        card.setLayout(null);
        card.setBounds(x, y, w, h);
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(new Color(220, 224, 230), 1));

        JPanel iconBox = new JPanel();
        iconBox.setLayout(null);
        iconBox.setBounds(15, 20, 42, 42);
        iconBox.setBackground(iconColor);
        card.add(iconBox);

        JLabel iconLabel = new JLabel(iconText, SwingConstants.CENTER);
        iconLabel.setBounds(0, 0, 42, 42);
        iconLabel.setFont(new Font("SansSerif", Font.PLAIN, 22));
        iconLabel.setForeground(Color.WHITE);
        iconBox.add(iconLabel);

        JLabel headingLabel = new JLabel(heading);
        headingLabel.setBounds(70, 15, 170, 22);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 14));
        headingLabel.setForeground(new Color(50, 50, 50));
        card.add(headingLabel);

        JLabel valueLabel = new JLabel(value);
        valueLabel.setBounds(70, 42, 140, 35);
        valueLabel.setFont(new Font("Arial", Font.BOLD, 26));
        valueLabel.setForeground(new Color(20, 20, 20));
        card.add(valueLabel);

        JLabel footerLabel = new JLabel(footer);
        footerLabel.setBounds(20, 95, 210, 22);
        footerLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        footerLabel.setForeground(footerColor);
        card.add(footerLabel);

        return card;
    }

    class DonutChartPanel extends JPanel {
        public DonutChartPanel() {
            setOpaque(false);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int pending = 120;
            int accepted = 3800;
            int rejected = 250;
            int total = pending + accepted + rejected;

            int start = 90;
            int size = 120;
            int x = 30;
            int y = 10;

            int acceptedAngle = (int) Math.round((accepted * 360.0) / total);
            int rejectedAngle = (int) Math.round((rejected * 360.0) / total);
            int pendingAngle = 360 - acceptedAngle - rejectedAngle;

            g2.setColor(new Color(33, 150, 243));
            g2.fillArc(x, y, size, size, start, -acceptedAngle);

            g2.setColor(new Color(158, 158, 158));
            g2.fillArc(x, y, size, size, start - acceptedAngle, -rejectedAngle);

            g2.setColor(new Color(244, 67, 54));
            g2.fillArc(x, y, size, size, start - acceptedAngle - rejectedAngle, -pendingAngle);

            g2.setColor(Color.WHITE);
            g2.fillOval(x + 25, y + 25, 70, 70);

            g2.setColor(new Color(70, 70, 70));
            g2.setFont(new Font("Arial", Font.PLAIN, 16));
            FontMetrics fm = g2.getFontMetrics();
            String text = "Applications";
            int textWidth = fm.stringWidth(text);
            g2.drawString(text, x + (size / 2) - (textWidth / 2), y + 65);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            new Dashboard();
            dispose();
        }
    }

    public static void main(String[] args) {
        new ReportsPage();
    }
}