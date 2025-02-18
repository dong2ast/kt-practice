package com.demo.kt.domain.sitter.repository;

import com.demo.kt.domain.sitter.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {


}
