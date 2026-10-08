// Library.java - Manages all the books and users of the library.
import java.util.ArrayList;

public class Library {

    ArrayList<Book> books;   // stores all books
    ArrayList<User> users;   // stores all registered users

    // Constructor creates the empty lists
    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    // Add a book after checking that the book ID is not repeated
    public void addBook(int bookId, String title, String author, String category) {
        if (findBook(bookId) != null) {
            System.out.println("Error: A book with ID " + bookId + " already exists.");
            return;
        }
        books.add(new Book(bookId, title, author, category));
        System.out.println("Book added successfully!");
    }

    // Display all books in the library
    public void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }
        System.out.println("---------- ALL BOOKS ----------");
        for (Book b : books) {
            System.out.println(b);   // calls toString()
            System.out.println("-----------------------------");
        }
    }

    // Search books by title or author (ignoring upper/lower case)
    public void searchBook(String keyword) {
        boolean found = false;
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(keyword.toLowerCase())
                    || b.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(b);
                System.out.println("-----------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No book found with that title or author.");
        }
    }

    // Register a new user after checking that the user ID is not repeated
    public void registerUser(int userId, String name, String email) {
        if (findUser(userId) != null) {
            System.out.println("Error: A user with ID " + userId + " already exists.");
            return;
        }
        users.add(new User(userId, name, email));
        System.out.println("User registered successfully!");
    }

    // Display all registered users
    public void viewAllUsers() {
        if (users.isEmpty()) {
            System.out.println("No users registered yet.");
            return;
        }
        System.out.println("---------- ALL USERS ----------");
        for (User u : users) {
            System.out.println(u);   // calls toString()
            System.out.println("-----------------------------");
        }
    }

    // Issue a book to a user (only if both exist and the book is Available)
    public void issueBook(int userId, int bookId) {
        User user = findUser(userId);
        if (user == null) {
            System.out.println("Error: User with ID " + userId + " does not exist.");
            return;
        }

        Book book = findBook(bookId);
        if (book == null) {
            System.out.println("Error: Book with ID " + bookId + " does not exist.");
            return;
        }

        if (book.isIssued()) {
            System.out.println("Error: This book is already issued to someone.");
            return;
        }

        book.issueTo(userId);   // update availability: Available -> Issued
        System.out.println("Book issued successfully to " + user.getName() + "!");
    }

    // Return a book (only if the book exists and was actually issued)
    public void returnBook(int bookId) {
        Book book = findBook(bookId);
        if (book == null) {
            System.out.println("Error: Book with ID " + bookId + " does not exist.");
            return;
        }

        if (!book.isIssued()) {
            System.out.println("Error: This book was not issued, so it cannot be returned.");
            return;
        }

        book.returnBook();   // update availability: Issued -> Available
        System.out.println("Book returned successfully!");
    }

    // Display only the books that are currently issued
    public void viewIssuedBooks() {
        boolean found = false;
        System.out.println("-------- ISSUED BOOKS ---------");
        for (Book b : books) {
            if (b.isIssued()) {
                User u = findUser(b.getIssuedToUserId());
                System.out.println(b);
                System.out.println("Issued To: " + ((u != null) ? u.getName() : "Unknown"));
                System.out.println("-----------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books are currently issued.");
        }
    }

    // Helper: find a book by ID, or return null if not present
    private Book findBook(int bookId) {
        for (Book b : books) {
            if (b.getBookId() == bookId) {
                return b;
            }
        }
        return null;
    }

    // Helper: find a user by ID, or return null if not present
    private User findUser(int userId) {
        for (User u : users) {
            if (u.getUserId() == userId) {
                return u;
            }
        }
        return null;
    }
}