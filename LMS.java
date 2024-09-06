import java.util.ArrayList;
import java.util.Scanner;

// Book class to represent a book in the library
class Book {
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowBook() {
        isBorrowed = true;
    }

    public void returnBook() {
        isBorrowed = false;
    }
}

// Library class to manage the collection of books
class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            for (Book book : books) {
                System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Borrowed: " + (book.isBorrowed() ? "Yes" : "No"));
            }
        }
    }

    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isBorrowed()) {
                    System.out.println("Sorry, the book is already borrowed.");
                } else {
                    book.borrowBook();
                    System.out.println("You have borrowed: " + book.getTitle());
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isBorrowed()) {
                    System.out.println("The book was not borrowed.");
                } else {
                    book.returnBook();
                    System.out.println("You have returned: " + book.getTitle());
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }
}

// Main class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(title, author));
                    break;
                case 2:
                    library.viewBooks();
                    break;
                case 3:
                    System.out.print("Enter the title of the book to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    library.borrowBook(borrowTitle);
                    break;
                case 4:
                    System.out.print("Enter the title of the book to return: ");
                    String returnTitle = scanner.nextLine();
                    library.returnBook(returnTitle);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
