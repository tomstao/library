import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryUtility {
    private LibraryUtility() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }
    public static void welcomeScreen() {
        System.out.println("""
                Welcome to use Tom's library management system!"
                Press any key to use the system, or press "N" to exit the program.
                Enter "R" for registering a new user.
                """);
    }

    public static String getUserName(Integer userId, Library library) {
        return library.getUsers().get(userId).getName();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static int getValidInteger(String prompt) {
        while (true) {  // Keep asking until a valid integer is entered
            try {
                System.out.print(prompt);
                return scanner.nextInt();  // Read integer input
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    public static String getValidString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim(); // Read input and remove extra spaces
    }

}
