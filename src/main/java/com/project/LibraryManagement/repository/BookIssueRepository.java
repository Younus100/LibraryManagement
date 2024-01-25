package com.project.LibraryManagement.repository;

import com.project.LibraryManagement.model.BookIssue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BookIssueRepository extends JpaRepository<BookIssue,Long> {
    BookIssue findByUserId(Long userId);



}
