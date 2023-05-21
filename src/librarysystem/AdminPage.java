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
    private List<Book> books;
;

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

 JButton addBookButton = new JButton("Add Book");
        addBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String bookName = JOptionPane.showInputDialog(frame, "Enter book title:");
                if (bookName != null && !bookName.isEmpty()) {
                    String bookPrice = JOptionPane.showInputDialog(frame, "Enter book price:");
                    double price = Double.parseDouble(bookPrice);
                    String bookID = JOptionPane.showInputDialog(frame, "Enter book ID:");
                    int id = Integer.parseInt(bookID);
                    Book book = new Book(bookName, price, id);
                    books.add(book);
                    JOptionPane.showMessageDialog(frame, "Book added successfully!");
                }
            }
        });

        JButton viewIssuedBookButton = new JButton("View Issued Books");
        viewIssuedBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (Book book : books) {
                    // Display book details (name, price, ID)
                    System.out.println("Book Name: " + book.getName());
                    System.out.println("Book Price: " + book.getPrice());
                    System.out.println("Book ID: " + book.getId());
                }
            }
        });

        JButton returnBookButton = new JButton("Return Book");
        returnBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String bookID = JOptionPane.showInputDialog(frame, "Enter book ID:");
                if (bookID != null && !bookID.isEmpty()) {
                    int id = Integer.parseInt(bookID);
                    boolean found = false;
                    for (Book book : books) {
                        if (book.getId() == id) {
                            books.remove(book);
                            found = true;
                            JOptionPane.showMessageDialog(frame, "Book returned successfully!");
                            break;
                        }
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(frame, "Book not found!");
                    }
                }
            }
        });

        JButton issueBookButton = new JButton("Issue Book");
        issueBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String bookID = JOptionPane.showInputDialog(frame, "Enter book ID:");
                if (bookID != null && !bookID.isEmpty()) {
                    int id = Integer.parseInt(bookID);
                    boolean found = false;
                    for (Book book : books) {
                        if (book.getId() == id) {
                            found = true;
                            JOptionPane.showMessageDialog(frame, "Book issued successfully!");
                            break;
                        }
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(frame, "Book not found!");
                    }
                }
            }
        });

        JButton createResetButton = new JButton("Create/Reset");
        addBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String book = JOptionPane.showInputDialog(frame, "Enter book title:");
                if (book != null && !book.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Book added successfully!");
                }
            }
        });

        panel.add(viewUsersButton);
        panel.add(viewIssuedBookButton);
        panel.add(addUserButton);
        panel.add(viewIssuedBookButton);
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
