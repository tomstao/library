public class Books {
    private String title, author, publisher;
    private int year;
    private int pages;
    private boolean available = true;

    public Books(String title, String author, String publisher, int year, int pages) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.pages = pages;
    }

    public Books(String title) {
        this.title = title;
    }

    public Books(int nextId, String title, String author) {
    }

    public boolean isAvailable() {
        return available;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPages() {
        return pages;
    }

    public int getYear() {
        return year;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

}
