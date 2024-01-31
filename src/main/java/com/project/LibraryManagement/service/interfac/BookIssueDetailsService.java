package com.project.LibraryManagement.service.interfac;

import com.project.LibraryManagement.exception.BookException;
import com.project.LibraryManagement.model.Book;
import com.project.LibraryManagement.model.BookIssueDetails;

import java.util.List;

public interface BookIssueDetailsService {
    public BookIssueDetails issueBook(Long bookId, Long userId) throws BookException;
    public void returnBook(Long bookIssueId) throws BookException;
    List<Book> getBookIssuedByUser(Long userId) throws BookException;

    }
