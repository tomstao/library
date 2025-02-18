import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //boolean startTitle = true;
        Library library = Library.getInstance();

        do{
            LibraryUtility.welcomeScreen();
            Scanner scanner = new Scanner(System.in);
            String continuation = scanner.nextLine();
            System.out.println("Please enter the user name: :");
            String userName = scanner.nextLine();
            if (userName.equals("Admin")){
                System.out.println("""
                        Welcome Admin!
                        would you like to end the system?
                        Please enter yes to end the system
                        """);
                String input = scanner.nextLine();
                if (input.equals("yes")){
                    break;
                }
            }
            if(!(continuation.equals("N"))){
                System.out.printf("""
                        Welcome! %s:\s
                        What would you like to read to day?
                        """,userName);
            }
            System.out.println("Thank you for using!" + "\n");
        } while(true);


    }
}