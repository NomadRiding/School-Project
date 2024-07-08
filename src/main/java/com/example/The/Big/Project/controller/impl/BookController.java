package com.example.The.Big.Project.controller.impl;

import com.example.The.Big.Project.model.Book;
import com.example.The.Big.Project.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books")
    public List<Book> getAllUsers(){
        return bookRepository.findAll();
    }

}

