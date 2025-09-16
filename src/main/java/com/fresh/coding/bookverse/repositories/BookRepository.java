package com.fresh.coding.bookverse.repositories;

import com.fresh.coding.bookverse.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}