package com.example.The.Big.Project.controller.impl;

import com.example.The.Big.Project.model.Book;
import com.example.The.Big.Project.model.Rating;
import com.example.The.Big.Project.service.interfaces.IBookService;
import com.example.The.Big.Project.service.interfaces.IRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private IBookService bookService;

    @Autowired
    IRatingService ratingService;

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Integer id) {
        return bookService.getBook(id);
    }




    @PostMapping("/{bookId}/ratings")
    public Rating createRating(@PathVariable Integer bookId, @RequestBody Rating rating) {
        return ratingService.saveRating(bookId, rating);
    }
}

