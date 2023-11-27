package com.example.springbootbookbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootbookbackend.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
