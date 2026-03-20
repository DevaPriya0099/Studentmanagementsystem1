package Studentmanagementsystem1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LogoutPage extends JFrame implements ActionListener {

    JLabel titleLabel, messageLabel;
    JButton loginButton, exitButton;

    public LogoutPage() {
        setTitle("Student Management System - Logout");
        setSize(500, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 500, 300);
        panel.setBackground(new Color(245, 240, 255));
        add(panel);

        titleLabel = new JLabel("Logout Successful");
        titleLabel.setBounds(130, 40, 250, 35);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(new Color(88, 44, 131));
        panel.add(titleLabel);

        messageLabel = new JLabel("You have been logged out successfully.");
        messageLabel.setBounds(110, 95, 300, 25);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        messageLabel.setForeground(new Color(60, 60, 60));
        panel.add(messageLabel);

        loginButton = new JButton("Login Again");
        loginButton.setBounds(100, 170, 130, 40);
        styleButton(loginButton, new Color(52, 152, 219));
        panel.add(loginButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(260, 170, 130, 40);
        styleButton(exitButton, new Color(192, 57, 43));
        panel.add(exitButton);

        setVisible(true);
    }

    private void styleButton(JButton button, Color color) {
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            new Login();
            dispose();
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new LogoutPage();
    }
}