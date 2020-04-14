package com.nextprogrammers.crudApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nextprogrammers.crudApp.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
