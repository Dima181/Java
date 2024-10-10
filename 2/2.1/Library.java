import java.util.*;

public class Library {
    private final Map<String, Book> catalogBook = new HashMap<>();
    private final Map<Integer, Reader> readers = new HashMap<>();

    public void addToCatalog(Book book) {
        catalogBook.putIfAbsent(book.getName(), book);
    }

    public void addReader(Reader reader) {
        readers.putIfAbsent(reader.getrId(), reader);
    }

    public Book getBook(String name) {
        return catalogBook.remove(name);
    }

    public List<Book> getCatalog() {
        return new ArrayList<>(catalogBook.values());
    }

    public List<Reader> getReaders() {
        return new ArrayList<>(readers.values());
    }

    public void distributeBooks() {
        Random random = new Random();
        for (Reader reader : readers.values()) {
            int bookCount = random.nextInt(3) + 1;
            for (int i = 0; i < bookCount; i++) {
                if (!catalogBook.isEmpty()) {
                    Book book = catalogBook.values().iterator().next();
                    reader.takeBook(book);
                    getBook(book.getName());
                }
            }
        }
    }

    public int totalBooksTaken() {
        return readers.values().stream().mapToInt(reader -> reader.getTakenBooks().size()).sum();
    }
}