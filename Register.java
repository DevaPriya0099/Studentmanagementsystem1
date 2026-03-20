package Studentmanagementsystem1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Register extends JFrame implements ActionListener {

    JTextField nameField, emailField;
    JPasswordField passwordField, confirmPasswordField;
    JButton registerButton, backButton;
    JPanel panel;

    public Register() {
        setTitle("Register - Student Management System");
        setSize(460, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        getContentPane().setBackground(new Color(244, 246, 248));

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(30, 30, 380, 390);
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createLineBorder(new Color(206, 212, 218), 1));
        add(panel);

        JLabel title = new JLabel("Register");
        title.setBounds(110, 25, 180, 40);
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setForeground(new Color(90, 70, 52));
        panel.add(title);

        JLabel subtitle = new JLabel("Create your account");
        subtitle.setBounds(110, 60, 180, 25);
        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitle.setForeground(new Color(108, 117, 125));
        panel.add(subtitle);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(40, 105, 120, 25);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        nameLabel.setForeground(new Color(51, 51, 51));
        panel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(40, 130, 300, 35);
        nameField.setFont(new Font("Arial", Font.PLAIN, 14));
        nameField.setBackground(new Color(241, 243, 245));
        nameField.setBorder(BorderFactory.createLineBorder(new Color(206, 212, 218), 1));
        panel.add(nameField);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(40, 175, 120, 25);
        emailLabel.setFont(new Font("Arial", Font.BOLD, 14));
        emailLabel.setForeground(new Color(51, 51, 51));
        panel.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(40, 200, 300, 35);
        emailField.setFont(new Font("Arial", Font.PLAIN, 14));
        emailField.setBackground(new Color(241, 243, 245));
        emailField.setBorder(BorderFactory.createLineBorder(new Color(206, 212, 218), 1));
        panel.add(emailField);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(40, 245, 120, 25);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        passwordLabel.setForeground(new Color(51, 51, 51));
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(40, 270, 300, 35);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField.setBackground(new Color(241, 243, 245));
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(206, 212, 218), 1));
        panel.add(passwordField);

        JLabel confirmLabel = new JLabel("Confirm Password");
        confirmLabel.setBounds(40, 315, 150, 25);
        confirmLabel.setFont(new Font("Arial", Font.BOLD, 14));
        confirmLabel.setForeground(new Color(51, 51, 51));
        panel.add(confirmLabel);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(40, 340, 300, 35);
        confirmPasswordField.setFont(new Font("Arial", Font.PLAIN, 14));
        confirmPasswordField.setBackground(new Color(241, 243, 245));
        confirmPasswordField.setBorder(BorderFactory.createLineBorder(new Color(206, 212, 218), 1));
        panel.add(confirmPasswordField);

        registerButton = new JButton("Register");
        registerButton.setBounds(55, 435, 140, 35);
        registerButton.setFont(new Font("Arial", Font.BOLD, 15));
        registerButton.setBackground(new Color(138, 121, 103));
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusPainted(false);
        registerButton.setBorder(BorderFactory.createEmptyBorder());
        registerButton.addActionListener(this);
        add(registerButton);

        backButton = new JButton("Back");
        backButton.setBounds(245, 435, 140, 35);
        backButton.setFont(new Font("Arial", Font.BOLD, 15));
        backButton.setBackground(new Color(73, 80, 87));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createEmptyBorder());
        backButton.addActionListener(this);
        add(backButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == registerButton) {
            String name = nameField.getText().trim();
            String email = emailField.getText().trim();
            String password = String.valueOf(passwordField.getPassword());
            String confirm = String.valueOf(confirmPasswordField.getPassword());

            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirm.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Fill all fields");
            } else if (!password.equals(confirm)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match");
            } else if (UserData.userExists(email)) {
                JOptionPane.showMessageDialog(this, "Email already registered");
            } else {
                UserData.addUser(email, password);
                JOptionPane.showMessageDialog(this, "Registered Successfully");
                new Login();
                dispose();
            }
        }

        if (e.getSource() == backButton) {
            new Login();
            dispose();
        }
    }

    public static void main(String[] args) {
        new Register();
    }
}