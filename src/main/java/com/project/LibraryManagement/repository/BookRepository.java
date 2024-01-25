package com.project.LibraryManagement.repository;

import com.project.LibraryManagement.model.Book;
import com.project.LibraryManagement.model.BookIssue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {

}
