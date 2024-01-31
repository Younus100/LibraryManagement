package com.project.LibraryManagement.service.interfac;

import com.project.LibraryManagement.model.Author;
import com.project.LibraryManagement.model.Book;
import com.project.LibraryManagement.model.Category;
import com.project.LibraryManagement.model.Publisher;

import java.util.List;

public interface BookService {
    Book addBook(Book book);
    void removeBook(Long bookId);
    Book updateBookDetails(Book book);
    List<Book> finByCategory(Category category);
    List<Book> findByAuther(Author author);
    Book getBookById(Long bookId);
    List<Book> filterBook(Category category, Publisher publisher);

    List<Book> getAllBooks();

}
