// Main.java - Entry point of the program. Shows the menu and handles all user input.
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            showMenu();

            int choice = readInt(sc, "Enter your choice: ");

            switch (choice) {

                case 1:   // Add Book
                    int bookId = readInt(sc, "Book ID: ");
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Category: ");
                    String category = sc.nextLine();
                    library.addBook(bookId, title, author, category);
                    break;

                case 2:   // View All Books
                    library.viewAllBooks();
                    break;

                case 3:   // Search Book
                    System.out.print("Enter title or author to search: ");
                    library.searchBook(sc.nextLine());
                    break;

                case 4:   // Register User
                    int userId = readInt(sc, "User ID: ");
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    library.registerUser(userId, name, email);
                    break;

                case 5:   // View All Users
                    library.viewAllUsers();
                    break;

                case 6:   // Issue Book
                    int issueUserId = readInt(sc, "Enter User ID: ");
                    int issueBookId = readInt(sc, "Enter Book ID: ");
                    library.issueBook(issueUserId, issueBookId);
                    break;

                case 7:   // Return Book
                    int returnBookId = readInt(sc, "Enter Book ID to return: ");
                    library.returnBook(returnBookId);
                    break;

                case 8:   // View Issued Books
                    library.viewIssuedBooks();
                    break;

                case 9:   // Exit
                    System.out.println("Thank you for using the Online Library Management System. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 9.");
            }

            System.out.println();
        }
    }

    // Display the main menu
    public static void showMenu() {
        System.out.println("=================================");
        System.out.println("   ONLINE LIBRARY MANAGEMENT");
        System.out.println("=================================");
        System.out.println();
        System.out.println("1. Add Book");
        System.out.println("2. View All Books");
        System.out.println("3. Search Book");
        System.out.println("4. Register User");
        System.out.println("5. View All Users");
        System.out.println("6. Issue Book");
        System.out.println("7. Return Book");
        System.out.println("8. View Issued Books");
        System.out.println("9. Exit");
        System.out.println();
    }

    // Read an integer from the user. Basic exception handling:
    // if the user types something that is not a number, ask again.
    public static int readInt(Scanner sc, String message) {
        while (true) {
            try {
                System.out.print(message);
                int value = sc.nextInt();
                if (sc.hasNextLine()) {
                    sc.nextLine();   // consume the leftover newline (if any)
                }
                return value;
            } catch (InputMismatchException e) {
                sc.nextLine();   // clear the invalid input
                System.out.println("Invalid input! Please enter a number.");
            }
        }
    }
}