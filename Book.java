// Book.java - Represents a single book in the library.
public class Book {

    private int bookId;
    private String title;
    private String author;
    private String category;
    private boolean isIssued;      // availability status: false = Available, true = Issued
    private int issuedToUserId;    // ID of the user who borrowed it (-1 = not issued to anyone)

    // Constructor
    public Book(int bookId, String title, String author, String category) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.isIssued = false;
        this.issuedToUserId = -1;
    }

    // Getters and setters
    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public int getIssuedToUserId() {
        return issuedToUserId;
    }

    // Called when a book is issued: Available -> Issued
    public void issueTo(int userId) {
        isIssued = true;
        issuedToUserId = userId;
    }

    // Called when a book is returned: Issued -> Available
    public void returnBook() {
        isIssued = false;
        issuedToUserId = -1;
    }

    // Display book details in a readable way
    public String toString() {
        String status = (isIssued) ? "Issued" : "Available";
        return "ID: " + bookId
             + "\nTitle: " + title
             + "\nAuthor: " + author
             + "\nCategory: " + category
             + "\nStatus: " + status;
    }
}