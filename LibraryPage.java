package Studentmanagementsystem1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;

public class LibraryPage extends JFrame implements ActionListener {

    JLabel titleLabel, idLabel, bookNameLabel, authorLabel, genreLabel, isbnLabel,
            borrowerIdLabel, issueDateLabel, statusLabel, languageLabel,
            memberNameLabel, memberCategoryLabel, searchLabel, overviewLabel;

    JTextField idField, bookNameField, authorField, genreField, isbnField,
            borrowerIdField, issueDateField, memberNameField, memberCategoryField, searchField;

    JComboBox<String> statusBox, languageBox;

    JButton addButton, updateButton, deleteButton, clearButton, viewButton, backButton, searchButton;

    JTable libraryTable;
    DefaultTableModel model;

    public LibraryPage() {
        setTitle("Student Management System - Library");
        setSize(1000, 620);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 1000, 620);
        panel.setBackground(new Color(239, 247, 243));
        add(panel);

        titleLabel = new JLabel("Library Details");
        titleLabel.setBounds(20, 15, 260, 35);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(new Color(30, 84, 84));
        panel.add(titleLabel);

        idLabel = new JLabel("Book ID:");
        idLabel.setBounds(20, 70, 70, 20);
        idLabel.setFont(new Font("Arial", Font.BOLD, 12));
        panel.add(idLabel);

        idField = new JTextField();
        idField.setBounds(110, 66, 145, 24);
        panel.add(idField);

        authorLabel = new JLabel("Author:");
        authorLabel.setBounds(340, 70, 60, 20);
        authorLabel.setFont(new Font("Arial", Font.BOLD, 12));
        panel.add(authorLabel);

        authorField = new JTextField();
        authorField.setBounds(420, 66, 145, 24);
        panel.add(authorField);

        genreLabel = new JLabel("Genre:");
        genreLabel.setBounds(650, 70, 60, 20);
        genreLabel.setFont(new Font("Arial", Font.BOLD, 12));
        panel.add(genreLabel);

        genreField = new JTextField();
        genreField.setBounds(760, 66, 145, 24);
        panel.add(genreField);

        bookNameLabel = new JLabel("Book Name:");
        bookNameLabel.setBounds(20, 100, 85, 20);
        bookNameLabel.setFont(new Font("Arial", Font.BOLD, 12));
        panel.add(bookNameLabel);

        bookNameField = new JTextField();
        bookNameField.setBounds(110, 96, 145, 24);
        panel.add(bookNameField);

        isbnLabel = new JLabel("ISBN:");
        isbnLabel.setBounds(340, 100, 60, 20);
        isbnLabel.setFont(new Font("Arial", Font.BOLD, 12));
        panel.add(isbnLabel);

        isbnField = new JTextField();
        isbnField.setBounds(420, 96, 145, 24);
        panel.add(isbnField);

        borrowerIdLabel = new JLabel("Borrower ID:");
        borrowerIdLabel.setBounds(650, 100, 85, 20);
        borrowerIdLabel.setFont(new Font("Arial", Font.BOLD, 12));
        panel.add(borrowerIdLabel);

        borrowerIdField = new JTextField();
        borrowerIdField.setBounds(760, 96, 145, 24);
        panel.add(borrowerIdField);

        issueDateLabel = new JLabel("Issue Date:");
        issueDateLabel.setBounds(20, 130, 80, 20);
        issueDateLabel.setFont(new Font("Arial", Font.BOLD, 12));
        panel.add(issueDateLabel);

        issueDateField = new JTextField();
        issueDateField.setBounds(110, 126, 145, 24);
        panel.add(issueDateField);

