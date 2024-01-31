package com.project.LibraryManagement.repository;

import com.project.LibraryManagement.model.BookIssue;
import com.project.LibraryManagement.model.BookIssueDetails;
import com.project.LibraryManagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookIssueRepository extends JpaRepository<BookIssue,Long> {
    BookIssue findByUserId(Long userId);
    // Return only the BookIssue.user for a specific book_id
    List<User> findUsersByBookIssueDetailsBook_Id(Long bookId);

}
