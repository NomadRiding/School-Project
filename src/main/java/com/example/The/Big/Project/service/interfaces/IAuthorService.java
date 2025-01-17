package com.example.The.Big.Project.service.interfaces;

import com.example.The.Big.Project.model.Author;
import com.example.The.Big.Project.model.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAuthorService {
    List<Author> getAllAuthors();
    Author getAuthorById(Integer id);

    Author saveAuthor(Author author);

    void deleteAuthor(Integer id);

    void updateAuthor(Author author, Integer id);
}
