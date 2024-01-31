package com.project.LibraryManagement.service;

import com.project.LibraryManagement.model.User;
import com.project.LibraryManagement.repository.BookIssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookIssueService {
    @Autowired
    private BookIssueRepository bookIssueRepository;

    public List<User> getUsersByBookId(Long bookId) {
        return bookIssueRepository.findUsersByBookIssueDetailsBook_Id(bookId);
    }
}
