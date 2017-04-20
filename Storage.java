import java.util.ArrayList;
/**
 * Created by ubuneclipse on 2/14/17.
 */
public class Storage {
    private ArrayList<Book> books = new ArrayList<>();

    public Storage() {
        books.add(new Book("White Fang", "Jack London"));
        books.add(new Book("The Sea-Wolf", "Jack London"));
        books.add(new Book("The Road", "Jack London"));
        books.add(new Book("The Adventures of Tom Sawyer", "Mark Twain"));
        books.add(new Book("Around the World in 80 Days", "Jules Verne"));
        books.add(new Book("Twenty Thousand Leagues Under the Sea", "Jules Verne"));
        books.add(new Book("The Mysterious Island", "Jules Verne"));
        books.add(new Book("The Four Million", "O. Henry"));
        books.add(new Book("The Last Leaf", "O. Henry"));
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
