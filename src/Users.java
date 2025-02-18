import java.util.ArrayList;

public class Users {
    private int birthYear;
    private String name;
    private char  gender;
    static private int id = 1;
    private final ArrayList<Integer> borrowedBooks; // Store rented book IDs

    public Users(int birthYear, String name, char gender) {
        this.birthYear = birthYear;
        this.name = name;
        this.gender = gender;
        id++;
        borrowedBooks = new ArrayList<>();
    }

    public Users(String name) {
        this.name = name;
        birthYear = 2000;
        gender = 'U';
        id++;
        borrowedBooks = new ArrayList<>();
    }

    public char getGender() {
        return gender;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(int bookId) {
        borrowedBooks.add(bookId);
    }

    public boolean returnBook(int bookId) {
        return borrowedBooks.remove((Integer) bookId);
    }

    @Override
    public String toString() {
        return "User ID: " + id + " | Name: " + name + " | Birth Year: " + birthYear + " | Gender: " + gender;
    }
}
