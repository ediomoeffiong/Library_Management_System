import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        System.out.print("Input Title: ");
        Scanner scanTitle = new Scanner(System.in);
        String title = scanTitle.nextLine();

        System.out.print("Input Author: ");
        Scanner scanAuthor = new Scanner(System.in);
        String author = scanAuthor.nextLine();

        System.out.print("Input Book ID: ");
        Scanner scanBookID = new Scanner(System.in);
        int bookID = scanBookID.nextInt();

        System.out.print("Input User Name: ");
        Scanner scanUserName = new Scanner(System.in);
        String userName = scanUserName.nextLine();

        System.out.print("Input User ID: ");
        Scanner scanUserID = new Scanner(System.in);
        int userID = scanUserID.nextInt();

        library.addBook(new Book(title, author, bookID));

        library.addUser(new User(userName, userID));

        // All books
        System.out.println("All books in the library:");
        library.listBooks();

        // All users
        System.out.println("\nAll users:");
        library.listUsers();

        // Borrowing books
        System.out.println("\nBorrowing books:");
        library.borrowBook(bookID, userID);

        // Borrowed books
        System.out.println("\nBorrowed books:");
        library.listBorrowedBooks();

        // Returning a book
        System.out.println("\nReturning a book:");
        library.returnBook(bookID, userID);

        // Listing borrowed books after returning
        System.out.println("\nBorrowed books after returning:");
        library.listBorrowedBooks();
    }
}
