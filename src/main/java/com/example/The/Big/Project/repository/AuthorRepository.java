package com.example.The.Big.Project.repository;


import com.example.The.Big.Project.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Author getAuthorById(Integer id);
}
