package com.example.The.Big.Project.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Integer isbn;

    @JsonManagedReference
    @OneToMany(mappedBy = "book")
    private List<Rating> ratings;

    @JsonManagedReference
    @ManyToMany(mappedBy = "books")
    private List<User> users;

    @ManyToOne
    private Author author;

    public Book(String title, Author author){
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

}
