package com.example.The.Big.Project.service.impl;

import com.example.The.Big.Project.model.Author;
import com.example.The.Big.Project.repository.AuthorRepository;
import com.example.The.Big.Project.service.interfaces.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements IAuthorService {
    @Autowired
    AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(Integer id){
        Optional<Author> authorOptional = authorRepository.findById(id);
        if(authorOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author " + id + " not found");
        return authorOptional.get();
    }

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Integer id){
        Optional<Author> authorOptional = authorRepository.findById(id);
        if (authorOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author " + id + " not found.");
        authorRepository.deleteById(id);
    }

    @Override
    public void updateAuthor(Author author, Integer id) {

    }

}
