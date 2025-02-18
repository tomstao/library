public class LibraryUtility {
    private LibraryUtility() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }
    public static void welcomeScreen() {
        System.out.println("Welcome to use Tom's library management system!"
                + "\n" + "Press any key to use the system, or press \"N\" to exit the program.");
    }
}
