package com.example.The.Big.Project.repository;

import com.example.The.Big.Project.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;

    @Test
    public void findAll_books_bookList(){
        List<Book> bookList = bookRepository.findAll();
        System.out.println(bookList);
        assertEquals(4, bookList.size());
    }

    @Test
    public void findById_validId_correctBook(){
        Optional <Book> bookOptional = bookRepository.findById(1);
        assertTrue(bookOptional.isPresent());
        System.out.println(bookOptional.get());
        assertEquals("Harry Potter and the Prisoner of Azkaban", bookOptional.get());
    }

    @Test
    public void findById_invalidId_bookNotPresent(){
        Optional<Book> bookOptional = bookRepository.findById(444);
        assertTrue(bookOptional.isEmpty());
    }

}
