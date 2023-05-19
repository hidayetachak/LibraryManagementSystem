/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarysystem;

/**
 *
 * @author Hidayet
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AdminPage {
    private JFrame frame;
    private List<User> users = new ArrayList<>();
    private List<String> books;

    public AdminPage() {
        frame = new JFrame("Admin Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); 

        JPanel panel = new JPanel();

        JButton viewUsersButton = new JButton("View Users");
viewUsersButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        StringBuilder userList = new StringBuilder();
        for (User user : users) {
            userList.append("User ID: ").append(user.getUid()).append("\n");
            userList.append("Username: ").append(user.getUsername()).append("\n");
            userList.append("Password: ").append(user.getPassword()).append("\n");
            userList.append("Is Admin: ").append(user.isAdmin() ? "Yes" : "No").append("\n");
            userList.append("\n");
        }
        JOptionPane.showMessageDialog(frame, userList.toString(), "Users", JOptionPane.PLAIN_MESSAGE);
    }
});


        JButton addUserButton = new JButton("Add User");
addUserButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String uid = JOptionPane.showInputDialog(frame, "Enter UID:");
        if (uid == null || uid.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid UID!");
            return;
        }
        
        String username = JOptionPane.showInputDialog(frame, "Enter username:");
        if (username == null || username.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid username!");
            return;
        }
        
        String password = JOptionPane.showInputDialog(frame, "Enter password:");
        if (password == null || password.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid password!");
            return;
        }
        
        int isAdminOption = JOptionPane.showConfirmDialog(frame, "Is the user an admin?", "Admin Status", JOptionPane.YES_NO_OPTION);
        boolean isAdmin = (isAdminOption == JOptionPane.YES_OPTION);
        
        
        User newUser = new User(uid, username, password, isAdmin);
        users.add(newUser);
        
        JOptionPane.showMessageDialog(frame, "User added successfully!");
    }
});


        JButton viewBooksButton = new JButton("View Books");
        viewBooksButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder bookList = new StringBuilder();
                for (String book : books) {
                    bookList.append(book).append("\n");
                }
                JOptionPane.showMessageDialog(frame, bookList.toString(), "Books", JOptionPane.PLAIN_MESSAGE);
            }
        });

        JButton addBookButton = new JButton("Add Book");
        addBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String book = JOptionPane.showInputDialog(frame, "Enter book title:");
                if (book != null && !book.isEmpty()) {
                    books.add(book);
                    JOptionPane.showMessageDialog(frame, "Book added successfully!");
                }
            }
        });
        JButton viewIssuedBookButton = new JButton("View Issued Books");
        addBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String book = JOptionPane.showInputDialog(frame, "Enter book title:");
                if (book != null && !book.isEmpty()) {
                    books.add(book);
                    JOptionPane.showMessageDialog(frame, "Book added successfully!");
                }
            }
        });
        JButton returnBookButton = new JButton("View Issued Books");
        addBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String book = JOptionPane.showInputDialog(frame, "Enter book title:");
                if (book != null && !book.isEmpty()) {
                    books.add(book);
                    JOptionPane.showMessageDialog(frame, "Book added successfully!");
                }
            }
        });
        JButton issueBookButton = new JButton("View Issued Books");
        addBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String book = JOptionPane.showInputDialog(frame, "Enter book title:");
                if (book != null && !book.isEmpty()) {
                    books.add(book);
                    JOptionPane.showMessageDialog(frame, "Book added successfully!");
                }
            }
        });
        JButton createResetButton = new JButton("View Issued Books");
        addBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String book = JOptionPane.showInputDialog(frame, "Enter book title:");
                if (book != null && !book.isEmpty()) {
                    books.add(book);
                    JOptionPane.showMessageDialog(frame, "Book added successfully!");
                }
            }
        });

        panel.add(viewUsersButton);
        panel.add(viewIssuedBookButton);
        panel.add(addUserButton);
        panel.add(viewBooksButton);
        panel.add(addBookButton);
        panel.add(createResetButton);
        panel.add(issueBookButton);
        panel.add(returnBookButton);
        frame.add(panel);
        frame.setVisible(true);

        users = new ArrayList<>();
        books = new ArrayList<>();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }
}
