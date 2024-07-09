package com.example.The.Big.Project.service.interfaces;

import com.example.The.Big.Project.model.Author;

import java.util.List;

public interface IAuthorService {
    List<Author> getAllAuthors();
    Author getAuthorById(Integer id);
}