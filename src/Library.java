import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;
    private Map<User, ArrayList<Book>> borrowRecords;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
        borrowRecords = new HashMap<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public User findUserById(int userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }

    public void borrowBook(int bookId, int userId) {
        Book book = findBookById(bookId);
        User user = findUserById(userId);

        if (book != null && user != null) {
            if (!book.isBorrowed()) {
                book.borrowBook();
                borrowRecords.putIfAbsent(user, new ArrayList<>());
                borrowRecords.get(user).add(book);
                System.out.println("Book borrowed successfully.");
            } else {
                System.out.println("Book is already borrowed.");
            }
        } else {
            System.out.println("Invalid book ID or user ID.");
        }
    }

    public void returnBook(int bookId, int userId) {
        Book book = findBookById(bookId);
        User user = findUserById(userId);

        if (book != null && user != null && borrowRecords.containsKey(user)) {
            if (borrowRecords.get(user).remove(book)) {
                book.returnBook();
                System.out.println("Book returned successfully.");
            } else {
                System.out.println("User did not borrow this book.");
            }
        } else {
            System.out.println("Invalid book ID or user ID.");
        }
    }

    public void listBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void listUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    public void listBorrowedBooks() {
        for (Map.Entry<User, ArrayList<Book>> entry : borrowRecords.entrySet()) {
            System.out.println("User: " + entry.getKey().getName());
            for (Book book : entry.getValue()) {
                System.out.println("  " + book);
            }
        }
    }
}