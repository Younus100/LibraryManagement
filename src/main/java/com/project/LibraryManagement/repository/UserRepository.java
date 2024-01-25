package com.project.LibraryManagement.repository;

import com.project.LibraryManagement.model.BookIssue;
import com.project.LibraryManagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
