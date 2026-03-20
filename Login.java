package Studentmanagementsystem1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    JLabel titleLabel, emailLabel, passwordLabel;
    JTextField emailField;
    JPasswordField passwordField;
    JButton loginButton, registerButton, cancelButton;

    public Login() {
        setTitle("Student Management System - Login");
        setSize(420, 320);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 420, 320);
        panel.setBackground(new Color(34, 40, 49));
        add(panel);

        titleLabel = new JLabel("Login");
        titleLabel.setBounds(30, 20, 150, 35);
        titleLabel.setForeground(new Color(0, 173, 181));
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        panel.add(titleLabel);

        JLabel heading = new JLabel("Student Management System");
        heading.setBounds(30, 60, 300, 25);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Arial", Font.PLAIN, 18));
        panel.add(heading);

        emailLabel = new JLabel("Email");
        emailLabel.setBounds(40, 110, 100, 30);
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(140, 110, 220, 30);
        panel.add(emailField);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(40, 160, 100, 30);
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(140, 160, 220, 30);
        panel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(50, 225, 90, 35);
        loginButton.addActionListener(this);
        panel.add(loginButton);

        registerButton = new JButton("Register");
        registerButton.setBounds(160, 225, 90, 35);
        registerButton.addActionListener(this);
        panel.add(registerButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(270, 225, 90, 35);
        cancelButton.addActionListener(this);
        panel.add(cancelButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String email = emailField.getText().trim();
            String password = String.valueOf(passwordField.getPassword());

            if (UserData.validateUser(email, password)) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                new Dashboard();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Email or Password");
            }
        }

        if (e.getSource() == registerButton) {
            new Register();
            dispose();
        }

        if (e.getSource() == cancelButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}