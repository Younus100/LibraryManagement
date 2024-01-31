package com.project.LibraryManagement.repository;

import com.project.LibraryManagement.model.BookIssue;
import com.project.LibraryManagement.model.BookIssueDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookIssueDetailsRepository extends JpaRepository<BookIssueDetails,Long> {
    BookIssueDetails findByUserId(Long userId);

}
