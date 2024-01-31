package com.project.LibraryManagement.service;

import com.project.LibraryManagement.exception.BookException;
import com.project.LibraryManagement.model.Book;
import com.project.LibraryManagement.model.BookIssue;
import com.project.LibraryManagement.model.BookIssueDetails;
import com.project.LibraryManagement.model.User;
import com.project.LibraryManagement.repository.BookIssueDetailsRepository;
import com.project.LibraryManagement.repository.BookIssueRepository;
import com.project.LibraryManagement.repository.BookRepository;
import com.project.LibraryManagement.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookIssueDetailsService {

    private final BookIssueDetailsRepository bookIssueDetailsRepositor;
    private  final BookIssueRepository bookIssueRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private BookIssueService bookIssueService;

    public BookIssueDetailsService(BookIssueDetailsRepository bookIssueDetailsRepositor, BookIssueRepository bookIssueRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.bookIssueDetailsRepositor = bookIssueDetailsRepositor;
        this.bookIssueRepository = bookIssueRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public BookIssueDetails issueBook(Long bookId, Long userId) throws BookException {
        Optional<Book> book = bookRepository.findById(bookId);
        if(!book.isPresent()) {
            throw new BookException("Book with id " + bookId + " is not available for issue.");
        }
        Optional<User> user = userRepository.findById(userId);
        if(!user.isPresent()) {
            throw new BookException("User with id " + userId + " is not available for issue.");
        }
        BookIssue bookIssue = bookIssueRepository.findByUserId(userId);
        List<User> userList =  bookIssueService.getUsersByBookId(bookId);
        if(userList.contains(user.get())){
            throw  new BookException("Already Issued");
        }
        BookIssueDetails bookIssueDetails= new BookIssueDetails();
        bookIssueDetails.setBook(book.get());
        bookIssueDetails.setBookIssue(bookIssue);
        bookIssueDetails.setIssueTime(LocalDateTime.now());
        bookIssueDetails.setExpiryTime(LocalDate.from(LocalDateTime.now().plusWeeks(1)));

        bookIssue.getBookIssueDetails().add(bookIssueDetails);

        return bookIssueDetailsRepositor.save(bookIssueDetails)
    }

    public void returnBook(Long bookIssueId) throws BookException {
        BookIssue bookIssue = bookIssueRepository.findById(bookIssueId)
                .orElseThrow(() -> new BookException("Book issue not found with id: " + bookIssueId));

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
