package com.project.LibraryManagement.service;

import com.project.LibraryManagement.exception.BookException;
import com.project.LibraryManagement.model.Book;
import com.project.LibraryManagement.model.BookIssue;
import com.project.LibraryManagement.model.User;
import com.project.LibraryManagement.repository.BookIssueRepository;
import com.project.LibraryManagement.repository.BookRepository;
import com.project.LibraryManagement.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookIssueService {

    private final BookIssueRepository bookIssueRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public BookIssueService(
            BookIssueRepository bookIssueRepository,
            BookRepository bookRepository,
            UserRepository userRepository) {
        this.bookIssueRepository = bookIssueRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public BookIssue issueBook(Long bookId, Long userId) throws BookException {
        Optional<Book> book = bookRepository.findById(bookId);
        if(!book.isPresent()) {
            throw new BookException("Book with id " + bookId + " is not available for issue.");
        }
        Optional<User> user = userRepository.findById(userId);
        if(!user.isPresent()) {
            throw new BookException("Book with id " + bookId + " is not available for issue.");
        }
        BookIssue bookIssue = bookIssueRepository.findByUserId(userId);
        if(bookIssue!=null) {
            bookIssue = new BookIssue();
            bookIssue.
        }
        bookIssue.getBook().add(book.get());
        bookIssueRepository.save(bookIssue);




        BookIssue bookIssue = new BookIssue();
        bookIssue.setBook(book);
        bookIssue.setUser(user);
        bookIssue.setIssueTime(LocalDateTime.now());
        bookIssue.setExpiryTime(LocalDate.now().plusDays(14)); // Example: 14 days issue period

        // Perform any other business logic or validations as needed

        // Save the book issue
        return bookIssueRepository.save(bookIssue);
    }

    public void returnBook(Long bookIssueId) {
        BookIssue bookIssue = bookIssueRepository.findById(bookIssueId)
                .orElseThrow(() -> new EntityNotFoundException("Book issue not found with id: " + bookIssueId));

        // Perform any business logic related to returning a book

        // Update book availability
        Book book = bookIssue.getBook();
        book.setAvailable(true);
        bookRepository.save(book);

        // Delete the book issue record
        bookIssueRepository.delete(bookIssue);
    }

    // Other methods as needed, e.g., getBookIssuesByUser, getBookIssuesByBook, etc.
}
