class Reader {
    private final int rId;
    private final String name;
    private final Map<String, Book> takenBooks = new HashMap<>();

    public Reader(String name) {
        this.name = name;
        this.rId = new Random().nextInt(1000);
    }

    public int getrId() {
        return rId;
    }

    public void takeBook(Book book) {
        takenBooks.putIfAbsent(book.getName(), book);
    }

    public List<Book> getTakenBooks() {
        return new ArrayList<>(takenBooks.values());
    }

    @Override
    public String toString() {
        return name;
    }
}