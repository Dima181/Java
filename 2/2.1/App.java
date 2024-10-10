public class App {
    public static void main(String[] args) {
        Library library = new Library();
        
        String[] bookNames = {"Book1", "Book2", "Book3", "Book4", "Book5", "Book6", "Book7", "Book8", "Book9", "Book10"};
        String[] readerNames = {"Reader1", "Reader2", "Reader3", "Reader4", "Reader5"};

        for (String bookName : bookNames) {
            library.addToCatalog(new Book(bookName));
        }

        for (String readerName : readerNames) {
            library.addReader(new Reader(readerName));
        }

        library.distributeBooks();

        System.out.println("Книги в библиотеке: " + library.getCatalog());
        System.out.println("Читатели библиотеки: " + library.getReaders());
        System.out.println("Количество книг у читателей: " + library.totalBooksTaken());
    }
}