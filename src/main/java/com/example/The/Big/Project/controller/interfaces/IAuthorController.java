package com.example.The.Big.Project.controller.interfaces;

import com.example.The.Big.Project.model.Author;

import java.util.List;

public interface IAuthorController {
    List<Author> getAllAuthors();
    Author getAuthorById(Integer id);
}
