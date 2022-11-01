package com.techno.mapping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techno.mapping.entity.Book;

public interface BookRepo extends JpaRepository<Book, Long> {

}