        statusLabel = new JLabel("Status:");
        statusLabel.setBounds(340, 130, 60, 20);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 12));
        panel.add(statusLabel);

        statusBox = new JComboBox<>(new String[]{"Available", "Issued", "Returned"});
        statusBox.setBounds(420, 126, 145, 24);
        panel.add(statusBox);

        languageLabel = new JLabel("Language:");
        languageLabel.setBounds(650, 130, 80, 20);
        languageLabel.setFont(new Font("Arial", Font.BOLD, 12));
        panel.add(languageLabel);

        languageBox = new JComboBox<>(new String[]{"English", "Hindi", "Telugu"});
        languageBox.setBounds(760, 126, 145, 24);
        panel.add(languageBox);

        JLabel memberStatusTitle = new JLabel("Member Borrowing Status");
        memberStatusTitle.setBounds(20, 160, 200, 20);
        memberStatusTitle.setFont(new Font("Arial", Font.BOLD, 14));
        memberStatusTitle.setForeground(new Color(60, 60, 60));
        panel.add(memberStatusTitle);

        addButton = new JButton("Add");
        addButton.setBounds(70, 190, 100, 32);
        styleButton(addButton, new Color(52, 152, 219));
        panel.add(addButton);

        updateButton = new JButton("Update");
        updateButton.setBounds(190, 190, 110, 32);
        styleButton(updateButton, new Color(46, 204, 113));
        panel.add(updateButton);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(320, 190, 100, 32);
        styleButton(deleteButton, new Color(231, 76, 60));
        panel.add(deleteButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(440, 190, 100, 32);
        styleButton(clearButton, new Color(243, 156, 18));
        panel.add(clearButton);

        viewButton = new JButton("View");
        viewButton.setBounds(560, 190, 100, 32);
        styleButton(viewButton, new Color(26, 188, 156));
        panel.add(viewButton);

        backButton = new JButton("Back");
        backButton.setBounds(680, 190, 100, 32);
        styleButton(backButton, new Color(52, 73, 94));
        panel.add(backButton);

        searchLabel = new JLabel("Search:");
        searchLabel.setBounds(20, 255, 60, 20);
        searchLabel.setFont(new Font("Arial", Font.BOLD, 12));
        panel.add(searchLabel);

        searchField = new JTextField();
        searchField.setBounds(80, 252, 170, 26);
        panel.add(searchField);

        searchButton = new JButton("Search");
        searchButton.setBounds(270, 250, 100, 30);
        styleButton(searchButton, new Color(44, 62, 80));
        panel.add(searchButton);

        JPanel memberPanel = new JPanel();
        memberPanel.setLayout(null);
        memberPanel.setBounds(490, 245, 420, 38);
        memberPanel.setBackground(new Color(242, 240, 245));
        memberPanel.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));
        panel.add(memberPanel);

        memberNameLabel = new JLabel("Member Name:");
        memberNameLabel.setBounds(10, 4, 95, 14);
        memberNameLabel.setFont(new Font("Arial", Font.BOLD, 12));
        memberPanel.add(memberNameLabel);

        memberNameField = new JTextField("Aakash Sharma");
        memberNameField.setBounds(110, 2, 140, 16);
        memberNameField.setBorder(null);
        memberNameField.setEditable(false);
        memberNameField.setBackground(new Color(242, 240, 245));
        memberPanel.add(memberNameField);

        memberCategoryLabel = new JLabel("Member Category:");
        memberCategoryLabel.setBounds(10, 20, 120, 14);
        memberCategoryLabel.setFont(new Font("Arial", Font.BOLD, 12));
        memberPanel.add(memberCategoryLabel);

        memberCategoryField = new JTextField("Faculty");
        memberCategoryField.setBounds(130, 18, 100, 16);
        memberCategoryField.setBorder(null);
        memberCategoryField.setEditable(false);
        memberCategoryField.setBackground(new Color(242, 240, 245));
        memberPanel.add(memberCategoryField);

        String[] columns = {
                "Book ID", "ISBN", "Book Name", "Author", "Genre",
                "Language", "Borrower ID", "Issue Date", "Status"
        };

        String[][] data = {
                {"B101", "9780070701199", "Java Programming", "Herbert Schildt", "Computer Science", "English", "M001", "20-03-2026", "Available"},
                {"B102", "9780321122261", "Database System", "Navathe", "Computer Science", "English", "M002", "21-03-2026", "Issued"},
                {"B103", "9780136002344", "Computer Networks", "Forouzan", "Computer Science", "English", "M003", "22-03-2026", "Returned"},
                {"B104", "9780470128725", "Operating System", "Galvin", "Computer Science", "English", "M004", "23-03-2026", "Available"},
                {"B105", "9780070146310", "Data Structures", "Seymour Lipschutz", "Computer Science", "English", "M005", "24-03-2026", "Issued"},
                {"B106", "9780070701199", "Mathematics", "Herbert Schildt", "Mathematics", "English", "M001", "25-03-2026", "Available"},
                {"B107", "9780321122261", "Database System", "Navathe", "Philosophy", "Philosophy", "M002", "26-03-2026", "Issued"},
                {"B108", "9780136002344", "Computer Networks", "Galvin", "Philosophy", "English", "M002", "27-03-2026", "Returned"}
        };

        model = new DefaultTableModel(data, columns);
        libraryTable = new JTable(model);
        libraryTable.setRowHeight(24);
        libraryTable.setFont(new Font("Arial", Font.PLAIN, 12));
        libraryTable.setGridColor(new Color(180, 200, 185));
        libraryTable.setSelectionBackground(new Color(190, 225, 205));
        libraryTable.setSelectionForeground(Color.BLACK);

        JTableHeader header = libraryTable.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 12));
        header.setBackground(new Color(233, 240, 236));
        header.setForeground(Color.BLACK);

        JScrollPane scrollPane = new JScrollPane(libraryTable);
        scrollPane.setBounds(20, 300, 890, 230);
        panel.add(scrollPane);

        JPanel overviewPanel = new JPanel();
        overviewPanel.setLayout(null);
        overviewPanel.setBounds(770, 530, 180, 70);
        overviewPanel.setBackground(new Color(245, 245, 240));
        overviewPanel.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        panel.add(overviewPanel);

        overviewLabel = new JLabel("Library Overview");
        overviewLabel.setBounds(45, 5, 120, 18);
        overviewLabel.setFont(new Font("Arial", Font.BOLD, 14));
        overviewPanel.add(overviewLabel);

        JLabel totalBooks = new JLabel("Total Books:           1520");
        totalBooks.setBounds(10, 25, 160, 14);
        totalBooks.setFont(new Font("Arial", Font.PLAIN, 12));
        overviewPanel.add(totalBooks);

        JLabel booksIssued = new JLabel("Books Issued:        315");
        booksIssued.setBounds(10, 40, 160, 14);
        booksIssued.setFont(new Font("Arial", Font.PLAIN, 12));
        overviewPanel.add(booksIssued);

        JLabel newAdditions = new JLabel("New Additions(Month): 45");
        newAdditions.setBounds(10, 55, 165, 14);
        newAdditions.setFont(new Font("Arial", Font.PLAIN, 12));
        overviewPanel.add(newAdditions);

        libraryTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = libraryTable.getSelectedRow();
                if (row != -1) {
                    idField.setText(model.getValueAt(row, 0).toString());
                    isbnField.setText(model.getValueAt(row, 1).toString());
                    bookNameField.setText(model.getValueAt(row, 2).toString());
                    authorField.setText(model.getValueAt(row, 3).toString());
                    genreField.setText(model.getValueAt(row, 4).toString());
                    languageBox.setSelectedItem(model.getValueAt(row, 5).toString());
                    borrowerIdField.setText(model.getValueAt(row, 6).toString());
                    issueDateField.setText(model.getValueAt(row, 7).toString());
                    statusBox.setSelectedItem(model.getValueAt(row, 8).toString());
                }
            }
        });

        setVisible(true);
    }

    private void styleButton(JButton button, Color color) {
        button.setFont(new Font("Arial", Font.BOLD, 13));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.addActionListener(this);
    }

    private void clearFields() {
        idField.setText("");
        bookNameField.setText("");
        authorField.setText("");
        genreField.setText("");
        isbnField.setText("");
        borrowerIdField.setText("");
        issueDateField.setText("");
        searchField.setText("");
        statusBox.setSelectedIndex(0);
        languageBox.setSelectedIndex(0);
        memberNameField.setText("Aakash Sharma");
        memberCategoryField.setText("Faculty");
        libraryTable.clearSelection();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String id = idField.getText().trim();
            String isbn = isbnField.getText().trim();
            String bookName = bookNameField.getText().trim();
            String author = authorField.getText().trim();
            String genre = genreField.getText().trim();
            String language = languageBox.getSelectedItem().toString();
            String borrowerId = borrowerIdField.getText().trim();
            String issueDate = issueDateField.getText().trim();
            String status = statusBox.getSelectedItem().toString();

            if (id.isEmpty() || isbn.isEmpty() || bookName.isEmpty() || author.isEmpty() || issueDate.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all required fields.");
            } else {
                model.addRow(new Object[]{id, isbn, bookName, author, genre, language, borrowerId, issueDate, status});
                JOptionPane.showMessageDialog(this, "Book added successfully.");
                clearFields();
            }

        } else if (e.getSource() == updateButton) {
            int row = libraryTable.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Please select a row to update.");
            } else {
                model.setValueAt(idField.getText().trim(), row, 0);
                model.setValueAt(isbnField.getText().trim(), row, 1);
                model.setValueAt(bookNameField.getText().trim(), row, 2);
                model.setValueAt(authorField.getText().trim(), row, 3);
                model.setValueAt(genreField.getText().trim(), row, 4);
                model.setValueAt(languageBox.getSelectedItem().toString(), row, 5);
                model.setValueAt(borrowerIdField.getText().trim(), row, 6);
                model.setValueAt(issueDateField.getText().trim(), row, 7);
                model.setValueAt(statusBox.getSelectedItem().toString(), row, 8);
                JOptionPane.showMessageDialog(this, "Book updated successfully.");
                clearFields();
            }

        } else if (e.getSource() == deleteButton) {
            int row = libraryTable.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Please select a row to delete.");
            } else {
                model.removeRow(row);
                JOptionPane.showMessageDialog(this, "Book deleted successfully.");
                clearFields();
            }

        } else if (e.getSource() == clearButton) {
            clearFields();

        } else if (e.getSource() == viewButton) {
            int row = libraryTable.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Please select a row to view.");
            } else {
                String details =
                        "Book ID: " + model.getValueAt(row, 0) + "\n" +
                        "ISBN: " + model.getValueAt(row, 1) + "\n" +
                        "Book Name: " + model.getValueAt(row, 2) + "\n" +
                        "Author: " + model.getValueAt(row, 3) + "\n" +
                        "Genre: " + model.getValueAt(row, 4) + "\n" +
                        "Language: " + model.getValueAt(row, 5) + "\n" +
                        "Borrower ID: " + model.getValueAt(row, 6) + "\n" +
                        "Issue Date: " + model.getValueAt(row, 7) + "\n" +
                        "Status: " + model.getValueAt(row, 8);

                JOptionPane.showMessageDialog(this, details, "Library Details", JOptionPane.INFORMATION_MESSAGE);
            }

        } else if (e.getSource() == searchButton) {
            String search = searchField.getText().trim().toLowerCase();
            boolean found = false;

            for (int i = 0; i < model.getRowCount(); i++) {
                String rowText = "";
                for (int j = 0; j < model.getColumnCount(); j++) {
                    rowText += model.getValueAt(i, j).toString().toLowerCase() + " ";
                }

                if (rowText.contains(search)) {
                    libraryTable.setRowSelectionInterval(i, i);
                    libraryTable.scrollRectToVisible(libraryTable.getCellRect(i, 0, true));
                    found = true;
                    break;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(this, "No matching book found.");
            }

        } else if (e.getSource() == backButton) {
            new Dashboard();
            dispose();
        }
    }

    public static void main(String[] args) {
        new LibraryPage();
    }
}