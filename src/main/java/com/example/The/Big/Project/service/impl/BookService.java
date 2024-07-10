package com.example.The.Big.Project.service.impl;

import com.example.The.Big.Project.model.Book;
import com.example.The.Big.Project.repository.BookRepository;
import com.example.The.Big.Project.service.interfaces.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.Optional;

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

    public Book getBookById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }


    @Override
    public void updateBook(Book book, Integer id) {
    Optional<Book> bookOptional = bookRepository.findById(id);
    if(bookOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book " + id + " not found");
    bookRepository.save(book);
    }

    @Override
    public void deleteBook(Integer id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book " + id + " not found!");
        bookRepository.deleteById(id);
    }


}
