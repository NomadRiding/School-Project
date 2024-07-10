package com.example.The.Big.Project.controller.impl;

import com.example.The.Big.Project.model.Book;
import com.example.The.Big.Project.model.Rating;
import com.example.The.Big.Project.service.interfaces.IBookService;
import com.example.The.Big.Project.service.interfaces.IRatingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class
BookController {

    @Autowired
    private IBookService bookService;


    //  ****************************************************  GET  ****************************************************


    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Integer id) {
        return bookService.getBook(id);
    }


    //  ****************************************************  POST  ****************************************************

    public Book createBook(@PathVariable Integer id, @RequestBody Book book){
        return bookService.saveBook(book);
    }





    //  ****************************************************  PUT  ****************************************************

    @PutMapping("/books/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBook(@RequestBody @Valid Book book, @PathVariable Integer id){
        bookService.updateBook(book, id);
    }


    //  ****************************************************  DELETE  ****************************************************
    @DeleteMapping("/courses/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
    }

}



