package com.example.The.Big.Project.service.impl;

import com.example.The.Big.Project.model.Book;
import com.example.The.Big.Project.repository.BookRepository;
import com.example.The.Big.Project.service.interfaces.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    private BookRepository bookRepository;


    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Book getBook(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }



}
