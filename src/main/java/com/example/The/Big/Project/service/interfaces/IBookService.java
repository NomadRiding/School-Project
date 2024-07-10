package com.example.The.Big.Project.service.interfaces;

import com.example.The.Big.Project.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBookService {
    List<Book> getAllBooks();

    Book getBook(Integer id);

    void updateCourse(Book book, Integer id);

    void updateBook(Book book, Integer id);

    void deleteBook(Integer id);
}
