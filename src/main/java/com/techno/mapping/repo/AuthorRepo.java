package com.techno.mapping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techno.mapping.entity.Author;

public interface AuthorRepo extends JpaRepository<Author,Long>{

}
