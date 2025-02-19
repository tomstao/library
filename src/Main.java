import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Library library = Library.getInstance();

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = getValidInteger("Enter your choice: ");
            switch (choice) {
                case 1 -> registerUser();
                case 2 -> addBook();
                case 3 -> rentBook();
                case 4 -> returnBook();
                case 5 -> library.printUsers();
                case 6 -> library.printBooks();
                case 7 -> exitProgram();
                default -> System.out.println("Invalid choice! Please select a valid option.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
        System.out.println("1. Register User");
        System.out.println("2. Add Book");
        System.out.println("3. Rent Book");
        System.out.println("4. Return Book");
        System.out.println("5. View All Users");
        System.out.println("6. View All Books");
        System.out.println("7. Exit");
    }

    private static void registerUser() {
        System.out.println("\n--- Register User ---");
        String name = getValidString("Enter user name: ");
        int birthYear = getValidInteger("Enter birth year: ");
        char gender = getValidChar("Enter gender (M/F/U): ");
        library.userRegister(birthYear, name, gender);
        System.out.println("User registered successfully!");
    }

    private static void addBook() {
        System.out.println("\n--- Add Book ---");
        String title = getValidString("Enter book title: ");
        String author = getValidString("Enter book author: ");
        library.addBook(title, author);
        System.out.println("Book added successfully!");
    }

    private static void rentBook() {
        System.out.println("\n--- Rent Book ---");
        int userId = getValidInteger("Enter your User ID: ");
        int bookId = getValidInteger("Enter Book ID: ");
        library.rentBook(bookId, userId);
    }

    private static void returnBook() {
        System.out.println("\n--- Return Book ---");
        int userId = getValidInteger("Enter your User ID: ");
        int bookId = getValidInteger("Enter Book ID: ");
        library.returnBook(bookId, userId);
    }

    private static void exitProgram() {
        System.out.println("Exiting Library System. Goodbye!");
        System.exit(0);
    }

    private static int getValidInteger(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine(); // Clear input buffer
            }
        }
    }

    private static String getValidString(String prompt) {
        System.out.print(prompt);
        scanner.nextLine(); // Consume any leftover newline
        return scanner.nextLine().trim();
    }

    private static char getValidChar(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.next().trim().toUpperCase();
            if (input.length() == 1 && (input.equals("M") || input.equals("F") || input.equals("U"))) {
                return input.charAt(0);
            }
            System.out.println("Invalid input! Enter M, F, or U.");
        }
    }
}