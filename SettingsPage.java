package Studentmanagementsystem1;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class SettingsPage extends JFrame implements ActionListener {

    JLabel titleLabel, notificationLabel, darkModeLabel, languageLabel;
    JToggleButton notificationToggle, darkModeToggle;
    JComboBox<String> languageBox;
    JButton saveButton, backButton;
    JPanel mainPanel, cardPanel;

    public SettingsPage() {
        setTitle("Student Management System - Settings");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        // Main Panel
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(0, 0, 900, 500);
        mainPanel.setBackground(new Color(30, 45, 60));
        add(mainPanel);

        // Title
        titleLabel = new JLabel("Settings");
        titleLabel.setBounds(25, 20, 250, 50);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 42));
        titleLabel.setForeground(Color.WHITE);
        mainPanel.add(titleLabel);

        // Card Panel
        cardPanel = new JPanel();
        cardPanel.setLayout(null);
        cardPanel.setBounds(20, 100, 840, 320);
        cardPanel.setBackground(new Color(45, 50, 60));
        cardPanel.setBorder(new LineBorder(new Color(90, 100, 120), 2, true));
        mainPanel.add(cardPanel);

        // Notifications
        notificationLabel = new JLabel("Enable Notifications:");
        notificationLabel.setBounds(50, 40, 220, 30);
        notificationLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        notificationLabel.setForeground(Color.WHITE);
        cardPanel.add(notificationLabel);

        notificationToggle = new JToggleButton("ON");
        notificationToggle.setBounds(300, 40, 80, 35);
        styleToggle(notificationToggle);
        notificationToggle.setSelected(true);
        updateToggle(notificationToggle);
        notificationToggle.addActionListener(e -> updateToggle(notificationToggle));
        cardPanel.add(notificationToggle);

        // Dark Mode
        darkModeLabel = new JLabel("Enable Dark Mode:");
        darkModeLabel.setBounds(50, 110, 220, 30);
        darkModeLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        darkModeLabel.setForeground(Color.WHITE);
        cardPanel.add(darkModeLabel);

        darkModeToggle = new JToggleButton("ON");
        darkModeToggle.setBounds(300, 110, 80, 35);
        styleToggle(darkModeToggle);
        darkModeToggle.setSelected(true);
        updateToggle(darkModeToggle);
        darkModeToggle.addActionListener(e -> {
            updateToggle(darkModeToggle);
            applyTheme();
        });
        cardPanel.add(darkModeToggle);

        // Language
        languageLabel = new JLabel("Language:");
        languageLabel.setBounds(50, 180, 220, 30);
        languageLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        languageLabel.setForeground(Color.WHITE);
        cardPanel.add(languageLabel);

        String[] languages = {"English", "Telugu", "Hindi"};
        languageBox = new JComboBox<>(languages);
        languageBox.setBounds(300, 180, 220, 40);
        languageBox.setFont(new Font("Arial", Font.PLAIN, 18));
        languageBox.setBackground(new Color(70, 80, 95));
        languageBox.setForeground(Color.WHITE);
        languageBox.setFocusable(false);
        cardPanel.add(languageBox);

        // Save Button
        saveButton = new JButton("Save");
        saveButton.setBounds(250, 250, 150, 45);
        styleButton(saveButton);
        saveButton.addActionListener(this);
        cardPanel.add(saveButton);

        // Back Button
        backButton = new JButton("Back");
        backButton.setBounds(450, 250, 150, 45);
        styleButton(backButton);
        backButton.addActionListener(this);
        cardPanel.add(backButton);

        setVisible(true);
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setBackground(new Color(135, 206, 250));
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        button.setBorder(new LineBorder(new Color(180, 220, 255), 1, true));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void styleToggle(JToggleButton toggle) {
        toggle.setFont(new Font("Arial", Font.BOLD, 14));
        toggle.setFocusPainted(false);
        toggle.setCursor(new Cursor(Cursor.HAND_CURSOR));
        toggle.setBorder(new LineBorder(Color.WHITE, 1, true));
    }

    private void updateToggle(JToggleButton toggle) {
        if (toggle.isSelected()) {
            toggle.setText("ON");
            toggle.setBackground(new Color(102, 220, 170));
        } else {
            toggle.setText("OFF");
            toggle.setBackground(new Color(220, 220, 220));
        }
    }

    private void applyTheme() {
        if (darkModeToggle.isSelected()) {
            mainPanel.setBackground(new Color(30, 45, 60));
            cardPanel.setBackground(new Color(45, 50, 60));

            titleLabel.setForeground(Color.WHITE);
            notificationLabel.setForeground(Color.WHITE);
            darkModeLabel.setForeground(Color.WHITE);
            languageLabel.setForeground(Color.WHITE);

            languageBox.setBackground(new Color(70, 80, 95));
            languageBox.setForeground(Color.WHITE);
        } else {
            mainPanel.setBackground(new Color(230, 240, 250));
            cardPanel.setBackground(Color.WHITE);

            titleLabel.setForeground(Color.BLACK);
            notificationLabel.setForeground(Color.BLACK);
            darkModeLabel.setForeground(Color.BLACK);
            languageLabel.setForeground(Color.BLACK);

            languageBox.setBackground(Color.WHITE);
            languageBox.setForeground(Color.BLACK);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            String notifications = notificationToggle.isSelected() ? "Enabled" : "Disabled";
            String darkMode = darkModeToggle.isSelected() ? "Enabled" : "Disabled";
            String language = languageBox.getSelectedItem().toString();

            JOptionPane.showMessageDialog(this,
                    "Settings Saved Successfully!\n\n" +
                    "Notifications: " + notifications + "\n" +
                    "Dark Mode: " + darkMode + "\n" +
                    "Language: " + language);
        }

        if (e.getSource() == backButton) {
            dispose();
        }
    }

    public static void main(String[] args) {
        new SettingsPage();
    }
}