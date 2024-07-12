package com.example.The.Big.Project.controller.impl;

import com.example.The.Big.Project.model.Book;
import com.example.The.Big.Project.service.interfaces.IBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController implements IBookService{

    @Autowired
    private IBookService bookService;



    //  ****************************************************  GET  ****************************************************


    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    @ResponseStatus(HttpStatus.OK) // This should be OK instead of CREATED
    public Book getBookById(@PathVariable Integer id) {
        return bookService.getBookById(id);
    }


    //  ****************************************************  POST  ****************************************************

    @PostMapping("/books")
    public Book createBook(@RequestBody @Valid Book book) {
        return bookService.saveBook(book);
    }



    //  ****************************************************  PUT  ****************************************************

    @PutMapping("/books/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBook(@RequestBody @Valid Book book, @PathVariable Integer id) {
        bookService.updateBook(book, id);
    }


    //  ****************************************************  DELETE  ****************************************************
    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
    }

    @Override
    public Book saveBook(Book book) {
        return null;
    }

}



