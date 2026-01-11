package service;

import dao.BookDAO;
import model.Book;
import model.Status;

import java.util.List;
import java.util.stream.Collectors;

public class BookService {

    private final BookDAO dao = new BookDAO();

    public List<Book> getBooks() {
        return dao.findAll();
    }

    public List<Book> searchBooks(String keyword) {
        return dao.findAll().stream()
                .filter(b ->
                        b.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                                b.getAuthor().toLowerCase().contains(keyword.toLowerCase())
                )
                .collect(Collectors.toList());
    }

    public void addBook(String title, String author) {
        dao.insert(title, author);
    }

    public void removeBook(Book book) {
        dao.delete(book.getId());
    }

    public void toggle(Book book) {
        Status newStatus = book.getStatus() == Status.AVAILABLE
                ? Status.BORROWED
                : Status.AVAILABLE;
        dao.updateStatus(book.getId(), newStatus);
    }
}
