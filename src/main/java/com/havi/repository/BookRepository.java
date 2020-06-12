package com.havi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.havi.domain.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
}
