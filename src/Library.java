import java.util.HashMap;

public class Library {
    private final HashMap<Integer, Books> books; // Now using book ID as key
    private static Library instance;
    static private int nextId = 1; // Unique ID generator
    private int nextUserId = 1;
    private final HashMap<Integer, Users> users;

    public HashMap<Integer, Books> getBooks() {
        return books;
    }

    public HashMap<Integer, Users> getUsers() {
        return users;
    }



    private Library() {
        books = new HashMap<>();
        users = new HashMap<>();
        Users Admin = new Users("Admin");
        users.put(9999,Admin);
    }

    public void userRegister(String userName) {
        Users newUser = new Users(userName);
        users.put(nextUserId, newUser);
        nextUserId++;
    }

    public void userRegister(int birthYear, String userName, char gender) {
        Users newUser = new Users(birthYear, userName, gender);
        users.put(nextUserId, newUser);
        nextUserId++;
    }

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public void addBook(String title, String author) {
        Books book = new Books(nextId, title, author); // Create book with unique ID
        books.put(nextId, book);
        System.out.println("Added Book: " + book.getTitle() + " " + book.getAuthor());
        nextId++; // Increment ID for next book
    }

    public void removeBook(int bookId) {
        if (books.containsKey(bookId)) {
            System.out.println("Removed Book: " + books.get(bookId));
            books.remove(bookId);
        } else {
            System.out.println("Book ID " + bookId + " not found.");
        }
    }

    public void printBooks() {
        if (books.isEmpty()) {
            System.out.println("The library has no books.");
            return;
        }
        for (Books book : books.values()) {
            System.out.println(book);
        }
    }

    public void rentBook(int bookId, int userId) {
        if (bookValidation(bookId, userId)) return; // Exit early if validation fails

        Books book = books.get(bookId);
        Users user = users.get(userId);

        if (!book.isAvailable()) {
            System.out.println("Book is already rented: " + book.getTitle());
            return;
        }

        book.setAvailable(false);
        user.borrowBook(bookId);
        System.out.println(user.getName() + " rented " + book);
    }

    public void returnBook(int bookId, int userId) {
        if (bookValidation(bookId, userId)) return; // Exit early if validation fails

        Books book = books.get(bookId);
        Users user = users.get(userId);

        if (book.isAvailable()) {
            System.out.println("Book is not rented.");
            return;
        }
        if (!user.returnBook(bookId)) {
            System.out.println(user.getName() + " did not rent this book.");
            return;
        }

        book.setAvailable(true);
        System.out.println(user.getName() + " returned " + book);
    }

    public void printUsers() {
        if (users.isEmpty()) {
            System.out.println("No users registered.");
            return;
        }
        for (Users user : users.values()) {
            System.out.println(user);
        }
    }

    private boolean bookValidation(int bookId, int userId) {
        if (!books.containsKey(bookId)) {
            System.out.println("Book ID " + bookId + " not found.");
            return true;
        }
        if (!users.containsKey(userId)) {
            System.out.println("User ID " + userId + " not found.");
            return true;
        }
        return false; // ✅ Valid book and user
    }

    @Override
    public String toString() {
        return "The book title:" + books.get(nextId).getTitle() + ", author:" + books.get(nextId).getAuthor()
                + ", publisher:" + books.get(nextId).getPublisher() + ", year:" + books.get(nextId).getYear();
    }
}
